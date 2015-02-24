package com.llama.tech.airports.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class MainGUI extends JFrame 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7674397543833453767L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private QueryPanel queryPanel;
	private OptionsPanel optionsPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblNewLabel.setBounds(12, 14, 664, 110);
		contentPane.add(lblNewLabel);
		
		queryPanel = new QueryPanel();
		queryPanel.setBounds(12, 136, 326, 253);
		contentPane.add(queryPanel);
		
		optionsPanel = new OptionsPanel();
		optionsPanel.setBounds(350, 136, 326, 253);
		contentPane.add(optionsPanel);
		
		LowerAdditionalInfoPanel lowerAdditionalInfoPanel = new LowerAdditionalInfoPanel();
		lowerAdditionalInfoPanel.setBounds(12, 396, 664, 40);
		contentPane.add(lowerAdditionalInfoPanel);
	}
}
