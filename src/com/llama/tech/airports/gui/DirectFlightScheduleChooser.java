package com.llama.tech.airports.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
import com.llama.tech.airports.graphics.HintTextFieldUI;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class DirectFlightScheduleChooser extends JDialog  implements ActionListener
{

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldAeroOrigen;
	private JTextField textFieldAeroDestino;
	private JButton btnCancel;
	private JButton btnFetchInfo;
	private JDateChooser dateChooser;
	private OptionsPanel optionsPanel;
	private LocalDate date;
	private String depCode;
	private String arrCode;

	/**
	 * Create the dialog.
	 * @param optionsPanel 
	 */
	public DirectFlightScheduleChooser(OptionsPanel optionsPanel) 
	{
		setBounds(100, 100, 428, 194);
		this.optionsPanel = optionsPanel;
		setTitle("Consultar Vuelos Directos");
		getContentPane().setLayout(new BorderLayout());
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
		
		textFieldAeroOrigen = new JTextField();
		panel.add(textFieldAeroOrigen, "6, 2, fill, default");
		textFieldAeroOrigen.setToolTipText("Introducir un código conformado hasta por cuatro caractéres");
		textFieldAeroOrigen.setUI(new HintTextFieldUI("e.g: JFK", true));
		textFieldAeroOrigen.setColumns(4);
		
		JLabel lblNewLabel_1 = new JLabel("Código Aeropuerto Destino:");
		panel.add(lblNewLabel_1, "2, 4, left, default");
		
		textFieldAeroDestino = new JTextField();
		panel.add(textFieldAeroDestino, "6, 4, fill, default");
		textFieldAeroDestino.setToolTipText("Introducir un código conformado hasta por cuatro caractéres");
		textFieldAeroDestino.setUI(new HintTextFieldUI("e.g: ATL", true));
		textFieldAeroDestino.setColumns(4);
		
		JLabel lblNewLabel_2 = new JLabel("Escoja una Fecha:");
		panel.add(lblNewLabel_2, "2, 6, left, default");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		dateChooser = new JDateChooser();
		try 
		{
			dateChooser.setMinSelectableDate(sdf.parse("01-01-2006"));
			dateChooser.setMaxSelectableDate(sdf.parse("31-12-2008"));
			dateChooser.setDate(sdf.parse("01-01-2006"));
		} 
		catch (ParseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel.add(dateChooser, "6, 6, fill, default");
		
		btnFetchInfo = new JButton("Consultar");
		btnFetchInfo.setActionCommand("FETCH");
		btnFetchInfo.addActionListener(this);
		btnFetchInfo.setBounds(58, 109, 117, 25);
		contentPanel.add(btnFetchInfo);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(233, 109, 117, 25);
		btnCancel.setActionCommand("CANCEL");
		btnCancel.addActionListener(this);
		contentPanel.add(btnCancel);
	}
	
	
	public void send_signal(boolean term)
	{
		if(term)
		{
			optionsPanel.directFlightSearch(date, depCode, arrCode);
		}
		super.dispose();
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("FETCH"))
		{
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-mm-yyyy");
			SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
			Date d = dateChooser.getDate();
			String date = sdf.format(d);
			this.date =  LocalDate.parse(date, dtf);
			this.depCode = textFieldAeroOrigen.getText();
			this.arrCode = textFieldAeroDestino.getText();
			send_signal(true);
		}
		else
		{
			send_signal(false);
		}
		
	}
	
	@Override
	public void dispose()
	{
		send_signal(false);
	}
	
	
}
