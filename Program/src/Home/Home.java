package Home;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.JMenuItem;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\CalClothes\\Program\\bin\\Home\\home.png"));
		setTitle("HOME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 349);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMember = new JMenu("Member");
		mnMember.setHorizontalAlignment(SwingConstants.RIGHT);
		menuBar.add(mnMember);
		
		JMenuItem menuItem = new JMenuItem("\u0E2D\u0E2D\u0E01\u0E08\u0E32\u0E01\u0E23\u0E30\u0E1A\u0E1A");
		mnMember.add(menuItem);
		
		
		JMenuItem menuItem_1 = new JMenuItem("");
		mnMember.add(menuItem_1);
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
		btnStock.setBounds(96, 34, 243, 50);
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
		btnCalTheProduct.setBounds(96, 110, 243, 50);
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
		btnAdmin.setBounds(96, 177, 243, 50);
		contentPane.add(btnAdmin);
		
		JButton btHome = new JButton();
		btHome.setBounds(0, 0, 55, 42);
		btHome.setIcon(new ImageIcon(new ImageIcon("D:\\CalClothes\\Program\\bin\\Home\\home.png")
				.getImage().getScaledInstance(btHome.getWidth(), btHome.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		 
		btHome.setBorderPainted(false); 
		btHome.setContentAreaFilled(false);
		btHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
			}
		});
		
		getContentPane().add(btHome);
		
		JLabel lbHome = new JLabel("");
		lbHome.setIcon(new ImageIcon("D:\\CalClothes\\image\\bgLogin.jpg"));
		lbHome.setBounds(0, 0, 466, 289);
		contentPane.add(lbHome);
		lbHome.setIcon(new ImageIcon(new ImageIcon("D:\\CalClothes\\image\\bgLogin.jpg")
				.getImage().getScaledInstance(lbHome.getWidth(), lbHome.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		
			
		
	}
}
