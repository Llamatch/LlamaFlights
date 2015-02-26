package com.llama.tech.airports.gui;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.llama.tech.airports.backbone.Aeropuerto;
import com.llama.tech.airports.backbone.ISistemaConsulta;
import com.llama.tech.airports.backbone.SistemaConsulta;
import com.llama.tech.airports.backbone.Vuelo;
import com.llama.tech.utils.dict.Dictionary;
import com.llama.tech.utils.dict.LlamaDict;
import com.llama.tech.utils.dict.LlamaDict.UnhashableTypeException;
import com.llama.tech.utils.list.Lista;

public class MainGUI extends JFrame 
{
	public static enum WindowState
	{
		PERIOD_CHOOSER, AIRPORT_SEARCH, FLIGHT_SEARCH, AIRPORT_COMPARISON, DIRECT_FLIGHT; 
	}

	private static final long serialVersionUID = -7674397543833453767L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private QueryPanel queryPanel;
	private OptionsPanel optionsPanel;
	private ISistemaConsulta flightDataBase;
	private PeriodChooser periodChooser;
	private AirportInformation airportInfo;
	private Dictionary<WindowState, Boolean> states = new LlamaDict<WindowState, Boolean>(6); 
	private final static String DIR_ARCHIVO = "./data/persistence/";
	public final static File ARCHIVO = new File(DIR_ARCHIVO+"info.flight");
	private boolean initialization = true;
	private boolean initialized = false;
	private int year;
	private int month;
	private FlightInformation flightInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGUI() 
	{
		for(WindowState w: WindowState.values())
		{
			try 
			{
				states.addEntry(w, false);
			} 
			catch (UnhashableTypeException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try
		{
			ISistemaConsulta temp = cargar();
			if(temp != null)
			{
				flightDataBase = temp;
				flightDataBase.reInitializeConnection();
				initialization = false;
				initialized = true;
			}
		}
		catch(Exception e)
		{

		}

		if(initialization)
		{
			try {
				states.setEntry(WindowState.PERIOD_CHOOSER, true);
			} catch (UnhashableTypeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			periodChooser = new PeriodChooser(this);
			periodChooser.setVisible(true);
			periodChooser.setAlwaysOnTop(true);
			periodChooser.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			try 
			{
				flightDataBase = new SistemaConsulta(month, year);
			} 
			catch (ClassNotFoundException | SQLException | IOException | UnhashableTypeException e) 
			{
				e.printStackTrace();
			}
			//periodChooser.setVisible(false);
			initialization = false;
			initialized = true;

		}

		setTitle("LlamaFly");
		setBounds(100, 100, 708, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblNewLabel.setBounds(12, 14, 664, 110);
		contentPane.add(lblNewLabel);
		queryPanel = new QueryPanel(this);
		queryPanel.setBounds(12, 136, 326, 253);
		contentPane.add(queryPanel);
		optionsPanel = new OptionsPanel(this);
		optionsPanel.setBounds(350, 136, 326, 253);
		contentPane.add(optionsPanel);
		System.out.println("Total: "+flightDataBase.getTotalVuelos());
		LowerAdditionalInfoPanel lowerAdditionalInfoPanel = new LowerAdditionalInfoPanel(year, month, flightDataBase.getTotalVuelos());
		lowerAdditionalInfoPanel.setBounds(12, 396, 664, 40);
		contentPane.add(lowerAdditionalInfoPanel);
	}

	@Override
	public void dispose()
	{
		try 
		{
			flightDataBase.cerrarInstancia();
			guardar(flightDataBase);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}

	public ISistemaConsulta cargar()
	{
		try {
			if(ARCHIVO.exists())
			{
				FileInputStream fis = new FileInputStream(ARCHIVO);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object flights = ois.readObject();
				ois.close();
				fis.close();
				return (ISistemaConsulta) flights;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public void guardar(ISistemaConsulta is)
	{
		try{
			FileOutputStream fos = new FileOutputStream(ARCHIVO);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(is);
			oos.close();
			fos.close();

		}
		catch(Exception e)
		{

		}
	}


	public void setPeriod(int year, int month)
	{
		this.year = year;
		this.month = month;
	}

	public void cambiarTemporada()
	{
		//periodChooser.setVisible(true);
		if(initialized)
		{
			try 
			{
				if(!states.getValue(WindowState.PERIOD_CHOOSER))
				{
					states.setEntry(WindowState.PERIOD_CHOOSER, true);
					periodChooser.setVisibility();
				}
				flightDataBase.cambiarTemporada(year, month);
			} 
			catch (IOException | UnhashableTypeException | SQLException e) {

				JOptionPane.showMessageDialog(this, "Hubo un problema cargando la información");
			}
		}
	}

	public void setState(WindowState w, Boolean v)
	{
		try 
		{
			states.setEntry(w, v);
		} 
		catch (UnhashableTypeException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void buscarVuelo(String codigo)
	{
		Lista<Vuelo> vuelos = flightDataBase.buscarVuelo(codigo);
		if(vuelos.isEmpty())
			JOptionPane.showMessageDialog(this, "No se han encontrado vuelos. Verifique que el código es correcto");
		else
		{
			flightInfo = new FlightInformation();
			flightInfo.refrescarVentana(vuelos, "BUSQUEDA");
		}
	}

	public void buscarAeropuerto(String codigo)
	{
		Aeropuerto air = flightDataBase.buscarAeropuerto(codigo);
		if(air==null)
			JOptionPane.showMessageDialog(this, "No se han encontrado aeropuertos. Verifique que el código es correcto");
		else
		{
			airportInfo = new AirportInformation();
			airportInfo.refrescarInfo(air);
		}
			
	}

	public void eliminarVuelo(String codigo) 
	{
		 boolean borro=flightDataBase.eliminarVuelo(codigo);
		 
		 if(borro)
			 JOptionPane.showMessageDialog(this, "El vuelo se eliminó satisfactoriamente");
		 else
			 JOptionPane.showMessageDialog(this, "No se encontró el vuelo para eliminarlo");
	}
	
	public void buscarVuelosDirectos(String codigoOrigen, String codigoDestino, LocalDate fecha)
	{

		Lista<Vuelo> lista =flightDataBase.buscarVuelosDirectos(codigoOrigen, codigoDestino,fecha);
		flightInfo = new FlightInformation();
		flightInfo.refrescarVentana(lista, "BUSQUEDA");
		
		
	}




}