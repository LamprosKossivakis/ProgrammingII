package com.dimitris;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class Search_page extends JFrame {

	JFrame frame = new JFrame();
	JButton button1 = new JButton();
	JTextField text_search = new JTextField();
	JButton button2 = new JButton();
	JLabel label = new JLabel();
	JLabel label1 = new JLabel();
	JPanel panel = new JPanel();
	JTextField display = new JTextField();
	JCheckBox check = new JCheckBox();
	JPanel panel1 = new JPanel();
	


	int contacts_trig = -1;

	DefaultListModel<Object> model_test = new DefaultListModel();
	JList l_test = new JList(model_test);
	
	DefaultListModel<Object> model_con = new DefaultListModel();
	JList l_con = new JList(model_con);

	public Search_page() {

		// panel.setBounds(200, 200, 100, 100);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		check.setText("Contacts");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 350);
		// frame.setSize(280, 300);
		frame.setResizable(false);
		frame.setLayout(null);
		//panel.setLayout(new FlowLayout());
		frame.setTitle("COVID-19");
		display.setEditable(false);
		label.setText("PATIENT'S AMKA");

		text_search.setText("type patient's amka");
		text_search.setPreferredSize(new Dimension(160, 40));
		display.setPreferredSize(new Dimension(300, 40));
		button1.setText("SEARCH");
		button2.setText("BACK");
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("dmst.png").getImage().getScaledInstance(350, 60, Image.SCALE_DEFAULT));
		label1.setIcon(imageIcon);
		
		label1.setBounds(10, 10, 400, 60);
		
		frame.add(label1);
		

		text_search.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				text_search.setText("");
			}

			public void focusLost(FocusEvent e) {

			}

		});

		model_test.addListDataListener(new ListDataListener() {

			public void contentsChanged(ListDataEvent e) {
				System.out.println("CONTENT CHANGED");
			}

			public void intervalAdded(ListDataEvent e) {
				System.out.println("CONTENT CHANGED");

			}

			public void intervalRemoved(ListDataEvent e) {
				System.out.println("CONTENT CHANGED");

			}
		});
		
		model_con.addListDataListener(new ListDataListener() {

			public void contentsChanged(ListDataEvent e) {
				System.out.println("CONTENT CHANGED");
			}

			public void intervalAdded(ListDataEvent e) {
				System.out.println("CONTENT CHANGED");

			}

			public void intervalRemoved(ListDataEvent e) {
				System.out.println("CONTENT CHANGED");

			}
		});

		panel.add(l_test);
		panel.add(l_con);
		

		button1.addActionListener(

				new ActionListener() {

					public void actionPerformed(ActionEvent event) {

						try {

							panel.setVisible(false);
							int amka = Integer.parseInt(text_search.getText());
							System.out.println(amka);
							int search_res = StoredProc.search_patient(amka);
							String tested;

							// DefaultListModel<Object> model = new DefaultListModel();
							// JList l = new JList(model);

							Font newTextFieldFont = new Font(display.getFont().getName(), display.getFont().getStyle(),
									10);
							display.setFont(newTextFieldFont);

							// if the patient exists in the databsae or not

							if (search_res == 0) {

								JOptionPane.showMessageDialog(frame, "DATA FOR THIS AMKA DONT EXIST", "ERROR",
										JOptionPane.ERROR_MESSAGE);
								model_test.removeAllElements();
								model_con.removeAllElements();
								panel.revalidate();

							} else {

								// load the patients testing data to the arraylist

								ArrayList test_list = new ArrayList();
								test_list = StoredProc.getTestData(amka);
								model_test.removeAllElements();

								for (Object val : test_list)
									model_test.addElement(val);
								
								if (contacts_trig == 1) {
									//call method to getContacts
									
									
									ArrayList con_list = new ArrayList();
									con_list = StoredProc.show_contacts(amka);
									
									model_con.removeAllElements();
									
									for (Object val : con_list)
										model_con.addElement(val);
									
									
								}else {
									model_con.removeAllElements();
								}
								

							}

							panel.setVisible(true);

						} catch (NumberFormatException nfe) {
							System.out.println("ERROR");
							JOptionPane.showMessageDialog(frame, "TYPE NUMBERS ONLY", "ERROR",
									JOptionPane.ERROR_MESSAGE);

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				});

		check.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				if (ie.getStateChange() == 1) {
					System.out.println("CHANGE STO CHECK");
					contacts_trig = 1;

				} else {
					System.out.println("CHANGE STO  UN CHECK");
					contacts_trig = 0;
				}
			}
		});

		button2.addActionListener(

				new ActionListener() {

					public void actionPerformed(ActionEvent event) {
						frame.dispose();
						new HomePage();

					}

				});
		
		
		label.setBounds(10, 80,150 , 25);
		text_search.setBounds(130 , 80, 150,25);
		button2.setBounds(40, 120, 100, 25);
		button1.setBounds(160, 120, 100, 25);
		check.setBounds(280, 80, 100, 25);
		
		panel.setBounds(100, 150, 200, 200);
		
		panel.setVisible(false);
		frame.add(label);
		frame.add(text_search);
		frame.add(check);
		frame.add(button1);
		frame.add(panel);
		frame.add(button2);
		frame.setVisible(true);

	}

}
