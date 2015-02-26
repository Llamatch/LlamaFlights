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
	private JFormattedTextField textMax;
	private JFormattedTextField lonMin;
	private JFormattedTextField latMin;
	private JFormattedTextField lonMax;
	private JFormattedTextField latMax;
	private JButton btnVisualizar;
	private JButton btnCancelar;
	
	

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
				textMax = new JFormattedTextField();
				panel.add(textMax, "4, 2, fill, default");
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
				lonMin = new JFormattedTextField();
				panel.add(lonMin, "8, 2, fill, default");
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Latitud Mínima:");
				panel.add(lblNewLabel_2, "4, 4, left, default");
			}
			{
				latMin = new JFormattedTextField();
				panel.add(latMin, "8, 4, fill, default");
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Longitud Máxima:");
				panel.add(lblNewLabel_3, "4, 6");
			}
			{
				lonMax = new JFormattedTextField();
				panel.add(lonMax, "8, 6, fill, default");
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Latitud Máxima:");
				panel.add(lblNewLabel_4, "4, 8");
			}
			{
				latMax = new JFormattedTextField();
				panel.add(latMax, "8, 8, fill, default");
			}
		}
		{
			btnVisualizar = new JButton("Visualizar");
			btnVisualizar.setBounds(116, 219, 117, 25);
			contentPanel.add(btnVisualizar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(245, 219, 117, 25);
			contentPanel.add(btnCancelar);
		}
		
	}
}
