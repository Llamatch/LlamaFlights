package com.llama.tech.airports.backbone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
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
import com.opencsv.CSVReader;

/**
 * Esta es la clase principal del mundo
 */
public class SistemaConsulta implements ISistemaConsulta, Serializable{

	/**
	 * Este es el diccionario donde se guardan las areolinas del sistema
	 */
	private  Dictionary<String,Aerolinea> aerolineas;

	/**
	 * Este es el diccionario donde se guardan los aeropuertos del sistema
	 */
	private Dictionary<String, Aeropuerto> aeropuertos;

	/**
	 * Esta es la instancia de la clase que contiene la conexion a la base de datos
	 */
	private transient Query query;

	/**
	 * Este es el entero que representa el año de consluta
	 */
	private int anho;

	/**
	 * Este es el entero que representa el mes de consluta
	 */
	private int mes;

	/**
	 * Este es el total de vuelos en el sistema
	 */
	private int totalVuelos;

	/**
	 * Este es el constructor de la clase
	 * @param pmes mes en el que se quiere hacer la consulta
	 * @param panho año en el que se quiere hacer la consulta
	 * @throws ClassNotFoundException Si hay problemas conectandose a la clase del database
	 * @throws SQLException si hay problemas conectandose al database
	 * @throws UnhashableTypeException 
	 * @throws IOException 
	 */
	public SistemaConsulta(int pmes, int panho) throws ClassNotFoundException, SQLException, IOException, UnhashableTypeException
	{
		aerolineas = new LlamaDict<String, Aerolinea>(1500); 
		aeropuertos = new LlamaDict<String, Aeropuerto>(2000);
		query = new Query();
		mes=pmes;
		anho=panho;
		totalVuelos=0;
		cargar();
	}

	@Override
	public void cargar() throws IOException, UnhashableTypeException, SQLException
	{
		cargarAerolineas();
		cargarAeropuertos();
		System.out.println("PORQUE");
		cargarVuelos();
	}


	/**
	 * Carga la información de los vuelos
	 * @throws UnhashableTypeException si se intenta añadir un valor inválido a una tabla de hash
	 * @throws SQLException si hay problemas conectandose a la database
	 */
	private void cargarVuelos() throws UnhashableTypeException, SQLException {

		System.out.println("empece");

		Lista<String> info = null;

		try
		{
			info = query.get_flightsPerMonth(anho+"", mes+"");
		}
		catch(SQLException s)
		{
			s.getMessage();
		}

		//Vuelo(int 0 numeroVuelo, String 1 aerolinea, Calendar 2 fecha, Calendar 3 horaDespegueProg, 
		//Calendar 4 horaDespegueReal, Calendar 5 horaAterrizajeProg, Calendar 6 horaAterrizajeReal,
		//Aeropuerto 7 origen, Aeropuerto 8 destino, String 9 avion, int 10 distancia, boolean 11 pcancelado)

		System.out.println("segui");


		for(int i=0; i<info.size();i++)
		{	
			try

			{
				System.out.println("empece ciclo");
				String p[]=info.get(i).split(":");

				Aerolinea ar = aerolineas.getValue(p[1]);
				Aeropuerto origen = aeropuertos.getValue(p[7]);
				Aeropuerto destino = aeropuertos.getValue(p[8]);

				LocalDate fecha = LocalDate.of(anho, mes, Integer.parseInt(p[2].split(",")[0]));

				if(p[4].equals("NA"))
					p[4]=p[3];
				if(p[6].equals("NA"))
					p[6]=p[5];

				if(p[4].length()==2)
					p[4] = "00"+p[4];
				if(p[6].length()==2)
					p[6]="00"+p[6];
				if(p[3].length()==2)
					p[3]="00"+p[3];
				if(p[5].length()==2)
					p[5]="00"+p[5];

				if(p[4].length()==3)
					p[4] = "0"+p[4];
				if(p[6].length()==3)
					p[6]="0"+p[6];
				if(p[3].length()==3)
					p[3]="0"+p[3];
				if(p[5].length()==3)
					p[5]="0"+p[5];



				int horDesReal=Integer.parseInt(p[4].substring(0, 1));
				int minDesReal=Integer.parseInt(p[4].substring(2, 3));
				int horAterReal=Integer.parseInt(p[6].substring(0, 1));;
				int minAterReal=Integer.parseInt(p[6].substring(2, 3));;


				LocalTime horaDesReal = LocalTime.of(horDesReal, minDesReal);
				LocalDateTime horaDespegueReal = LocalDateTime.of(fecha, horaDesReal);

				LocalTime horaAterReal = LocalTime.of(horAterReal, minAterReal);
				LocalDateTime horaAterrizajeReal = LocalDateTime.of(fecha, horaAterReal);

				boolean cancelado = p[11].equals("0")?false:true;

				Vuelo v = new Vuelo(Integer.parseInt(p[0]), ar, fecha, p[3], horaDespegueReal, p[5], horaAterrizajeReal, origen, destino, p[9], Integer.parseInt(p[10]), cancelado);
				totalVuelos++;

				ar.addVuelo(v);
				destino.addVuelo(v);

				System.out.println("vuelo");
			}
			catch(Exception e)
			{
				System.out.println(info.get(i));
				e.getStackTrace();
			}


		}


	}


	/**
	 * Carga la información de los aeropuertos desde los archivos dados
	 * @throws IOException Si hay problemas leyendo los archivos
	 * @throws UnhashableTypeException si s eintenta agregar un valor inválido a un atabla de hash
	 */
	private void cargarAeropuertos() throws IOException, UnhashableTypeException {

		File f = new File("./data/airports.csv");
		FileReader fr = new FileReader(f);

		CSVReader reader = new CSVReader(fr);
		String [] info;
		reader.readNext();
		while ((info = reader.readNext()) != null) {
			// nextLine[] is an array of values from the line
			//System.out.println(info[0] +","+ info[1] + "etc...");
			Aeropuerto ar = new Aeropuerto(info[0],Double.parseDouble(info[5]),Double.parseDouble(info[6]),info[1],info[2],info[4],info[3]);
			aeropuertos.addEntry(info[0], ar);

		}

		//		f = new File("./data/aeropuertos.csv");
		//		fr = new FileReader(f);

		//		reader = new CSVReader(fr, ';');
		//		
		//		reader.readNext();
		//	    while ((info = reader.readNext()) != null) 
		//	    {
		//	        // nextLine[] is an array of values from the line
		//	    	String no = "Información no disponible";
		//	    	System.out.println(info[0] + " etc...");
		//	    	Aeropuerto ar = new Aeropuerto(info[0],Double.parseDouble(info[1]),Double.parseDouble(info[2]),no,no,no,no);
		//			aeropuertos.addEntry(info[0], ar);	        
		//	    }


		BufferedReader br = new BufferedReader(fr);
		//
		//		br.readLine();
		//		for(String line = br.readLine();line!=null;line=br.readLine())
		//		{
		//			//"iata","airport","city","state","country","lat","long"
		//			System.out.println(line);
		//			info= line.split(",");
		//			System.out.println(info[4]);
		//			Aeropuerto ar = new Aeropuerto(info[0],Double.parseDouble(info[5]),Double.parseDouble(info[6]),info[1],info[2],info[4],info[3]);
		//			aeropuertos.addEntry(info[0], ar);
		//
		//		}
		//
		//		fr.close();
		//		br.close();

		f = new File("./data/aeropuertos.csv");
		fr = new FileReader(f);
		br = new BufferedReader(fr);

		br.readLine();
		for(String line = br.readLine();line!=null;line=br.readLine())
		{
			//			locationID;Latitude;Longitud
			String no = "Información no disponible";
			info= line.split(";");
			try
			{
				Aeropuerto ar = new Aeropuerto(info[0],Double.parseDouble(info[1]),Double.parseDouble(info[2]),no,no,no,no);
				aeropuertos.addEntry(info[0], ar);
			}
			catch(IndexOutOfBoundsException e)
			{
				System.out.println("mori");
				continue;
			}

			System.out.println("aeropuerto");

		}
		System.out.println("acabe");

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
			String codigoDestino, LocalDate fecha) {
		LocalTime inicio= LocalTime.of(0, 0);
		LocalTime fin = LocalTime.of(23, 59);
		LocalDateTime fechaInic = LocalDateTime.of(fecha, inicio);
		LocalDateTime fechaFin = LocalDateTime.of(fecha, fin);
		Lista<Vuelo> vuelos = aeropuertos.getValue(codigoDestino).buscarVuelosPeriodoFecha(fechaInic, fechaFin);
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
	public Aeropuerto buscarAeropuerto(String codigo) 
	{
		System.out.println(codigo);
		//		LlamaIterator<String> keys = aeropuertos.getKeys();
		//		while(keys.hasNext())
		//		{
		//			System.out.println(keys.next());
		//		}
		return aeropuertos.getValue(codigo);
	}

	@Override
	public Lista<Vuelo> buscarVuelosPeriodoFecha(LocalDateTime fechaInic, LocalDateTime fechaFin, String codAeropuerto) {

		return aeropuertos.getValue(codAeropuerto).buscarVuelosPeriodoFecha(fechaInic, fechaFin);
	}

	@Override
	public boolean eliminarVuelo(String codigo) {

		return aerolineas.getValue(codigo.substring(0, 1)).removeVuelo(codigo.substring(2, codigo.length()-1));

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


	/**
	 * Carga las aerolineas desde el archivo dado
	 * @throws IOException Si hay problemas leyendo el archivo
	 * @throws UnhashableTypeException Si se intenta agregar un valor inválido a una tabla de hash
	 */
	private void cargarAerolineas() throws IOException, UnhashableTypeException {

		File f = new File("./data/airlinesIATA.csv");
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
		totalVuelos=0;
		mes = pmes;
		anho = panho;
		LlamaIterator<Aeropuerto> it = aeropuertos.getValues();
		while(it.hasNext())
			it.next().clarVuelos();

		LlamaIterator<Aerolinea> ir = aerolineas.getValues();
		while(ir.hasNext())
			it.next().clarVuelos();
		cargarVuelos();

	}

	@Override
	public void cerrarInstancia() throws SQLException 
	{
		query.close_connection();
	}

	public int getTotalVuelos()
	{
		return totalVuelos;
	}

	@Override
	public void reInitializeConnection() throws ClassNotFoundException, SQLException 
	{
		query = new Query();

	}

}
