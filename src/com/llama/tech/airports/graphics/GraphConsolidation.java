package com.llama.tech.airports.graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

public class GraphConsolidation implements Serializable
{
	/**
	 * Este metodo construye el gráfico comparando los traficos de vuelos
	 * @param codes codigos de aeropuertos
	 * @param proportions trafico de los aeropuertos
	 * @param title titulo del grafico
	 * @return Imagen con el grafico
	 */
	public static ImageIcon buildGraph(String[] codes, Double[] proportions, String title)
	{
		DefaultPieDataset dataset = new DefaultPieDataset();
		for(int i = 0; i < codes.length; i++)
		{
			dataset.setValue( codes[i] , proportions[i]);
		}
		
		JFreeChart chart = ChartFactory.createPieChart3D( 
		         title ,  // chart title                   
		         dataset ,         // data 
		         true ,            // include legend                   
		         true, 
		         false);
		
		
		final PiePlot3D plot = ( PiePlot3D ) chart.getPlot( );             
	    plot.setStartAngle(180+35);
	    plot.setForegroundAlpha( 0.60f );             
	    plot.setInteriorGap( 0.02 );             
	    int width = 640; /* Width of the image */             
	    int height = 480; /* Height of the image */
	    BufferedImage image = chart.createBufferedImage(width,height);
	    
	    return new ImageIcon(image);
	}

}
