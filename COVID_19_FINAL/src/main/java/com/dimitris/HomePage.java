package com.dimitris;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HomePage extends LoginPage {

	JFrame frame = new JFrame();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton button4 = new JButton();
	JButton change_user = new JButton();
	JPanel panel_user = new JPanel();
	JPanel button_panel = new JPanel();
	JPanel panel = new JPanel();

	JTextField user_text = new JTextField();

	public HomePage() {

		button_panel.setLayout(new BoxLayout(button_panel, BoxLayout.Y_AXIS));

		user_text.setText("User: " + NameSurname);
		user_text.setEditable(false);
		panel_user.add(user_text);

		frame.setTitle("COVID-19");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 250);

		frame.setLayout(new FlowLayout());

		frame.setResizable(true);
		
		//button2.setPreferredSize(new Dimension(100,100));
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("dmst.png").getImage().getScaledInstance(330, 55, Image.SCALE_DEFAULT));
		label.setIcon(imageIcon);
		
		label.setBounds(5, 10, 400, 50);
		panel.add(label);
		
		frame.add(panel);
		
		
		
		
		button1.setText("Add a patient");
		button1.addActionListener(

				new ActionListener() {
					public void actionPerformed(ActionEvent event) {

						new InsertPage();
						frame.dispose();

					}

				});

		button2.addActionListener(

				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						frame.dispose();
						new Search_page();

					}

				});

		change_user.addActionListener(

				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						frame.dispose();
						new LoginPage();

					}

				});
		
		button3.addActionListener(

				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						frame.dispose();
						new GeneralTips();

					}

				});
		
		button3.setText("General Info");
		button2.setText("Search for a patient");
		change_user.setText("Change user");
		//button2.addActionListener();
		
		button_panel.add(button1);
		button_panel.add(button2);
		button_panel.add(button3);
		button_panel.add(change_user);

		frame.add(panel_user);
		frame.add(button_panel);

		frame.setVisible(true);

	}

}
