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
import javax.swing.border.TitledBorder;
import javax.swing.JFormattedTextField;
import com.toedter.calendar.JDateChooser;

public class FlightSearch extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField formattedTextField_1;
	private JFormattedTextField formattedTextField_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JFormattedTextField formattedTextField;
	private JDateChooser dateChooser;

	/**
	 * Create the dialog.
	 */
	public FlightSearch() 
	{
		setBounds(100, 100, 334, 249);
		setTitle("Consultar Vuelo");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Informaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(12, 12, 290, 135);
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
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,}));
			{
				JLabel lblNewLabel = new JLabel("Código Aeropuerto:");
				panel.add(lblNewLabel, "2, 2, right, default");
			}
			{
				formattedTextField = new JFormattedTextField();
				panel.add(formattedTextField, "4, 2, fill, default");
			}
			{
				JLabel lblNewLabel = new JLabel("Fecha:");
				panel.add(lblNewLabel, "2, 4");
			}
			
			dateChooser = new JDateChooser();
			panel.add(dateChooser, "4, 4, fill, default");
			{
				JLabel lblNewLabel = new JLabel("Hora Inicio:");
				panel.add(lblNewLabel, "2, 6");
			}
			{
				formattedTextField_1 = new JFormattedTextField();
				panel.add(formattedTextField_1, "4, 6, fill, default");
			}
			{
				JLabel lblNewLabel = new JLabel("Hora Fin:");
				panel.add(lblNewLabel, "2, 8");
			}
			{
				formattedTextField_2 = new JFormattedTextField();
				panel.add(formattedTextField_2, "4, 8, fill, default");
			}
		}
		{
			btnNewButton = new JButton("Consultar");
			btnNewButton.setBounds(22, 159, 117, 25);
			contentPanel.add(btnNewButton);
		}
		{
			btnNewButton_1 = new JButton("Cancelar");
			btnNewButton_1.setBounds(173, 159, 117, 25);
			contentPanel.add(btnNewButton_1);
		}
	}
}
