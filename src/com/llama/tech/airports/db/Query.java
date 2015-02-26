package com.llama.tech.airports.db;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import com.llama.tech.airports.backbone.Aeropuerto;
import com.llama.tech.utils.list.Lista;
import com.llama.tech.utils.list.LlamaArrayList;
import com.opencsv.CSVReader;

public final class Query
{
	private final static String IP = "157.253.236.58";
	private final static String PORT = "5432";
	private final static String USER = "estudiante";
	private final static String PASS = "EstructurasDatos2015";
	private final static String DB = "estructurasVuelos";
	private final static String URL = "jdbc:postgresql://"+IP+":"+PORT+"/"+DB;
	private Connection conn;
	
	
//	año
//	mes
//	dia
//	dia_semana
//	DepTime
//	CRSDepTime
//	ArrTime
//	CRSArrTime
//	carrier
//	num_vuelo
//	TailNum
//	tiempo_vuelo_actual
//	tiempo_vuelo_programado
//	airTime
//	arrDelay
//	depDelay
//	origen
//	destino
//	distancia
//	tax_in
//	tax_out
//	cancelado
//	codigoCancelacion
//	desviado
//	retraso_carrier
//	retraso_clima
//	retraso_NAS
//	retraso_seguridad
//	retraso_tripulacion
	
	/**
	 * Este es el constructor del Query. El hace el contacto con el database
	 * @throws ClassNotFoundException si no se encuentra la clase
	 * @throws SQLException si hay problemas accediendo al database
	 */
	public Query() throws ClassNotFoundException, SQLException
	{
		Class.forName("org.postgresql.Driver");
		System.out.println("Connecting to: "+IP+":"+PORT);
		conn = DriverManager.getConnection(URL, USER, PASS);
		System.out.println("Opened database successfully");
		//select column_name from information_schema.columns where table_name='table'
		//select año,mes,dia,origen,destino,num_vuelo from vuelos where año = "2007" and mes = "4"
        //
//		SELECT vuelos.carrier AS carrier,
//	       COUNT(*) AS num_vuelo
//	 FROM  vuelos
//	 JOIN  Book_author
//	   ON  Book.isbn = Book_author.isbn
//	 GROUP BY Book.title;
		//
	}
	
	/**
	 * Este metodo imprime la lista entera de aeropuertos origen
	 * @throws SQLException si hay problemas accediendo la base de datos
	 */
	public void get_airportList() throws SQLException
	{
		
		Statement stmt = conn.createStatement();
		String sql = "SELECT DISTINCT origen FROM vuelos;";
		//String sql = "select origen,año,mes,dia,destino,num_vuelo,carrier from vuelos where año = '2007' and mes = '4' and dia = '28' and origen ='IAH'";
		ResultSet rs = stmt.executeQuery(sql);
		int count = 0;
		while(rs.next())
		{
			System.out.println(rs.getString(1));
			count++;
		}
		System.out.println(count);
		stmt.close();
	}
	
	/**
	 * Este metodo imprime los vuelos de un dia
	 * @param year año consulta
	 * @param month mes consulta
	 * @param day dia consulta
	 * @throws SQLException si hay problemas accediendo la base de datos
	 */
	public void get_flightsPerDay(String year, String month, String day) throws SQLException
	{
		Lista<String> l;
		Statement stmt = conn.createStatement();
		String sql = String.format("SELECT carrier, num_vuelo, origen, destino, distancia,\"DepTime\", \"TailNum\" FROM vuelos WHERE año = '%s' AND mes = '%s' AND dia = '%s' AND carrier = 'AA';", year, month, day);
		ResultSet rs = stmt.executeQuery(sql);
		int count = 0;
		while(rs.next())
		{
			System.out.println(rs.getString(1)+rs.getString(2)+":"+rs.getString(6)+"("+rs.getString(7)+")");
			count++;
		}
		System.out.println(count);
		stmt.close();
	}
	
	/**
	 * Este metodo retorna una lista con todos los vuelos de un mes
	 * @param year año consulta
	 * @param month mes consulta
	 * @return lista con vuelos del mes solicitado
	 * @throws SQLException si hay problemas accediendo la base de datos
	 */
	public Lista<String> get_flightsPerMonth(String year, String month) throws SQLException
	{

		Lista<String> l = new LlamaArrayList<String>(2000);
		Statement stmt = conn.createStatement();
//		String sql = String.format("SELECT dia, "
//				+ "carrier, num_vuelo, origen, destino, distancia,'DepTime', "
//				+ "cancelado FROM vuelos WHERE año = '%s' AND mes = '%s';", year, month);
		System.out.println("Fetching...");
		String sql = String.format("SELECT dia, \"DepTime\", \"CRSDepTime\", \"ArrTime\", \"CRSArrTime\", "
				+ "carrier, num_vuelo, \"TailNum\", origen, destino, distancia, "
				+ "cancelado FROM vuelos WHERE año = '%s' AND mes = '%s';", year, month);
		
//		String sql = String.format("SELECT 1dia, 2DepTime, 3CRSDepTime, 4ArrTime, 5CRSArrTime, "
//		+ "6carrier, 7num_vuelo, 8TailNum, 9origen, 10destino, 11distancia, "
//		+ "12cancelado, 13ArrTime FROM vuelos WHERE año = '%s' AND mes = '%s';", year, month);
		
		//Vuelo(int numeroVuelo, String aerolinea, Calendar fecha, Calendar horaDespegueProg, 
//		Calendar horaDespegueReal, Calendar horaAterrizajeProg, Calendar horaAterrizajeReal,
		//Aeropuerto origen, Aeropuerto destino, String avion, int distancia, boolean pcancelado) 
		
		ResultSet rs = stmt.executeQuery(sql);
		int count = 0;
		while(rs.next())
		{
//			System.out.println(rs.getString(1)+rs.getString(2)+":"+rs.getString(6));
			StringBuilder s = new StringBuilder();
			s.append(rs.getString(7));
			s.append(":");
			s.append(rs.getString(6));
			s.append(":");
			//dia,mes,año
			s.append(rs.getString(1)+","+month+","+year);
			s.append(":");
			s.append(rs.getString(3));
			s.append(":");
			s.append(rs.getString(2));
			s.append(":");
			s.append(rs.getString(5));
			s.append(":");
			s.append(rs.getString(4));
			s.append(":");
			s.append(rs.getString(9));
			s.append(":");
			s.append(rs.getString(10));
			s.append(":");
			s.append(rs.getString(8));
			s.append(":");
			s.append(rs.getString(11));
			s.append(":");
			s.append(rs.getString(12));
			
			//System.out.println(s.toString());
			l.addAlFinal(s.toString());
			count++;
		}
		//System.out.println(count);
		stmt.close();
		
		return l;
	}
	
	/**
	 * Este metodo cierra la conexión con la base de datos
	 * @throws SQLException si hay problemas accediendo la base de datos
	 */
	public void close_connection() throws SQLException
	{
		System.out.print("Closing connection...");
		conn.close();
		System.out.print("Done!\n");
	}
	
	/**
	 * Este main sirve para probar los metodos de query
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try 
		{
			Query q = new Query();
			q.get_flightsPerMonth("2006", "3");
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}

