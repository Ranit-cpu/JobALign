package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener
{
      //button declaration
      JButton add,update, view, remove;
      
      
      public Home()
      {
            setLayout(null);
            
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int width = screenSize.width;
            int height = screenSize.height;
            
            // Load and scale the image to full screen
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Home.jpeg"));
            Image i2 = i1.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(0, 0, width, height);
            add(image);
            
            JLabel head = new JLabel("JobAlign");
            head.setBounds(200, 20, 2600, 100);
            head.setFont(new Font(Font.MONOSPACED, Font.BOLD, 72));
            head.setForeground(Color.BLACK);
            add(head);
            image.add(head);
            
            add = new JButton("Add Employee");
            add.setBounds(45, 130, 300, 60);
            add.setFont(new Font(Font.SERIF, Font.BOLD,40));
            add.addActionListener(this);
            image.add(add);
            
            view = new JButton("View Employee");
            view.setBounds(420, 130, 300, 60);
            view.setFont(new Font(Font.SERIF,Font.BOLD,40));
            view.addActionListener(this);
            image.add(view);
            
            update = new JButton("Update Employee");
            update.setBounds(25, 230, 350, 60);
            update.setFont(new Font(Font.SERIF,Font.BOLD,40));
            update.addActionListener(this);
            image.add(update);
            
            remove = new JButton("Remove Employee");
            remove.setBounds(400, 230, 350, 60);
            remove.setFont(new Font(Font.SERIF,Font.BOLD,40));
            remove.addActionListener(this);
            image.add(remove);
            
            setBounds(450,100,800,600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
      }
      public static void main(String[] args)
      {
            new Home();
      }
      
      @Override
      public void actionPerformed(ActionEvent e) {
            if(e.getSource()==add){
                  setVisible(false);
                  new AddEmployee();
            } else if(e.getSource()== view) {
                  setVisible(false);
                  new ViewEmployee();
            } else if (e.getSource() == update) {
                  setVisible(false);
                  new Update();
            }else{
                  setVisible(false);
                  new RemoveEmployeeDetails();
            }
      }
}
