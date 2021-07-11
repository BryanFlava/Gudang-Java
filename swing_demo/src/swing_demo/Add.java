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
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Add {
	
	Add(){
		JFrame f=new JFrame();
		JButton b=new JButton("Tambahkan");
		JButton b1=new JButton("Back");
		JLabel l1,l2,l3;
		JTextField t1,t2,t3;
		l1=new JLabel("Nama Barang");
		l1.setBounds(50,100,200,30);
		t1=new JTextField();
		t1.setBounds(200,100,200,30);
		l2=new JLabel("Deskripsi Barang");
		l2.setBounds(50,150,200,30);
		t2=new JTextField();
		t2.setBounds(200,150,200,30);
		l3=new JLabel("Harga Barang");
		l3.setBounds(50,200,200,30);
		t3=new JTextField();
		t3.setBounds(200,200,200,30);
		JLabel l4=new JLabel("Tambahkan Data");
		l4.setBounds(200, 40, 100, 30);
		b.setBounds(200,250,200,30);
		b1.setBounds(200,300,200,30);
		
		f.getContentPane().setBackground(Color.GRAY);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(b);
		f.add(l4);
		f.add(b1);
		
		f.setSize(500, 400);
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
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_penjualaan","root","");
					Statement smt=con.createStatement();
					smt.executeUpdate("insert into tb_menu(nama_barang,deskripsi,harga) values('"+value1+"','"+value2+"','"+value3+"')");
					JOptionPane.showInputDialog(this, "Berhasil Ditambahkan :) ");
				
				}catch(Exception re){System.out.println(re);}
				
			}
		});

	
	b1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new Welcome();
			
		}
	});

	}

	private void setDefaultCloseOperation(int disposeOnClose) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new Add();

	}

}
