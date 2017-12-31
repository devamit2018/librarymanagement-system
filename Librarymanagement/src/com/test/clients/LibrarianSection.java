package com.test.clients;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.test.models.Addbooks;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibrarianSection extends JFrame {

	private JPanel contentPane;
	private JLabel lblLibrarianSection;
	private JButton btnNewButton;
	private JButton btnViewBooks;
	private JButton btnIssueBook;
	private JButton btnViewIssuedBooks;
	private JButton btnReturnBooks;
	private JButton btnLogout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianSection frame = new LibrarianSection();
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
	public LibrarianSection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLibrarianSection());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnViewBooks());
		contentPane.add(getBtnIssueBook());
		contentPane.add(getBtnViewIssuedBooks());
		contentPane.add(getBtnReturnBooks());
		contentPane.add(getBtnLogout());
		setVisible(true);
	}
	private JLabel getLblLibrarianSection() {
		if (lblLibrarianSection == null) {
			lblLibrarianSection = new JLabel("Librarian Section");
			lblLibrarianSection.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblLibrarianSection.setBounds(163, 11, 128, 28);
		}
		return lblLibrarianSection;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Add Books");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					new Addbooksframe();
					dispose();
					
					
					
					
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnNewButton.setBounds(116, 50, 219, 46);
		}
		return btnNewButton;
	}
	private JButton getBtnViewBooks() {
		if (btnViewBooks == null) {
			btnViewBooks = new JButton("View Books");
			btnViewBooks.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new ViewBooks().populatedata();
					dispose();
				}
			});
			btnViewBooks.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnViewBooks.setBounds(116, 107, 219, 46);
		}
		return btnViewBooks;
	}
	private JButton getBtnIssueBook() {
		if (btnIssueBook == null) {
			btnIssueBook = new JButton("Issue Book");
			btnIssueBook.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new Issuebook();
					dispose();
				}
			});
			btnIssueBook.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnIssueBook.setBounds(116, 164, 219, 46);
		}
		return btnIssueBook;
	}
	private JButton getBtnViewIssuedBooks() {
		if (btnViewIssuedBooks == null) {
			btnViewIssuedBooks = new JButton("View issued Books");
			btnViewIssuedBooks.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new ViewIssuedbooks().populatedata();
					dispose();
				}
			});
			btnViewIssuedBooks.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnViewIssuedBooks.setBounds(116, 221, 219, 46);
		}
		return btnViewIssuedBooks;
	}
	private JButton getBtnReturnBooks() {
		if (btnReturnBooks == null) {
			btnReturnBooks = new JButton("Return Book");
			btnReturnBooks.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new Returnbook();
				}
			});
			btnReturnBooks.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnReturnBooks.setBounds(116, 278, 219, 46);
		}
		return btnReturnBooks;
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
			btnLogout.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnLogout.setBounds(116, 335, 219, 46);
		}
		return btnLogout;
	}
}
