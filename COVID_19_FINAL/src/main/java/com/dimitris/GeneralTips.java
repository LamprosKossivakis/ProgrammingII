package com.dimitris;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GeneralTips {
	
	JFrame frame = new JFrame(); //creates a frame
    JButton button1= new JButton();
    JTextField text = new JTextField();
    
    
    GeneralTips(){
        frame.setSize(300,350);
        frame.setResizable(false);
        frame.setTitle("Tips/Info");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.white);

        ImageIcon image = new ImageIcon("covid19.jpg"); //create an ImageIcon
        frame.setIconImage(image.getImage()); // change icon of this
        frame.getContentPane().setBackground(new Color(150, 50, 50)); //change color of Background
        frame.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        Border border = BorderFactory.createLineBorder(Color.GREEN, 3);


        
        
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("1135-staysafe.png").getImage().getScaledInstance(250, 150, Image.SCALE_DEFAULT));
        
        JLabel label = new JLabel(); //creates a label
        label.setText("Κορωνοϊός Covid-19 – Οδηγίες");
        label.setIcon(imageIcon);
        label.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT, CENTER, RIGHT of imageicon
        label.setVerticalTextPosition(JLabel.TOP); //set text TOP,CENTER, BOTTOM of imageicon
        label.setForeground(new Color(123, 150, 60)); //set color of text
        label.setFont(new Font("ASD", Font.ITALIC, 18));

        text.setEditable(false);
        text.setText("https://eody.gov.gr/neos-koronaios-covid-19/");
        
        
        button1.setText("Back");
       

        button1.addActionListener(

                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        frame.dispose();
                        new HomePage();

                    }

                });



        frame.add(text);
        frame.add(label);
        frame.add(button1);
        frame.setVisible(true); //make frame visible
    }
}
