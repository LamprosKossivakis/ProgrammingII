package com.dimitris;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewUser {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	JLabel userlabel = new JLabel("Username(*)");
	JTextField user_text = new JTextField();

	JLabel passwordlabel = new JLabel("Password(*)");
	JTextField password_text = new JTextField();

	JLabel passwordVerlabel = new JLabel("Verify Password(*)");
	JTextField password_ver_text = new JTextField();

	JLabel namelabel = new JLabel("Name");
	JTextField name_text = new JTextField();

	JLabel surnamelabel = new JLabel("Surname");
	JTextField surname_text = new JTextField();

	JLabel emailabel = new JLabel("Email");
	JTextField email_text = new JTextField();

	JButton submit = new JButton();
	JButton back = new JButton();
	ResultSet rs1;
	
	JLabel label = new JLabel();

	public NewUser() {

		frame.setTitle("New User");

		frame.setSize(350, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(panel);

		panel.setLayout(null);

		ImageIcon imageIcon = new ImageIcon(new ImageIcon("dmst.png").getImage().getScaledInstance(330, 55, Image.SCALE_DEFAULT));
		label.setIcon(imageIcon);
		
		label.setBounds(5, 10, 400, 50);
		panel.add(label);
		// name label
		// name text

		// surname label
		// surname text

		namelabel.setBounds(10, 80, 80, 25);
		panel.add(namelabel);
		name_text.setBounds(130, 80, 165, 25);
		panel.add(name_text);

		surnamelabel.setBounds(10, 110, 80, 25);
		panel.add(surnamelabel);
		surname_text.setBounds(130, 110, 165, 25);
		panel.add(surname_text);

		emailabel.setBounds(10, 140, 80, 25);
		panel.add(emailabel);
		email_text.setBounds(130, 140, 165, 25);
		panel.add(email_text);

		userlabel.setBounds(10, 170, 80, 25);
		panel.add(userlabel);
		user_text.setBounds(130, 170, 165, 25);
		panel.add(user_text);

		passwordlabel.setBounds(10, 200, 80, 25);
		panel.add(passwordlabel);
		password_text.setBounds(130, 200, 165, 25);
		panel.add(password_text);

		passwordVerlabel.setBounds(10, 230, 100, 25);
		panel.add(passwordVerlabel);
		password_ver_text.setBounds(130, 230, 165, 25);
		panel.add(password_ver_text);

		submit.setBounds(185, 270, 80, 25);
		submit.setText("Submit");
		panel.add(submit);	

		back.setBounds(70, 270, 100, 25);
		back.setText("Back");
		panel.add(back);

		back.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new LoginPage();

			}
		});

		submit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String username = user_text.getText();
				String pass1 = password_text.getText();
				String pass2 = password_ver_text.getText();

				if (username.equals("") | pass1.equals("") | pass2.equals("")) {
					JOptionPane.showMessageDialog(frame, "FILL IN ALL THE INFO ASKED", "ERROR",
							JOptionPane.ERROR_MESSAGE);

				} else {
					if (pass1.equals(pass2)) {

						// call insert method
						// alter the stored proc to find out if the username exists

						try {
							
							String name = name_text.getText();
							String surname = surname_text.getText();
							String email = email_text.getText();
							
							int inserted = StoredProc.insert_credentilas(username, pass1,name,surname,email);
							
								

							if (inserted == 0) {
								JOptionPane.showMessageDialog(frame, "THE USERNAME ALREADY EXISTS", "ERROR",
										JOptionPane.ERROR_MESSAGE);
								user_text.setText("");
								
								

							} else {
								JOptionPane.showMessageDialog(frame, "SUBMITTED SUCCESFULLY", "SUCCESS",
										JOptionPane.DEFAULT_OPTION);
								
								name_text.setText("");
								surname_text.setText("");
								email_text.setText("");
								user_text.setText("");
								password_text.setText("");
								password_ver_text.setText("");
							}

						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					} else {
						JOptionPane.showMessageDialog(frame, "PASSWORDS DONT MATCH", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}

				}

			}

		});

		frame.setVisible(true);
	}

}
