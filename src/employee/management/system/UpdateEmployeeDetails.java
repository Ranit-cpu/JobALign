package employee.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class UpdateEmployeeDetails extends JFrame implements ActionListener {
      
      JLabel empid, ename, fname;
      JButton back, confirmDetails;
      JTextField salary, address, phonenum, email, designation, aadhaar;
      JComboBox<String> education;
      JDateChooser dcdob;
      String employeeid, name;
      
      UpdateEmployeeDetails(String employeeid)
      {
            this.employeeid = employeeid;
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
            
            // Head Label
            JLabel head = new JLabel("Update Employee Details");
            head.setBounds(350, 20, 2600, 100);
            head.setFont(new Font(Font.SERIF, Font.BOLD, 50));
            head.setForeground(Color.BLACK);
            image.add(head);
            
            // Name Label & Field
            JLabel labelname = new JLabel("Name:");
            labelname.setBounds(50, 140, 100, 35);
            labelname.setFont(new Font(Font.SERIF, Font.BOLD, 30));
            image.add(labelname);
            
            ename = new JLabel();
            ename.setBounds(150, 145, 300, 30);
            ename.setFont(new Font(Font.SERIF, Font.BOLD, 30));
            image.add(ename);
            
            // Father's Name Label & Field
            JLabel Fathername = new JLabel("Father's Name:");
            Fathername.setBounds(550, 140, 250, 35);
            Fathername.setFont(new Font(Font.SERIF, Font.BOLD, 30));
            image.add(Fathername);
            
            fname = new JLabel();
            fname.setBounds(760, 145, 300, 35);
            fname.setFont(new Font(Font.SERIF, Font.BOLD, 30));
            image.add(fname);
            
            // Date of Birth Label & DateChooser
            JLabel labeldob = new JLabel("Date of Birth:");
            labeldob.setBounds(50, 200, 300, 35);
            labeldob.setFont(new Font(Font.SERIF, Font.BOLD, 30));
            image.add(labeldob);
            
            dcdob = new JDateChooser();
            dcdob.setBounds(240, 200, 250, 30);
            dcdob.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
            image.add(dcdob);
            
            // Salary
            JLabel labelSalary = new JLabel("Salary:");
            labelSalary.setBounds(650, 200, 200, 35);
            labelSalary.setFont(new Font(Font.SERIF, Font.BOLD, 30));
            image.add(labelSalary);
            
            salary = new JTextField();
            salary.setBounds(750, 200, 200, 30);
            salary.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
            image.add(salary);
            
            // Address
            JLabel labeladd = new JLabel("Address:");
            labeladd.setBounds(50, 260, 125, 35);
            labeladd.setFont(new Font(Font.SERIF, Font.BOLD, 30));
            image.add(labeladd);
            
            address = new JTextField();
            address.setBounds(175, 260, 1000, 30);
            address.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
            image.add(address);
            
            // Phone Number
            JLabel phone = new JLabel("Phone No:");
            phone.setBounds(50, 350, 350, 35);
            phone.setFont(new Font(Font.SERIF, Font.BOLD, 30));
            image.add(phone);
            
            phonenum = new JTextField();
            phonenum.setBounds(200, 350, 375, 30);
            phonenum.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
            image.add(phonenum);
            
            // Email
            JLabel labelemail = new JLabel("E-mail:");
            labelemail.setBounds(650, 350, 200, 35);
            labelemail.setFont(new Font(Font.SERIF, Font.BOLD, 30));
            image.add(labelemail);
            
            email = new JTextField();
            email.setBounds(750, 350, 425, 30);
            email.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
            image.add(email);
            
            // Education
            JLabel labeledu = new JLabel("Education:");
            labeledu.setBounds(50, 400, 250, 35);
            labeledu.setFont(new Font(Font.SERIF, Font.BOLD, 30));
            image.add(labeledu);
            
            String[] courses = {"BBA", "BCA", "BA", "B.Sc", "B.COM", "B.Tech", "MBA", "MCA", "MA", "M.Tech", "M.Sc"};
            education = new JComboBox<>(courses);
            education.setBounds(200, 405, 200, 30);
            education.setFont(new Font(Font.SERIF, Font.BOLD, 18));
            image.add(education);
            
            JLabel labelpos = new JLabel("Designation:");
            labelpos.setBounds(590,400,200,35);
            labelpos.setFont(new Font(Font.SERIF,Font.BOLD,30));
            image.add(labelpos);
            
            //Position Text Field
            designation = new JTextField();
            designation.setBounds(750,400,425,30);
            designation.setFont(new Font(Font.SERIF,Font.PLAIN,30));
            image.add(designation);
            
            //Aadhaar label
            JLabel labelAadhaar = new JLabel("Aadhaar No:");
            labelAadhaar.setBounds(50,450,250,35);
            labelAadhaar.setFont(new Font(Font.SERIF,Font.BOLD,30));
            image.add(labelAadhaar);
            
            //Aadhaar text field
            aadhaar = new JTextField();
            aadhaar.setBounds(250,450,250,30);
            aadhaar.setFont(new Font(Font.SERIF,Font.PLAIN,30));
            image.add(aadhaar);
            
            // Employee ID
            JLabel labelEmpid = new JLabel("EmployeeID:");
            labelEmpid.setBounds(580, 450, 200, 35);
            labelEmpid.setFont(new Font(Font.SERIF, Font.BOLD, 30));
            image.add(labelEmpid);
            
            empid = new JLabel();
            empid.setBounds(765, 450, 425, 35);
            empid.setFont(new Font(Font.SERIF, Font.BOLD, 30));
            image.add(empid);
            
            try {
                  Connect con = new Connect();
                  ResultSet rs = con.s.executeQuery("SELECT * FROM Employee WHERE EmployeeID = '" + employeeid + "'");
                  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                  
                  while (rs.next()) {
                        ename.setText(rs.getString("Name"));
                        fname.setText(rs.getString("FatherName"));
                        empid.setText(rs.getString("EmployeeID"));
                        salary.setText(rs.getString("Salary"));
                        address.setText(rs.getString("Address"));
                        phonenum.setText(rs.getString("PhoneNo"));
                        email.setText(rs.getString("Email"));
                        designation.setText(rs.getString("Designation"));
                        aadhaar.setText(rs.getString("AadhaarNo"));
                        
                        String dobString = rs.getString("DOB");
                        if (dobString != null && !dobString.isEmpty()) {
                              try {
                                    Date dobDate = sdf.parse(dobString);
                                    dcdob.setDate(dobDate);
                              } catch (ParseException e) {
                                    dcdob.setDate(null);
                              }
                        }
                  }
            } catch (Exception e) {
                  JOptionPane.showMessageDialog(null, "Unable to process the request.");
            }
            
            // Buttons
            confirmDetails = new JButton("Confirm Details");
            confirmDetails.setBounds(200, 550, 400, 50);
            confirmDetails.setFont(new Font(Font.SERIF, Font.BOLD, 45));
            confirmDetails.addActionListener(this);
            confirmDetails.setForeground(Color.WHITE);
            confirmDetails.setBackground(Color.BLACK);
            confirmDetails.setOpaque(true);
            confirmDetails.setBorderPainted(false);
            confirmDetails.setFocusPainted(false);
            add(confirmDetails);
            
            back = new JButton("Back");
            back.setBounds(700, 550, 300, 50);
            back.setFont(new Font(Font.SERIF, Font.BOLD, 45));
            back.addActionListener(this);
            back.setForeground(Color.WHITE);
            back.setBackground(Color.BLACK);
            back.setOpaque(true);
            back.setBorderPainted(false);
            back.setFocusPainted(false);
            add(back);
            
            setBounds(250,100,1200,700);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
      }
      
      public static void main(String[] args) {
            new UpdateEmployeeDetails("E101"); // Example Employee ID
      }
      
      @Override
      public void actionPerformed(ActionEvent e) {
            if (e.getSource() == confirmDetails) {
                  String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
                  String sal = salary.getText();
                  String location = address.getText();
                  String phone = phonenum.getText();
                  String mail = email.getText();
                  String edu = Objects.requireNonNull(education.getSelectedItem()).toString();
                  String post = designation.getText();
                  String UID = aadhaar.getText();
                  String id =empid.getText();
                  
                  if (dob.isEmpty() || sal.isEmpty() ||location.isEmpty() || phone.isEmpty() || mail.isEmpty()
                          || edu.isEmpty() || post.isEmpty() || UID.isEmpty() || id.isEmpty()) {
                        
                        JOptionPane.showMessageDialog(null, "All fields are required. Please fill in the missing details.", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Stop execution if any field is empty
                  }
                  
                  if (!UID.matches("\\d{12}")) {
                        JOptionPane.showMessageDialog(null, "Invalid Aadhaar Number! It must be exactly 12 digits.", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Stop execution if Aadhaar is invalid
                  }
                  
                  try{
                        Connect con = new Connect();
                        String query = "update Employee set DOB ='"+dob+"',Salary='"+sal+"',Address='"+location+"',PhoneNo='"+phone+
                                "',Email='"+mail+"',Qualification='"+edu+"',Designation='"+post+"',AadhaarNo='"+UID+"'where EmployeeID='"+employeeid+"'";
                        con.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Details Updated successfully ✅");
                        setVisible(false);
                        new Home();
                  }catch(Exception ae){
                        throw new RuntimeException(ae);
                  }
            } else if (e.getSource() == back) {
                  setVisible(false);
                  new Update();
            }
      }
}
