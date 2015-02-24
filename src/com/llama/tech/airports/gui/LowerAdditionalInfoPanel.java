package com.llama.tech.airports.gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class LowerAdditionalInfoPanel extends JPanel 
{
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public LowerAdditionalInfoPanel() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textField.setEditable(false);
		textField.setBackground(UIManager.getColor("Button.background"));
		textField.setBounds(181, 12, 141, 19);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Periodo seleccionado:");
		lblNewLabel.setBounds(12, 14, 185, 15);
		add(lblNewLabel);
		
		JLabel lblTotalVuelosCargados = new JLabel("Total vuelos cargados:");
		lblTotalVuelosCargados.setBounds(338, 14, 185, 15);
		add(lblTotalVuelosCargados);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textField_1.setBackground(UIManager.getColor("Button.background"));
		textField_1.setBounds(507, 12, 154, 19);
		add(textField_1);

	}
}
