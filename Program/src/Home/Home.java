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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMember = new JMenu("Member");
		menuBar.add(mnMember);
		
		JMenuItem menuItem = new JMenuItem("\u0E2D\u0E2D\u0E01\u0E08\u0E32\u0E01\u0E23\u0E30\u0E1A\u0E1A");
		mnMember.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("");
		mnMember.add(menuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Stock");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home home = new Home();
				home.setVisible(true);
			}
		});
		btnNewButton.setBounds(96, 34, 243, 50);
		contentPane.add(btnNewButton);
		
		JButton btnCalculateTheProduct = new JButton("Calculate \r\nthe product");
		btnCalculateTheProduct.setBounds(96, 110, 243, 50);
		contentPane.add(btnCalculateTheProduct);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setBounds(96, 177, 243, 50);
		contentPane.add(btnAdmin);
		
		JButton btHome = new JButton();
		btHome.setBounds(0, 0, 55, 42);
		btHome.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\P_SWL\\Desktop\\322118\\Project\\Program\\src\\Home\\home.png")
				.getImage().getScaledInstance(btHome.getWidth(), btHome.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		 
		btHome.setBorderPainted(false); 
		btHome.setContentAreaFilled(false);
		btHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
			}
		});
		
		getContentPane().add(btHome);
			
		
	}
}
