package com.llama.tech.airports.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class Query 
{
	private final static String IP = "157.253.236.58";
	private final static String PORT = "5432";
	private final static String USER = "estudiante";
	private final static String PASS = "EstructurasDatos2015";
	private final static String DB = "estructurasVuelos";
	//jdbc:postgresql://157.253.236.58:5432/estructurasVuelos
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
	
	public Query() throws ClassNotFoundException, SQLException
	{
		Class.forName("org.postgresql.Driver");
		System.out.println("Connecting to: "+IP+":"+PORT);
		conn = DriverManager.getConnection(URL, USER, PASS);
		System.out.println("Opened database successfully");
		Statement stmt = conn.createStatement();
		String sql = "select origen,año,mes,dia,destino,num_vuelo,carrier from vuelos where año = '2007' and mes = '4' and dia = '28' and origen ='IAH'";
		ResultSet rs = stmt.executeQuery(sql);
		int count = 0;
		while(rs.next())
		{
			System.out.println(rs.getString(1)+":"+rs.getString(7)+rs.getString(6));
			count++;
		}
		System.out.println(count);
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
	
	
	
	
	public static void main(String[] args) 
	{
		try {
			new Query();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}