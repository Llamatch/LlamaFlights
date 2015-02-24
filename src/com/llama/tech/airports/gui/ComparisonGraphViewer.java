package com.llama.tech.airports.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

public class ComparisonGraphViewer extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public ComparisonGraphViewer() 
	{
		setBounds(100, 100, 542, 376);
		setTitle("Gráfico Comparativo (Aeropuertos)");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			lblNewLabel.setBounds(10, 10, 502, 263);
			contentPanel.add(lblNewLabel);
		}
		
		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.setBounds(202, 285, 117, 25);
		contentPanel.add(btnNewButton);
	}

}
