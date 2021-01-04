import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class HomePage extends JFrame {

	JFrame frame = new JFrame();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton button4 = new JButton();

	public HomePage() {

		frame.setTitle("COVID-19");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setLayout(new FlowLayout());
		frame.setResizable(false);

		button1.setText("INSERT A PATIENT");
		button1.addActionListener(

				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						frame.dispose();
						new Insert_page();

					}

				});

		button2.addActionListener(

				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						frame.dispose();
						new Search_page();

					}

				});

		button2.setText("SEARCH A PATIENT");
		// button2.addActionListener();

		frame.add(button1);
		frame.add(button2);
		frame.setVisible(true);

	}

}
