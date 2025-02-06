package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewEmployee extends JFrame implements ActionListener {
      
      JTable table;
      Choice empid, name;
      JButton search,print,back,all;
      
      ViewEmployee(){
            
            getContentPane().setBackground(new Color(135, 206, 235));
            setLayout(null);
            
            JLabel searchlbl = new JLabel("Select EmployeeID");
            searchlbl.setBounds(20,25,200,24);
            searchlbl.setFont(new Font(Font.SERIF,Font.BOLD,24));
            add(searchlbl);
            
            empid = new Choice();
            empid.setBounds(230,25,200,24);
            empid.setFont(new Font(Font.SERIF,Font.BOLD,24));
            add(empid);
            
            JLabel searchname = new JLabel("Select Employee Name");
            searchname.setBounds(450,25,250,24);
            searchname.setFont(new Font(Font.SERIF,Font.BOLD,24));
            add(searchname);
            
            name = new Choice();
            name.setBounds(700,25,200,28);
            name.setFont(new Font(Font.SERIF,Font.BOLD,24));
            add(name);
            
            table = new JTable();
            
            try{
                  Connect con = new Connect();
                  ResultSet rs = con.s.executeQuery("select * from Employee");
                  while(rs.next()){
                        empid.add(rs.getString("EmployeeID"));
                  }
            }catch (Exception e){
                  JOptionPane.showMessageDialog(null, "⚠️No such Employee Found");
            }
            try{
                  Connect con = new Connect();
                  ResultSet rs = con.s.executeQuery("select * from Employee");
                  while(rs.next()){
                        name.add(rs.getString("Name"));
                  }
            }catch (Exception e){
                  JOptionPane.showMessageDialog(null, "⚠️No such Employee Found");
            }
            
            JScrollPane jsp = new JScrollPane(table);
            jsp.setBounds(0,100,1774,1200);
            add(jsp);
            
            search = new JButton("SEARCH");
            search.setBounds(40,50,200,50);
            search.setFont(new Font(Font.SERIF,Font.BOLD,30));
            search.addActionListener(this);
            add(search);
            
            print = new JButton("PRINT");
            print.setBounds(250,50,200,50);
            print.setFont(new Font(Font.SERIF,Font.BOLD,30));
            print.addActionListener(this);
            add(print);
            
            
            back = new JButton("BACK");
            back.setBounds(870,50,150,50);
            back.setFont(new Font(Font.SERIF,Font.BOLD,30));
            back.addActionListener(this);
            add(back);
            
            all = new JButton("Show All Employee Details");
            all.setBounds(460,50,400,50);
            all.setFont(new Font(Font.SERIF,Font.BOLD,30));
            all.addActionListener(this);
            add(all);
            
            setBounds(0,0,1774,1200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
      }
      public static void main(String[] args){
            new ViewEmployee();
      }
      
      @Override
      public void actionPerformed(ActionEvent e) {
            
            if(e.getSource()==search){
                  try{
                        Connect con = new Connect();
                        ResultSet rs = con.s.executeQuery("select * from Employee where EmployeeID = '"+empid.getSelectedItem()+"' AND Name='"+name.getSelectedItem()+"'");
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                  }catch (Exception ae){
                        JOptionPane.showMessageDialog(null, "⚠️No such Employee Found");
                  }
            
            } else if (e.getSource()==print) {
                  try{
                        table.print();
                  } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Unable to print Employee data");
                  }
            
            } else if (e.getSource()==all) {
                  try{
                        Connect con = new Connect();
                        
                        ResultSet rs = con.s.executeQuery("select * from Employee");
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                  }catch (Exception ae){
                        JOptionPane.showMessageDialog(null, "⚠️No such Employee Found");
                  }
            } else{
                  setVisible(false);
                  new Home();
            }
            
      }
}