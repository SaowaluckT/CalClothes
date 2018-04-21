package cal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Home.Home;
import connect.Connect;
import net.proteanit.sql.DbUtils;
import Calculate.calculate;

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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class summary extends JFrame {

	Connect conn = new Connect();
	String qry = null;
	ResultSet result = null;
	
	private JPanel contentPane;
	private JTextField txtPriceSummary;
	private JTextField tfPrice;
	private JTextField tfVat;
	private JTextField tfTotPrice;
	private JTable table;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					summary frame = new summary();
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
	public summary() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtPriceSummary = new JTextField();
		txtPriceSummary.setBounds(146, 36, 333, 47);
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
		btHome.setBounds(29, 36, 87, 51);
		btHome.setIcon(new ImageIcon(new ImageIcon("D:\\CalClothes\\Program\\src\\Home\\home.png")
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
				calculate ca = new calculate();
				ca.setVisible(true);
			}
		});
		contentPane.add(btnBack);
		btnBack.setIcon(new ImageIcon(new ImageIcon("D:\\CalClothes\\icon\\back.png").getImage()
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
		tfVat.setColumns(10);
		tfVat.setBounds(441, 383, 152, 25);
		contentPane.add(tfVat);
		
		tfTotPrice = new JTextField();
		tfTotPrice.setColumns(10);
		tfTotPrice.setBounds(441, 417, 152, 25);
		contentPane.add(tfTotPrice);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(146, 110, 453, 202);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String qry = "SELECT * FROM clothes ";
					result =  conn.stmt.executeQuery(qry);
					table.setModel(DbUtils.resultSetToTableModel(result));

					System.out.println(qry);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		});

	}
}
