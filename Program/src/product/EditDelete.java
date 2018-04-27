package product;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connect.Connect;
import home.Home;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class EditDelete extends JFrame {

	private JPanel frame;
	private JTextField tfSearch;
	private JTextField tfPro_ID;
	private JTextField tfPattern;
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
	private JTextField tfQuantity;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditDelete frame = new EditDelete();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setAlwaysOnTop(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public void clearTf() { //สร้าง method เพื่อทำให้ text field เป็น null
	
		tfSearch.setText(null);
		tfPro_ID.setText(null);
		tfPattern.setText(null);
		tfColor.setText(null);
		tfPrice.setText(null);
		tfQuantity.setText(null);
		tfPicture.setText(null);
	}
	
	/**
	 * Create the frame.
	 */

	public EditDelete() {
		File Icon = new File("icon");
		setTitle("Edit and Delete the Product");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Icon.getAbsolutePath()+"\\edit.png"));	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 470);
		frame = new JPanel();
		frame.setBackground(new Color(255, 250, 205));
		frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frame);
		frame.setLayout(null);

		
		JComboBox cbType = new JComboBox();
		cbType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbType.setModel(new DefaultComboBoxModel(new String[] {"Shirt", "Dress"}));
		cbType.setBounds(347, 122, 166, 21);
		frame.add(cbType);
		
		JLabel lblEditdelete = new JLabel("Edit/Delete");
		lblEditdelete.setBounds(111, 21, 216, 41);
		lblEditdelete.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 35));
		lblEditdelete.setForeground(Color.BLACK);
		lblEditdelete.setBackground(Color.WHITE);
		frame.add(lblEditdelete);

		JLabel lblSearchProductId = new JLabel(
				"Search Product ID");
		lblSearchProductId.setBounds(31, 78, 140, 14);
		lblSearchProductId.setFont(new Font("5103_tLU_JIUMJIUM", Font.PLAIN, 18));
		lblSearchProductId.setBackground(Color.GREEN);
		frame.add(lblSearchProductId);

		
		JButton btnHome = new JButton("");
		btnHome.setBounds(10, 2, 60, 60);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Home.main(null);
			}
		});
		btnHome.setBackground(Color.ORANGE);
		btnHome.setIcon(new ImageIcon(((new ImageIcon(Icon.getAbsolutePath()+"\\home.png")).getImage())
				.getScaledInstance(btnHome.getWidth(), btnHome.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		frame.add(btnHome);
		btnHome.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\home.png").getImage()
				.getScaledInstance(btnHome.getWidth(), btnHome.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));

		btnHome.setBorderPainted(false);
		btnHome.setContentAreaFilled(false);

		tfSearch = new JTextField();
		tfSearch.setBounds(143, 70, 150, 31);
		frame.add(tfSearch);
		tfSearch.setColumns(10);



		JLabel lblProid = new JLabel("Product ID");
		lblProid.setBounds(31, 126, 68, 14);
		lblProid.setFont(new Font("5103_tLU_JIUMJIUM", Font.PLAIN, 18));
		frame.add(lblProid);

		JLabel lblType = new JLabel("Type");
		lblType.setBounds(301, 122, 46, 23);
		lblType.setFont(new Font("5103_tLU_JIUMJIUM", Font.PLAIN, 18));
		frame.add(lblType);

		JLabel lblTexture = new JLabel("Pattern");
		lblTexture.setBounds(53, 182, 46, 14);
		lblTexture.setFont(new Font("5103_tLU_JIUMJIUM", Font.PLAIN, 18));
		frame.add(lblTexture);

		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(301, 182, 46, 14);
		lblColor.setFont(new Font("5103_tLU_JIUMJIUM", Font.PLAIN, 18));
		frame.add(lblColor);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(301, 234, 46, 14);
		lblPrice.setFont(new Font("5103_tLU_JIUMJIUM", Font.PLAIN, 18));
		frame.add(lblPrice);

		JLabel lblPicture = new JLabel("Picture");
		lblPicture.setBounds(53, 234, 46, 14);
		lblPicture.setFont(new Font("5103_tLU_JIUMJIUM", Font.PLAIN, 18));
		frame.add(lblPicture);

		tfPro_ID = new JTextField();
		tfPro_ID.setBounds(111, 117, 166, 31);
		frame.add(tfPro_ID);
		tfPro_ID.setColumns(10);

		tfPattern = new JTextField();
		tfPattern.setBounds(111, 174, 166, 31);
		frame.add(tfPattern);
		tfPattern.setColumns(10);

		tfColor = new JTextField();
		tfColor.setBounds(347, 174, 166, 31);
		frame.add(tfColor);
		tfColor.setColumns(10);

		tfPrice = new JTextField();
		tfPrice.setBounds(347, 226, 166, 31);
		frame.add(tfPrice);
		tfPrice.setColumns(10);

		tfPicture = new JTextField();
		tfPicture.setBounds(111, 226, 166, 31);
		frame.add(tfPicture);
		tfPicture.setColumns(10);

		JButton btDelete = new JButton("");
		btDelete.setBounds(356, 370, 91, 31);
		btDelete.setEnabled(false);
		btDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					conn.connect();
				
				int confirm = JOptionPane.showConfirmDialog(null,
						"Delete ''" + tfPro_ID.getText() + "'' ?", "Confirm",JOptionPane.OK_CANCEL_OPTION);//ถามเพื่อยืนยันการลบ
				if (confirm == 0) {
					String qry = "DELETE FROM clothes WHERE Pro_ID like '" + tfPro_ID.getText() + "'";
					System.out.print(qry);
					try {
						conn.stmt.executeUpdate(qry);
						JOptionPane.showMessageDialog(null, "Delete product ID: ''"+ tfPro_ID.getText()+ "'' successfully");
					} catch (SQLException e) {
						System.out.print(e);
					}
				}
				conn.disConnect();
				clearTf();
				cbType.setSelectedIndex(0);
			}
		});
		btDelete.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\btDe.png").getImage()
				.getScaledInstance(btDelete.getWidth(), btDelete.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btDelete.setBorderPainted(false);
		btDelete.setContentAreaFilled(false);
		frame.add(btDelete);

		JButton btEdit = new JButton("");
		btEdit.setBounds(242, 365, 100, 41);
		btEdit.setEnabled(false);
		btEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conn.connect();
				String qry = "UPDATE clothes SET Pro_ID = '" 
				+ tfPro_ID.getText() 
				+ "', Type = '" 
				+ cbType.getSelectedItem().toString()	
				+ "', Pattern = '" 
				+ tfPattern.getText() 
				+ "', Color = '" 
				+ tfColor.getText() 
				+ "', Price = "		
				+ tfPrice.getText() 
				+ ", Quantity = "
				+ tfQuantity.getText()
				+ ", Picture = '"
				+ tfPicture.getText()
				+ "'"
				+ " WHERE Pro_ID = '" 
				+ tfPro_ID.getText() 
				+ "';";  //สร้าง SQL ในการลบข้อมูล

				System.out.println(qry);
				try {
					conn.stmt.execute(qry);
					JOptionPane.showMessageDialog(null, "Edit  product ID: ''"+ tfPro_ID.getText()+ "'' successfully");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn.disConnect();
				clearTf();
			}
		});
		frame.add(btEdit);
		btEdit.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\btEd.png").getImage()
				.getScaledInstance(btEdit.getWidth(), btEdit.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btEdit.setBorderPainted(false);
		btEdit.setContentAreaFilled(false);

		JButton btnBack = new JButton("");
		btnBack.setBounds(10, 365, 71, 55);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Stock.main(null);
			}
		});
		frame.add(btnBack);
		btnBack.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\back.png").getImage()
				.getScaledInstance(btnBack.getWidth(), btnBack.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));

		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
		
		tfQuantity = new JTextField();
		tfQuantity.setBounds(111, 277, 166, 31);
		tfQuantity.setColumns(10);
		frame.add(tfQuantity);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(42, 285, 60, 14);
		lblQuantity.setFont(new Font("5103_tLU_JIUMJIUM", Font.PLAIN, 18));
		frame.add(lblQuantity);
		
		JButton btnRefresh = new JButton("");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearTf();
				cbType.setSelectedIndex(0);
			}
		});
		btnRefresh.setBounds(467, 365, 46, 41);
		frame.add(btnRefresh);
		btnRefresh.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\reload.png")
				.getImage()
				.getScaledInstance(btnRefresh.getWidth(), btnRefresh.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnRefresh.setBorderPainted(false);
		btnRefresh.setContentAreaFilled(false);
		
		JButton btSearch = new JButton("");
		btSearch.setBounds(303, 70, 39, 31);
		btSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				conn.connect();
				try {
					qry = "SELECT * FROM clothes where Pro_ID = '" + tfSearch.getText() + "'";

					result = conn.stmt.executeQuery(qry);

					if (result.last()) {
						Rowsize = result.getRow();
						result.beforeFirst();
					}

					if (result.next()) {
						tfPro_ID.setText(result.getString("Pro_ID"));

						tfPattern.setText(result.getString("Pattern"));
						tfColor.setText(result.getString("Color"));
						tfPrice.setText(result.getString("Price"));
						tfQuantity.setText(result.getString("Quantity"));
						tfPicture.setText(result.getString("Picture"));
						if (result.getString("Type").equals("Shirt")) 
						{
							cbType.setSelectedIndex(0);
						} else
						{
							cbType.setSelectedIndex(1);
						}
						btDelete.setEnabled(true);
						btEdit.setEnabled(true);
							
					}else {
						JOptionPane.showMessageDialog(null, "Did not find information");
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				conn.disConnect();
				
			}
		});
		frame.add(btSearch);
		btSearch.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\search2.png").getImage()
				.getScaledInstance(btSearch.getWidth(), btSearch.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btSearch.setBorderPainted(false);
		btSearch.setContentAreaFilled(false);
	}
}