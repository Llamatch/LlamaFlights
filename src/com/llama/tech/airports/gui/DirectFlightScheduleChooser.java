package com.llama.tech.airports.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DirectFlightScheduleChooser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton_1;
	private JButton btnNewButton;

	/**
	 * Create the dialog.
	 */
	public DirectFlightScheduleChooser() 
	{
		setBounds(100, 100, 428, 194);
		setTitle("Consultar Vuelos Directos");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 12, 367, 86);
		contentPanel.add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(13dlu;default):grow"),}));
		
		JLabel lblNewLabel = new JLabel("Código Aeropuerto Origen:");
		panel.add(lblNewLabel, "2, 2, left, default");
		
		textField = new JTextField();
		panel.add(textField, "6, 2, fill, default");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Código Aeropuerto Destino:");
		panel.add(lblNewLabel_1, "2, 4, left, default");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "6, 4, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Escoja una Fecha:");
		panel.add(lblNewLabel_2, "2, 6, left, default");
		
		JDateChooser dateChooser = new JDateChooser();
		panel.add(dateChooser, "6, 6, fill, default");
		
		btnNewButton = new JButton("Consultar");
		btnNewButton.setBounds(58, 109, 117, 25);
		contentPanel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(233, 109, 117, 25);
		contentPanel.add(btnNewButton_1);
	}
}
