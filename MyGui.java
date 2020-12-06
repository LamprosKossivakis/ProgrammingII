import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyGui extends JFrame implements ActionListener {
    JFrame frame = new JFrame(); //creates a frame
    JButton button1= new JButton();
    JButton button2= new JButton();
    JButton button3= new JButton();
    JButton button4= new JButton();
    JButton button5= new JButton();
    MyGui(){
        frame.setTitle("Covid Checkpoint");  //sets the title of the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        frame.setResizable(true); //prevent this from being resized
        frame.setVisible(true); //make this visible

        ImageIcon image = new ImageIcon("covid.png"); //create an ImageIcon
        frame.setIconImage(image.getImage()); // change icon of this
        frame.getContentPane().setBackground(new Color(123, 50, 250)); //change color of Background
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,10,100));
        Border border = BorderFactory.createLineBorder(Color.GREEN, 3);

        ImageIcon image2 = new ImageIcon("ΟΠΑ.jpg");

        JLabel label = new JLabel(); //creates a label
        label.setText("Welcome for Covid test");
        label.setIcon(image2);
        label.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT, CENTER, RIGHT of imageicon
        label.setVerticalTextPosition(JLabel.TOP); //set text TOP,CENTER, BOTTOM of imageicon
        label.setForeground(new Color(0, 150, 60)); //set color of text
        label.setFont(new Font("ASD", Font.ITALIC, 18));


        label.setIconTextGap(25); //set gap of text to image
        label.setBackground(Color.BLACK); //set background color
        label.setOpaque(true); //display background color
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER); //set vertical position of icon+text within label
        label.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of icon+text within label
        label.setBounds(250,0,250,250); //set x,y position within frame as well as dimensions
        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.setBounds(500,0,250,250);
        panel.setPreferredSize((new Dimension(600,200)));
        //panel.add(new JButton("1.Διεξαγωγή Τεστ για τον Covid-19"));

        button1.setText("1.Διεξαγωγή Τεστ για τον Covid-19");
        panel.add(button1);

        button2.setText("2.Μετάβαση σε λίστα με όσους έχουν ήδη κάνει το τεστ");
        panel.add(button2);

        button3.setText("3.Μέταβαση σε λίστα με τους θετικούς στον κορονοϊό");
        panel.add(button3);

        button4.setText("4.Μετάβαση σε λίστα με αυτούς που βρέθηκαν αρνητικοί στον ιό");
        panel.add(button4);

        button5.setText("5.Παρακολούθηση της επιδημιολογικής εικόνας");
        panel.add(button5);


        panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        frame.add(panel);
        frame.add(label);
        frame.setVisible(true); //make frame visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button2){
            AllTested.printTested();
            frame.dispose();
        }
    }
}
