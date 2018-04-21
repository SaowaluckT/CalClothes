package EditDelete;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Home.Home;
import Stock.stock;
import connect.Connect;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class EditDelete extends JFrame {

	private JPanel frame;
	private JTextField tfSearch;
	private JTextField tfPro_ID;
	private JTextField tfType;
	private JTextField tfTexture;
	private JTextField tfColor;
	private JTextField tfPrice;
	private JTextField tfPicture;

	/**
	 * Launch the application.
	 */
	Connect conn = new Connect();
	String qry = null;
	ResultSet result = null;
	int Rowsize;
	Statement s = null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditDelete frame = new EditDelete();
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
	
	public EditDelete() {
		initialize();
				 
	}
	public void initialize() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 470);
		frame = new JPanel();
		frame.setBackground(Color.ORANGE);
		frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frame);
		frame.setLayout(null);
		
		JLabel lblEditdelete = new JLabel("Edit/Delete");
		lblEditdelete.setBounds(127, 6, 107, 31);
		lblEditdelete.setForeground(Color.BLACK);
		lblEditdelete.setBackground(Color.WHITE);
		frame.add(lblEditdelete);
		
		JLabel label = new JLabel("\u0E04\u0E49\u0E19\u0E2B\u0E32\u0E23\u0E2B\u0E31\u0E2A\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		label.setBounds(31, 78, 128, 14);
		label.setBackground(Color.GREEN);
		frame.add(label);
		
		JButton btnHome = new JButton("");
		btnHome.setBounds(10, 2, 60, 60);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Home home = new Home();
				home.setVisible(true);
			}
		});
		btnHome.setBackground(Color.ORANGE);
		btnHome.setIcon(new ImageIcon(((new ImageIcon("D:\\Proj\\CalClothes\\icon\\home.png")).getImage()).getScaledInstance(btnHome.getWidth(), btnHome.getHeight(),java.awt.Image.SCALE_AREA_AVERAGING)));
		frame.add(btnHome);
		btnHome.setIcon(new ImageIcon(new ImageIcon("D:\\CalClothes\\Program\\bin\\Home\\home.png")
						.getImage().getScaledInstance(btnHome.getWidth(), btnHome.getHeight(),
								java.awt.Image.SCALE_AREA_AVERAGING)));

		btnHome.setBorderPainted(false);
		btnHome.setContentAreaFilled(false);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(127, 70, 150, 31);
		frame.add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btSearch = new JButton("");
		btSearch.setBounds(289, 70, 39, 31);
		btSearch.setBackground(Color.ORANGE);
		btSearch.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent arg0) {
				try {
						qry = "SELECT * FROM clothes where Pro_ID = '" +
						tfSearch.getText() + "'";
						
						result = conn.stmt.executeQuery(qry);
					   
						if (result.last()) {
							  Rowsize = result.getRow();
							  result.beforeFirst(); 
					    }
						
						
						if (result.next()) {
							tfPro_ID.setText(result.getString("Pro_ID"));
							tfType.setText(result.getString("Type"));
							tfTexture.setText(result.getString("Pattern"));
							tfColor.setText(result.getString("Color"));
							tfPrice.setText(result.getString("Price"));
							//tfPicture.setText(rs.getString("Pic_Name"));
							
						}						
						//lbDBBar.setText(Integer.toString(rs.getRow()) + "/" + Integer.toString(Rowsize));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		frame.add(btSearch);
		btSearch.setIcon(new ImageIcon(((new ImageIcon("C:\\Users\\User\\Desktop\\icon\\search.png")).getImage()).getScaledInstance(btSearch.getWidth(), btSearch.getHeight(),java.awt.Image.SCALE_AREA_AVERAGING)));
		
		
		JLabel lblProid = new JLabel("Pro_ID");
		lblProid.setBounds(53, 125, 46, 14);
		frame.add(lblProid);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(53, 171, 46, 14);
		frame.add(lblType);
		
		JLabel lblTexture = new JLabel("Texture");
		lblTexture.setBounds(53, 213, 46, 14);
		frame.add(lblTexture);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(53, 255, 46, 14);
		frame.add(lblColor);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(53, 297, 46, 14);
		frame.add(lblPrice);
		
		JLabel lblPicture = new JLabel("Picture");
		lblPicture.setBounds(53, 339, 46, 14);
		frame.add(lblPicture);
		
		tfPro_ID = new JTextField();
		tfPro_ID.setBounds(111, 117, 166, 31);
		frame.add(tfPro_ID);
		tfPro_ID.setColumns(10);
		
		tfType = new JTextField();
		tfType.setBounds(111, 163, 166, 31);
		frame.add(tfType);
		tfType.setColumns(10);
		
		tfTexture = new JTextField();
		tfTexture.setBounds(111, 205, 166, 31);
		frame.add(tfTexture);
		tfTexture.setColumns(10);
		
		tfColor = new JTextField();
		tfColor.setBounds(111, 247, 166, 31);
		frame.add(tfColor);
		tfColor.setColumns(10);
		
		tfPrice = new JTextField();
		tfPrice.setBounds(111, 289, 166, 31);
		frame.add(tfPrice);
		tfPrice.setColumns(10);
		
		tfPicture = new JTextField();
		tfPicture.setBounds(111, 331, 166, 31);
		frame.add(tfPicture);
		tfPicture.setColumns(10);
		
		JButton btDelete = new JButton("Delete");
		btDelete.setBounds(228, 396, 89, 23);
		btDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btDelete.setBackground(Color.RED);
		btDelete.setForeground(Color.WHITE);
		frame.add(btDelete);
		
		JButton btEdit = new JButton("Edit");
		btEdit.setBounds(327, 396, 89, 23);
		btEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String qry = "UPDATE clothes SET Pro_ID = '" + tfPro_ID.getText() + "',Type = '"
							+ tfType.getText() + "',Texture= '" + tfTexture.getText() + "',Color= '" + tfColor.getText()
							+ "',Price= '" + tfPrice.getText();
					result = conn.stmt.executeQuery(qry);
					}
				catch (SQLException e2) {
					e2.printStackTrace();
					}
			}
		});
		btEdit.setForeground(Color.WHITE);
		btEdit.setBackground(Color.BLUE);
		frame.add(btEdit);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				stock st = new stock();
				st.setVisible(true);
			}
		});
		btnBack.setBounds(10, 364, 71, 55);
		frame.add(btnBack);
		btnBack.setIcon(new ImageIcon(new ImageIcon("D:\\CalClothes\\icon\\back.png")
						.getImage().getScaledInstance(btnBack.getWidth(), btnBack.getHeight(),
								java.awt.Image.SCALE_AREA_AVERAGING)));

		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
		
	}
}