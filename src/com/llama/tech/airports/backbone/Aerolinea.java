package com.llama.tech.airports.backbone;

import java.io.Serializable;

import com.llama.tech.utils.list.Lista;
import com.llama.tech.utils.list.LlamaArrayList;

/**
 * Esta es la clase que modela una aerolinea
 */
public class Aerolinea implements Serializable{

	/**
	 * Este es el atributo que representa el codigo único de la areolina
	 */
	private String codigo;
	
	/**
	 * Este es el atributo que representa el nombre de la areolina
	 */
	private String nombre;
	
	/**
	 * Este es la lista de los vuelos pertenecientes a esta aerolinea
	 */
	private Lista<Vuelo> vuelos;

	/**
	 * Este es el metodo constructor de una aerolinea
	 * @param pCodigo codigo de la aerolinea
	 * @param pNombre nombre de la aerolinea
	 */
	public Aerolinea(String pCodigo, String pNombre)
	{
		codigo=pCodigo;
		nombre = pNombre;
		vuelos = new LlamaArrayList<Vuelo>(100);
	}
	
	@Override
	public int hashCode()
	{
		return codigo.hashCode();
	}

	/**
	 * Este metodo añade un vuelo a la lista de vuelos, e manera ordenada por codigo
	 * @param v vuelo a añadir
	 */
	public void addVuelo(Vuelo v)
	{
		vuelos.add(busquedaBinariaPos(v), v);

	}
	
	/**
	 * Este método reinicia la lista de vuelos
	 */
	public void clarVuelos()
	{
		vuelos.clear();
	}

	/**
	 * Este método remueve todos los vuelos que tengan el codigo dato por parametro de la aerolinea
	 * @param codigo Codigo de vuelos a eliminar. Recibe solo la parte numerica del codigo
	 */
	public boolean removeVuelo(String codigo)
	{


		//codigo son solo los dos ultimos numeros
		int cod = Integer.parseInt(codigo);
		int inicio =0;
		int fin= vuelos.size()-1;
		int medio =0;
		boolean borreAero=false;

		while(inicio<=fin)
		{
			medio=(inicio+fin)/2;
			if(vuelos.get(medio).getNumeroVuelo()==cod)
			{
				Vuelo v = vuelos.remove(medio);
				if(!borreAero)
				{
					v.getDestino().removeVuelo(this.codigo+codigo);
					borreAero=true;
				}
				medio++;
			}
			else if(vuelos.get(medio).getNumeroVuelo()<cod)
			{
				inicio = medio+1;
			}
			else
			{
				fin=medio-1;
			}
		}
		
		return borreAero;


	}

	/**
	 * Este vuelo busca todos los vuelos que tengas el codigo dado por parametro
	 * @param codigo Codigo de vuelos a consultar. Recibe solo la parte númerica del código
	 * @return Lista con todos los vuelos que tengan el código dado por parámetro
	 */
	public Lista<Vuelo> busquedaBinariaVuelo(String codigo)
	{
		Lista<Vuelo> ret = new LlamaArrayList<Vuelo>(30);

		//codigo son solo los dos ultimos numeros
		int cod = Integer.parseInt(codigo);
		int inicio =0;
		int fin= vuelos.size()-1;
		int medio =0;

		while(inicio<=fin)
		{
			medio=(inicio+fin)/2;
			if(vuelos.get(medio).getNumeroVuelo()==cod)
			{
				ret.addAlFinal(vuelos.get(medio));
				medio++;
			}
			else if(vuelos.get(medio).getNumeroVuelo()<cod)
			{
				inicio = medio+1;
			}
			else
			{
				fin=medio-1;
			}
		}

		return ret;

	}

	/**
	 * Este metodo hace uso de la búsqueda binaria para encontrar la posición en la que se debería agregar un vuelo según su codigo
	 * @param v Vuelo a agregar
	 * @return posición apropiada para agregar vuelo.
	 */
	public int busquedaBinariaPos(Vuelo v)
	{
		int inicio =0;
		int fin= vuelos.size()-1;
		int medio =0;
		boolean encontre = false;

		while(inicio<=fin&&!encontre)
		{
			medio=(inicio+fin)/2;
			if(vuelos.get(medio).getNumeroVuelo()==v.getNumeroVuelo())
			{
				encontre = true;
			}
			else if(vuelos.get(medio).getNumeroVuelo()<v.getNumeroVuelo())
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
	 * Este método retorna el codigo de la aerolinea 
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}


	/**
	 * Este metodo retorna el nombre de la aerolinea
	 * @return nombre aerolinea
	 */
	public String getNombre() {
		return nombre;
	}




}
