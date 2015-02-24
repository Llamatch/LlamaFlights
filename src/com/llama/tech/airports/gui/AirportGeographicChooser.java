package com.llama.tech.airports.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.border.TitledBorder;
import java.awt.Component;
import javax.swing.Box;

public class AirportGeographicChooser extends JDialog 
{

	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField formattedTextField_1;
	private JFormattedTextField formattedTextField_2;
	private JFormattedTextField formattedTextField_3;
	private JFormattedTextField formattedTextField_4;
	private JFormattedTextField formattedTextField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	
	

	/**
	 * Create the dialog.
	 */
	public AirportGeographicChooser() {
		setBounds(100, 100, 496, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(8, 12, 460, 41);
			contentPanel.add(panel);
			panel.setLayout(new FormLayout(new ColumnSpec[] {
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(38dlu;default)"),
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(0dlu;default)"),
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(9dlu;default):grow"),},
				new RowSpec[] {
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,}));
			{
				JLabel lblNewLabel = new JLabel("¿Número máximo de aeropuertos a Visualizar?");
				panel.add(lblNewLabel, "2, 2, right, default");
			}
			{
				formattedTextField_1 = new JFormattedTextField();
				panel.add(formattedTextField_1, "4, 2, fill, default");
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Informaci\u00F3n Geogr\u00E1fica", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 65, 460, 142);
			contentPanel.add(panel);
			panel.setLayout(new FormLayout(new ColumnSpec[] {
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("default:grow"),
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,},
				new RowSpec[] {
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,}));
			{
				JLabel lblNewLabel_1 = new JLabel("Longitud Mínima:");
				panel.add(lblNewLabel_1, "4, 2");
			}
			{
				formattedTextField_2 = new JFormattedTextField();
				panel.add(formattedTextField_2, "8, 2, fill, default");
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Latitud Mínima:");
				panel.add(lblNewLabel_2, "4, 4, left, default");
			}
			{
				formattedTextField_3 = new JFormattedTextField();
				panel.add(formattedTextField_3, "8, 4, fill, default");
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Longitud Máxima:");
				panel.add(lblNewLabel_3, "4, 6");
			}
			{
				formattedTextField_4 = new JFormattedTextField();
				panel.add(formattedTextField_4, "8, 6, fill, default");
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Latitud Máxima:");
				panel.add(lblNewLabel_4, "4, 8");
			}
			{
				formattedTextField = new JFormattedTextField();
				panel.add(formattedTextField, "8, 8, fill, default");
			}
		}
		{
			btnNewButton = new JButton("Visualizar");
			btnNewButton.setBounds(116, 219, 117, 25);
			contentPanel.add(btnNewButton);
		}
		{
			btnNewButton_1 = new JButton("Cancelar");
			btnNewButton_1.setBounds(245, 219, 117, 25);
			contentPanel.add(btnNewButton_1);
		}
	}
}
