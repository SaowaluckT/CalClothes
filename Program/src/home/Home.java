package home;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import admin.Admin;
import calculate.Calculate;
import login.Login;
import product.Stock;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.EventQueue;
import java.awt.event.*;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;


public class Home extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);//การกำหนดแสดงผลหน้า 
					frame.setResizable(false);//การกำหนด Resize ได้ false = ไม่ใช่
					frame.setAlwaysOnTop(false);//การกำหนดแสดงผลบนสุดเสมอ false = ไม่ใช่				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		File Icon = new File("icon");
		File Image = new File("image");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Icon.getAbsolutePath()+"\\home.png"));
		setTitle("HOME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStock = new JButton("Stock");
		btnStock.setBackground(new Color(255, 153, 153));
		btnStock.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 30));
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Stock.main(null);
			
			}
		});
		btnStock.setBounds(115, 44, 243, 50);
		contentPane.add(btnStock);

		JButton btnCalTheProduct = new JButton("Calculate \r\nthe product");
		btnCalTheProduct.setBackground(new Color(255, 255, 102));
		btnCalTheProduct.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 25));
		btnCalTheProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //ปิดหน้า
				Calculate.main(null); //เปิดหน้า Calculate
				
			}
		});
		btnCalTheProduct.setBounds(115, 114, 243, 50);
		contentPane.add(btnCalTheProduct);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setBackground(new Color(204, 255, 102));
		btnAdmin.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 30));
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();//ปิดหน้า
				Admin.main(null);//เปิดหน้า Admin
			}
		});
		btnAdmin.setBounds(115, 182, 243, 50);
		contentPane.add(btnAdmin);
		
		JButton btHome = new JButton();
		btHome.setBounds(0, 0, 55, 42);
		btHome.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\home.png")
				.getImage().getScaledInstance(btHome.getWidth(), btHome.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		 
		btHome.setBorderPainted(false); 
		btHome.setContentAreaFilled(false);		
		contentPane.add(btHome);
		
		
		JButton btLogOut = new JButton();
		btLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int confirm = JOptionPane.showConfirmDialog(null,"Log out ?", "Confirm",JOptionPane.OK_CANCEL_OPTION);
				if(confirm == 0) {
					dispose();//ปิดหน้า
					Login.main(null);//เปิดหน้า Login
				}
				
			}
		});
		btLogOut.setBounds(401, 0, 49, 42);
		contentPane.add(btLogOut);
		btLogOut.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\logOff.png")
				.getImage().getScaledInstance(btLogOut.getWidth(), btLogOut.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btLogOut.setContentAreaFilled(false);
		btLogOut.setBorderPainted(false);
			
		JLabel lblLogout = new JLabel("Log-out");
		lblLogout.setForeground(Color.RED);
		lblLogout.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 15));
		lblLogout.setBounds(401, 33, 49, 25);
		contentPane.add(lblLogout);
		
		JLabel lbHome = new JLabel("");
		lbHome.setBounds(0, 0, 466, 283);
		contentPane.add(lbHome);
		lbHome.setIcon(new ImageIcon(new ImageIcon(Image.getAbsolutePath()+"\\bgLogin.jpg")
				.getImage().getScaledInstance(lbHome.getWidth(), lbHome.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
	}
}
