package product;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import connect.Connect;
import home.Home;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyEvent;

public class Insert extends JFrame {
	
	Connect conn = new Connect();
	String qry = null;
	//String result = null;
	int Rowsize;
	
	private JPanel contentPane;
	private JTextField tfProID;
	private JTextField tfPattern;
	private JTextField tfColor;
	private JTextField tfPrice;
	private JTextField tfPic;
	private JTextField tfPicture;
	private JTextField tfQuantity;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert frame = new Insert();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setAlwaysOnTop(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void clearTf() {
		tfProID.setText(null);
		tfPattern.setText(null);
		tfColor.setText(null);
		tfPrice.setText(null);
		tfQuantity.setText(null);
		tfPicture.setText(null);
	}
	
	

	/**
	 * Create the frame.
	 */
	public Insert() {
		File Icon = new File("icon");
		setTitle("Insert Product");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Icon.getAbsolutePath()+"\\insert3.png"));
		
		getContentPane().setLayout(null);

		tfPic = new JTextField();
		tfPic.setBounds(144, 193, 96, 19);
		getContentPane().add(tfPic);
		tfPic.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 452);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 160, 122));
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
		contentPane.setLayout(null);
		btHome.setBounds(0, 24, 55, 42);
		contentPane.add(btHome); 
		btHome.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\home.png")
				.getImage().getScaledInstance(btHome.getWidth(), btHome.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
				
		btHome.setBorderPainted(false); 
		btHome.setContentAreaFilled(false);
		
		
		
		JComboBox cbType = new JComboBox();
		cbType.setBounds(165, 127, 175, 21);
		cbType.setModel(new DefaultComboBoxModel(new String[] {"Shirt", "Dress"}));
		contentPane.add(cbType);
		
		JLabel lblProductId = new JLabel("Product ID");
		lblProductId.setBounds(65, 94, 107, 13);
		contentPane.add(lblProductId);
		
		tfProID = new JTextField();
		tfProID.setBounds(165, 91, 175, 25);
		contentPane.add(tfProID);
		tfProID.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Type");
		lblNewLabel.setBounds(65, 131, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pattern");
		lblNewLabel_1.setBounds(65, 172, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		tfPattern = new JTextField();
		tfPattern.setBounds(165, 169, 175, 25);
		contentPane.add(tfPattern);
		tfPattern.setColumns(10);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(65, 214, 45, 13);
		contentPane.add(lblColor);
		
		tfColor = new JTextField();
		tfColor.setBounds(165, 211, 175, 23);
		contentPane.add(tfColor);
		tfColor.setColumns(10);
		
		JLabel lblInsert = new JLabel("Insert");
		//lblInsert.setForeground(Color.RED);
		lblInsert.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 35));
		lblInsert.setBounds(70, 26, 130, 40);
		contentPane.add(lblInsert);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(65, 249, 45, 13);
		contentPane.add(lblPrice);
		
		tfPrice = new JTextField();
		tfPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Please enter numeric");
                }
			}
		});
		tfPrice.setBounds(165, 245, 86, 25);
		contentPane.add(tfPrice);
		tfPrice.setColumns(10);
		
		JLabel lblPicture = new JLabel("Picture");
		lblPicture.setBounds(65, 284, 45, 13);
		contentPane.add(lblPicture);

		tfPicture = new JTextField();
		tfPicture.setBounds(165, 281, 86, 21);
		contentPane.add(tfPicture);
		tfPicture.setColumns(10);
		
		JButton btnInsert = new JButton("");
		btnInsert.setBounds(387, 306, 61, 55);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conn.connect();
				if(tfProID.getText().equals("") || tfPattern.getText().equals("") || tfColor.getText().equals("") || tfPrice.getText().equals("") || tfQuantity.getText().equals("") || tfPicture.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter information");
				}else {
					try {
				String qry = "INSERT INTO clothes (Pro_ID,Type,Pattern,Color,Price,Quantity,Picture) VALUES ('"
				+ tfProID.getText() 
				+ "','" 
				+ cbType.getSelectedItem().toString() 
				+ "','" 
				+ tfPattern.getText() 
				+ "','" 
				+ tfColor.getText() 
				+ "',"
				+ tfPrice.getText()
				+ ","
				+ tfQuantity.getText()
				+ ",'"
				+ tfPicture.getText()
				+ "')";	
				System.out.print(qry);	
					conn.stmt.executeUpdate(qry);
					JOptionPane.showMessageDialog(null, "Insert product ''"+ tfProID.getText() +"'' successfully");
					} catch (SQLException ee) {
						ee.printStackTrace();
					}
					conn.disConnect();
				}
			}
		});
		contentPane.add(btnInsert);
		btnInsert.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\insert3.png").getImage().getScaledInstance(
						btnInsert.getWidth(), btnInsert.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnInsert.setBorderPainted(false);
		btnInsert.setContentAreaFilled(false);
		
		JButton btnRefresh = new JButton("");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearTf();
				cbType.setSelectedItem("Shirt");
			}
		});
		btnRefresh.setBounds(458, 306, 61, 55);
		contentPane.add(btnRefresh);
		btnRefresh.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\reload.png")
				.getImage()
				.getScaledInstance(btnRefresh.getWidth(), btnRefresh.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnRefresh.setBorderPainted(false);
		btnRefresh.setContentAreaFilled(false);
		
		JButton btnBack = new JButton("");
		btnBack.setBounds(10, 338, 72, 55);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Stock.main(null);
			}
		});
		contentPane.add(btnBack);
		btnBack.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\back.png").getImage()
				.getScaledInstance(btnBack.getWidth(), btnBack.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));

		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
		
		JLabel lblRefresh = new JLabel("Refresh");
		lblRefresh.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 20));
		lblRefresh.setBounds(468, 372, 55, 21);
		contentPane.add(lblRefresh);
		
		JLabel lblInsert_1 = new JLabel("Insert");
		lblInsert_1.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 20));
		lblInsert_1.setBounds(397, 372, 55, 21);
		contentPane.add(lblInsert_1);
		
		tfQuantity = new JTextField();
		tfQuantity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
						char caracter = e.getKeyChar();
		                if (((caracter < '0') || (caracter > '9'))
		                        && (caracter != '\b')) {
		                    e.consume();
		                    JOptionPane.showMessageDialog(null, "Please enter numeric");
		                }
			}
		});
		tfQuantity.setColumns(10);
		tfQuantity.setBounds(329, 245, 86, 25);
		contentPane.add(tfQuantity);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(273, 249, 66, 13);
		contentPane.add(lblQuantity);

	}
}
