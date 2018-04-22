package cal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Home.Home;
import connect.Connect;
import net.proteanit.sql.DbUtils;
import Calculate.Calculate;

import net.proteanit.sql.DbUtils;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.PreparedStatement;
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
	public Map<String, Integer> productSelect = new HashMap<String, Integer>();
	
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
	public Summary() {
		File Icon = new File("icon");
		setTitle("Summary product price");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Icon.getAbsolutePath()+"\\cal2.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtPriceSummary = new JTextField();
		txtPriceSummary.setBounds(146, 11, 333, 47);
		txtPriceSummary.setHorizontalAlignment(SwingConstants.CENTER);
		txtPriceSummary.setForeground(new Color(0, 0, 0));
		txtPriceSummary.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 35));
		txtPriceSummary.setText("Price Summary");
		txtPriceSummary.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Price =");
		lblNewLabel.setBounds(364, 347, 72, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("VAT 7% =");
		lblNewLabel_1.setBounds(333, 383, 94, 25);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("Total Price =");
		lblNewLabel_2.setBounds(310, 419, 126, 25);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btHome = new JButton("");
		btHome.setBounds(10, 11, 59, 47);
		btHome.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\home.png")
				.getImage().getScaledInstance(btHome.getWidth(), btHome.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		 
		btHome.setBorderPainted(false); 
		btHome.setContentAreaFilled(false);
		btHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Home home = new Home();
				home.setVisible(true);
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btHome);
		contentPane.add(txtPriceSummary);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("New button");
		btnBack.setBounds(25, 404, 80, 51);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Calculate ca = new Calculate();
				ca.setVisible(true);
			}
		});
		contentPane.add(btnBack);
		btnBack.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\back.png").getImage()
				.getScaledInstance(btnBack.getWidth(), btnBack.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));

		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
		
		JButton btnLoadData = new JButton("Load");
		btnLoadData.setBounds(29, 117, 80, 39);
		contentPane.add(btnLoadData);
		
		tfPrice = new JTextField();
		tfPrice.setBounds(441, 347, 152, 25);
		contentPane.add(tfPrice);
		tfPrice.setColumns(10);
		
		tfVat = new JTextField();
		tfVat.setBounds(441, 383, 152, 25);
		tfVat.setColumns(10);
		contentPane.add(tfVat);
		
		tfTotPrice = new JTextField();
		tfTotPrice.setBounds(441, 417, 152, 25);
		tfTotPrice.setColumns(10);
		contentPane.add(tfTotPrice);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(140, 128, 453, 202);
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
				conn.connect();
				try {
					model.setRowCount(0);
					int sum=0;
					for ( String key : productSelect.keySet() ) {
						String qry = "SELECT * FROM clothes WHERE Pro_ID='"+key+"'";

						System.out.println(qry);
						result =  conn.stmt.executeQuery(qry);
						if (result.next()) {
							sum += Integer.parseInt(result.getString("Price"))*productSelect.get(key);
							model.addRow(new Object[] {
									result.getString("Pro_ID"),
									result.getString("Type"),
									result.getString("Pattern"),
									result.getString("Color"),
									result.getString("Price"),
									result.getString("Quantity"),
									productSelect.get(key)
							});
						}
					}
					DecimalFormat df = new DecimalFormat();
					df.setMaximumFractionDigits(2);
					tfTotPrice.setText(String.valueOf(df.format(sum+sum*0.07)));
					tfVat.setText(String.valueOf(sum*0.07));
					tfPrice.setText(String.valueOf(sum));
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn.disConnect();
			}
		});

	}
}
