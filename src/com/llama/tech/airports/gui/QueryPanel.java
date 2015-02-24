package com.llama.tech.airports.gui;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;

public class QueryPanel extends JPanel 
{
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnBuscarVuelo;
	private JButton btnEliminarVueloDel;
	private JTextField textField_2;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public QueryPanel() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Consultas", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(51, 51, 51)));
		setLayout(null);
		
		JLabel lblCdigoAeropuerto = new JLabel("Código Aeropuerto:");
		lblCdigoAeropuerto.setBounds(31, 40, 174, 15);
		add(lblCdigoAeropuerto);
		
		textField_1 = new JTextField();
		textField_1.setBounds(198, 38, 114, 19);
		add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("Buscar Aeropuerto");
		btnNewButton.setBounds(48, 77, 246, 25);
		add(btnNewButton);
		
		JLabel lblCdigoVuelo = new JLabel("Código Vuelo:");
		lblCdigoVuelo.setBounds(31, 134, 174, 15);
		add(lblCdigoVuelo);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(198, 132, 114, 19);
		add(textField_2);
		
		btnBuscarVuelo = new JButton("Buscar Vuelo");
		btnBuscarVuelo.setBounds(48, 171, 246, 25);
		add(btnBuscarVuelo);
		
		btnEliminarVueloDel = new JButton("Eliminar Vuelo del Sistema");
		btnEliminarVueloDel.setBounds(48, 208, 246, 25);
		add(btnEliminarVueloDel);

	}
}
