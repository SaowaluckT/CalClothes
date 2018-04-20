package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Home.Home;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
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
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setBounds(96, 12, 46, 14);
		contentPane.add(lblAdmin);
		
		JButton btnHome = new JButton("");
		btnHome.setBounds(0, 0, 65, 38);
		contentPane.add(btnHome);
		btnHome.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\P_SWL\\Desktop\\322118\\Project\\Program\\src\\Home\\home.png")
				.getImage().getScaledInstance(btnHome.getWidth(), btnHome.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		 
		btnHome.setBorderPainted(false); 
		btnHome.setContentAreaFilled(false);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Home home = new Home();
				home.setVisible(true);
			}
		});
	}
}
