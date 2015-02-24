package com.llama.tech.airports.backbone;


import java.time.LocalDateTime;

import com.llama.tech.utils.list.Lista;
import com.llama.tech.utils.list.LlamaArrayList;
import com.llama.tech.utils.list.LlamaIterator;

public class Aeropuerto {
	
	private String codigo;
	private double latitud;
	private double longitud;
	private Lista<Vuelo> vuelos;
	private String nombre;
	private String ciudad;
	private String pais;
	private String estado;
	
	
	public Aeropuerto(String codigo, double latitud, double longitud,
			String nombre, String ciudad, String pais, String estado) {
		
		//TODO manejar constantes para asignar "info no disponible" a los respectivos atributos
		
		this.codigo = codigo;
		this.latitud = latitud;
		this.longitud = longitud;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
		this.estado = estado;
		
		vuelos = new LlamaArrayList<Vuelo>(200);
	}
	
	public void addVuelo(Vuelo v)
	{
		vuelos.add(busquedaBinaria(v), v);
	}
	
	public int busquedaBinaria(Vuelo v)
	{
		int inicio =0;
		int fin= vuelos.size()-1;
		int medio =0;
		boolean encontre = false;

		while(inicio<=fin&&!encontre)
		{
			medio=(inicio+fin)/2;
			if(vuelos.get(medio).getHoraAterrizajeReal().compareTo(v.getHoraAterrizajeReal())==0)
			{
				encontre = true;
			}
			else if(vuelos.get(medio).getHoraAterrizajeReal().compareTo(v.getHoraAterrizajeReal())<0)
			{
				inicio = medio+1;
			}
			else
			{
				fin=medio-1;
			}
		}

		return medio;
	
	}
	
	public Lista<Vuelo> buscarVuelosPeriodoFecha(LocalDateTime fechaInic, LocalDateTime fechaFin) {
		
		Lista<Vuelo> ret = new LlamaArrayList<Vuelo>(1000);
		
		LlamaIterator<Vuelo> it = vuelos.iterator();
		boolean fin = false;
		boolean inic=false;
		
		while(it.hasNext()&&!fin)
		{
			Vuelo v = it.next();
			if(!inic)
			{
				if(!v.getHoraAterrizajeReal().isBefore(fechaInic))
				{
					inic=true;
					ret.addAlFinal(v);
				}
			}
			else
			{
				if(!v.getHoraAterrizajeReal().isAfter(fechaFin))
				{
					ret.addAlFinal(v);
				}
				else
				{
					fin = true;
				}
			}
		}
		
		return ret;

	}
	
	public void removeVuelo(String codigo)
	{
		LlamaIterator<Vuelo> it = vuelos.iterator();
		
		int pos=0;
		while(it.hasNext())
		{
			Vuelo v = it.next();
			if(v.getCodigo().equals(codigo))
				vuelos.remove(pos);
			pos++;
		}
	}
	
	public int darTrafico()
	{
		return vuelos.size();
	}
	public Lista<Vuelo> darVuelos()
	{
		return vuelos;
	}

	public String getCodigo() {
		return codigo;
	}

	public double getLatitud() {
		return latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getPais() {
		return pais;
	}

	public String getEstado() {
		return estado;
	}
	
	
	
	

}
