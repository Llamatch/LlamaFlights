package com.llama.tech.airports.graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

public class GraphConsolidation 
{
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
	
	
	public static void main(String... args)
	{
		JFrame ventana = new JFrame();
		ventana.setLayout(new BorderLayout());
		ventana.setSize(new Dimension(650,490));
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String[] codes = {"BRA", "VNM", "IDN", "COL", "ETH"}; 
		Double[] proportions = {33.1, 15.2, 6.3, 5.9, 5.0};
		
		ImageIcon image = buildGraph(codes, proportions, "2011 Top twenty green coffee producers");
		JLabel label = new JLabel(image);
		
		ventana.add(label);
		ventana.setVisible(true);
		
		
//		 Brazil 	2,609,040 	43,484 	33.1%
//		 2 	 Vietnam 	1,200,000 	20,000 	15.2%
//		 3 	 Indonesia[note 1] 	495,000 	8,250 	6.3%
//		 4 	 Colombia 	468,000 	7,800 	5.9%
//		 5 	 Ethiopia[note 1] 	390,000 	6,500 	5.0%
		
	}
}
