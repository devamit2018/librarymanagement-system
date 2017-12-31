package com.test.clients;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.test.models.Addlibrarian;
import com.test.services.Librarianservices;
import com.test.services.Librarianservicesimpl;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Deleteframe extends JFrame {

	private JPanel contentPane;
	private JTextField idtxt;
	private JButton btnDelete;
	private JButton btnBack;
	private JLabel lblEnterId;
	private Viewframe viewframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deleteframe frame = new Deleteframe();
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
	public Deleteframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 331, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getIdtxt());
		contentPane.add(getBtnDelete());
		contentPane.add(getBtnBack());
		contentPane.add(getLblEnterId());
		setVisible(true);
	}
	private JTextField getIdtxt() {
		if (idtxt == null) {
			idtxt = new JTextField();
			idtxt.setBounds(149, 32, 100, 20);
			idtxt.setColumns(10);
		}
		return idtxt;
	}
	private JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Addlibrarian li = new Addlibrarian();
					
					String sid = idtxt.getText();
					
					int id = Integer.parseInt(sid);
					
					Librarianservices lis = new Librarianservicesimpl();
					boolean result = lis.deletelibrarian(id);
					if(result==true)
					{
						JOptionPane.showMessageDialog(null, "record deleted successfully");
						new Viewframe().Populatedata();
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "error");
					}
					
				}
			});
			btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnDelete.setBounds(149, 63, 89, 41);
		}
		return btnDelete;
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
			btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnBack.setBounds(10, 121, 89, 23);
		}
		return btnBack;
	}
	private JLabel getLblEnterId() {
		if (lblEnterId == null) {
			lblEnterId = new JLabel("Enter Id:");
			lblEnterId.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblEnterId.setBounds(43, 35, 79, 17);
		}
		return lblEnterId;
	}
}
