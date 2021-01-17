package covidcheckpoint;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ContactsPage {
    JFrame frame = new JFrame();
    JButton button1 = new JButton();
    JButton button2 = new JButton();
    JTextField text_name = new JTextField("name");
    JTextField text_surname = new JTextField("surname");
    JTextField text_test = new JTextField("test");
    JLabel label = new JLabel();

    public ContactsPage(int amka) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(280, 350);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());
        frame.setTitle("COVID-19");

        ImageIcon image = new ImageIcon("covid19.jpg"); //create an ImageIcon
        frame.setIconImage(image.getImage()); // change icon of this
        frame.getContentPane().setBackground(new Color(150, 50, 50)); //change color of Background
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,10,100));
        Border border = BorderFactory.createLineBorder(Color.GREEN, 3);

        button1.setText("SUBMIT");
        button2.setText("DONE");

        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {

                boolean problem = false;

                try {

                    String name = text_name.getText();
                    String surname = text_surname.getText();
                    int test = Integer.parseInt(text_test.getText());

                    System.out.println(name);
                    System.out.println(surname);
                    System.out.println(test);

                    text_name.setText("name");
                    text_surname.setText("surname");
                    text_test.setText("test");

                } catch (NumberFormatException ife) {
                    JOptionPane.showMessageDialog(frame, "INPUT PROPER DATA", "ERROR", JOptionPane.WARNING_MESSAGE);
                    problem = true;

                } finally {
                    if (problem == false) {
                        System.out.println(amka);
                        JOptionPane.showMessageDialog(frame, "SUBMITTED SYCCESFULLY", "MESSAGE",
                                JOptionPane.DEFAULT_OPTION);



                    }

                }

            }

        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                frame.dispose();
                new Gui();

            }

        });

        // add button2 actionListener

        text_name.setPreferredSize(new Dimension(200, 40));
        text_surname.setPreferredSize(new Dimension(200, 40));
        text_test.setPreferredSize(new Dimension(200, 40));

        text_surname.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                text_surname.setText("");
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

        label.setText("INSERT CONTACT'S INFO");

        frame.add(label);
        frame.add(text_name);
        frame.add(text_surname);
        frame.add(text_test);
        frame.add(button1);
        frame.add(button2);

        frame.setVisible(true);

    }

}
