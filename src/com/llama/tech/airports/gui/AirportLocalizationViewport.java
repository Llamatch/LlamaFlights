package com.llama.tech.airports.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class AirportLocalizationViewport extends JDialog 
{

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private final JList list = new JList();
	private final JButton btnNewButton = new JButton("Cerrar");

	/**
	 * Create the dialog.
	 */
	public AirportLocalizationViewport() 
	{
		setBounds(100, 100, 792, 481);
		setTitle("Información y localización geográfica");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblNewLabel = new JLabel("");
			lblNewLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			lblNewLabel.setBounds(279, 12, 481, 409);
			contentPanel.add(lblNewLabel);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBorder(new TitledBorder(null, "Informaci\u00F3n Marcadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			scrollPane.setBounds(12, 95, 241, 243);
			contentPanel.add(scrollPane);
			{
				list.setBackground(UIManager.getColor("Button.background"));
				scrollPane.setViewportView(list);
			}
		}
		{
			btnNewButton.setBounds(77, 370, 117, 25);
			contentPanel.add(btnNewButton);
		}
	}
}
