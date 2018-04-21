package Insert;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Home.Home;
import connect.Connect;
import login.Login;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;

public class Insert extends JFrame {
	
	public Connection conn;
	public Statement stmt = null;
	
	String qry = null;
	String rs = null;
	int Rowsize;
	
	private JPanel contentPane;
	private JTextField tfProID;
	private JTextField tfPattern;
	private JTextField tfColor;
	private JTextField tfPrice;
	private boolean status;
	private String Pro_ID;
	private String Type;
	private String Pattern;
	private String Color;
	private double Price;
	private String Pic_Name;
	private JTextField tfPic;
	private JTextField tfPicture;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert frame = new Insert();
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
	public Insert() {
		
		getContentPane().setLayout(null);

		tfPic = new JTextField();
		tfPic.setBounds(144, 193, 96, 19);
		getContentPane().add(tfPic);
		tfPic.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 470);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btHome = new JButton();
		btHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Home home = new Home();
				home.setVisible(true);
			}
		});
		btHome.setBounds(0, 24, 55, 42);
		contentPane.add(btHome); 
		btHome.setIcon(new ImageIcon(new ImageIcon("D:\\CalClothes\\Program\\src\\Home\\home.png")
				.getImage().getScaledInstance(btHome.getWidth(), btHome.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
				
		btHome.setBorderPainted(false); 
		btHome.setContentAreaFilled(false);
		
		
		
		JComboBox cbType = new JComboBox();
		cbType.setBounds(165, 127, 96, 21);
		cbType.setModel(new DefaultComboBoxModel(new String[] {"Shirt", "Dress"}));
		contentPane.add(cbType);
		
		JLabel lblProductId = new JLabel("Product ID");
		lblProductId.setBounds(65, 94, 107, 13);
		contentPane.add(lblProductId);
		
		tfProID = new JTextField();
		tfProID.setBounds(165, 91, 96, 19);
		contentPane.add(tfProID);
		tfProID.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Type");
		lblNewLabel.setBounds(65, 131, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pattern");
		lblNewLabel_1.setBounds(65, 172, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		tfPattern = new JTextField();
		tfPattern.setBounds(165, 169, 96, 19);
		contentPane.add(tfPattern);
		tfPattern.setColumns(10);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(65, 214, 45, 13);
		contentPane.add(lblColor);
		
		tfColor = new JTextField();
		tfColor.setBounds(165, 211, 96, 19);
		contentPane.add(tfColor);
		tfColor.setColumns(10);
		
		JLabel lblInsert = new JLabel("Insert");
		lblInsert.setForeground(Color.RED);
		lblInsert.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 35));
		lblInsert.setBounds(70, 26, 130, 40);
		contentPane.add(lblInsert);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(65, 249, 45, 13);
		contentPane.add(lblPrice);
		
		tfPrice = new JTextField();
		tfPrice.setBounds(165, 246, 96, 19);
		contentPane.add(tfPrice);
		tfPrice.setColumns(10);
		
		JLabel lblPicture = new JLabel("Picture");
		lblPicture.setBounds(65, 284, 45, 13);
		contentPane.add(lblPicture);

		tfPicture = new JTextField();
		tfPicture.setBounds(165, 281, 96, 19);
		contentPane.add(tfPicture);
		tfPicture.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setBounds(330, 306, 85, 21);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String qry = "INSERT INTO clothes (Pro_ID,Type,Pattern,Color,Price,Pic_Name) VALUES ('"
				+ tfProID.getText() + "','" + cbType.getSelectedItem().toString() + "','" + tfPattern.getText() + "','" + tfColor.getText() + "',"+ tfPrice.getText()+",'"+ tfPicture.getText() + "'" + ")";	
				System.out.print(qry);
				
			}
		});
		contentPane.add(btnInsert);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 536, 22);
		contentPane.add(menuBar);
		
		JMenu mnMember = new JMenu("Member");
		menuBar.add(mnMember);
		
		JMenuItem mnLogout = new JMenuItem("\u0E2D\u0E2D\u0E01\u0E08\u0E32\u0E01\u0E23\u0E30\u0E1A\u0E1A");
		mnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Login login = new Login();
				login.setVisible(true);
				
			}
		});
		mnMember.add(mnLogout);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfProID.setText(null);
				cbType.setSelectedItem("Shirt");
				tfPattern.setText(null);
				tfColor.setText(null);
				tfPrice.setText(null);
				tfPicture.setText(null);
			}
		});
		btnRefresh.setBounds(414, 306, 85, 21);
		contentPane.add(btnRefresh);

	}
}
