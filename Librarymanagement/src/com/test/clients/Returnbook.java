package com.test.clients;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.test.services.Returnservices;
import com.test.services.Returnservicesimpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Returnbook extends JFrame {

	private JPanel contentPane;
	private JLabel lblReturnBook;
	private JLabel lblBookCallno;
	private JTextField calltxt;
	private JLabel lblStudentId;
	private JTextField idtxt;
	private JButton btnReturnBook;
	private JButton btnBack;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Returnbook frame = new Returnbook();
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
	public Returnbook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 319, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblReturnBook());
		contentPane.add(getLblBookCallno());
		contentPane.add(getCalltxt());
		contentPane.add(getLblStudentId());
		contentPane.add(getIdtxt());
		contentPane.add(getBtnReturnBook());
		contentPane.add(getBtnBack());
		contentPane.add(getLblNewLabel());
		setVisible(true);
	}

	private JLabel getLblReturnBook() {
		if (lblReturnBook == null) {
			lblReturnBook = new JLabel("Return Book");
			lblReturnBook.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblReturnBook.setBounds(156, 11, 106, 26);
		}
		return lblReturnBook;
	}
	private JLabel getLblBookCallno() {
		if (lblBookCallno == null) {
			lblBookCallno = new JLabel("Book Callno:");
			lblBookCallno.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblBookCallno.setBounds(20, 55, 91, 17);
		}
		return lblBookCallno;
	}
	private JTextField getCalltxt() {
		if (calltxt == null) {
			calltxt = new JTextField();
			calltxt.setBounds(121, 52, 112, 20);
			calltxt.setColumns(10);
		}
		return calltxt;
	}
	private JLabel getLblStudentId() {
		if (lblStudentId == null) {
			lblStudentId = new JLabel("Student id:");
			lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblStudentId.setBounds(20, 86, 91, 17);
		}
		return lblStudentId;
	}
	private JTextField getIdtxt() {
		if (idtxt == null) {
			idtxt = new JTextField();
			idtxt.setColumns(10);
			idtxt.setBounds(121, 83, 112, 20);
		}
		return idtxt;
	}
	private JButton getBtnReturnBook() {
		if (btnReturnBook == null) {
			btnReturnBook = new JButton("Return Book");
			btnReturnBook.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					String Bookcallno = calltxt.getText();
					int Studentid = Integer.parseInt(idtxt.getText());
					
				Returnservices rs = new Returnservicesimpl();
				
				int i = rs.delete(Bookcallno, Studentid);
				
				if(i>0)
				{
					JOptionPane.showMessageDialog(null,"Book returned successfully!");
					new LibrarianSection();
					dispose();
				}
					
				else
				{
					JOptionPane.showMessageDialog(null,"Sorry unable to return the book!");
				}
					
				}
			});
			btnReturnBook.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnReturnBook.setBounds(121, 128, 152, 38);
		}
		return btnReturnBook;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new LibrarianSection();
					dispose();
				}
			});
			btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnBack.setBounds(10, 177, 121, 38);
		}
		return btnBack;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Note:Check the Book properly!!");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setBounds(85, 229, 208, 14);
		}
		return lblNewLabel;
	}
}
