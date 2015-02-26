package com.llama.tech.airports.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
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

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PeriodChooser extends JDialog implements ActionListener
{

	private final JPanel contentPanel = new JPanel();
	private MainGUI main;
	private JYearChooser yearChooser;
	private JMonthChooser monthChooser;
	private JButton btnNewButton;

	/**
	 * Create /the dialog.
	 */
	public PeriodChooser(MainGUI v) 
	{
		super(v, ModalityType.APPLICATION_MODAL);
		main=v;
		getContentPane().setPreferredSize(new Dimension(426, 288));
		getContentPane().setSize(new Dimension(426, 288));
		setSize(new Dimension(426, 288));
		setMaximumSize(new Dimension(426, 288));
		setMinimumSize(new Dimension(426, 288));
		setBounds(100, 100, 426, 288);
		setTitle("Periodo Consulta");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		String s = "Por favor, introducir un año y un mes válido para realizar la consulta. Es posible modificar este periodo en cualquier momento.";
		String html1 = "<html><body style='width: ";
		String html2 = "px'>";
		JLabel lblNewLabel = new JLabel(html1+"250"+html2+s);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblNewLabel.setBounds(12, 12, 379, 85);
		contentPanel.add(lblNewLabel);//QUE PASO AQUI Dónde!?


		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Periodo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 109, 379, 76);
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

		JLabel lblNewLabel_1 = new JLabel("Año:");
		panel.add(lblNewLabel_1, "2, 2, center, center");


		yearChooser = new JYearChooser();
		yearChooser.setYear(2006);
		yearChooser.setEndYear(2008);
		yearChooser.setStartYear(2006);
		panel.add(yearChooser, "4, 2, fill, default");

		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut, "6, 2");
		{
			JLabel lblNewLabel_2 = new JLabel("Mes:");
			panel.add(lblNewLabel_2, "10, 2");
		}

		monthChooser = new JMonthChooser();
		panel.add(monthChooser, "12, 2, center, center");


		btnNewButton = new JButton("Consultar");
		btnNewButton.setBounds(143, 197, 117, 25);
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand("CONSULTAR");
		contentPanel.add(btnNewButton);

	}

	public int darAnho()
	{
		return yearChooser.getYear();
	}

	public int darMes()
	{
		return monthChooser.getMonth();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("CONSULTAR"))
		{
			main.setPeriod(darAnho(), darMes());
			main.cambiarTemporada();
			dispose();
		}
		
	}
	
	public void setVisibility()
	{
		setModalityType(ModalityType.APPLICATION_MODAL);
		setVisible(true);
	}
	
	
	
}
