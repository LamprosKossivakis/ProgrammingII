package com.dimitris;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.microsoft.sqlserver.jdbc.SQLServerException;

public class InsertPage extends JFrame {
	JFrame frame = new JFrame();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JTextField text_amka = new JTextField("AMKA");
	JTextField text_name = new JTextField("name");
	JTextField text_surname = new JTextField("surname");
	JTextField text_age = new JTextField("age");
	JLabel label = new JLabel();
	
	// JTextField text_test = new JTextField("tested");

	String[] options1 = { "NEGATIVE", "POSSITIVE" };
	String[] options2 = { "FEMALE", "MALE" };

	String[] options3 = { "Περιφέρεια Ανατολικής Μακεδονίας και Θράκης", "Περιφέρεια Κεντρικής Μακεδονίας",
			"Περιφέρεια Δυτικής Μακεδονίας", "Περιφέρεια Ηπείρου", "Περιφέρεια Θεσσαλίας", "Περιφέρεια Ιονίων Νήσων",
			"Περιφέρεια Δυτικής Ελλάδας", "Περιφέρεια Στερεάς Ελλάδας", "Περιφέρεια Αττικής", "Περιφέρεια Πελοποννήσου",
			"Περιφέρεια Βορείου Αιγαίου", "Περιφέρεια Νοτίου Αιγαίου", "Περιφέρεια Κρήτης" };
	JComboBox combo1 = new JComboBox(options1);
	JComboBox combo2 = new JComboBox(options2);
	JComboBox combo3 = new JComboBox(options3);

	int test = 0;
	String test_toString = "NEGATIVE";
	int geo = 1;
	String sex = "F";
	int days;

	public InsertPage() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(310, 380);
		frame.setResizable(true);
		frame.setLayout(new FlowLayout());
		frame.setTitle("COVID-19");
		text_amka.setPreferredSize(new Dimension(200, 40));
		text_name.setPreferredSize(new Dimension(200, 40));
		text_surname.setPreferredSize(new Dimension(200, 40));
		text_age.setPreferredSize(new Dimension(200, 40));
		// text_test.setPreferredSize(new Dimension(200, 40));

		text_name.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				text_name.setText("");
			}

			public void focusLost(FocusEvent e) {

			}

		});

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
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("dmst.png").getImage().getScaledInstance(300, 50, Image.SCALE_DEFAULT));
		label.setIcon(imageIcon);
		
		label.setBounds(5, 10, 400, 50);
		frame.add(label);

		/**
		 * text_test.addFocusListener(new FocusListener() {
		 * 
		 * public void focusGained(FocusEvent e) { text_test.setText(""); }
		 * 
		 * public void focusLost(FocusEvent e) {
		 * 
		 * }
		 * 
		 * });
		 */

		frame.add(text_amka);
		frame.add(text_name);
		frame.add(text_surname);
		frame.add(text_age);
		// frame.add(text_test);

		frame.add(combo1);
		frame.add(combo2);
		frame.add(combo3);

		button1.setText("BACK");
		button2.setText("SUBMIT");

		combo1.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				test = combo1.getSelectedIndex();
				if (test == 0) {
					test_toString = "NEGATIVE";

				} else {
					test_toString = "POSSITIVE";
				}
				System.out.println("ITEM LISTENER SAYS: " + test);

			}

		});

		combo2.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {

				if (combo2.getSelectedIndex() == 0) {
					sex = "F";
				} else {
					sex = "M";
				}
				System.out.println("ITEM LISTENER SAYS: " + sex);

			}

		});

		combo3.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				geo = combo3.getSelectedIndex() + 1;
				System.out.println("ITEM LISTENER SAYS: " + geo);

			}

		});
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				frame.dispose();
				new HomePage();

			}

		});

		button2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				int amka = 0;

				boolean problem = false;

				try {

					amka = Integer.parseInt(text_amka.getText());
					String name = text_name.getText();
					String surname = text_surname.getText();
					int age = Integer.parseInt(text_age.getText());

					// search if the amka exists in the table// if yes then modify else just add her
					// prosoxi me to return statment
					days = StoredProc.insert_patient(amka, name, surname, age, test_toString, sex, geo);

					System.out.println("DAYS ELLAPSED " + days);

					text_amka.setText("amka");
					text_name.setText("name");
					text_surname.setText("surname");
					text_age.setText("age");

				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(frame, "MAKE SURE TO INSERT PROPER DATA", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					// System.out.println("ERROR");
					problem = true;

				} catch (SQLServerException e1) {
					System.out.println("ERROR");
					JOptionPane.showMessageDialog(frame, "PATIENTS AMKA ALREADY EXISTS", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					System.out.println(test);
					if (problem == false) {
						if (days == -1) {
							JOptionPane.showMessageDialog(frame, "SUBMITTED SYCCESFULLY", "MESSAGE",
									JOptionPane.DEFAULT_OPTION);

							if (test == 1) {
								int ans = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO ADD PATIENTS CONTACTS?",
										"MESSAGE", JOptionPane.YES_NO_OPTION);
								if (ans == JOptionPane.YES_OPTION) {

									new ContactsPage(amka);
									frame.dispose();

									// open the new window with the contact credentials
									// dispose window SecPage

								} else if (ans == JOptionPane.NO_OPTION) {
									new HomePage();
									frame.dispose();
								}
							}
						} else {
							if (days < 14) {
								JOptionPane.showMessageDialog(frame,
										"PATIENT IS TESTED POSSITIVE AND SHOULD WAIT FOR 14 DAYS TO REPEAT TEST",
										"MESSAGE", JOptionPane.DEFAULT_OPTION);

							} else {
								JOptionPane.showMessageDialog(frame, "SUBMITTED SUCCESFULLY ", "MESSAGE",
										JOptionPane.DEFAULT_OPTION);
							}
						}
					}
				}

			}

		});

		frame.add(button1);
		frame.add(button2);

		frame.setVisible(true);
		// frame.pack();

	}

}
