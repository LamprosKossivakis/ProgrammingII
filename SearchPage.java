package covidcheckpoint;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SearchPage {
    JFrame frame = new JFrame();
    JButton button1 = new JButton();
    JTextField text_search = new JTextField();
    JButton button2 = new JButton();
    JLabel label = new JLabel();
    JPanel panel = new JPanel();

    public SearchPage() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setResizable(true);
        frame.setLayout(new FlowLayout());
        frame.setTitle("COVID-19");

        ImageIcon image = new ImageIcon("covid19.jpg"); //create an ImageIcon
        frame.setIconImage(image.getImage()); // change icon of this
        frame.getContentPane().setBackground(new Color(150, 50, 50)); //change color of Background
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,10,100));
        Border border = BorderFactory.createLineBorder(Color.GREEN, 3);

        label.setText("TYPE IN THE PATIENT'S AMKA");

        text_search.setText("type patient's amka");
        text_search.setPreferredSize(new Dimension(160, 40));

        button1.setText("SEARCH");
        button2.setText("BACK");

        text_search.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                text_search.setText("");
            }

            public void focusLost(FocusEvent e) {

            }

        });

        button1.addActionListener(

                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {

                        try {

                            int amka = Integer.parseInt(text_search.getText());
                            System.out.println(amka);

                            // Frame Size

                            String[][] data = { { "Kundan Kumar Jha", "4031", "CSE" }, { "Anand Jha", "6014", "IT" } };

                            // Column Names
                            String[] columnNames = { "Name", "Roll Number", "Department" };

                            // Initializing the JTable
                            JTable j = new JTable(data, columnNames);
                            // j.setBounds(30, 40, 200, 300);

                            // adding it to JScrollPane
                            // JScrollPane sp = new JScrollPane(j);
                            panel.setVisible(true);
                            panel.add(j);

                        } catch (NumberFormatException nfe) {
                            System.out.println("ERROR");

                        }

                    }

                });

        button2.addActionListener(

                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        frame.dispose();
                        new Gui();

                    }

                });
        panel.setVisible(false);
        frame.add(label);
        frame.add(text_search);
        frame.add(button1);
        frame.add(button2);
        frame.add(panel);
        frame.setVisible(true);

    }

}
