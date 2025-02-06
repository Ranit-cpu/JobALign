package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployeeDetails extends JFrame implements ActionListener {
      
      Choice cEmpId;
      JButton delete, back;
      
      RemoveEmployeeDetails() {
            setLayout(null);
            
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int width = screenSize.width;
            int height = screenSize.height;
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Home.jpeg"));
            Image i2 = i1.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(0, 0, width, height);
            add(image);
            
            JLabel labelempId = new JLabel("EmpID:");
            labelempId.setBounds(50, 50, 120, 30);
            labelempId.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
            image.add(labelempId);
            
            cEmpId = new Choice();
            cEmpId.setBounds(200, 50, 150, 30);
            image.add(cEmpId);
            
            try {
                  Connect c = new Connect();
                  String query = "select * from Employee";
                  ResultSet rs = c.s.executeQuery(query);
                  while(rs.next()) {
                        cEmpId.add(rs.getString("EmployeeID"));
                  }
            } catch (Exception e) {
                  e.printStackTrace();
            }
            
            JLabel labelname = new JLabel("Name:");
            labelname.setBounds(50, 100, 300, 35);
            labelname.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
            image.add(labelname);
            
            JLabel lblname = new JLabel();
            lblname.setBounds(200, 100, 300, 30);
            lblname.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
            image.add(lblname);
            
            JLabel labelphone = new JLabel("Phone:");
            labelphone.setBounds(50, 150, 300, 30);
            labelphone.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
            image.add(labelphone);
            
            JLabel lblphone = new JLabel();
            lblphone.setBounds(200, 150, 300, 30);
            lblphone.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
            image.add(lblphone);
            
            JLabel labelemail = new JLabel("Email:");
            labelemail.setBounds(50, 200, 300, 30);
            labelemail.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
            image.add(labelemail);
            
            JLabel lblemail = new JLabel();
            lblemail.setBounds(200, 200, 400, 35);
            lblemail.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
            image.add(lblemail);
            
            try {
                  Connect c = new Connect();
                  String query = "select * from employee where EmployeeID = '"+cEmpId.getSelectedItem()+"'";
                  ResultSet rs = c.s.executeQuery(query);
                  while(rs.next()) {
                        lblname.setText(rs.getString("Name"));
                        lblphone.setText(rs.getString("PhoneNo"));
                        lblemail.setText(rs.getString("Email"));
                  }
            } catch (Exception e) {
                  e.printStackTrace();
            }
            
            cEmpId.addItemListener(ie -> {
                  try {
                        Connect c = new Connect();
                        String query = "select * from employee where EmployeeID = '"+cEmpId.getSelectedItem()+"'";
                        ResultSet rs = c.s.executeQuery(query);
                        while(rs.next()) {
                              lblname.setText(rs.getString("Name"));
                              lblphone.setText(rs.getString("PhoneNo"));
                              lblemail.setText(rs.getString("Email"));
                        }
                  } catch (Exception e) {
                        e.printStackTrace();
                  }
            });
            
            delete = new JButton("Delete");
            delete.setBounds(80, 300, 200,35);
            delete.setFont(new Font(Font.SERIF,Font.BOLD,30));
            delete.addActionListener(this);
            image.add(delete);
            
            back = new JButton("Back");
            back.setBounds(300, 300, 200,35);
            back.setFont(new Font(Font.SERIF,Font.BOLD,30));
            back.addActionListener(this);
            image.add(back);
            
            setBounds(500, 150,700, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
      }
      
      public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == delete) {
                  try {
                        Connect c = new Connect();
                        String query = "delete from employee where EmployeeID = '"+cEmpId.getSelectedItem()+"'";
                        c.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Employee Information Deleted Successfully✅");
                        setVisible(false);
                        new Home();
                  } catch (Exception e) {
                        e.printStackTrace();
                  }
            } else {
                  setVisible(false);
                  new Home();
            }
      }
      
      public static void main(String[] args) {
            new RemoveEmployeeDetails();
      }
}