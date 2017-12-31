package com.test.clients;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.test.models.Addbooks;
import com.test.services.Librarianservices;
import com.test.services.Librarianservicesimpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Addbooksframe extends JFrame {

	private JPanel contentPane;
	private JLabel lblAddBooks;
	private JLabel lblCallNo;
	private JTextField calltxt;
	private JLabel lblAuthor;
	private JTextField namtxt;
	private JLabel lblAuthor_1;
	private JTextField auttxt;
	private JLabel lblPublisher;
	private JTextField pubtxt;
	private JLabel lblQuantity;
	private JTextField quatxt;
	private JButton btnAddBooks;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addbooksframe frame = new Addbooksframe();
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
	public Addbooksframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblAddBooks());
		contentPane.add(getLblCallNo());
		contentPane.add(getCalltxt());
		contentPane.add(getLblAuthor());
		contentPane.add(getNamtxt());
		contentPane.add(getLblAuthor_1());
		contentPane.add(getAuttxt());
		contentPane.add(getLblPublisher());
		contentPane.add(getPubtxt());
		contentPane.add(getLblQuantity());
		contentPane.add(getQuatxt());
		contentPane.add(getBtnAddBooks());
		contentPane.add(getBtnBack());
		setVisible(true);
	}

	private JLabel getLblAddBooks() {
		if (lblAddBooks == null) {
			lblAddBooks = new JLabel("Add Books");
			lblAddBooks.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblAddBooks.setBounds(109, 11, 80, 20);
		}
		return lblAddBooks;
	}
	private JLabel getLblCallNo() {
		if (lblCallNo == null) {
			lblCallNo = new JLabel("Call No:");
			lblCallNo.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblCallNo.setBounds(24, 54, 69, 20);
		}
		return lblCallNo;
	}
	private JTextField getCalltxt() {
		if (calltxt == null) {
			calltxt = new JTextField();
			calltxt.setBounds(103, 55, 134, 20);
			calltxt.setColumns(10);
		}
		return calltxt;
	}
	private JLabel getLblAuthor() {
		if (lblAuthor == null) {
			lblAuthor = new JLabel("Name:");
			lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblAuthor.setBounds(24, 99, 69, 20);
		}
		return lblAuthor;
	}
	private JTextField getNamtxt() {
		if (namtxt == null) {
			namtxt = new JTextField();
			namtxt.setColumns(10);
			namtxt.setBounds(103, 100, 134, 20);
		}
		return namtxt;
	}
	private JLabel getLblAuthor_1() {
		if (lblAuthor_1 == null) {
			lblAuthor_1 = new JLabel("Author:");
			lblAuthor_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblAuthor_1.setBounds(24, 140, 69, 20);
		}
		return lblAuthor_1;
	}
	private JTextField getAuttxt() {
		if (auttxt == null) {
			auttxt = new JTextField();
			auttxt.setColumns(10);
			auttxt.setBounds(103, 141, 134, 20);
		}
		return auttxt;
	}
	private JLabel getLblPublisher() {
		if (lblPublisher == null) {
			lblPublisher = new JLabel("Publisher:");
			lblPublisher.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPublisher.setBounds(24, 184, 69, 20);
		}
		return lblPublisher;
	}
	private JTextField getPubtxt() {
		if (pubtxt == null) {
			pubtxt = new JTextField();
			pubtxt.setColumns(10);
			pubtxt.setBounds(103, 185, 134, 20);
		}
		return pubtxt;
	}
	private JLabel getLblQuantity() {
		if (lblQuantity == null) {
			lblQuantity = new JLabel("Quantity:");
			lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblQuantity.setBounds(24, 231, 69, 20);
		}
		return lblQuantity;
	}
	private JTextField getQuatxt() {
		if (quatxt == null) {
			quatxt = new JTextField();
			quatxt.setColumns(10);
			quatxt.setBounds(103, 232, 134, 20);
		}
		return quatxt;
	}
	private JButton getBtnAddBooks() {
		if (btnAddBooks == null) {
			btnAddBooks = new JButton("Add Books");
			btnAddBooks.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					
					Addbooks ad = new Addbooks();
					
					ad.setCallno(calltxt.getText());
					ad.setName(namtxt.getText());
					ad.setAuthor(auttxt.getText());
					ad.setPublisher(pubtxt.getText());
					ad.setQuantity(Integer.parseInt(quatxt.getText()));
					
					Librarianservices lis = new Librarianservicesimpl();
					
					boolean result =lis.addbooks(ad);
					if(result==true)
					{
						JOptionPane.showMessageDialog(null, "books added successfully");
						calltxt.setText("");
						namtxt.setText("");
						auttxt.setText("");
						pubtxt.setText("");
						quatxt.setText("");
					}
					else
					{
						
						JOptionPane.showMessageDialog(null, "error");	
						
					}
					
				}
			});
			btnAddBooks.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnAddBooks.setBounds(109, 275, 116, 34);
		}
		return btnAddBooks;
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
			btnBack.setBounds(265, 275, 107, 34);
		}
		return btnBack;
	}
}
