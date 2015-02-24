package com.llama.tech.airports.backbone;

import com.llama.tech.utils.list.Lista;
import com.llama.tech.utils.list.LlamaArrayList;

public class Aerolinea {

	private String codigo;
	private String nombre;
	private Lista<Vuelo> vuelos;

	public Aerolinea(String pCodigo, String pNombre)
	{
		codigo=pCodigo;
		nombre = pNombre;
		vuelos = new LlamaArrayList<Vuelo>(100);
	}

	public void addVuelo(Vuelo v)
	{
		vuelos.add(busquedaBinariaPos(v), v);

	}

	/**
	 * 
	 * @param codigo recibe solo la parte numerica del codigo
	 */
	public void removeVuelo(String codigo)
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


	}

	/**
	 * 
	 * @param codigo recibe solo la parte númerica del código
	 * @return
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



}
