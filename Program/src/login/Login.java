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
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

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
		File Icon = new File("/CalClothes/icon");
		File Image = new File("/CalClothes/image");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Icon.getAbsolutePath()+"\\lg.png"));
		setTitle("Login");
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
		lblUsername.setBounds(71, 91, 104, 27);
		lblUsername.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 20));
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(71, 131, 83, 32);
		lblPassword.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 20));
		contentPane.add(lblPassword);
		
		JButton btnLogIn = new JButton("");
		btnLogIn.setBounds(182, 188, 104, 32);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conn.connect();
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
				conn.disConnect();
			}
			
		});
		contentPane.add(btnLogIn);
		btnLogIn.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\login2.png")
				.getImage().getScaledInstance(btnLogIn.getWidth(), btnLogIn.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		 
		btnLogIn.setBorderPainted(false); 
		btnLogIn.setContentAreaFilled(false);
		
		
		JLabel lblVakandaClothes = new JLabel("VAKANDA CLOTHES");
		lblVakandaClothes.setBounds(71, 31, 288, 47);
		lblVakandaClothes.setHorizontalAlignment(SwingConstants.CENTER);
		lblVakandaClothes.setFont(new Font("5103_tLU_JIUMJIUM", Font.PLAIN, 40));
		contentPane.add(lblVakandaClothes);
		
		tfPass = new JPasswordField();
		tfPass.setBounds(164, 132, 154, 32);
		contentPane.add(tfPass);
		
		JLabel lbLogin = new JLabel("");
		lbLogin.setBounds(0, 0, 444, 261);
		contentPane.add(lbLogin);
		lbLogin.setIcon(new ImageIcon(new ImageIcon(Image.getAbsolutePath()+"\\bgLogin.jpg")
				.getImage().getScaledInstance(lbLogin.getWidth(), lbLogin.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		 
		btnLogIn.setBorderPainted(false); 
		btnLogIn.setContentAreaFilled(false);
		
	}
}
