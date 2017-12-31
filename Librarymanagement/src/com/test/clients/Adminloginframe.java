package com.test.clients;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Adminloginframe extends JFrame {

	private JPanel contentPane;
	private JLabel lblname;
	private JTextField namtxt;
	private JLabel lblpassword;
	private JPasswordField paswwordtxt;
	private JLabel lblAdminLoginForm;
	private JButton btnLogin;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminloginframe frame = new Adminloginframe();
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
	public Adminloginframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblname());
		contentPane.add(getNamtxt());
		contentPane.add(getLblpassword());
		contentPane.add(getPaswwordtxt());
		contentPane.add(getLblAdminLoginForm());
		contentPane.add(getBtnLogin());
		contentPane.add(getLblNewLabel());
		setVisible(true);
	}

	private JLabel getLblname() {
		if (lblname == null) {
			lblname = new JLabel("Enter Name:");
			lblname.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblname.setBounds(37, 94, 78, 14);
		}
		return lblname;
	}
	private JTextField getNamtxt() {
		if (namtxt == null) {
			namtxt = new JTextField();
			namtxt.setBounds(152, 92, 109, 20);
			namtxt.setColumns(10);
		}
		return namtxt;
	}
	private JLabel getLblpassword() {
		if (lblpassword == null) {
			lblpassword = new JLabel("Enter Password:");
			lblpassword.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblpassword.setBounds(33, 131, 109, 20);
		}
		return lblpassword;
	}
	private JPasswordField getPaswwordtxt() {
		if (paswwordtxt == null) {
			paswwordtxt = new JPasswordField();
			paswwordtxt.setBounds(152, 132, 109, 20);
		}
		return paswwordtxt;
	}
	private JLabel getLblAdminLoginForm() {
		if (lblAdminLoginForm == null) {
			lblAdminLoginForm = new JLabel("Admin Login Form");
			lblAdminLoginForm.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblAdminLoginForm.setBounds(96, 31, 137, 14);
		}
		return lblAdminLoginForm;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String username = namtxt.getText();
					String password =paswwordtxt.getText();
					
					if(username.equals("admin") && password.equals("admin123"))
					{
						JOptionPane.showMessageDialog(null, "login success");
						new Adminsectionframe();
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "login error");
					}
					
				}
			});
			btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 14));
			btnLogin.setBounds(172, 189, 89, 23);
		}
		return btnLogin;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setEnabled(false);
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBackground(SystemColor.activeCaption);
			lblNewLabel.setBounds(10, 11, 313, 250);
		}
		return lblNewLabel;
	}
}
