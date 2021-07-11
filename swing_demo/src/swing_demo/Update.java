package swing_demo;

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

public class Update {
	
	Update(){
		JFrame f=new JFrame();
		JButton b=new JButton("Update");
		JLabel l1,l2,l3,l4;
		JTextField t1,t2,t3,t4;
		l1=new JLabel("ID Barang");
		l1.setBounds(50,100,200,30);
		t1=new JTextField();
		t1.setBounds(200,100,200,30);
		l2=new JLabel("Nama Barang");
		l2.setBounds(50,150,200,30);
		t2=new JTextField();
		t2.setBounds(200,150,200,30);
		l3=new JLabel("Deskripsi");
		l3.setBounds(50,200,200,30);
		t3=new JTextField();
		t3.setBounds(200,200,200,30);
		l4=new JLabel("Harga");
		l4.setBounds(50,250,200,30);
		t4=new JTextField();
		t4.setBounds(200,250,200,30);
		b.setBounds(200,300,100,30);
		
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(l4);
		f.add(t4);
		f.add(b);
		
		f.setSize(500, 450);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		
b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String value1 = t1.getText();
				String value2 = t2.getText();
				String value3=t3.getText();
				String value4=t4.getText();
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_penjualaan","root","");
					Statement smt=con.createStatement();
					smt.executeUpdate("UPDATE tb_menu set nama_barang='"+value2+"', deskripsi='"+value3+"', harga='"+value4+"' where id_barang='"+value1+"'");
//					smt.executeUpdate("insert into tb_menu(nama_barang,deskripsi,harga) values('"+value1+"','"+value2+"','"+value3+"')");
					JOptionPane.showInputDialog(this, "Menu updated Successfully");
				
				}catch(Exception re){System.out.println(re);}
				
			}
		});
		
		
		
		
	}

	public static void main(String[] args) {
		new Update();
	}

}
