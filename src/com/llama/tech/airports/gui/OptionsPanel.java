package com.llama.tech.airports.gui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;

public class OptionsPanel extends JPanel {
	private JButton btnVuelosDirectos;
	private JButton btnCompararTrficoDe;
	private JButton btnBuscarAeropuertosPor;
	private JButton btnBuscarVuelosPor;
	private JButton btnCambiarPeriodo;
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
		add(btnVuelosDirectos);
		
		btnCompararTrficoDe = new JButton("Comparar tráfico de areopuertos");
		btnCompararTrficoDe.setBounds(33, 75, 270, 25);
		add(btnCompararTrficoDe);
		
		btnBuscarAeropuertosPor = new JButton("Buscar Aeropuertos por zona");
		btnBuscarAeropuertosPor.setBounds(33, 128, 270, 25);
		add(btnBuscarAeropuertosPor);
		
		btnBuscarVuelosPor = new JButton("Buscar vuelos por periodo");
		btnBuscarVuelosPor.setBounds(33, 172, 270, 25);
		add(btnBuscarVuelosPor);
		
		btnCambiarPeriodo = new JButton("Cambiar periodo");
		btnCambiarPeriodo.setBounds(33, 209, 270, 25);
		add(btnCambiarPeriodo);

	}
}
