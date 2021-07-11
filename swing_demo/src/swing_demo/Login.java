package swing_demo;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

 

public class Login {
	Login(){
			
		JFrame f=new JFrame("LOGIN SEKARANG");
		JTextField t4;
		JPasswordField t5;
		JLabel l1=new JLabel("Username");
		JLabel l2=new JLabel("Password");
		JLabel l3=new JLabel("Halaman Login");
		l1.setBounds(30, 100, 100, 30);
		f.add(l1);
		l2.setBounds(30,150,100,20);
		f.add(l2);
		l3.setBounds(150, 50, 100, 30);
		f.add(l3);
		t4=new JTextField();
		t5=new JPasswordField();
		JButton b1=new JButton("Login");
		JButton b=new JButton("Registrasi");
		f.add(t4);
		t4.setBounds(100,100,200,30);
		f.add(t5);
		t5.setBounds(100,150,200,30);
		f.add(b1);
		f.add(b);
		b1.setBounds(100,200,200,30);
		b.setBounds(100,250,200,30);
		f.getContentPane().setBackground(Color.GRAY);
		f.setSize(400, 400);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Reg();
				
			}
		});
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String value1=t4.getText();
				String value2=t5.getText();
				String user1="user";
				String pass1="pass";
							
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_penjualaan","root","");
					PreparedStatement ps=con.prepareStatement("select * from tb_user where user='"+value1+"' and pass='"+value2+"'");
					ResultSet rs=ps.executeQuery();
							
					while(rs.next()){
						user1=rs.getString("user");
						pass1=rs.getString("pass");
					}
					
					
					if(value1.equals(user1) && value2.equals(pass1)){
						new Welcome();
					}
					else{
						JOptionPane.showInputDialog(this, "Passwordnya/Usernamenya Salah :) ");
					}
				}
		
					catch(Exception re){System.out.println(re);}
			}
		});
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Reg();
				
			}
		});
		
	}

		public static void main(String[] args) {
			new Login();
		}
	}


