package com.test.clients;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.test.models.Addlibrarian;
import com.test.services.Librarianservices;
import com.test.services.Librarianservicesimpl;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Adminsectionframe extends JFrame {

	private JPanel contentPane;
	private JButton btnAddLibrarian;
	private JButton btnViewLibrarian;
	private JButton btnDeleteLibrarian;
	private JButton btnLogout;
	private JLabel lblAdminSection;
	private Viewframe viewframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminsectionframe frame = new Adminsectionframe();
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
	public Adminsectionframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 308, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnAddLibrarian());
		contentPane.add(getBtnViewLibrarian());
		contentPane.add(getBtnDeleteLibrarian());
		contentPane.add(getBtnLogout());
		contentPane.add(getLblAdminSection());
		setVisible(true);
	}

	private JButton getBtnAddLibrarian() {
		if (btnAddLibrarian == null) {
			btnAddLibrarian = new JButton("Add Librarian");
			btnAddLibrarian.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Addlibrarianframe();
					dispose();
				}
			});
			btnAddLibrarian.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnAddLibrarian.setBounds(60, 78, 156, 42);
		}
		return btnAddLibrarian;
	}
	private JButton getBtnViewLibrarian() {
		if (btnViewLibrarian == null) {
			btnViewLibrarian = new JButton("View Librarian");
			btnViewLibrarian.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new Viewframe().Populatedata();;
					
					dispose();
					
					
				}
			});
			btnViewLibrarian.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnViewLibrarian.setBounds(60, 148, 156, 42);
		}
		return btnViewLibrarian;
	}
	private JButton getBtnDeleteLibrarian() {
		if (btnDeleteLibrarian == null) {
			btnDeleteLibrarian = new JButton("Delete Librarian");
			btnDeleteLibrarian.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new Deleteframe();
					dispose();
					
				}
			});
			btnDeleteLibrarian.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnDeleteLibrarian.setBounds(60, 213, 156, 42);
		}
		return btnDeleteLibrarian;
	}
	private JButton getBtnLogout() {
		if (btnLogout == null) {
			btnLogout = new JButton("Logout");
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new Mainframe();
					dispose();
				}
			});
			btnLogout.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnLogout.setBounds(60, 276, 139, 42);
		}
		return btnLogout;
	}
	private JLabel getLblAdminSection() {
		if (lblAdminSection == null) {
			lblAdminSection = new JLabel("Admin Section");
			lblAdminSection.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblAdminSection.setBounds(82, 29, 90, 23);
		}
		return lblAdminSection;
	}
	

}
