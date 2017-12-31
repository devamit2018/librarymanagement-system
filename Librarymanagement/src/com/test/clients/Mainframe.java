package com.test.clients;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mainframe extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnLibrarianLogin;
	private JLabel lblLibraryManagement;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainframe frame = new Mainframe();
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
	public Mainframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 337, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnLibrarianLogin());
		contentPane.add(getLblLibraryManagement());
		contentPane.add(getLblNewLabel());
		setVisible(true);
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Admin login");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Adminloginframe();
					dispose();
					
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNewButton.setBounds(94, 83, 131, 38);
		}
		return btnNewButton;
	}
	private JButton getBtnLibrarianLogin() {
		if (btnLibrarianLogin == null) {
			btnLibrarianLogin = new JButton("Librarian login");
			btnLibrarianLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Librarianloginform();
					dispose();
					
				}
			});
			btnLibrarianLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnLibrarianLogin.setBounds(94, 152, 131, 38);
		}
		return btnLibrarianLogin;
	}
	private JLabel getLblLibraryManagement() {
		if (lblLibraryManagement == null) {
			lblLibraryManagement = new JLabel("Library Management");
			lblLibraryManagement.setFont(new Font("Sitka Small", Font.BOLD, 14));
			lblLibraryManagement.setBounds(86, 29, 156, 27);
		}
		return lblLibraryManagement;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DEV\\Downloads\\Compressed\\background-images\\background-imager\\Elegant_Background-4.jpg"));
			lblNewLabel.setBounds(0, 0, 321, 261);
		}
		return lblNewLabel;
	}
}
