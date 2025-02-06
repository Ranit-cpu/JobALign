package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.HashMap;

public class Update extends JFrame implements ActionListener {
      
      Choice empid;
      JButton update, back;
      JLabel name;
      HashMap<String, String> empData;
      
      Update(){
            
            getContentPane().setBackground(new Color(135, 206, 235));
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
            
            JLabel searchlbl = new JLabel("Select EmployeeID");
            searchlbl.setBounds(75,25,300,30);
            searchlbl.setFont(new Font(Font.SERIF,Font.BOLD,30));
            image.add(searchlbl);
            
            empid = new Choice();
            empid.setBounds(50,80,300,20);
            empid.setFont(new Font(Font.SERIF,Font.BOLD,20));
            image.add(empid);
            
            JLabel searchname = new JLabel("Employee Name");
            searchname.setBounds(75,125,300,30);
            searchname.setFont(new Font(Font.SERIF,Font.BOLD,30));
            image.add(searchname);
            
            name = new JLabel();
            name.setBounds(50,190,300,20);
            name.setFont(new Font(Font.SERIF,Font.BOLD,20));
            image.add(name);
            
            update = new JButton("UPDATE");
            update.setBounds(30,275,150,35);
            update.setFont(new Font(Font.SERIF,Font.BOLD,30));
            update.addActionListener(this);
            image.add(update);
            
            back = new JButton("BACK");
            back.setBounds(200,275,150,35);
            back.setFont(new Font(Font.SERIF,Font.BOLD,30));
            back.addActionListener(this);
            image.add(back);
            
            empData = new HashMap<>();
            
            try {
                  Connect con = new Connect();
                  ResultSet rs = con.s.executeQuery("SELECT EmployeeID, Name FROM Employee");
                  
                  while (rs.next()) {
                        String id = rs.getString("EmployeeID");
                        String empName = rs.getString("Name");
                        empData.put(id, empName);
                        empid.add(id);
                  }
                  
            } catch (Exception e) {
                  JOptionPane.showMessageDialog(null, "⚠️ No Employees Found");
            }
            
            
            empid.addItemListener(ie -> {
                  try {
                        Connect c = new Connect();
                        String query = "select * from employee where EmployeeID = '"+empid.getSelectedItem()+"'";
                        ResultSet rs = c.s.executeQuery(query);
                        while(rs.next()) {
                              name.setText(rs.getString("Name"));
                        }
                  } catch (Exception e) {
                        e.printStackTrace();
                  }
            });
            
            setBounds(700,250,400,400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
      }
      
      public static void main(String[] args){
            new Update();
      }
      
      @Override
      public void actionPerformed(ActionEvent e) {
            if (e.getSource()==update) {
                  setVisible(false);
                  new UpdateEmployeeDetails(empid.getSelectedItem());
            }
            else{
                  setVisible(false);
                  new Home();
            }
      }
}
