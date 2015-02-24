package com.llama.tech.airports.backbone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.llama.tech.airports.db.Query;
import com.llama.tech.utils.dict.Dictionary;
import com.llama.tech.utils.dict.LlamaDict;
import com.llama.tech.utils.dict.LlamaDict.UnhashableTypeException;
import com.llama.tech.utils.list.Lista;
import com.llama.tech.utils.list.LlamaArrayList;
import com.llama.tech.utils.list.LlamaIterator;

public class SistemaConsulta implements ISistemaConsulta{

	private  Dictionary<String,Aerolinea> aerolineas;
	private Dictionary<String, Aeropuerto> aeropuertos;
	private Query query;
	private int anho;
	private int mes;

	public SistemaConsulta(int pmes, int panho) throws ClassNotFoundException, SQLException
	{
		aerolineas = new LlamaDict<String, Aerolinea>(1500); 
		aeropuertos = new LlamaDict<String, Aeropuerto>(2000);
		query = new Query();
		mes=pmes;
		anho=panho;
	}

	@Override
	public void cargar() throws IOException, UnhashableTypeException, SQLException
	{
		cargarAerolineas();
		cargarAeropuertos();
		cargarVuelos();
	}


	public void cargarVuelos() throws IOException, UnhashableTypeException, SQLException {


		Lista<String> info = query.get_flightsPerMonth(anho+"", mes+"");

		//Vuelo(int 0 numeroVuelo, String 1 aerolinea, Calendar 2 fecha, Calendar 3 horaDespegueProg, 
		//Calendar 4 horaDespegueReal, Calendar 5 horaAterrizajeProg, Calendar 6 horaAterrizajeReal,
		//Aeropuerto 7 origen, Aeropuerto 8 destino, String 9 avion, int 10 distancia, boolean 11 pcancelado)




		for(int i=0; i<info.size();i++)
		{
			String p[]=info.get(i).split(":");

			Aerolinea ar = aerolineas.getValue(p[1]);
			Aeropuerto origen = aeropuertos.getValue(p[7]);
			Aeropuerto destino = aeropuertos.getValue(p[8]);

			LocalDate fecha = LocalDate.of(anho, mes, Integer.parseInt(p[2].split(",")[0]));

			if(p[4].length()==3)
				p[4] = "0"+p[4];
			if(p[6].length()==3)
				p[6]="0"+p[6];

			int horDesReal=Integer.parseInt(p[4].substring(0, 1));
			int minDesReal=Integer.parseInt(p[4].substring(2, 3));
			int horAterReal=Integer.parseInt(p[6].substring(0, 1));;
			int minAterReal=Integer.parseInt(p[6].substring(2, 3));;


			LocalTime horaDesReal = LocalTime.of(horDesReal, minDesReal);
			LocalDateTime horaDespegueReal = LocalDateTime.of(fecha, horaDesReal);

			LocalTime horaAterReal = LocalTime.of(horAterReal, minAterReal);
			LocalDateTime horaAterrizajeReal = LocalDateTime.of(fecha, horaAterReal);

			boolean cancelado = p[11].equals("0")?false:true;

			Vuelo v = new Vuelo(Integer.parseInt(p[0]), ar.getCodigo(), fecha, p[3], horaDespegueReal, p[5], horaAterrizajeReal, origen, destino, p[9], Integer.parseInt(p[10]), cancelado);

			ar.addVuelo(v);
			destino.addVuelo(v);

		}


	}


	private void cargarAeropuertos() throws IOException, UnhashableTypeException {

		File f = new File("./data/airports.csv");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);

		for(String line = br.readLine();line!=null;line=br.readLine())
		{
			//"iata","airport","city","state","country","lat","long"
			String[] info= line.split(",");
			Aeropuerto ar = new Aeropuerto(info[0],Double.parseDouble(info[5]),Double.parseDouble(info[6]),info[1],info[2],info[4],info[3]);
			aeropuertos.addEntry(info[0], ar);

		}

		fr.close();
		br.close();

		f = new File("./data/aeropuertos.csv");
		fr = new FileReader(f);
		br = new BufferedReader(fr);

		for(String line = br.readLine();line!=null;line=br.readLine())
		{
			//			locationID;Latitude;Longitud
			String no = "Información no disponible";
			String[] info= line.split(",");
			Aeropuerto ar = new Aeropuerto(info[0],Double.parseDouble(info[1]),Double.parseDouble(info[2]),no,no,no,no);
			aeropuertos.addEntry(info[0], ar);

		}

		fr.close();
		br.close();

	}

	@Override
	public Lista<Vuelo> buscarVuelo(String codigo) {

		Aerolinea ar = aerolineas.getValue(codigo.substring(0, 1));


		return ar.busquedaBinariaVuelo(codigo.substring(2, codigo.length()-1));


	}

	@Override
	public Lista<Vuelo> buscarVuelosDirectos(String codigoOrigen,
			String codigoDestino) {
		Lista<Vuelo> vuelos = aeropuertos.getValue(codigoDestino).darVuelos();
		Lista<Vuelo> ret = new LlamaArrayList<Vuelo>(200);

		LlamaIterator<Vuelo> it = vuelos.iterator();

		while(it.hasNext())
		{
			Vuelo v = it.next();
			if(v.getOrigen().getCodigo().equals(codigoOrigen))
				ret.addAlFinal(v);
		}

		return ret;
	}

	@Override
	public Aeropuerto buscarAeropuerto(String codigo) {

		return aeropuertos.getValue(codigo);
	}

	@Override
	public Lista<Vuelo> buscarVuelosPeriodoFecha(LocalDateTime fechaInic, LocalDateTime fechaFin, String codAeropuerto) {

		return aeropuertos.getValue(codAeropuerto).buscarVuelosPeriodoFecha(fechaInic, fechaFin);
	}

	@Override
	public void eliminarVuelo(String codigo) {

		aerolineas.getValue(codigo.substring(0, 1)).removeVuelo(codigo.substring(2, codigo.length()-1));;

	}

	@Override
	public Lista<Aeropuerto> darAeropuertoLimitesGeograficos(int max,
			String latlonMax, String latlonMin) {
		Lista<Aeropuerto> ret = new LlamaArrayList<Aeropuerto>(max);

		LlamaIterator<Aeropuerto> it = aeropuertos.getValues();

		double latMax = Double.parseDouble(latlonMax.split(";")[0]);
		double latMin = Double.parseDouble(latlonMin.split(";")[0]);
		double lonMax = Double.parseDouble(latlonMax.split(";")[1]);
		double lonMin = Double.parseDouble(latlonMin.split(";")[1]);

		int contador =0;

		while(it.hasNext()&&contador!=max)
		{
			Aeropuerto ar = it.next();
			if(ar.getLatitud()<=latMax&&ar.getLatitud()>=latMin&&ar.getLongitud()<=lonMax&&ar.getLongitud()>=lonMin)
				ret.addAlFinal(ar);
		}

		return ret;
	}

	@Override
	public String[] darTraficoAeropuertos(int n, String[] codigos) {

		String[] info = new String[n];
		int pos =0;

		for(String s:codigos)
		{
			Aeropuerto ar = aeropuertos.getValue(s);
			String inf = ar.getCodigo()+":"+ar.getNombre()+":"+ar.darTrafico();
			info[pos]=inf;
			pos++;
		}

		return null;
	}


	private void cargarAerolineas() throws IOException, UnhashableTypeException {

		File f = new File("./data/airlines.csv");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);

		for(String line = br.readLine();line!=null;line=br.readLine())
		{
			System.out.println(line);
			if(!line.split(",")[0].equals(""))
			{
				Aerolinea al = new Aerolinea(line.split(",")[0],line.split(",")[1]);
				aerolineas.addEntry(line.split(",")[0], al);
			}

		}
		fr.close();
		br.close();


	}

	@Override
	public void cambiarTemporada(int panho, int pmes) throws IOException, UnhashableTypeException, SQLException 
	{
		mes = pmes;
		anho=panho;
		cargarVuelos();

	}

	@Override
	public void cerrarInstancia() {
		// TODO Auto-generated method stub

	}

}
