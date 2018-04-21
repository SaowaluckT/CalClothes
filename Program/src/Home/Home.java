package Home;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import login.Login;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.EventQueue;
import java.awt.event.*;
import java.io.File;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
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
					frame.setVisible(true);
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
				Stock.stock admin1 = new Stock.stock();
				admin1.setVisible(true);
			
			}
		});
		btnStock.setBounds(115, 44, 243, 50);
		contentPane.add(btnStock);

		JButton btnCalTheProduct = new JButton("Calculate \r\nthe product");
		btnCalTheProduct.setBackground(new Color(255, 255, 102));
		btnCalTheProduct.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 25));
		btnCalTheProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Calculate.calculate admin1 = new Calculate.calculate();
				admin1.setVisible(true);
				
			}
		});
		btnCalTheProduct.setBounds(115, 121, 243, 50);
		contentPane.add(btnCalTheProduct);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setBackground(new Color(204, 255, 102));
		btnAdmin.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 30));
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				admin.main admin1 = new admin.main();
				admin1.setVisible(true);
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
				int confirm = JOptionPane.showConfirmDialog(null,"คุณต้องการออกจากระบบ หรือไม่ ?", "Log out",JOptionPane.OK_CANCEL_OPTION);
				if(confirm == 0) {
					dispose();
					login.Login lg = new login.Login();
					lg.setVisible(true);
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
