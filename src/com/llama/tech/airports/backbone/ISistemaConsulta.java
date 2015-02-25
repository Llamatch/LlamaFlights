package com.llama.tech.airports.backbone;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Calendar;

import com.llama.tech.utils.dict.LlamaDict.UnhashableTypeException;
import com.llama.tech.utils.list.Lista;

/**
 * Esta interfaz modela la clase principal del mundo
 */
public interface ISistemaConsulta 
{
	/**
	 * Este método se encarga de cargar la información al mundo dado el mes y anho de preferencia del usuario
	 * @throws IOException Si hay un problema leyendo alguno de los archivos
	 * @throws UnhashableTypeException Si se intenta agregar un elemento inválido a la tabla de hash
	 * @throws SQLException si hay un problema leyendo la base de datos
	 */
	public void cargar() throws IOException, UnhashableTypeException, SQLException;
	
	/**
	 * Devuelve una lista con los vuelos que tiene el codigo dado por parámetro
	 * @param codigo Codigo del vuelo al que se le solicita la información
	 * @return Lista con los vuelos que tienen el codigo dado por parametro
	 */
	public Lista<Vuelo> buscarVuelo(String codigo);
	
	/**
	 * Devuelve una lista con todos los vuelos que viajan de un aeropuerto de origen dado a un aeropuerto de destino dado
	 * @param codigoOrigen Codigo del aeropuerto de origen
	 * @param codigoDestino Codigo del aeropuerto de destino
	 * @return Lista con los vuelos directos entre los dos aeropuertos
	 */
	public Lista<Vuelo> buscarVuelosDirectos (String codigoOrigen, String codigoDestino);
	
	/**
	 * Busca un aeropuerto dado su codigo
	 * @param codigo Codigo del aeropuerto que s ebusca
	 * @return Aeropuerto con el codigo dado por parametro o null si no existe
	 */
	public Aeropuerto buscarAeropuerto (String codigo);
	
	/**
	 * Busca los vuelos aterrizando en un aeropuerto dadas unas horas iniciales y finales.
	 * @param fechaInic Hora de inicio de periodo
	 * @param fechaFin Hora de fin de periodo
	 * @param codAeropuerto Codigo de aeropuerto a consultar
	 * @return Lista con los vuelos aterrizando en el aeropuerto con codigo dado por parametro entre la shoras estipuladas
	 */
	public Lista<Vuelo> buscarVuelosPeriodoFecha (LocalDateTime fechaInic, LocalDateTime fechaFin, String codAeropuerto);
	
	/**
	 * Elimina un vuelo del sistema dado su codigo
	 * @param codigo Codigo del vuelo a eliminar
	 */
	public void eliminarVuelo (String codigo);
	
	/**
	 * Devuelve una lista con máximo max aeropuertos que tienen su ubicación geográfica dentro de los límites estipulados. 
	 * @param max Maximo de aeropuertos a visualizar
	 * @param latlonMax String con la información de los límites máximos. formato:   latitud:longitud
	 * @param latlonMin String con la información de los límites mínimos.  formato:   latitud:longitud
	 * @return Lista con máximo max aeropuertos que estén dentro de los límites geográficos.
	 */
	public Lista<Aeropuerto> darAeropuertoLimitesGeograficos(int max, String latlonMax, String latlonMin);
	
	/**
	 * Da una lista con la información de tráfico de aeropuertos de los n aeropuertos cuyo código se recibe por parámetro
	 * @param n Nùmero de aeropuertos de los cuales se requiere la información del tráfico aereo
	 * @param codigos Codigos de los aeropuertos a consultar
	 * @return String[] con la información de tráfico y el formato:  codigo:nombre:numeroVuelos
	 */
	public String[] darTraficoAeropuertos(int n, String[] codigos);
	
	/**
	 * Este método permite cambiar la temporada actual a una diferente. Cuando se ejecuta, la información de vuelos se actualiza.
	 * @param anho Año de la información solicitada
	 * @param mes Mes de la información solicitada
	 * @throws IOException Si hay un problema leyendo algún archivo
	 * @throws UnhashableTypeException Si se intenta añadir un elemento inválido a una tabla de hash
	 * @throws SQLException Si hay algun problema accediendo a la base de datos
	 */
	public void cambiarTemporada(int anho, int mes) throws IOException, UnhashableTypeException, SQLException;
	
	/**
	 * Cierra la conexión con la base de datos.
	 * @throws SQLException Si ocurre un error al intentar cerrar la conexión con la base de datos.
	 */
	public void cerrarInstancia() throws SQLException;
	
	/**
	 * Retorna el número total de vuelos cargados para una temporada
	 * @return El número total de vuelos. 
	 */
	public int getTotalVuelos();
}
