package swing_demo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Welcome extends JFrame {
	
	   Welcome(){
		JFrame f =new JFrame();
		JLabel l1=new JLabel("Halaman Login");
		l1.setBounds(150, 50, 100, 30);
		f.add(l1);
		JButton b=new JButton("Tambahkan Data");
		b.setBounds(100,100,200,30);
		JButton b1=new JButton("Update Data");
		b1.setBounds(100,150,200,30);
		JButton b2=new JButton("Delete Data");
		b2.setBounds(100,200,200,30);
		JButton b3=new JButton("Cek Data");
		b3.setBounds(100,250,200,30);
		f.getContentPane().setBackground(Color.GRAY);
		f.setSize(400, 500);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.add(b);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		
	    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	    setTitle("Welcome");
	     b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Add();
				
			}
		});
	     b1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new Update();
					
				}
			});
	     b2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new Delete();
					
				}
			});
	     b3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						new AllItems();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
	     
	     
	     
	  }
	   public static void main(String[] args) {
		new Welcome();
	}
	 }
