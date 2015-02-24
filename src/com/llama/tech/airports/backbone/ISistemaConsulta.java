package com.llama.tech.airports.backbone;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Calendar;

import com.llama.tech.utils.dict.LlamaDict.UnhashableTypeException;
import com.llama.tech.utils.list.Lista;

public interface ISistemaConsulta 
{
	public void cargar() throws IOException, UnhashableTypeException, SQLException;
	public Lista<Vuelo> buscarVuelo(String codigo);
	public Lista<Vuelo> buscarVuelosDirectos (String codigoOrigen, String codigoDestino);
	public Aeropuerto buscarAeropuerto (String codigo);
	public Lista<Vuelo> buscarVuelosPeriodoFecha (LocalDateTime fechaInic, LocalDateTime fechaFin, String codAeropuerto);
	public void eliminarVuelo (String codigo);
	public Lista<Aeropuerto> darAeropuertoLimitesGeograficos(int max, String latlonMax, String latlonMin);
	public String[] darTraficoAeropuertos(int n, String[] codigos);
	public void cambiarTemporada(int anho, int mes) throws IOException, UnhashableTypeException, SQLException;
	public void cerrarInstancia();
}
