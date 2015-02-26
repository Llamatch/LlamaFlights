package com.llama.tech.airports.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;

public class OptionsPanel extends JPanel implements ActionListener
{
	private JButton btnVuelosDirectos;
	private JButton btnCompararTrficoDe;
	private JButton btnBuscarAeropuertosPor;
	private JButton btnBuscarVuelosPor;
	private JButton btnCambiarPeriodo;
	private DirectFlightScheduleChooser flightChooser;
	private MainGUI main;

	/**
	 * Create the panel.
	 * @param mainGUI 
	 */
	public OptionsPanel(MainGUI mainGUI) 
	{
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Opciones", TitledBorder.RIGHT, TitledBorder.TOP, null, null));
		setLayout(null);
		
		main = mainGUI;
		
		btnVuelosDirectos = new JButton("Consultar vuelos directos");
		btnVuelosDirectos.setBounds(33, 38, 270, 25);
		btnVuelosDirectos.setActionCommand("DIRECT_FLIGHTS");
		btnVuelosDirectos.addActionListener(this);
		add(btnVuelosDirectos);
		
		btnCompararTrficoDe = new JButton("Comparar tráfico de areopuertos");
		btnCompararTrficoDe.setBounds(33, 75, 270, 25);
		btnCompararTrficoDe.setActionCommand("AIR_TRAFFIC");
		btnCompararTrficoDe.addActionListener(this);
		add(btnCompararTrficoDe);
		
		btnBuscarAeropuertosPor = new JButton("Buscar Aeropuertos por zona");
		btnBuscarAeropuertosPor.setBounds(33, 128, 270, 25);
		btnBuscarAeropuertosPor.setActionCommand("AIR_ZONE");
		btnBuscarAeropuertosPor.addActionListener(this);
		add(btnBuscarAeropuertosPor);
		
		btnBuscarVuelosPor = new JButton("Buscar vuelos por periodo");
		btnBuscarVuelosPor.setBounds(33, 172, 270, 25);
		btnBuscarVuelosPor.setActionCommand("FLIGHT_PERIOD");
		btnBuscarVuelosPor.addActionListener(this);
		add(btnBuscarVuelosPor);
		
		btnCambiarPeriodo = new JButton("Cambiar periodo");
		btnCambiarPeriodo.setBounds(33, 209, 270, 25);
		btnCambiarPeriodo.setActionCommand("PERIOD_SELECTION");
		btnCambiarPeriodo.addActionListener(this);
		add(btnCambiarPeriodo);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("DIRECT_FLIGHTS"))
		{
			flightChooser = new DirectFlightScheduleChooser(this);
		}
		
	}

	public void directFlightSearch(LocalDate date, String depCode, String arrCode) 
	{
         main.buscarVuelosDirectos(depCode, arrCode, date);		
	}
	
	
	
	
	
	
}
