package com.llama.tech.airports.graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ConsultaMapas implements Serializable
{

	//private static JLabel label;
	/**
	 * Este atributo mantiene la posición del color
	 */
	private static int posColor;

	/**
	 * Este metodo retorna el mapa de un aeropuerto con las coordenadas dadas por parametro
	 * @param lat latitud
	 * @param lon longitud
	 * @return icono de la imagen generada desde el url
	 * @throws MalformedURLException si la url tiene problemas
	 * @throws IOException si hay problema accediendo a internet
	 */
	public static ImageIcon consultarMapaAeropuertoUnico(String lat, String lon) throws MalformedURLException, IOException
	{
		BufferedImage imagen = ImageIO.read(new URL("http://maps.googleapis.com/maps/api/staticmap?zoom=6&size=512x512&maptype=roadmap\\&markers=size:mid%7Ccolor:red%7C"+lat+","+lon+"&sensor=false"));
		ImageIcon ic = new ImageIcon(imagen);
		return ic;

	}

	/**
	 * Este metodo retorna un color para los marcadores 
	 * @return Nombre del color
	 */
	private static String darColorAleatorio()
	{
		//		{black, brown, green, purple, yellow, blue, gray, orange, red, white}.

		if(posColor==10)
			posColor=0;

		String ret = "";
		switch(posColor){
		case 0:
			ret = "black";
			break;
		case 1:
			ret=  "brown";
			break;
		case 2:
			ret= "green";
			break;
		case 3:
			ret="purple";
			break;
		case 4:
			ret="yellow";
			break;
		case 5:
			ret="blue";
			break;
		case 6:
			ret="gray";
			break;
		case 7:
			ret="orange";
			break;
		case 8:
			ret="red";
			break;
		case 9:
			ret="white";
			break;
		default:
			ret="red";
		}
		posColor++;
		return ret;

	}

	/**
	 * Este metodo reotrna una imagen con los marcadores de los aeropuertos con coordenadas dadas por paramtero
	 * @param latlon coordenadas de aeropuertos latitug:longitud
	 * @return Imagen con mapa
	 * @throws MalformedURLException si hay problemas con la url
	 * @throws IOException si hay problemas accediendo a internet
	 */
	public static ImageIcon consultarMultiplesAeropuertos(String[] latlon) throws MalformedURLException, IOException//lat lon en formato lat:lon
	{
		String direccion = "http://maps.googleapis.com/maps/api/staticmap?size=520x520&maptype=roadmap";
		char c = 'A';
		
		for(String s : latlon)
		{
			StringBuilder ss = new StringBuilder();
			ss.append("&markers=color:");
			ss.append(darColorAleatorio());
			ss.append("%7Clabel:");
			ss.append(c);
			ss.append("%7C");
			ss.append(s.split(":")[0]);
			ss.append(",");
			ss.append(s.split(":")[1]);
			direccion+=ss.toString();
			c++;
		}
		System.out.println(direccion);
		BufferedImage imagen = ImageIO.read(new URL(direccion));
		ImageIcon ic = new ImageIcon(imagen);
		return ic;

	}

//	public static void main(String[] args) {
//
//		JFrame ventanis = new JFrame();
//		ventanis.setLayout(new BorderLayout());
//		ventanis.setSize(new Dimension(520,520));
//		ventanis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		String[] latlon = new String[]{63.259591+":"+-144.667969,58.107733+":"+-120.541936};
//		try {
////			consultarMapaAeropuertoUnico(63.259591+"",-144.667969+"");
//			consultarMultiplesAeropuertos(latlon);
//			ventanis.add(label);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		ventanis.setVisible(true);
//
//	}

}
