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
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.TitledBorder;

public class PeriodChooser extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PeriodChooser dialog = new PeriodChooser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PeriodChooser() {
		setBounds(100, 100, 423, 349);
		setTitle("Periodo Consulta");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			lblNewLabel.setBounds(12, 12, 379, 154);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Periodo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(12, 176, 379, 76);
			contentPanel.add(panel);
			panel.setLayout(new FormLayout(new ColumnSpec[] {
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("default:grow"),
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("default:grow"),},
				new RowSpec[] {
					FormFactory.RELATED_GAP_ROWSPEC,
					RowSpec.decode("19dlu:grow"),}));
			{
				JLabel lblNewLabel_1 = new JLabel("Año:");
				panel.add(lblNewLabel_1, "2, 2, center, center");
			}
			
			JYearChooser yearChooser = new JYearChooser();
			panel.add(yearChooser, "4, 2, fill, default");
			
			Component horizontalStrut = Box.createHorizontalStrut(20);
			panel.add(horizontalStrut, "6, 2");
			{
				JLabel lblNewLabel_2 = new JLabel("Mes:");
				panel.add(lblNewLabel_2, "10, 2");
			}
			
			JMonthChooser monthChooser = new JMonthChooser();
			panel.add(monthChooser, "12, 2, center, center");
		}
		{
			JButton btnNewButton = new JButton("Consultar");
			btnNewButton.setBounds(143, 264, 117, 25);
			contentPanel.add(btnNewButton);
		}
	}
}
