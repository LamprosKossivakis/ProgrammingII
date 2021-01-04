import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.IllegalFormatException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Insert_page extends JFrame {

	JFrame frame = new JFrame();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JTextField text_amka = new JTextField("AMKA");
	JTextField text_name = new JTextField("name");
	JTextField text_surname = new JTextField("surname");
	JTextField text_age = new JTextField("age");
	JTextField text_test = new JTextField("tested");

	public Insert_page() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(280, 350);
		frame.setResizable(false);
		frame.setLayout(new FlowLayout());
		frame.setTitle("COVID-19");
		text_amka.setPreferredSize(new Dimension(200, 40));
		text_name.setPreferredSize(new Dimension(200, 40));
		text_surname.setPreferredSize(new Dimension(200, 40));
		text_age.setPreferredSize(new Dimension(200, 40));
		text_test.setPreferredSize(new Dimension(200, 40));

		text_name.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				text_name.setText("");
			}

			public void focusLost(FocusEvent e) {

			}

		});

		text_surname.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				text_surname.setText("");
			}

			public void focusLost(FocusEvent e) {

			}

		});

		text_age.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				text_age.setText("");
			}

			public void focusLost(FocusEvent e) {

			}

		});

		text_test.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				text_test.setText("");
			}

			public void focusLost(FocusEvent e) {

			}

		});

		frame.add(text_amka);
		frame.add(text_name);
		frame.add(text_surname);
		frame.add(text_age);
		frame.add(text_test);

		button1.setText("BACK");
		button2.setText("SUBMIT");

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				frame.dispose();
				new HomePage();

			}

		});

		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int amka = 0;

				boolean problem = false;

				try {
					amka = Integer.parseInt(text_amka.getText());
					String name = text_name.getText();
					String surname = text_surname.getText();
					int age = Integer.parseInt(text_age.getText());
					int test = Integer.parseInt(text_test.getText());
					System.out.println(amka);
					System.out.println(name);
					System.out.println(surname);
					System.out.println(age);
					System.out.println(test);

					text_amka.setText("amka");
					text_name.setText("name");
					text_surname.setText("surname");
					text_age.setText("age");
					text_test.setText("test");

				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(frame, "MAKE SURE TO INSERT PROPER DATA", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					//System.out.println("ERROR");
					problem = true;

				} finally {
					if (problem == false) {
						int ans = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO ADD PATIENTS CONTACTS?",
								"MESSAGE", JOptionPane.YES_NO_OPTION);
						if (ans == JOptionPane.YES_OPTION) {

							new Contacts_page(amka);
							frame.dispose();

							// open the new window with the contact credentials
							// dispose window SecPage

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
