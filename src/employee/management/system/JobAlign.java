package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobAlign extends JFrame implements ActionListener
{
      public JobAlign() throws InterruptedException
      {
            // Set the frame
            setSize(600, 600);
            setLocation(500, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            getContentPane().setBackground(Color.BLACK);
            getContentPane().setLayout(null);
            
            // Load the image
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/team-management.png"));
            Image i2 = i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(50, 40, 500, 500);
            add(image);
            
            // Add heading label
            JLabel head = new JLabel("JobAlign");
            head.setBounds(200, 10, 1600, 100);
            head.setFont(new Font(Font.MONOSPACED, Font.BOLD, 45));
            head.setForeground(Color.WHITE);
            add(head);
            
            // Add a button
            JButton clickHereToContinue = new JButton("CLICK HERE TO LOGIN");
            clickHereToContinue.setBounds(150, 500, 300, 50);
            clickHereToContinue.setBackground(Color.WHITE);
            clickHereToContinue.setForeground(Color.BLACK);
            clickHereToContinue.setFont(new Font(Font.DIALOG,Font.BOLD,20));
            clickHereToContinue.addActionListener(this);
            add(clickHereToContinue);
            
            setVisible(true);
      }
      
      @Override
      public void actionPerformed(ActionEvent e) {
            try {
                  setVisible(false);
                  new Login(); // Initialize and display the Login screen
            } catch (Exception ex) {
                  // Log errors for debugging
                  JOptionPane.showMessageDialog(this, "Error loading Login screen: " + ex.getMessage(),
                          "Error", JOptionPane.ERROR_MESSAGE);
            }
      }
      public static void main(String[] args) {
            try {
                  new JobAlign();
            } catch (InterruptedException e) {
                  throw new RuntimeException(e);
            }
      }
}
