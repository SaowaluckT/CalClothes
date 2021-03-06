package calculate;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connect.Connect;
import home.Home;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class Summary extends JFrame {

	Connect conn = new Connect();
	String qry = null;
	ResultSet result = null;
	
	private JPanel contentPane;
	private JTextField txtPriceSummary;
	private JTextField tfPrice;
	private JTextField tfVat;
	private JTextField tfTotPrice;
	private JTable table;
	public Map<String, Integer> productSelect = new HashMap<String, Integer>(); //ประกาศวัตถุเก็บค่าตัวแปรหลายค่า
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Summary frame = new Summary();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setAlwaysOnTop(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Summary() {
		File Icon = new File("icon");
		File Image = new File("Image");
		setTitle("Summary product price");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Icon.getAbsolutePath()+"\\cal2.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtPriceSummary = new JTextField();
		txtPriceSummary.setBounds(257, 11, 333, 47);
		txtPriceSummary.setHorizontalAlignment(SwingConstants.CENTER);
		txtPriceSummary.setForeground(new Color(218, 112, 214));
		txtPriceSummary.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 35));
		txtPriceSummary.setText("Price Summary");
		txtPriceSummary.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Price =");
		lblNewLabel.setForeground(new Color(255, 160, 122));
		lblNewLabel.setBounds(510, 341, 80, 25);
		lblNewLabel.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 30));
		
		JLabel lblNewLabel_1 = new JLabel("VAT 7% =");
		lblNewLabel_1.setForeground(new Color(255, 160, 122));
		lblNewLabel_1.setBounds(485, 377, 96, 25);
		lblNewLabel_1.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 30));
		
		JLabel lblNewLabel_2 = new JLabel("Total Price =");
		lblNewLabel_2.setForeground(new Color(255, 160, 122));
		lblNewLabel_2.setBounds(445, 413, 145, 25);
		lblNewLabel_2.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 30));
		
		JButton btHome = new JButton("");
		btHome.setBounds(10, 11, 59, 47);
		btHome.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\home.png")
				.getImage().getScaledInstance(btHome.getWidth(), btHome.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		 
		btHome.setBorderPainted(false); 
		btHome.setContentAreaFilled(false);
		btHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Home.main(null);
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btHome);
		contentPane.add(txtPriceSummary);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("");
		btnBack.setBounds(25, 404, 80, 51);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Calculate.main(null);
			}
		});
		contentPane.add(btnBack);
		btnBack.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\back.png").getImage()
				.getScaledInstance(btnBack.getWidth(), btnBack.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));

		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
		
		JButton btnLoadData = new JButton("Load");
		btnLoadData.setForeground(new Color(128, 128, 128));
		btnLoadData.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 25));
		btnLoadData.setBounds(25, 128, 80, 39);
		contentPane.add(btnLoadData);
		
		tfPrice = new JTextField();
		tfPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		tfPrice.setBounds(595, 341, 152, 25);
		contentPane.add(tfPrice);
		tfPrice.setColumns(10);
		
		tfVat = new JTextField();
		tfVat.setHorizontalAlignment(SwingConstants.RIGHT);
		tfVat.setBounds(595, 377, 152, 25);
		tfVat.setColumns(10);
		contentPane.add(tfVat);
		
		tfTotPrice = new JTextField();
		tfTotPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		tfTotPrice.setBounds(595, 411, 152, 25);
		tfTotPrice.setColumns(10);
		contentPane.add(tfTotPrice);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(115, 128, 632, 202);
		contentPane.add(scrollPane);
		
		DefaultTableModel model = new DefaultTableModel();
		table = new JTable(model);
		model.addColumn("Product ID");
	    model.addColumn("Type");
	    model.addColumn("Pattern");
	    model.addColumn("Color");
	    model.addColumn("Price");
	    model.addColumn("Quantity");
	    model.addColumn("Product Select");
	    
		scrollPane.setViewportView(table);
		
		
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				model.setRowCount(0); //พื้นที่แสดงตาราง
				if(!productSelect.isEmpty()) {
					conn.connect();
					try {
						int sum=0;
						for ( String key : productSelect.keySet() ) {
							qry = "SELECT * FROM clothes WHERE Pro_ID='"+key+"'";
	
							System.out.println(qry);
							result =  conn.stmt.executeQuery(qry);
							if (result.next()) {
								sum += Integer.parseInt(result.getString("Price"))*productSelect.get(key); //ราคา x จำนวนสินค้าที่เลือก(ขาย)=ราคารวม
								model.addRow(new Object[] { 
										result.getString("Pro_ID"),
										result.getString("Type"),
										result.getString("Pattern"),
										result.getString("Color"),
										result.getString("Price"),
										result.getString("Quantity"),
										productSelect.get(key)
								});
								productSelect.put(key, Integer.parseInt(result.getString("Quantity"))-productSelect.get(key));
							}
						}
						DecimalFormat df = new DecimalFormat("#.##");
						tfTotPrice.setText(String.valueOf(df.format(sum+sum*0.07)));
						tfVat.setText(String.valueOf(df.format(sum*0.07))); //คิดภาษี
						tfPrice.setText(String.valueOf(sum));
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						for ( String key : productSelect.keySet() ) {
							qry = "UPDATE clothes SET Quantity = "+productSelect.get(key)+" WHERE Pro_ID='"+key+"'"; //อัปเดตจำนวนสินค้าที่เหลือในสตีอกสินค้า
							
							System.out.println(qry);
							conn.stmt.executeUpdate(qry);
						}
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					conn.disConnect();
				}else {
					JOptionPane.showMessageDialog(null, "Please select product!","WARNING!",JOptionPane.WARNING_MESSAGE);
					
				}
				
			}
		});
		
		JLabel lbBG = new JLabel("");
		lbBG.setIcon(new ImageIcon(Image.getAbsolutePath()+"\\bgSum.jpg"));
		lbBG.setBounds(0, 0, 796, 481);
		contentPane.add(lbBG);

	}
}
