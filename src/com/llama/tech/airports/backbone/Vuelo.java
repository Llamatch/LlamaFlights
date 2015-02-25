package com.llama.tech.airports.backbone;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * Esta clase modela un vuelo
 */
public class Vuelo {
	
	/**
	 * Este atributo representa el numero del vuelo
	 */
	private int numeroVuelo;
	
	/**
	 * Este atributo representa el codigo de la areolinea del vuelo
	 */
	private Aerolinea aerolinea;
	
	/**
	 * Este atributo representa el codigo del vuelo
	 */
	private String codigo;
	
	/**
	 * Este atributo representa la fecha del vuelo
	 */
	private LocalDate fecha;
	
	/**
	 * Este atributo representa la hora de despegue programada del vuelo
	 */
	private String horaDespegueProg;
	
	/**
	 * Este atributo representa la hora de despegue real del vuelo
	 */
	private LocalDateTime horaDespegueReal;
	
	/**
	 * Este atributo representa  la hora de aterrizaje programada del vuelo
	 */
	private String horaAterrizajeProg;
	
	/**
	 * Este atributo representa la hora de aterrizaje real del vuelo
	 */
	private LocalDateTime horaAterrizajeReal;
	
	/**
	 * Este atributo representa el aeropuerto origen del vuelo
	 */
	private Aeropuerto origen;
	
	/**
	 * Este atributo representa el aeropuerto destino del vuelo
	 */
	private Aeropuerto destino;
	
	/**
	 * Este atributo representa el avion del vuelo
	 */
	private String avion;
	
	/**
	 * Este atributo representa la distancia recorrida en el vuelo
	 */
	private int distancia;
	
	/**
	 * Este atributo representa el estado de cancelación del vuelo
	 */
	private boolean cancelado;
	
	/**
	 * Este es el constructor de un vuelo.
	 * @param numeroVuelo
	 * @param aerolinea
	 * @param fecha
	 * @param horaDespegueProg
	 * @param horaDespegueReal
	 * @param horaAterrizajeProg
	 * @param horaAterrizajeReal
	 * @param origen
	 * @param destino
	 * @param avion
	 * @param distancia
	 * @param pcancelado
	 */
	public Vuelo(int numeroVuelo, Aerolinea aerolinea, LocalDate fecha, String horaDespegueProg, LocalDateTime horaDespegueReal,
			String horaAterrizajeProg, LocalDateTime horaAterrizajeReal,Aeropuerto origen, Aeropuerto destino, String avion, int distancia, boolean pcancelado) 
	{
		
		//solo se necesita compara hora real. Programada -> String 
		this.numeroVuelo = numeroVuelo;
		this.aerolinea = aerolinea;
		codigo = aerolinea.getCodigo()+numeroVuelo;;
		this.fecha = fecha;
		this.horaDespegueProg = horaDespegueProg;
		this.horaDespegueReal = horaDespegueReal;
		this.horaAterrizajeProg = horaAterrizajeProg;
		this.horaAterrizajeReal = horaAterrizajeReal;
		this.origen = origen;
		this.destino = destino;
		this.avion = avion;
		this.distancia = distancia;
		cancelado = pcancelado;
	
	}
 

	/**
	 * Retorna el numero del vuelo
	 * @return numero del vuelo
	 */
	public int getNumeroVuelo() {
		return numeroVuelo;
	}

	/**
	 * Retorna la aerolinea del vuelo
	 * @return codigo de la aerolinea
	 */
	public Aerolinea getAerolinea() {
		return aerolinea;
	}


	/**
	 * Retorna el codigo del vuelo
	 * @return codigo del vuelo
	 */
	public String getCodigo() {
		return codigo;
	}


	/**
	 * Retorna la fecha del vuelo
	 * @return fecha del vuelo
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * Retorna la hora de despegue programada del vuelo
	 * @return hora de despegue programda
	 */
	public String getHoraDespegueProg() {
		return horaDespegueProg;
	}

	/**
	 * Retorna la hora de despegue real del vuelo
	 * @return hora de despegue real
	 */
	public LocalDateTime getHoraDespegueReal() {
		return horaDespegueReal;
	}

	/**
	 * Retorna la hora de aterrizaje programada
	 * @return hora de aterrizaje programada
	 */
	public String getHoraAterrizajeProg() {
		return horaAterrizajeProg;
	}

	/**
	 * Reotrna la hora de aterrizaje real del vuelo
	 * @return hora de aterrizaje real
	 */
	public LocalDateTime getHoraAterrizajeReal() {
		return horaAterrizajeReal;
	}

	/**
	 * Retorna el aeropuerto origen del vuelo
	 * @return aeropuerto origen
	 */
	public Aeropuerto getOrigen() {
		return origen;
	}

	/**
	 * Retorna el aeropuerto destino del vuelo
	 * @return aeropuerto destino
	 */
	public Aeropuerto getDestino() {
		return destino;
	}

	/**
	 * Retorna el avion del vuelo
	 * @return avion del vuelo
	 */
	public String getAvion() {
		return avion;
	}

	/**
	 * Retorna la distancia recorrida por el vuelo
	 * @return distancia
	 */
	public int getDistancia() {
		return distancia;
	}	
	
	@Override
	public String toString()
	{
		return codigo + horaDespegueReal.toString();
	}

}
