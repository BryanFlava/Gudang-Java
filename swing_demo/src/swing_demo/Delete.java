package swing_demo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Delete {
	
	Delete(){
		JFrame f=new JFrame();
		JButton b=new JButton("Delete");
		JLabel l1;
		JTextField t1;
		l1=new JLabel("ID Barang");
		l1.setBounds(50,100,200,30);
		t1=new JTextField();
		t1.setBounds(150,100,200,30);
		b.setBounds(150,150,100,30);
		
		f.add(l1);
		f.add(t1);
		f.add(b);
		f.getContentPane().setBackground(Color.GRAY);
		f.setSize(400, 500);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		
		
b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String value1 = t1.getText();
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_penjualaan","root","");
					Statement smt=con.createStatement();
					smt.executeUpdate("DELETE from tb_menu where id_barang='"+value1+"'");
					//smt.executeUpdate("insert into tb_menu(name,descriptions,price) values('"+value1+"','"+value2+"','"+value3+"')");
					JOptionPane.showInputDialog(this, "Menu Delete Successfully");
				
				}catch(Exception re){System.out.println(re);}
				
			}
		});
	}
	
	
	

	public static void main(String[] args) {
		new Delete();

	}

}
