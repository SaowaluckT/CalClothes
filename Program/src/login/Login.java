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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfUser = new JTextField();
		tfUser.setBounds(185, 71, 133, 20);
		contentPane.add(tfUser);
		tfUser.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(92, 74, 83, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(92, 112, 83, 14);
		contentPane.add(lblPassword);
		
		JButton btnLogIn = new JButton("Log in");
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
		btnLogIn.setBounds(185, 159, 89, 23);
		contentPane.add(btnLogIn);
		
		JLabel lblVakandaClothes = new JLabel("VAKANDA CLOTHES");
		lblVakandaClothes.setFont(new Font("5103_tLU_JIUMJIUM", Font.PLAIN, 25));
		lblVakandaClothes.setBounds(147, 11, 133, 41);
		contentPane.add(lblVakandaClothes);
		
		tfPass = new JPasswordField();
		tfPass.setBounds(185, 109, 133, 20);
		contentPane.add(tfPass);
	}
}
