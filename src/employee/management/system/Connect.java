package employee.management.system;

import javax.swing.*;
import java.sql.*;

public class Connect {
      
      Connection con;
      Statement s;
      
      public Connect(){
            
            try{
                  Class.forName("com.mysql.cj.jdbc.Driver");
                  con = DriverManager.getConnection("jdbc:mysql:///JobAlign", "Ranit","12345");
                  s = con.createStatement();
            }catch(Exception e){
                  JOptionPane.showMessageDialog(null,"Unable to connect to Database❌");
            }
      }
      
}
