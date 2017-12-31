package com.test.clients;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.test.models.Issue;
import com.test.services.Issueservices;
import com.test.services.Librarianservices;
import com.test.services.Librarianservicesimpl;
import com.test.services.issueservicesimpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Issuebook extends JFrame {

	private JPanel contentPane;
	private JLabel lblIsuseBook;
	private JLabel lblBookCallno;
	private JTextField calltxt;
	private JLabel lblStudentId;
	private JTextField idtxt;
	private JLabel lblStudentName;
	private JTextField namtxt;
	private JLabel lblStudentContact;
	private JTextField contxt;
	private JButton btnIssueBook;
	private JButton btnBack;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Issuebook frame = new Issuebook();
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
	public Issuebook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblIsuseBook());
		contentPane.add(getLblBookCallno());
		contentPane.add(getCalltxt());
		contentPane.add(getLblStudentId());
		contentPane.add(getIdtxt());
		contentPane.add(getLblStudentName());
		contentPane.add(getNamtxt());
		contentPane.add(getLblStudentContact());
		contentPane.add(getContxt());
		contentPane.add(getBtnIssueBook());
		contentPane.add(getBtnBack());
		contentPane.add(getLblNewLabel());
		setVisible(true);
	}

	private JLabel getLblIsuseBook() {
		if (lblIsuseBook == null) {
			lblIsuseBook = new JLabel("Isuse  Book");
			lblIsuseBook.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblIsuseBook.setBounds(96, 11, 104, 27);
		}
		return lblIsuseBook;
	}
	private JLabel getLblBookCallno() {
		if (lblBookCallno == null) {
			lblBookCallno = new JLabel("Book Callno:");
			lblBookCallno.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblBookCallno.setBounds(10, 50, 76, 14);
		}
		return lblBookCallno;
	}
	private JTextField getCalltxt() {
		if (calltxt == null) {
			calltxt = new JTextField();
			calltxt.setBounds(146, 45, 133, 20);
			calltxt.setColumns(10);
		}
		return calltxt;
	}
	private JLabel getLblStudentId() {
		if (lblStudentId == null) {
			lblStudentId = new JLabel("Student id:");
			lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblStudentId.setBounds(10, 96, 76, 14);
		}
		return lblStudentId;
	}
	private JTextField getIdtxt() {
		if (idtxt == null) {
			idtxt = new JTextField();
			idtxt.setColumns(10);
			idtxt.setBounds(146, 91, 133, 20);
		}
		return idtxt;
	}
	private JLabel getLblStudentName() {
		if (lblStudentName == null) {
			lblStudentName = new JLabel("Student name:");
			lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblStudentName.setBounds(10, 143, 92, 14);
		}
		return lblStudentName;
	}
	private JTextField getNamtxt() {
		if (namtxt == null) {
			namtxt = new JTextField();
			namtxt.setColumns(10);
			namtxt.setBounds(146, 138, 133, 20);
		}
		return namtxt;
	}
	private JLabel getLblStudentContact() {
		if (lblStudentContact == null) {
			lblStudentContact = new JLabel("Student contact:");
			lblStudentContact.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblStudentContact.setBounds(10, 181, 112, 18);
		}
		return lblStudentContact;
	}
	private JTextField getContxt() {
		if (contxt == null) {
			contxt = new JTextField();
			contxt.setColumns(10);
			contxt.setBounds(146, 179, 133, 20);
		}
		return contxt;
	}
	private JButton getBtnIssueBook() {
		if (btnIssueBook == null) {
			btnIssueBook = new JButton("Issue Book");
			btnIssueBook.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					
					
					String Bookcallno = calltxt.getText();
					int Studentid = Integer.parseInt(idtxt.getText());
					String Studentname = namtxt.getText();
					String Studentcontact = contxt.getText();
					
					
					
					Issueservices is = new issueservicesimpl();
					boolean result = is.Checkbook(Bookcallno);
					
					if(result==true)
					{
						int i = is.Save(Bookcallno, Studentid, Studentname, Studentcontact);
						
						if(i>0)
						{
							JOptionPane.showMessageDialog(null, "Books issued successfully");
							calltxt.setText("");
							idtxt.setText("");
							namtxt.setText("");
							contxt.setText("");
						}
						
						else
						{
							JOptionPane.showMessageDialog(null, "check quantity");
						}
						
						
					}
					
					
						
				}});
					
					
					
					
					
			
			
					
				
			
			btnIssueBook.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnIssueBook.setBounds(161, 224, 127, 46);
		}
		return btnIssueBook;
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
			btnBack.setBounds(10, 275, 127, 46);
		}
		return btnBack;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Note:please Check Studentid carefully Before issuing book");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setBounds(10, 348, 320, 14);
		}
		return lblNewLabel;
	}
}
