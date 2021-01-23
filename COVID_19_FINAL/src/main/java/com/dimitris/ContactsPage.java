package com.dimitris;

import com.dimitris.StoredProc;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.microsoft.sqlserver.jdbc.SQLServerException;

public class ContactsPage extends JFrame {

	JFrame frame = new JFrame();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JTextField text_name = new JTextField("name");
	JTextField text_surname = new JTextField("surname");
	JTextField text_age = new JTextField("age");
	JLabel label = new JLabel();
	JLabel label1 = new JLabel();

	public ContactsPage(final int amka) {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(280, 350);
		frame.setResizable(false);
		frame.setLayout(new FlowLayout());
		frame.setTitle("COVID-19");

		button1.setText("SUBMIT");
		button2.setText("DONE");

		System.out.println(amka);
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("dmst.png").getImage().getScaledInstance(270, 40, Image.SCALE_DEFAULT));
		label1.setIcon(imageIcon);
		
		label1.setBounds(10, 10, 400, 60);
		
		frame.add(label1);
		

		button1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				boolean problem = false;

				try {

					String name = text_name.getText();
					String surname = text_surname.getText();
					int age = Integer.parseInt(text_age.getText());

					System.out.println(name);
					System.out.println(surname);
					System.out.println(age);

					text_name.setText("name");
					text_surname.setText("surname");
					text_age.setText("age");
					
					
					//use the stored proc
					
					StoredProc.insert_contact(amka, name, surname, age);
					

				} catch (NumberFormatException ife) {
					JOptionPane.showMessageDialog(frame, "INPUT PROPER DATA", "ERROR", JOptionPane.WARNING_MESSAGE);
					problem = true;

				} catch (SQLServerException e) {
					System.out.println("ERROR");
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (problem == false) {
						// System.out.println(amka);
						JOptionPane.showMessageDialog(frame, "SUBMITTED SYCCESFULLY", "MESSAGE",
								JOptionPane.DEFAULT_OPTION);

					}

				}

			}

		});

		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				frame.dispose();
				new HomePage();

			}

		});

		// add button2 actionListener

		text_name.setPreferredSize(new Dimension(200, 40));
		text_surname.setPreferredSize(new Dimension(200, 40));
		text_age.setPreferredSize(new Dimension(200, 40));

		text_surname.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				text_surname.setText("");
			}

			public void focusLost(FocusEvent e) {

			}

		});

		text_age.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				text_age.setText("");
			}

			public void focusLost(FocusEvent e) {

			}

		});

		label.setText("INSERT CONTACT'S INFO");

		frame.add(label);
		frame.add(text_name);
		frame.add(text_surname);
		frame.add(text_age);
		frame.add(button1);
		frame.add(button2);

		frame.setVisible(true);

	}

}
