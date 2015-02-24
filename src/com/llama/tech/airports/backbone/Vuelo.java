package com.llama.tech.airports.backbone;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

public class Vuelo {
	
	private int numeroVuelo;
	private String aerolinea;
	private String codigo;
	private LocalDate fecha;
	private String horaDespegueProg;
	private LocalDateTime horaDespegueReal;
	private String horaAterrizajeProg;
	private LocalDateTime horaAterrizajeReal;
	private Aeropuerto origen;
	private Aeropuerto destino;
	private String avion;
	private int distancia;
	private boolean cancelado;
	
	
	public Vuelo(int numeroVuelo, String aerolinea, LocalDate fecha, String horaDespegueProg, LocalDateTime horaDespegueReal,
			String horaAterrizajeProg, LocalDateTime horaAterrizajeReal,Aeropuerto origen, Aeropuerto destino, String avion, int distancia, boolean pcancelado) 
	{
		
		//solo se necesita compara hora real. Programada -> Strig 
		this.numeroVuelo = numeroVuelo;
		this.aerolinea = aerolinea;
		codigo = aerolinea+numeroVuelo;;
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
 

	public int getNumeroVuelo() {
		return numeroVuelo;
	}

	

	public void setNumeroVuelo(int numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}



	public String getAerolinea() {
		return aerolinea;
	}



	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}



	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public LocalDate getFecha() {
		return fecha;
	}



	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}



	public String getHoraDespegueProg() {
		return horaDespegueProg;
	}



	public void setHoraDespegueProg(String horaDespegueProg) {
		this.horaDespegueProg = horaDespegueProg;
	}



	public LocalDateTime getHoraDespegueReal() {
		return horaDespegueReal;
	}



	public void setHoraDespegueReal(LocalDateTime horaDespegueReal) {
		this.horaDespegueReal = horaDespegueReal;
	}



	public String getHoraAterrizajeProg() {
		return horaAterrizajeProg;
	}



	public void setHoraAterrizajeProg(String horaAterrizajeProg) {
		this.horaAterrizajeProg = horaAterrizajeProg;
	}



	public LocalDateTime getHoraAterrizajeReal() {
		return horaAterrizajeReal;
	}



	public void setHoraAterrizajeReal(LocalDateTime horaAterrizajeReal) {
		this.horaAterrizajeReal = horaAterrizajeReal;
	}



	public Aeropuerto getOrigen() {
		return origen;
	}



	public void setOrigen(Aeropuerto origen) {
		this.origen = origen;
	}



	public Aeropuerto getDestino() {
		return destino;
	}



	public void setDestino(Aeropuerto destino) {
		this.destino = destino;
	}



	public String getAvion() {
		return avion;
	}



	public void setAvion(String avion) {
		this.avion = avion;
	}



	public int getDistancia() {
		return distancia;
	}



	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	
	

}
