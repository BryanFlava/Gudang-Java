package swing_demo;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Reg {

	public static void main(String[] args) {
		JButton b=new JButton("Registrasi");
		JButton b1=new JButton("Login");
		String daerah[]={"Jawa","Kalimantan","Sulawesi","Papua"};
		JComboBox cb=new JComboBox(daerah);
		//JLabel lb=new JLabel("Label");
		JRadioButton rbc=new JRadioButton("Laki Laki");
		JRadioButton rb1=new JRadioButton("Perempuan");
		JFrame f= new JFrame("Halaman Registrasi");
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTextField t1,t2,t3;
		//JLabel l1,l2,l3,l4,l5,l6;
		JLabel l1=new JLabel("Name");
		l1.setBounds(10,100,200,30);
		t1=new JTextField();
		t1.setBounds(100,100,200,30);
		JLabel l2=new JLabel("Email");
		l2.setBounds(10,150,200,30);
		t2=new JTextField();
		t2.setBounds(100,150,200,30);
		JLabel l3=new JLabel("Password");
		l3.setBounds(10,200,200,30);
		t3=new JTextField();
		t3.setBounds(100,200,200,30);
		JLabel l4=new JLabel("Jenis Kelamin");
		l4.setBounds(10,250,200,30);
		JLabel l5=new JLabel("Daerah");
		l5.setBounds(10,350,200,30);
		rbc.setBounds(100,250,200,30);
		JLabel l6=new JLabel("Daftar Sekarang");
		l6.setBounds(100, 40, 100, 30);
		
	
		rb1.setBounds(100,300,200,30);
		cb.setBounds(100,350,200,30);
		b.setBounds(100,400,100,30);
		b1.setBounds(200,400,100,30);
		ButtonGroup bg=new ButtonGroup();
		f.getContentPane().setBackground(Color.GRAY);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		bg.add(rbc);
		bg.add(rb1);
		f.add(rbc);
		f.add(rb1);
		f.add(cb);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(l6);
		f.add(b);
		f.add(b1);
		f.setSize(350, 500);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String value1 = t1.getText();
				String value2 = t2.getText();
				String value3=t3.getText();
				String value4=cb.getSelectedItem().toString();
				String jenis_kelamin=null;
				
				if(rbc.isSelected())
				
				{
					jenis_kelamin="Laki Laki";
				}
				else if(rb1.isSelected())
				{
					jenis_kelamin="Perempuan";
				}
				
//				System.out.println(value1);
//				System.out.println(value2);
//				System.out.println(value3);
//				System.out.println(value4);
//				System.out.println(gender);
				
				// TODO Auto-generated method stub
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_penjualaan","root","");
					Statement smt=con.createStatement();
					smt.executeUpdate("insert into tb_user(user,email,pass,jenis_kelamin,daerah) values('"+value1+"','"+value2+"','"+value3+"','"+jenis_kelamin+"','"+value4+"')");
					
					JOptionPane.showInputDialog(this, "successfully registered");
				
				}catch(Exception re){System.out.println(re);}
				
				
			}
		});
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Login();
				
			}
		});
	}

	private static void setDefaultCloseOperation(int disposeOnClose) {
		// TODO Auto-generated method stub
		
	}}
		
		
	
