package employee.management.system;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class AddEmployee extends JFrame implements ActionListener
{
      Random random = new Random();
      int number = random.nextInt(999999);
      
      JLabel empid;
      JButton back,confirmDetails;
      JTextField ename,fname,salary,address,phonenum,email,designation,aadhaar;
      JComboBox education;
      JDateChooser dcdob;
      
      public AddEmployee()
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
            
            //Head Label
            JLabel head = new JLabel("Add Employee Details");
            head.setBounds(350, 20, 2600, 100);
            head.setFont(new Font(Font.SERIF,Font.BOLD,50));
            head.setForeground(Color.BLACK);
            image.add(head);
            
            //Name Label
            JLabel labelname = new JLabel("Name:");
            labelname.setBounds(50,140,100,35);
            labelname.setFont(new Font(Font.SERIF,Font.BOLD,30));
            image.add(labelname);
            
            //Name Text Field
            ename = new JTextField();
            ename.setBounds(150,140,300,30);
            ename.setFont(new Font(Font.SERIF,Font.PLAIN,30));
            image.add(ename);
            
            //Father's Name Label
            JLabel Fathername = new JLabel("Father's Name:");
            Fathername.setBounds(550,140,250,35);
            Fathername.setFont(new Font(Font.SERIF,Font.BOLD,30));
            image.add(Fathername);
            
            //Father's Name Text Field
            fname = new JTextField();
            fname.setBounds(750,140,300,30);
            fname.setFont(new Font(Font.SERIF,Font.PLAIN,30));
            image.add(fname);
            
            //D.O.B Label
            JLabel labeldob = new JLabel("Date of Birth:");
            labeldob.setBounds(50,200,300,35);
            labeldob.setFont(new Font(Font.SERIF,Font.BOLD,30));
            image.add(labeldob);
            
            //D.O.B Text Field
            dcdob= new JDateChooser();
            dcdob.setBounds(240,200,250,30);
            dcdob.setFont(new Font(Font.SERIF,Font.PLAIN,30));
            image.add(dcdob);
            
            //Salary Label
            JLabel labelSalary = new JLabel("Salary:");
            labelSalary.setBounds(650,200,200,35);
            labelSalary.setFont(new Font(Font.SERIF,Font.BOLD,30));
            image.add(labelSalary);
            
            //Salary text Field
            salary = new JTextField();
            salary.setBounds(750,200,200,30);
            salary.setFont(new Font(Font.SERIF,Font.PLAIN,30));
            image.add(salary);
            
            //Address Label
            JLabel labeladd = new JLabel("Address:");
            labeladd.setBounds(50,260,125,35);
            labeladd.setFont(new Font(Font.SERIF,Font.BOLD,30));
            image.add(labeladd);
            
            //Address Text Field
            address = new JTextField();
            address.setBounds(175,260,1000, 30);
            address.setFont(new Font(Font.SERIF,Font.PLAIN,30));
            image.add(address);
            
            //Phone number Label
            JLabel phone = new JLabel("Phone No :");
            phone.setBounds(50,350,350,35);
            phone.setFont(new Font(Font.SERIF,Font.BOLD,30));
            image.add(phone);
            
            //Phone Number Text Field
            phonenum = new JTextField();
            phonenum.setBounds(200,350,375,30);
            phonenum.setFont(new Font(Font.SERIF,Font.PLAIN,30));
            image.add(phonenum);
            
            //Email Label
            JLabel labelemail = new JLabel("E-mail:");
            labelemail.setBounds(650,350,200,35);
            labelemail.setFont(new Font(Font.SERIF,Font.BOLD,30));
            image.add(labelemail);
            
            //Email Text Field
            email = new JTextField();
            email.setBounds(750,350,425,30);
            email.setFont(new Font(Font.SERIF,Font.PLAIN,30));
            image.add(email);
            
            //Education Label
            JLabel labeledu = new JLabel("Education:");
            labeledu.setBounds(50,400,250,35);
            labeledu.setFont(new Font(Font.SERIF,Font.BOLD,30));
            image.add(labeledu);
            
            //Education text Field
            String[] courses = {"BBA","BCA","BA","B.Sc","B.COM","B.Tech","MBA","MCA","MA","M.Tech","M.Sc"};
            education = new JComboBox(courses);
            education.setBounds(200,405,200,30);
            education.setFont(new Font(Font.SERIF,Font.BOLD,18));
            education.setMaximumRowCount(5);
            image.add(education);
            
            //Position label field
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
            
            //EmployeeID label
            JLabel labelEmpid = new JLabel("EmployeeID:");
            labelEmpid.setBounds(580,450,200,35);
            labelEmpid.setFont(new Font(Font.SERIF,Font.BOLD,30));
            image.add(labelEmpid);
            
            //EmployeeID text field
            empid = new JLabel(""+number);
            empid.setBounds(765,450,425,35);
            empid.setFont(new Font(Font.SERIF,Font.PLAIN,30));
            image.add(empid);
            
            confirmDetails = new JButton("Confirm Details");
            confirmDetails.setBounds(200, 550, 400, 50);
            confirmDetails.setFont(new Font(Font.SERIF, Font.BOLD, 45));
            confirmDetails.addActionListener(this);
            confirmDetails.setForeground(Color.WHITE);
            confirmDetails.setBackground(Color.BLACK);
            confirmDetails.setOpaque(true);
            confirmDetails.setBorderPainted(false);
            confirmDetails.setFocusPainted(false);
            image.add(confirmDetails);
            
            back = new JButton("Back");
            back.setBounds(700, 550, 300, 50);
            back.setFont(new Font(Font.SERIF, Font.BOLD, 45));
            back.addActionListener(this);
            back.setForeground(Color.WHITE);
            back.setBackground(Color.BLACK);
            back.setOpaque(true);
            back.setBorderPainted(false);
            back.setFocusPainted(false);
            image.add(back);
            
            
            
            setBounds(250,100,1200,700);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
      }
      
      public static void main(String[] args){
            new AddEmployee();
      }
      
      @Override
      public void actionPerformed(ActionEvent e) throws RuntimeException {
            if(e.getSource()== confirmDetails){
                  String name = ename.getText();
                  String fathername = fname.getText();
                  String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
                  String sal = salary.getText();
                  String location = address.getText();
                  String phone = phonenum.getText();
                  String mail = email.getText();
                  String edu = Objects.requireNonNull(education.getSelectedItem()).toString();
                  String post = designation.getText();
                  String UID = aadhaar.getText();
                  String id =empid.getText();
                  
                  if (name.isEmpty() || fathername.isEmpty() || dob.isEmpty() || sal.isEmpty() ||
                          location.isEmpty() || phone.isEmpty() || mail.isEmpty() || edu.isEmpty() ||
                          post.isEmpty() || UID.isEmpty() || id.isEmpty()) {
                        
                        JOptionPane.showMessageDialog(null, "All fields are required. Please fill in the missing details.", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Stop execution if any field is empty
                  }
                  
                  if (!UID.matches("\\d{12}")) {
                        JOptionPane.showMessageDialog(null, "Invalid Aadhaar Number! It must be exactly 12 digits.", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Stop execution if Aadhaar is invalid
                  }
                  
                  try{
                        Connect con = new Connect();
                        String query = "insert into Employee values('"+name+"', '"+fathername+"', '"+dob+"', '"+sal+"', '"
                                +location+"', '"+phone+"', '"+mail+"', '"+edu+"', '"+post+"', '"+UID+"', '"+id+"')";
                        con.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Details Added successfully ✅");
                        setVisible(false);
                        new Home();
                  }catch(Exception ae){
                        throw new RuntimeException(ae);
                  }
            }
            else{
                  setVisible(false);
                  new Home();
            }
      }
}
