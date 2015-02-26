package com.llama.tech.airports.gui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.llama.tech.airports.backbone.Vuelo;
import com.llama.tech.airports.graphics.HintTextFieldUI;
import com.llama.tech.utils.list.Lista;
import com.llama.tech.utils.list.Lista;

import javax.swing.JButton;
import javax.swing.SpringLayout;

import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QueryPanel extends JPanel implements ActionListener
{
	private JTextField textFieldCodAeropuerto;
	private JButton btnBuscarVuelo;
	private JButton btnEliminarVueloDel;
	private JTextField textFieldCodVuelo;
	private JButton btnBuscarAero;
	private Lista<Vuelo> vuelosB;
	private MainGUI main;

	/**
	 * Create the panel.
	 * @param mainGUI 
	 */
	public QueryPanel(MainGUI mainGUI) 
	{
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Consultas", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(51, 51, 51)));
		setLayout(null);
		
		JLabel lblCdigoAeropuerto = new JLabel("Código Aeropuerto:");
		lblCdigoAeropuerto.setBounds(31, 40, 174, 15);
		add(lblCdigoAeropuerto);
		
		textFieldCodAeropuerto = new JTextField();
		textFieldCodAeropuerto.setToolTipText("Introducir un código conformado hasta por cuatro caractéres");
		textFieldCodAeropuerto.setUI(new HintTextFieldUI("e.g: JFK", true));
		textFieldCodAeropuerto.setBounds(198, 38, 114, 19);
		add(textFieldCodAeropuerto);
		textFieldCodAeropuerto.setColumns(4);
		
		btnBuscarAero = new JButton("Buscar Aeropuerto");
		btnBuscarAero.setBounds(48, 77, 246, 25);
		btnBuscarAero.setActionCommand("BUSCARAERO");
		btnBuscarAero.addActionListener(this);
		add(btnBuscarAero);
		
		JLabel lblCdigoVuelo = new JLabel("Código Vuelo:");
		lblCdigoVuelo.setBounds(31, 134, 174, 15);
		add(lblCdigoVuelo);
		
		textFieldCodVuelo = new JTextField();
		textFieldCodVuelo.setToolTipText("Introducir un código conformado hasta por seis caractéres");
		textFieldCodVuelo.setUI(new HintTextFieldUI("e.g: DL396", true));
		textFieldCodVuelo.setColumns(10);
		textFieldCodVuelo.setBounds(198, 132, 114, 19);
		add(textFieldCodVuelo);
		
		btnBuscarVuelo = new JButton("Buscar Vuelo");
		btnBuscarVuelo.setBounds(48, 171, 246, 25);
		btnBuscarVuelo.setActionCommand("BUSCARVUELO");
		btnBuscarVuelo.addActionListener(this);
		add(btnBuscarVuelo);
		
		btnEliminarVueloDel = new JButton("Eliminar Vuelo del Sistema");
		btnEliminarVueloDel.setBounds(48, 208, 246, 25);
		btnEliminarVueloDel.addActionListener(this);
		btnEliminarVueloDel.setActionCommand("ELIMINARVUELO");
		add(btnEliminarVueloDel);
		
		main = mainGUI;

	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("BUSCARVUELO"))
		{
			main.buscarVuelo(textFieldCodVuelo.getText());
			textFieldCodVuelo.setText("");
		}
		else if(e.getActionCommand().equals("ELIMINARVUELO"))
		{
			main.eliminarVuelo(textFieldCodVuelo.getText());
		}
		else if(e.getActionCommand().equals("BUSCARAERO"))
		{
			main.buscarAeropuerto(textFieldCodAeropuerto.getText());
			textFieldCodAeropuerto.setText("");
		}
		
	}
	
	
}
