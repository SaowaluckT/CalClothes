package EditDelete;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
	Connection conn = null;
	String qry = null;
	Statement stment = null ;
	ResultSet rs = null;
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
		
		try
		{
			
			
			conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/User/Desktop/CalClothes/DB.mdb", "", "");
			stment = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE,ResultSet.TYPE_SCROLL_SENSITIVE);
			
		} catch (SQLException e2)
		{
			e2.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 469);
		frame = new JPanel();
		frame.setBackground(Color.ORANGE);
		frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frame);
		frame.setLayout(null);
		
		JLabel lblEditdelete = new JLabel("Edit/Delete");
		lblEditdelete.setForeground(Color.BLACK);
		lblEditdelete.setBackground(Color.WHITE);
		lblEditdelete.setBounds(127, 6, 107, 31);
		frame.add(lblEditdelete);
		
		JLabel label = new JLabel("\u0E04\u0E49\u0E19\u0E2B\u0E32\u0E23\u0E2B\u0E31\u0E2A\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		label.setBackground(Color.GREEN);
		label.setBounds(31, 78, 128, 14);
		frame.add(label);
		
		JButton btHome = new JButton("");
		btHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btHome.setBackground(Color.ORANGE);
		btHome.setBounds(28, 6, 71, 52);
		frame.add(btHome);
		btHome.setIcon(new ImageIcon(((new ImageIcon("C:\\Users\\User\\Desktop\\icon\\home.png")).getImage()).getScaledInstance(btHome.getWidth(), btHome.getHeight(),java.awt.Image.SCALE_AREA_AVERAGING)));
		
		tfSearch = new JTextField();
		tfSearch.setBounds(127, 70, 150, 31);
		frame.add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btSearch = new JButton("");
		btSearch.setBackground(Color.ORANGE);
		btSearch.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent arg0) {
				try {
						qry = "SELECT * FROM clothes where Pro_ID = '" +
						tfSearch.getText() + "'";
						
						rs = stment.executeQuery(qry);
					   
						if (rs.last()) {
							  Rowsize = rs.getRow();
					          rs.beforeFirst(); 
					    }
						
						
						if (rs.next()) {
							tfPro_ID.setText(rs.getString("Pro_ID"));
							tfType.setText(rs.getString("Type"));
							tfTexture.setText(rs.getString("Pattern"));
							tfColor.setText(rs.getString("Color"));
							tfPrice.setText(rs.getString("Price"));
							//tfPicture.setText(rs.getString("Pic_Name"));
							
						}						
						//lbDBBar.setText(Integer.toString(rs.getRow()) + "/" + Integer.toString(Rowsize));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btSearch.setBounds(289, 70, 39, 31);
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
		btDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btDelete.setBackground(Color.RED);
		btDelete.setForeground(Color.WHITE);
		btDelete.setBounds(228, 396, 89, 23);
		frame.add(btDelete);
		
		JButton btEdit = new JButton("Edit");
		btEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String qry = "UPDATE clothes SET Pro_ID = '" + tfPro_ID.getText() + "',Type = '"
						+ tfType.getText() + "',Texture= '" + tfTexture.getText() + "',Color= '" + tfColor.getText()
						+ "',Price= '" + tfPrice.getText();
				try {
					stment.executeUpdate(qry);
					}
				catch (SQLException e2) {
					e2.printStackTrace();
					}
			}
		});
		btEdit.setForeground(Color.WHITE);
		btEdit.setBackground(Color.BLUE);
		btEdit.setBounds(327, 396, 89, 23);
		frame.add(btEdit);
	}
}