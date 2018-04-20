package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Home.Home;
import connect.Connect;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tfUser;
	Connect conn = new Connect();
	String qry = null;
	ResultSet result = null;
	private String Name;
	private String Surname;
	private String Username;
	private String Phone;
	private boolean status;
	private JPasswordField tfPass;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfUser = new JTextField();
		tfUser.setBounds(164, 89, 154, 32);
		contentPane.add(tfUser);
		tfUser.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 20));
		lblUsername.setBounds(71, 91, 104, 27);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 20));
		lblPassword.setBounds(71, 131, 83, 32);
		contentPane.add(lblPassword);
		
		JButton btnLogIn = new JButton("");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				qry = "SELECT * FROM members WHERE username = '"
						+ tfUser.getText()
						+ "' AND password = '"
						+ tfPass.getText()
						+ "'"; 
				
				try {
					result = conn.stmt.executeQuery(qry);
					
					if (result.next()) {
						Name = result.getString("Name");
						Username = result.getString("Username");
						Surname = result.getString("Surname");
						Phone = result.getString("Phone");
						status = true;
					}else {
						status = false;
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(status){
					JOptionPane.showMessageDialog(null, "Hello "+Name+" "+Surname,"Welcome to Clothes Shop",JOptionPane.PLAIN_MESSAGE);
					dispose();
					Home home = new Home();
					home.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Username or Password is incorrect!","Welcome to Clothes Shop",0);
					tfUser.setText(null);
					tfPass.setText(null);
				}
			}
		});
		btnLogIn.setBounds(164, 191, 104, 32);
		contentPane.add(btnLogIn);
		btnLogIn.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\P_SWL\\Desktop\\322118\\Project\\icon\\login2.png")
				.getImage().getScaledInstance(btnLogIn.getWidth(), btnLogIn.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		 
		btnLogIn.setBorderPainted(false); 
		btnLogIn.setContentAreaFilled(false);
		
		
		JLabel lblVakandaClothes = new JLabel("VAKANDA CLOTHES");
		lblVakandaClothes.setHorizontalAlignment(SwingConstants.CENTER);
		lblVakandaClothes.setFont(new Font("5103_tLU_JIUMJIUM", Font.PLAIN, 40));
		lblVakandaClothes.setBounds(71, 31, 288, 47);
		contentPane.add(lblVakandaClothes);
		
		tfPass = new JPasswordField();
		tfPass.setBounds(164, 132, 154, 32);
		contentPane.add(tfPass);
	}
}
