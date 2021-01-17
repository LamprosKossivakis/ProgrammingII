package covidcheckpoint;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneralTips {
    JFrame frame = new JFrame(); //creates a frame
    JButton button1= new JButton();
    GeneralTips(){
        frame.setSize(800,800);
        frame.setResizable(true);
        frame.setTitle("Tips/Info");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.white);

        ImageIcon image = new ImageIcon("covid19.jpg"); //create an ImageIcon
        frame.setIconImage(image.getImage()); // change icon of this
        frame.getContentPane().setBackground(new Color(150, 50, 50)); //change color of Background
        frame.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        Border border = BorderFactory.createLineBorder(Color.GREEN, 3);


        ImageIcon image2 = new ImageIcon("1135-staysafe.png");
        JLabel label = new JLabel(); //creates a label
        label.setText("Κορωνοϊός Covid-19 – Οδηγίες");
        label.setIcon(image2);
        label.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT, CENTER, RIGHT of imageicon
        label.setVerticalTextPosition(JLabel.TOP); //set text TOP,CENTER, BOTTOM of imageicon
        label.setForeground(new Color(123, 150, 60)); //set color of text
        label.setFont(new Font("ASD", Font.ITALIC, 18));


        button1.setText("Back");
        frame.add(button1);

        button1.addActionListener(

                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        frame.dispose();
                        new Gui();

                    }

                });




        frame.add(label);
        frame.setVisible(true); //make frame visible
    }
}
