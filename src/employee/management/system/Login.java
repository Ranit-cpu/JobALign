package employee.management.system;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class Login extends JFrame implements ActionListener {
      
      JTextField user;
      JPasswordField pass;
      
      public Login() {
            getContentPane().setBackground(Color.BLACK);
            setLayout(null);
            
            JLabel username = new JLabel("Username");
            username.setBounds(100, 130, 100, 30);
            username.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
            username.setForeground(Color.WHITE);
            add(username);
            
            user = new JTextField();
            user.setBounds(50, 160, 200, 30);
            user.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 25));
            add(user);
            
            JLabel password = new JLabel("Password");
            password.setBounds(100, 230, 100, 30);
            password.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
            password.setForeground(Color.WHITE);
            add(password);
            
            pass = new JPasswordField();
            pass.setBounds(50, 260, 200, 30);
            pass.setBackground(Color.WHITE);
            pass.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 25));
            add(pass);
            
            JButton login = new JButton("LOGIN");
            login.setBounds(100, 310, 100, 40);
            login.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
            login.setForeground(Color.BLACK);
            login.addActionListener(this);
            add(login);
            
            ImageIcon originalIcon = new ImageIcon(ClassLoader.getSystemResource("icons/user.jpeg"));
            Image roundedImage = createRoundedImage(originalIcon.getImage());
            
            JLabel image = new JLabel(new ImageIcon(roundedImage));
            image.setBounds(110, 20, 75, 75);
            add(image);
            
            setSize(300, 400);
            setLocation(700, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
      }
      
      private Image createRoundedImage(Image image) {
            // Create a buffered image from the original image
            BufferedImage original = new BufferedImage(75, 75, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = original.createGraphics();
            g2.drawImage(image, 0, 0, 75, 75, null);
            g2.dispose();
            
            // Create a circular mask and apply it
            BufferedImage circular = new BufferedImage(75, 75, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = circular.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            // Draw the circular mask
            Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, 75, 75);
            g2d.setClip(circle);
            g2d.drawImage(original, 0, 0, null);
            g2d.dispose();
            
            return circular;
      }
      
      @Override
      public void actionPerformed(ActionEvent e) {
            String usr = user.getText();
            String pas = new String(pass.getPassword());
            
            String query = "SELECT * FROM login WHERE username = ? AND password = ?";
            try {
                  Connect c = new Connect();
                  PreparedStatement pstmt = c.con.prepareStatement(query);
                  pstmt.setString(1, usr);
                  pstmt.setString(2, pas);
                  
                  ResultSet rs = pstmt.executeQuery();
                  if (rs.next()) {
                        setVisible(false);
                        new Home();
                  } else {
                        JOptionPane.showMessageDialog(null, "Wrong Username and password Combination❌");
                  }
            } catch (SQLException ex) {
                  throw new RuntimeException(ex);
            }
      }
      
      public static void main(String[] args) {
            new Login();
      }
}
