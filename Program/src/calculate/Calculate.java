package calculate;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import connect.Connect;
import home.Home;

import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Calculate extends JFrame {

	private JPanel contentPane;
	private JTextField tfPro_ID;
	private JTextField tfQ;
	private JTextField tfSearch;
	Connect conn = new Connect();
	String qry;
	ResultSet result;
	int Rowsize;
	private JTextField tfSelect;
	Map<String, Integer> productSelect = new HashMap<String, Integer>();
	private String pid = null;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculate frame = new Calculate();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setAlwaysOnTop(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the frame.
	 */
	public Calculate() {
		
		File Icon = new File("icon");
		File Image = new File("Image");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Icon.getAbsolutePath()+"\\p.png"));
		setTitle("Product Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 525);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnHome = new JButton("");
		btnHome.setBounds(10, 11, 60, 60);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				if(conn.statusDB) {
					conn.disConnect();
				}
				Home.main(null);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnHome);
		btnHome.setIcon(new ImageIcon(((new ImageIcon(Icon.getAbsolutePath()+"\\home.png")).getImage()).getScaledInstance(
						btnHome.getWidth(), btnHome.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnHome.setBorderPainted(false);
		btnHome.setContentAreaFilled(false);

		JButton btnCal = new JButton("");
		btnCal.setBounds(408, 171, 80, 60);
		btnCal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Summary sum = new Summary();
				sum.productSelect = productSelect;
				dispose();
				if(conn.statusDB) {
					conn.disConnect();
				}
				sum.setVisible(true);
			}
		});
		
		btnCal.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(btnCal);
		btnCal.setIcon(new ImageIcon(((new ImageIcon(Icon.getAbsolutePath()+"\\cal2.png")).getImage()).getScaledInstance(
						btnCal.getWidth(), btnCal.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnCal.setBorderPainted(false);
		btnCal.setContentAreaFilled(false);
		

		JLabel lblId = new JLabel("Product ID :");
		lblId.setBounds(121, 276, 105, 19);
		lblId.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 20));
		contentPane.add(lblId);

		tfPro_ID = new JTextField();
		tfPro_ID.setBounds(231, 277, 100, 20);
		contentPane.add(tfPro_ID);
		tfPro_ID.setColumns(10);

		JLabel lblQuantity = new JLabel("Quantity in stock :");
		lblQuantity.setBounds(73, 305, 148, 22);
		lblQuantity.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 20));
		contentPane.add(lblQuantity);

		tfQ = new JTextField();
		tfQ.setBounds(231, 308, 46, 20);
		contentPane.add(tfQ);
		tfQ.setColumns(10);

		JButton btnPD = new JButton("");
		btnPD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPD.setBounds(221, 158, 100, 100);
		
		
		btnPD.setBackground(new Color(255, 255, 255));
		contentPane.add(btnPD);
		
		JLabel lblNewLabel = new JLabel("Select the Product");
		lblNewLabel.setBounds(159, 14, 285, 57);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 35));
		contentPane.add(lblNewLabel);
		
		JLabel lblGoToCalculate = new JLabel("go to calculate");
		lblGoToCalculate.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 20));
		lblGoToCalculate.setBounds(396, 228, 105, 35);
		contentPane.add(lblGoToCalculate);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(182, 84, 184, 28);
		contentPane.add(tfSearch);
		tfSearch.setColumns(10);
		
		JComboBox comboBoxPD = new JComboBox();
		comboBoxPD.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 20));
		comboBoxPD.setModel(new DefaultComboBoxModel(new String[] {"All", "Pro_ID", "Type", "Pattern", "Color", "Price"}));
		comboBoxPD.setSelectedIndex(0);
		comboBoxPD.setBounds(78, 82, 80, 30);
		contentPane.add(comboBoxPD);
		
		JButton btnSelect = new JButton("");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((pid!=null) && !tfSelect.getText().equals("0")) {
					productSelect.put(pid, Integer.parseInt(tfSelect.getText()));
				}
				
			}
		});
		btnSelect.setBounds(326, 333, 40, 40);
		contentPane.add(btnSelect);
		btnSelect.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\insert2.png")
				.getImage()
				.getScaledInstance(btnSelect.getWidth(), btnSelect.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnSelect.setBorderPainted(false);
		btnSelect.setContentAreaFilled(false);
		
		JLabel label = new JLabel("00/00");
		label.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 25));
		label.setBounds(252, 396, 50, 57);
		contentPane.add(label);
		
		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!conn.statusDB) {
					conn.connect();
				}
				try {
					switch (comboBoxPD.getSelectedIndex()) {
					case 0:
						qry = "SELECT * FROM clothes";
						break;
					case 1:
						qry = "SELECT * FROM clothes where Pro_ID = '" + tfSearch.getText() + "'";
						break;
					case 2:
						qry = "SELECT * FROM clothes where Type = '" + tfSearch.getText() + "'";
						break;
					case 3:
						qry = "SELECT * FROM clothes where Pattern = '" + tfSearch.getText() + "'";
						break;
					case 4:
						qry = "SELECT * FROM clothes where Color = '" + tfSearch.getText() + "'";
						break;
					case 5:
						qry = "SELECT * FROM clothes where Price = " + tfSearch.getText() ;
						break;
					case 6:
						qry = "SELECT * FROM clothes where Quantity = " + tfSearch.getText() ;
						break;
					case 7:
						qry = "SELECT * FROM clothes where Picture = '" + tfSearch.getText() +"'";
						break;	
					}
					System.out.println(qry);
					result = conn.stmt.executeQuery(qry);
					// ------------------------fine maximum value---------------------
					if (result.last()) {
						Rowsize = result.getRow();
						result.beforeFirst();
						
					}
					// ---------------------------end------------------------------

					if (result.next()) {
						tfSelect.setText("0");
						pid=result.getString("Pro_ID");
						tfPro_ID.setText(pid);
						tfQ.setText(result.getString("Quantity"));
						
						
						btnPD.setIcon(new ImageIcon(((new ImageIcon(Image.getAbsolutePath()+"\\"+result.getString("Picture"))).getImage())
								.getScaledInstance(btnPD.getWidth(), btnPD.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
						label.setText(Integer.toString(result.getRow()) + "/" + Integer.toString(Rowsize));
						
					}
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSearch.setBounds(396, 60, 60, 52);
		contentPane.add(btnSearch);
		btnSearch.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\search3.png")
				.getImage()
				.getScaledInstance(btnSearch.getWidth(), btnSearch.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnSearch.setBorderPainted(false);
		btnSearch.setContentAreaFilled(false);
		
		JButton btnFirst = new JButton("");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (result.first()) {
						tfSelect.setText("0");
						pid=result.getString("Pro_ID");
						tfPro_ID.setText(result.getString("Pro_ID"));
						tfQ.setText(result.getString("Quantity"));
						btnPD.setIcon(new ImageIcon(((new ImageIcon(Image.getAbsolutePath()+"\\"+result.getString("Picture"))).getImage())
								.getScaledInstance(btnPD.getWidth(), btnPD.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
						label.setText(Integer.toString(result.getRow()) + "/" + Integer.toString(Rowsize));
					}

					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnFirst.setBounds(71, 396, 67, 57);
		contentPane.add(btnFirst);
		btnFirst.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\first.png").getImage()
				.getScaledInstance(btnFirst.getWidth(), btnFirst.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnFirst.setContentAreaFilled(false);
		btnFirst.setBorderPainted(false);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (result.previous()) {
						tfSelect.setText("0");
						pid=result.getString("Pro_ID");
						tfPro_ID.setText(result.getString("Pro_ID"));
						tfQ.setText(result.getString("Quantity"));
						btnPD.setIcon(new ImageIcon(((new ImageIcon(Image.getAbsolutePath()+"\\"+result.getString("Picture"))).getImage())
								.getScaledInstance(btnPD.getWidth(), btnPD.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
						label.setText(Integer.toString(result.getRow()) + "/" + Integer.toString(Rowsize));
					}

					
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});
		btnBack.setBounds(159, 396, 67, 57);
		contentPane.add(btnBack);
		btnBack.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\previous.png").getImage()
				.getScaledInstance(btnBack.getWidth(), btnBack.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		
		JButton btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (result.next()) {
						tfSelect.setText("0");
						pid=result.getString("Pro_ID");
						tfPro_ID.setText(result.getString("Pro_ID"));
						tfQ.setText(result.getString("Quantity"));
						btnPD.setIcon(new ImageIcon(((new ImageIcon(Image.getAbsolutePath()+"\\"+result.getString("Picture"))).getImage())
								.getScaledInstance(btnPD.getWidth(), btnPD.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
						label.setText(Integer.toString(result.getRow()) + "/" + Integer.toString(Rowsize));
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNext.setBounds(316, 396, 67, 57);
		contentPane.add(btnNext);
		btnNext.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\next2.png").getImage()
				.getScaledInstance(btnNext.getWidth(), btnNext.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnNext.setContentAreaFilled(false);
		btnNext.setBorderPainted(false);
		
		JButton btnLast = new JButton("");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (result.last()) {
						tfSelect.setText("0");
						pid=result.getString("Pro_ID");
						tfPro_ID.setText(result.getString("Pro_ID"));
						tfQ.setText(result.getString("Quantity"));
						btnPD.setIcon(new ImageIcon(((new ImageIcon(Image.getAbsolutePath()+"\\"+result.getString("Picture"))).getImage())
								.getScaledInstance(btnPD.getWidth(), btnPD.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
						label.setText(Integer.toString(result.getRow()) + "/" + Integer.toString(Rowsize));
					}

					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLast.setBounds(407, 396, 67, 57);
		contentPane.add(btnLast);
		btnLast.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\last.png").getImage()
				.getScaledInstance(btnLast.getWidth(), btnLast.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnLast.setContentAreaFilled(false);
		btnLast.setBorderPainted(false);
		
		JLabel lbSelect = new JLabel("Select Quantity  :");
		lbSelect.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 20));
		lbSelect.setBounds(83, 337, 140, 22);
		contentPane.add(lbSelect);
		
		tfSelect = new JTextField();
		tfSelect.setBounds(231, 342, 46, 20);
		contentPane.add(tfSelect);
		tfSelect.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u0E15\u0E31\u0E27");
		lblNewLabel_1.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 20));
		lblNewLabel_1.setBounds(287, 312, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("\u0E15\u0E31\u0E27");
		label_1.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 20));
		label_1.setBounds(287, 345, 46, 14);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u0E40\u0E25\u0E37\u0E2D\u0E01\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		lblNewLabel_2.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 20));
		lblNewLabel_2.setBounds(373, 341, 115, 21);
		contentPane.add(lblNewLabel_2);
		
		
		JLabel lbCal = new JLabel("");
		lbCal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbCal.setBounds(0, 0, 829, 509);
		contentPane.add(lbCal);
		lbCal.setIcon(new ImageIcon(Image.getAbsolutePath()+"\\bgCal.jpg"));
	}
}
