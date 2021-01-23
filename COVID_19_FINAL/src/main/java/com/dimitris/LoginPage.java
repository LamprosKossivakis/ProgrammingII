package com.dimitris;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPage {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel userlabel = new JLabel("username");
	JTextField user_text = new JTextField();
	JLabel passwordlabel = new JLabel("password");
	JTextField password_text = new JTextField();
	JButton sign_in = new JButton();
	JButton new_user = new JButton();
	ResultSet rs1;
	JLabel label = new JLabel();
	
	public static String NameSurname;

	HashMap<String, String> credentials = new HashMap<String, String>();

	public LoginPage() {

		// use a method to retrieve the credentials table from database
		try {
			rs1 = load_credentials();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		frame.setTitle("Login");

		frame.setSize(350, 250);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(panel);

		panel.setLayout(null);

		userlabel.setBounds(10, 80, 80, 25);
		panel.add(userlabel);

		user_text.setBounds(100, 80, 165, 25);
		panel.add(user_text);

		passwordlabel.setBounds(10, 110, 80, 25);
		panel.add(passwordlabel);

		password_text.setBounds(100, 110, 165, 25);
		panel.add(password_text);

		sign_in.setBounds(185, 160, 80, 25);
		sign_in.setText("Sign in");
		panel.add(sign_in);

		new_user.setBounds(70, 160, 100, 25);
		new_user.setText("New user");
		panel.add(new_user);
		
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("dmst.png").getImage().getScaledInstance(330, 55, Image.SCALE_DEFAULT));
		label.setIcon(imageIcon);
		
		label.setBounds(5, 10, 400, 50);
		panel.add(label);
        
         
		
		
		

		sign_in.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//System.out.println("SIGN IN");

				String username = user_text.getText();
				String password = password_text.getText();

				System.out.println(username);
				System.out.println(password);

				user_text.setText("");
				password_text.setText("");

				try {

					boolean found = false;

					rs1.beforeFirst();

					while (rs1.next()) {
						String username_actual = rs1.getString("username");
						String password_actual = rs1.getString("password");

						System.out.println(username_actual);
						System.out.println(password_actual);

						if (username_actual.equals(username) & password_actual.equals(password)) {
							System.out.println("MATCHING");
							found = true;
							
							//use a stored proc to get users name,surname
							NameSurname = StoredProc.getNameSurname(username);
							frame.dispose();
							new HomePage();
							

							break;
						}

					}

					if (found == false) {
						JOptionPane.showMessageDialog(frame, "THE CREDENTIALS YOU HAVE INSERTED ARE WRONG", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		new_user.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new NewUser();

			}
		});

		user_text.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				user_text.setText("");
			}

			public void focusLost(FocusEvent e) {

			}

		});

		password_text.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				password_text.setText("");
			}

			public void focusLost(FocusEvent e) {

			}

		});
		
		frame.setVisible(true);

	}

	public static ResultSet load_credentials() throws SQLException {

		ConnectionPool connectionPool = new ConnectionPool("jdbc:sqlserver://localhost:1433;databaseName=COVID_19",
				"sa", "dimitris", 5, 10, true);

		Connection con = connectionPool.getConnection();

		Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		String sql_code = ("select * from credentials");
		ResultSet rs;

		rs = statement.executeQuery(sql_code);

		return rs;

	}

}
