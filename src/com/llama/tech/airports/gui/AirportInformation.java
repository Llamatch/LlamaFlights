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
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class AirportInformation extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnNewButton;
	private JLabel lblNewLabel_6;

	/**
	 * Create the dialog.
	 */
	public AirportInformation() 
	{
		setTitle("Información Aeropuerto");
		setBounds(100, 100, 613, 530);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblNewLabel.setBounds(10, 170, 573, 263);
		contentPanel.add(lblNewLabel);
		
		btnNewButton = new JButton("Cerrar");
		btnNewButton.setBounds(238, 445, 117, 25);
		contentPanel.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(239, 12, 342, 146);
		contentPanel.add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(53dlu;default):grow"),},
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel_1 = new JLabel("Código Aeropuerto:");
		panel.add(lblNewLabel_1, "4, 2, left, default");
		
		textField = new JTextField();
		textField.setEditable(false);
		panel.add(textField, "6, 2, left, default");
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		panel.add(lblNewLabel_2, "4, 4, left, default");
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		panel.add(textField_1, "6, 4, left, default");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ciudad:");
		panel.add(lblNewLabel_3, "4, 6, left, default");
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		panel.add(textField_2, "6, 6, left, default");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Estado:");
		panel.add(lblNewLabel_4, "4, 8, left, default");
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		panel.add(textField_3, "6, 8, left, default");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("País:");
		panel.add(lblNewLabel_5, "4, 10, left, default");
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		panel.add(textField_4, "6, 10, left, default");
		textField_4.setColumns(10);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblNewLabel_6.setBounds(10, 12, 215, 146);
		contentPanel.add(lblNewLabel_6);
	}
}
