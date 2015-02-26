package com.llama.tech.airports.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
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
import com.llama.tech.airports.backbone.Vuelo;
import com.llama.tech.utils.list.Lista;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class FlightInformation extends JDialog implements ActionListener, ItemListener
{

	private final JPanel contentPanel = new JPanel();
	private JLabel lblAeroOrigen;
	private JTextField textFieldNombreOrigen;
	private JTextField textFieldCodigoorigen;
	private JTextField textFieldNombreDestino;
	private JTextField textFieldCodigoDestino;
	private JTextField textFieldAerolinea;
	private JTextField textFieldNumVuelo;
	private JTextField textFieldFecha;
	private JTextField textFieldHoraDespegue;
	private JTextField textField_HoraDeAterrizaje;
	private FlightSearch flightSearch;
	private JComboBox<Vuelo> comboBoxVuelosDisponibles;
	private JLabel labelAeroDestino;
	private JLabel lblNewLabelFotoAvion;
	private String tipo;

	/**
	 * Create the dialog.
	 */
	public FlightInformation() 
	{
		tipo = "BUSQUEDA";
        setVisible(true);
		setBounds(100, 100, 703, 508);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		lblAeroOrigen = new JLabel("");
		lblAeroOrigen.setBorder(new TitledBorder(null, "Origen", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		lblAeroOrigen.setBounds(25, 22, 239, 127);
		contentPanel.add(lblAeroOrigen);

		labelAeroDestino = new JLabel("");
		labelAeroDestino.setBorder(new TitledBorder(null, "Destino", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		labelAeroDestino.setBounds(25, 241, 239, 127);
		contentPanel.add(labelAeroDestino);

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

		textFieldNombreOrigen = new JTextField();
		textFieldNombreOrigen.setEditable(false);
		panel.add(textFieldNombreOrigen, "4, 2, fill, default");
		textFieldNombreOrigen.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Código:");
		panel.add(lblNewLabel_2, "2, 4, right, default");

		textFieldCodigoorigen = new JTextField();
		textFieldCodigoorigen.setEditable(false);
		panel.add(textFieldCodigoorigen, "4, 4, fill, default");
		textFieldCodigoorigen.setColumns(10);

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

		textFieldNombreDestino = new JTextField();
		textFieldNombreDestino.setEditable(false);
		panel_1.add(textFieldNombreDestino, "4, 2, fill, default");
		textFieldNombreDestino.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Código:");
		panel_1.add(lblNewLabel_4, "2, 4, right, default");

		textFieldCodigoDestino = new JTextField();
		textFieldCodigoDestino.setEditable(false);
		panel_1.add(textFieldCodigoDestino, "4, 4, fill, default");
		textFieldCodigoDestino.setColumns(10);

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

		comboBoxVuelosDisponibles = new JComboBox<Vuelo>();
		comboBoxVuelosDisponibles.addItemListener(this);
		panel_2.add(comboBoxVuelosDisponibles, "6, 2, fill, default");

		JLabel lblNewLabel_6 = new JLabel("Aerolínea:");
		panel_2.add(lblNewLabel_6, "2, 6");

		textFieldAerolinea = new JTextField();
		textFieldAerolinea.setEditable(false);
		panel_2.add(textFieldAerolinea, "6, 6, fill, default");
		textFieldAerolinea.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Número Vuelo:");
		panel_2.add(lblNewLabel_7, "2, 8");

		textFieldNumVuelo = new JTextField();
		textFieldNumVuelo.setEditable(false);
		panel_2.add(textFieldNumVuelo, "6, 8, fill, default");
		textFieldNumVuelo.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Fecha:");
		panel_2.add(lblNewLabel_8, "2, 10");

		textFieldFecha = new JTextField();
		textFieldFecha.setEditable(false);
		panel_2.add(textFieldFecha, "6, 10, fill, default");
		textFieldFecha.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Hora de Despegue:");
		panel_2.add(lblNewLabel_9, "2, 12");

		textFieldHoraDespegue = new JTextField();
		textFieldHoraDespegue.setEditable(false);
		panel_2.add(textFieldHoraDespegue, "6, 12, fill, default");
		textFieldHoraDespegue.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Hora de Aterrizaje:");
		panel_2.add(lblNewLabel_10, "2, 14");

		textField_HoraDeAterrizaje = new JTextField();
		textField_HoraDeAterrizaje.setEditable(false);
		textField_HoraDeAterrizaje.setVerifyInputWhenFocusTarget(false);
		panel_2.add(textField_HoraDeAterrizaje, "6, 14, fill, default");
		textField_HoraDeAterrizaje.setColumns(10);

		lblNewLabelFotoAvion = new JLabel("");
		lblNewLabelFotoAvion.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblNewLabelFotoAvion.setBounds(281, 241, 390, 196);
		contentPanel.add(lblNewLabelFotoAvion);
		
		flightSearch = new FlightSearch(this);
		
	}

    
	
	public void refrescarVentana(Lista<Vuelo> lista, String tipoConsulta)
	{
		tipo = tipoConsulta;
		Vuelo[] vuelos = new Vuelo[lista.size()];
		for(int i = 0; i < lista.size(); i++)
		{
			vuelos[i] = lista.get(i);
		}
		ComboBoxModel<Vuelo> cb = new DefaultComboBoxModel<Vuelo>(vuelos);
		comboBoxVuelosDisponibles.setModel(cb);
	}
	
	
	public void actualizarinfo(Vuelo v)
	{
		//lblAeroOrigen
		textFieldAerolinea.setText(v.getAerolinea().getNombre());
		if(tipo.equals("BUSQUEDA"))
		{
			textField_HoraDeAterrizaje.setText(v.getHoraAterrizajeProg().substring(0, 1)+":"+v.getHoraAterrizajeProg().substring(2, 3));
			textFieldHoraDespegue.setText(v.getHoraDespegueProg().substring(0, 1)+":"+v.getHoraDespegueProg().substring(2, 3));
		}
		else
		{
			DateTimeFormatter dt = DateTimeFormatter.ofPattern("HH:mm"); //Ya viste el funcionamiento del JFormattedText?
			textField_HoraDeAterrizaje.setText(v.getHoraAterrizajeReal().toLocalTime().format(dt));
			textFieldHoraDespegue.setText(v.getHoraDespegueReal().toLocalTime().format(dt));
		}

		textFieldCodigoDestino.setText(v.getDestino().getCodigo());
		textFieldCodigoorigen.setText(v.getOrigen().getCodigo());
		textFieldFecha.setText(v.getFecha().toString());
		textFieldNombreDestino.setText(v.getDestino().getNombre());
		textFieldNombreOrigen.setText(v.getOrigen().getNombre());
		textFieldNumVuelo.setText(v.getNumeroVuelo()+"");
	}



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		if(e.getSource().equals(comboBoxVuelosDisponibles))
		{
			if (e.getStateChange() == ItemEvent.SELECTED) 
			{
				Vuelo item = (Vuelo) e.getItem(); //→ Año
				if(item!=null)
				{
					actualizarinfo(item);
				}
			}
		}
		
	}
	
}