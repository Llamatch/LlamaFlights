package com.llama.tech.airports.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class FlightInformation extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JComboBox comboBox;
	private JLabel label;
	private JLabel lblNewLabel_11;

	/**
	 * Create the dialog.
	 */
	public FlightInformation() 
	{
		setBounds(100, 100, 703, 508);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new TitledBorder(null, "Origen", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		lblNewLabel.setBounds(25, 22, 239, 127);
		contentPanel.add(lblNewLabel);
		
		label = new JLabel("");
		label.setBorder(new TitledBorder(null, "Destino", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		label.setBounds(25, 241, 239, 127);
		contentPanel.add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 161, 239, 57);
		contentPanel.add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		panel.add(lblNewLabel_1, "2, 2, right, default");
		
		textField = new JTextField();
		textField.setEditable(false);
		panel.add(textField, "4, 2, fill, default");
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Código:");
		panel.add(lblNewLabel_2, "2, 4, right, default");
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		panel.add(textField_1, "4, 4, fill, default");
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(25, 380, 239, 57);
		contentPanel.add(panel_1);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel_3 = new JLabel("Nombre:");
		panel_1.add(lblNewLabel_3, "2, 2, right, default");
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		panel_1.add(textField_2, "4, 2, fill, default");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Código:");
		panel_1.add(lblNewLabel_4, "2, 4, right, default");
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		panel_1.add(textField_3, "4, 4, fill, default");
		textField_3.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(282, 22, 389, 196);
		contentPanel.add(panel_2);
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel_5 = new JLabel("Vuelos Disponibles:");
		panel_2.add(lblNewLabel_5, "2, 2");
		
		comboBox = new JComboBox();
		panel_2.add(comboBox, "6, 2, fill, default");
		
		JLabel lblNewLabel_6 = new JLabel("Aerolínea:");
		panel_2.add(lblNewLabel_6, "2, 6");
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		panel_2.add(textField_4, "6, 6, fill, default");
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Número Vuelo:");
		panel_2.add(lblNewLabel_7, "2, 8");
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		panel_2.add(textField_5, "6, 8, fill, default");
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Fecha:");
		panel_2.add(lblNewLabel_8, "2, 10");
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		panel_2.add(textField_6, "6, 10, fill, default");
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Hora de Despegue:");
		panel_2.add(lblNewLabel_9, "2, 12");
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		panel_2.add(textField_7, "6, 12, fill, default");
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Hora de Aterrizaje:");
		panel_2.add(lblNewLabel_10, "2, 14");
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setVerifyInputWhenFocusTarget(false);
		panel_2.add(textField_8, "6, 14, fill, default");
		textField_8.setColumns(10);
		
		lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblNewLabel_11.setBounds(281, 241, 390, 196);
		contentPanel.add(lblNewLabel_11);
	}
	
	
	
}
