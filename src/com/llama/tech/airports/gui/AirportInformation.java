package com.llama.tech.airports.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.llama.tech.airports.backbone.Aeropuerto;
import com.llama.tech.airports.db.ImageContent;
import com.llama.tech.airports.graphics.ConsultaMapas;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import java.awt.Dialog.ModalityType;
import java.awt.Dialog.ModalExclusionType;

public class AirportInformation extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JTextField textFieldCodigoAero;
	private JTextField textFieldNombre;
	private JTextField textFieldCiudad;
	private JTextField textFieldEstado;
	private JTextField textFieldPais;
	private JButton btnNewButton;
	private JLabel lblNewLabelFotoAero;

	/**
	 * Create the dialog.
	 */
	public AirportInformation() 
	{
		setTitle("Información Aeropuerto");
		setBounds(100, 100, 613, 530);
		setVisible(true);
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
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand("CERRAR");
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

		textFieldCodigoAero = new JTextField();
		textFieldCodigoAero.setEditable(false);
		panel.add(textFieldCodigoAero, "6, 2, left, default");
		textFieldCodigoAero.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		panel.add(lblNewLabel_2, "4, 4, left, default");

		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		panel.add(textFieldNombre, "6, 4, left, default");
		textFieldNombre.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Ciudad:");
		panel.add(lblNewLabel_3, "4, 6, left, default");

		textFieldCiudad = new JTextField();
		textFieldCiudad.setEditable(false);
		panel.add(textFieldCiudad, "6, 6, left, default");
		textFieldCiudad.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Estado:");
		panel.add(lblNewLabel_4, "4, 8, left, default");

		textFieldEstado = new JTextField();
		textFieldEstado.setEditable(false);
		panel.add(textFieldEstado, "6, 8, left, default");
		textFieldEstado.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("País:");
		panel.add(lblNewLabel_5, "4, 10, left, default");

		textFieldPais = new JTextField();
		textFieldPais.setEditable(false);
		panel.add(textFieldPais, "6, 10, left, default");
		textFieldPais.setColumns(10);

		lblNewLabelFotoAero = new JLabel("");
		lblNewLabelFotoAero.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblNewLabelFotoAero.setBounds(10, 12, 215, 146);
		contentPanel.add(lblNewLabelFotoAero);
	}

	public void refrescarInfo(Aeropuerto a)
	{
		textFieldCodigoAero.setText(a.getCodigo());
		textFieldCiudad.setText(a.getCiudad());
		textFieldEstado.setText(a.getEstado());
		textFieldNombre.setText(a.getNombre());
		textFieldPais.setText(a.getPais());
		ImageIcon ic;
		BufferedImage imagen;
//		try {
//			imagen = ImageIO.read(ImageContent.find_planeImg(a.getNombre()));
//			if(imagen==null)
//			{
//
//				ic = new ImageIcon("./data/img/default.png");
//			}
//			else
//			{
//				ic = new ImageIcon(imagen);	
//			}
//			lblNewLabelFotoAero.setIcon(ic); 
//		} catch (Exception e) {
//			
//			JOptionPane.showMessageDialog(this, "Hubo un error cargando las imagenes");
//			dispose();
//		}
		
		try {
			ic = ConsultaMapas.consultarMapaAeropuertoUnico(""+a.getLatitud(), ""+a.getLongitud());
			System.out.println(ic.getIconWidth() +":"+ic.getIconHeight());
			lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
			//img.getScaledInstance(, height)
			lblNewLabel.setIcon(ic);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this,"Hubo un error cargando el mapa");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.equals("CERRAR"))
			dispose();
		
	}
}
