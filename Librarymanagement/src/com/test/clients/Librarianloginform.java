package com.test.clients;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.test.services.Librarianservices;
import com.test.services.Librarianservicesimpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Librarianloginform extends JFrame {

	private JPanel contentPane;
	private JLabel lblLibrarianLoginForm;
	private JLabel lblNewLabel;
	private JTextField namtxt;
	private JLabel lblEnterPassword;
	private JPasswordField passtxt;
	private JButton btnLogin;
	
	private Librarianservicesimpl lis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Librarianloginform frame = new Librarianloginform();
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
	public Librarianloginform() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLibrarianLoginForm());
		contentPane.add(getLblNewLabel());
		contentPane.add(getNamtxt());
		contentPane.add(getLblEnterPassword());
		contentPane.add(getPasstxt());
		contentPane.add(getBtnLogin());
		setVisible(true);
	}
	private JLabel getLblLibrarianLoginForm() {
		if (lblLibrarianLoginForm == null) {
			lblLibrarianLoginForm = new JLabel("Librarian Login Form");
			lblLibrarianLoginForm.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblLibrarianLoginForm.setBounds(144, 11, 136, 24);
		}
		return lblLibrarianLoginForm;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Enter Name:");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel.setBounds(27, 80, 81, 24);
		}
		return lblNewLabel;
	}
	private JTextField getNamtxt() {
		if (namtxt == null) {
			namtxt = new JTextField();
			namtxt.setBounds(156, 81, 153, 24);
			namtxt.setColumns(10);
		}
		return namtxt;
	}
	private JLabel getLblEnterPassword() {
		if (lblEnterPassword == null) {
			lblEnterPassword = new JLabel("Enter Password:");
			lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblEnterPassword.setBounds(27, 116, 105, 24);
		}
		return lblEnterPassword;
	}
	private JPasswordField getPasstxt() {
		if (passtxt == null) {
			passtxt = new JPasswordField();
			passtxt.setBounds(156, 116, 153, 24);
		}
		return passtxt;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String name= namtxt.getText();
					String password = String.valueOf(passtxt.getPassword());
					Librarianservices lis = new Librarianservicesimpl();
					boolean result = lis.validate(name, password);
					
					if(result==true)
					
					{
						JOptionPane.showMessageDialog(null, "succeess");
						new LibrarianSection();
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "error");
						namtxt.setText("");
						passtxt.setText("");
					}
					
				}
					
					
					
				
			});
			btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnLogin.setBounds(191, 172, 105, 30);
		}
		return btnLogin;
	}
}
