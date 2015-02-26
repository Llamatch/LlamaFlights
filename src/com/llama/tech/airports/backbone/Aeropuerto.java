package com.llama.tech.airports.backbone;


import java.io.Serializable;
import java.time.LocalDateTime;

import com.llama.tech.utils.list.Lista;
import com.llama.tech.utils.list.LlamaArrayList;
import com.llama.tech.utils.list.LlamaIterator;

/**
 * Esta clase modela un aeropuerto
 */
public class Aeropuerto implements Serializable {
	
	/**
	 * Este atributo representa el codigo IATA unico del aeropuerto
	 */
	private String codigo;
	
	/**
	 * Este atributo representa la latitud del aeropuerto
	 */
	private double latitud;
	
	/**
	 * Este atributo representa la longitud del aeropuerto
	 */
	private double longitud;
	
	/**
	 * Este atributo representa la lista de vuelos aterrizando en el aeropuerto
	 */
	private Lista<Vuelo> vuelos;
	
	/**
	 * Este atributo representa el nombre del aeropuerto
	 */
	private String nombre;
	
	/**
	 * Representa la ciudad del aeropuerto
	 */
	private String ciudad;
	
	/**
	 * Este atributo representa el pais del aeropuerto
	 */
	private String pais;
	
	/**
	 * Este atributo representa el estado del aeropuerto
	 */
	private String estado;
	
	/**
	 * Este es el método constructor de un aeropuerto
	 * @param codigo codigo del aeropuerto
	 * @param latitud latitud de aeropuerto
	 * @param longitud longitud del aeropuerto
	 * @param nombre nombre del aeropuerto
	 * @param ciudad ciudad del aeropuerto
	 * @param pais pais del aeropuerto
	 * @param estado estado del aeropuerto
	 */
	public Aeropuerto(String codigo, double latitud, double longitud,
			String nombre, String ciudad, String pais, String estado) {
		
		
		this.codigo = codigo;
		this.latitud = latitud;
		this.longitud = longitud;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
		this.estado = estado;
		
		vuelos = new LlamaArrayList<Vuelo>(200);
	}
	
	@Override
	public int hashCode()
	{
		return codigo.hashCode();
	}
	
	/**
	 * Este método agrega un vuelo de manera ordenada ( por fecha ) a la lista de vuelos
	 * @param v Vuelo a agregar
	 */
	public void addVuelo(Vuelo v)
	{
		vuelos.add(busquedaBinaria(v), v);
	}
	
	/**
	 * Este metodo reinicia la lista de vuelos
	 */
	public void clarVuelos()
	{
		vuelos.clear();
	}
	
	/**
	 * Este método utiliza la búsqueda binaria para encontrar la posición en la que se debería agregar un vuelo según su código
	 * @param v Vuelo a agregar
	 * @return posición apropiada
	 */
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
	
	/**
	 * Este método retorna un alista de vuelos que estén en el periodo dado por parámetro
	 * @param fechaInic hora de ocmienzo del parámetro
	 * @param fechaFin hora de fin del parámetro
	 * @return Lista con vuelos que estén dentro de las hroas estipuladas
	 */
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
	
	/**
	 * Borra de la lista de vuelos todos lo scuelos con el codigo dado por parametro
	 * @param codigo codigo de vuelos a borrar
	 */
	public boolean removeVuelo(String codigo)
	{
		LlamaIterator<Vuelo> it = vuelos.iterator();
		boolean ret = false;
		int pos=0;
		while(it.hasNext())
		{
			Vuelo v = it.next();
			if(v.getCodigo().equals(codigo))
			{
				vuelos.remove(pos);
				ret=true;
			}
			pos++;
		}
		
		return ret;
	}
	
	/**
	 * Dá el tráfico ( num vuelos) de el aeropuerto
	 * @return trafico del aeropuerto
	 */
	public int darTrafico()
	{
		return vuelos.size();
	}
	
	/**
	 * Retorna la lista de vuelos
	 * @return lista de vuelos
	 */
	public Lista<Vuelo> darVuelos()
	{
		return vuelos;
	}

	/**
	 * Retorna el codigo del aeropuerto
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Retorna la latitud del aeropuerto
	 * @return latitud
	 */
	public double getLatitud() {
		return latitud;
	}

	/**
	 * Retorna la ongitud del aeropuerto
	 * @return longitud
	 */
	public double getLongitud() {
		return longitud;
	}

	/**
	 * Retorna el nombre del aeropuerto
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Retirna la ciudad del aeropuerto
	 * @return ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * Retorna el pais del aeropuerto
	 * @return pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * Retorna el estado del aeropuerto
	 * @return estado
	 */
	public String getEstado() {
		return estado;
	}
	
	
	
	

}
