package swing_demo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AllItems {
	
	
	AllItems() throws Exception{
		
		
		
		JFrame f=new JFrame();
		JButton b=new JButton("Cek Data");
		JButton b1=new JButton("Back");
		JLabel l1,l2,l3,l4,l5;
		l5=new JLabel("Mengecek Data");
		l5.setBounds(200, 50, 100, 30);
		f.add(l5);
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
		b.setBounds(200,300,200,30);
		b1.setBounds(200,350,200,30);
		
		JTable tb=new JTable(1,4);
		tb.setBounds(500,100,400,150);
		
		f.add(l1);
		f.add(t1);
		f.add(l2);
		f.add(t2);
		f.add(l3);
		f.add(t3);
		f.add(l4);
		f.add(t4);
		f.add(b);
		f.add(b1);
		f.add(tb);
		f.getContentPane().setBackground(Color.GRAY);
		f.setSize(500, 450);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
		
		try{
			String value1=t1.getText();
			// TODO Auto-generated method stub
			String idb1=null;
			String nb1=null;
			String desc1=null;
			String harga1= null;
			
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_penjualaan","root","");
		Statement smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
		ResultSet rs=smt.executeQuery("select * from tb_menu where id_barang='"+value1+"'");
			JOptionPane.showInputDialog(this, "Barangnya Ada :) ");
		
		DefaultTableModel mo=(DefaultTableModel)tb.getModel();
		
		while(rs.next()){
			String idb=rs.getString("id_barang");
			String nb=rs.getString("nama_barang");
			String desc=rs.getString("deskripsi");
			String harga=rs.getString("harga");
			
			
			t1.setText(idb);
			t2.setText(nb);
			t3.setText(desc);
			t4.setText(harga);
			
			idb1=rs.getString("id_barang");
			nb1=rs.getString("nama_barang");
			desc1=rs.getString("deskripsi");
			harga1=rs.getString("harga");
			
			
//			String name=rs.getString("name");
//			String desc=rs.getString("description");
//			String price=rs.getString("price");
//			System.out.println(rs.getString("id")+ ""+rs.getString("name")+" "+rs.getString("descriptions")+" "+rs.getString("price"));  
		}
		mo.addRow(new Object[]{idb1,nb1,desc1,harga1});
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



	public static void main(String[] args)throws Exception {
		new AllItems();
	}

}
