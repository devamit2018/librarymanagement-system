package com.test.clients;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.test.models.Addlibrarian;
import com.test.services.Librarianservices;
import com.test.services.Librarianservicesimpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Addlibrarianframe extends JFrame {

	private JPanel contentPane;
	private JLabel lblAddLibrarian;
	private JLabel lblName;
	private JTextField namtxt;
	private JLabel lblPassword;
	private JPasswordField passtxt;
	private JLabel lblEmail;
	private JTextField emailtxt;
	private JLabel lblAddress;
	private JTextField addtxt;
	private JLabel lblCity;
	private JTextField citytxt;
	private JLabel lblPhone;
	private JTextField phntxt;
	private JButton btnAddLibrarian;
	private JButton btnBack;
	
	private Viewframe viewframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addlibrarianframe frame = new Addlibrarianframe();
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
	public Addlibrarianframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblAddLibrarian());
		contentPane.add(getLblName());
		contentPane.add(getNamtxt());
		contentPane.add(getLblPassword());
		contentPane.add(getPasstxt());
		contentPane.add(getLblEmail());
		contentPane.add(getEmailtxt());
		contentPane.add(getLblAddress());
		contentPane.add(getAddtxt());
		contentPane.add(getLblCity());
		contentPane.add(getCitytxt());
		contentPane.add(getLblPhone());
		contentPane.add(getPhntxt());
		contentPane.add(getBtnAddLibrarian());
		contentPane.add(getBtnBack());
		setVisible(true);
	}

	private JLabel getLblAddLibrarian() {
		if (lblAddLibrarian == null) {
			lblAddLibrarian = new JLabel("Add Librarian");
			lblAddLibrarian.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblAddLibrarian.setBounds(156, 11, 88, 21);
		}
		return lblAddLibrarian;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Name");
			lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblName.setBounds(31, 63, 46, 14);
		}
		return lblName;
	}
	private JTextField getNamtxt() {
		if (namtxt == null) {
			namtxt = new JTextField();
			namtxt.setBounds(114, 61, 145, 20);
			namtxt.setColumns(10);
		}
		return namtxt;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPassword.setBounds(31, 111, 66, 14);
		}
		return lblPassword;
	}
	private JPasswordField getPasstxt() {
		if (passtxt == null) {
			passtxt = new JPasswordField();
			passtxt.setBounds(114, 109, 145, 20);
		}
		return passtxt;
	}
	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email");
			lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblEmail.setBounds(31, 159, 46, 14);
		}
		return lblEmail;
	}
	private JTextField getEmailtxt() {
		if (emailtxt == null) {
			emailtxt = new JTextField();
			emailtxt.setColumns(10);
			emailtxt.setBounds(114, 157, 145, 20);
		}
		return emailtxt;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address");
			lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblAddress.setBounds(31, 205, 66, 14);
		}
		return lblAddress;
	}
	private JTextField getAddtxt() {
		if (addtxt == null) {
			addtxt = new JTextField();
			addtxt.setColumns(10);
			addtxt.setBounds(114, 203, 145, 20);
		}
		return addtxt;
	}
	private JLabel getLblCity() {
		if (lblCity == null) {
			lblCity = new JLabel("City");
			lblCity.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblCity.setBounds(31, 254, 46, 14);
		}
		return lblCity;
	}
	private JTextField getCitytxt() {
		if (citytxt == null) {
			citytxt = new JTextField();
			citytxt.setColumns(10);
			citytxt.setBounds(114, 252, 145, 20);
		}
		return citytxt;
	}
	private JLabel getLblPhone() {
		if (lblPhone == null) {
			lblPhone = new JLabel("Phone");
			lblPhone.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblPhone.setBounds(31, 298, 46, 14);
		}
		return lblPhone;
	}
	private JTextField getPhntxt() {
		if (phntxt == null) {
			phntxt = new JTextField();
			phntxt.setColumns(10);
			phntxt.setBounds(114, 296, 145, 20);
		}
		return phntxt;
	}
	private JButton getBtnAddLibrarian() {
		if (btnAddLibrarian == null) {
			btnAddLibrarian = new JButton("Add Librarian");
			btnAddLibrarian.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Addlibrarian li = new Addlibrarian();
					li.setName(namtxt.getText());
					li.setPassword(passtxt.getText());
					li.setEmail(emailtxt.getText());
					li.setAddress(addtxt.getText());
					li.setCity(citytxt.getText());
					li.setPhone(phntxt.getText());
					
					Librarianservices lis = new Librarianservicesimpl();
					
					boolean result =lis.AddLibrarian(li);
					
					if(result == true)
					{
						
						JOptionPane.showMessageDialog(null, "Librarian added successfully");
						namtxt.setText("");
					passtxt.setText("");
						emailtxt.setText("");
						addtxt.setText("");
						citytxt.setText("");
						phntxt.setText("");
						addtxt.setText("");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "unable to add librarian");	
					}
					
					
					
					
					
				}
			});
			btnAddLibrarian.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnAddLibrarian.setBounds(156, 327, 145, 40);
		}
		return btnAddLibrarian;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new Adminsectionframe();
					dispose();
				}
			});
			btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnBack.setBounds(20, 359, 94, 34);
		}
		return btnBack;
	}
	
	
	
	
	
	
	
	
	
	
}
