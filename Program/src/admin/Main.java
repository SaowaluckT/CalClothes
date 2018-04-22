package admin;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Home.Home;
import connect.Connect;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField tfUser;
	private JTextField tfPass;
	private JTextField tfName;
	private JTextField tfSurname;
	private JTextField tfPhone;
	Connect conn = new Connect();
	String qry = null;
	ResultSet result = null;

	private JTextField tfSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public void clearTf() {
		tfUser.setText(null);
		tfPass.setText(null);
		tfName.setText(null);
		tfSurname.setText(null);
		tfPhone.setText(null);
	}

	public Main() {
		File Icon = new File("icon");
		File Image = new File("Image");
		setTitle("Admin");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\CalClothes\\Program\\icon\\users.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 353);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox cbbOption = new JComboBox();
		cbbOption.setBounds(10, 52, 86, 20);
		cbbOption.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 16));
		cbbOption.setModel(new DefaultComboBoxModel(new String[] {"Username", "Name", "Surname", "Phone"}));
		cbbOption.setSelectedIndex(0);
		contentPane.add(cbbOption);

		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setBounds(114, 12, 192, 26);
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 30));
		contentPane.add(lblAdmin);

		JButton btnHome = new JButton("");
		btnHome.setBounds(0, 0, 65, 38);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home home = new Home();
				home.setVisible(true);
			}

		});
		contentPane.add(btnHome);
		btnHome.setIcon(
				new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\home.png")
						.getImage().getScaledInstance(btnHome.getWidth(), btnHome.getHeight(),
								java.awt.Image.SCALE_AREA_AVERAGING)));

		btnHome.setBorderPainted(false);
		btnHome.setContentAreaFilled(false);

		JLabel lblUser = new JLabel("Username");
		lblUser.setBounds(11, 95, 85, 25);
		lblUser.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 20));
		contentPane.add(lblUser);

		JLabel lblPass = new JLabel("Password");
		lblPass.setBounds(19, 131, 86, 20);
		lblPass.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 20));
		contentPane.add(lblPass);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(32, 172, 73, 14);
		lblName.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 20));
		contentPane.add(lblName);

		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(32, 209, 73, 14);
		lblSurname.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 20));
		contentPane.add(lblSurname);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(32, 249, 73, 14);
		lblPhone.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 20));
		contentPane.add(lblPhone);

		tfUser = new JTextField();
		tfUser.setBounds(105, 92, 201, 26);
		contentPane.add(tfUser);
		tfUser.setColumns(10);

		tfPass = new JTextField();
		tfPass.setBounds(105, 129, 201, 26);
		tfPass.setColumns(10);
		contentPane.add(tfPass);

		tfName = new JTextField();
		tfName.setBounds(105, 166, 201, 26);
		tfName.setColumns(10);
		contentPane.add(tfName);

		tfSurname = new JTextField();
		tfSurname.setBounds(105, 203, 201, 27);
		tfSurname.setColumns(10);
		contentPane.add(tfSurname);

		tfPhone = new JTextField();
		tfPhone.setBounds(105, 243, 201, 26);
		tfPhone.setColumns(10);
		contentPane.add(tfPhone);

		tfSearch = new JTextField();
		tfSearch.setBounds(106, 49, 183, 26);
		tfSearch.setColumns(10);
		contentPane.add(tfSearch);

		JButton btnSearch = new JButton("");
		btnSearch.setBounds(302, 37, 38, 38);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn.connect();
				clearTf();
				try {
					switch (cbbOption.getSelectedIndex()) {
					case 0:
						qry = "SELECT * FROM members where Username = '" + tfSearch.getText() + "'";
						break;
					case 1:
						qry = "SELECT * FROM members where Name = '" + tfSearch.getText() + "'";
						break;
					case 2:
						qry = "SELECT * FROM members where Surname = '" + tfSearch.getText() + "'";
						break;
					case 3:
						qry = "SELECT * FROM members where Phone = '" + tfSearch.getText() + "'";
						break;
					}
					System.out.println(qry);
					result = conn.stmt.executeQuery(qry);
					// ------------------------fine maximum value---------------------
					if (result.last()) {
						
						result.beforeFirst();
					}
					// ---------------------------end------------------------------

					if (result.next()) {
						tfUser.setText(result.getString("Username"));
						tfName.setText(result.getString("Name"));
						tfSurname.setText(result.getString("Surname"));
						tfPhone.setText(result.getString("Phone"));
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				conn.disConnect();
			}
		});
		contentPane.add(btnSearch);
		btnSearch.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\search.png")
				.getImage()
				.getScaledInstance(btnSearch.getWidth(), btnSearch.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnSearch.setBorderPainted(false);
		btnSearch.setContentAreaFilled(false);

		JButton btnEdit = new JButton("");
		btnEdit.setBounds(386, 128, 38, 38);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn.connect();
				String qry1 = "UPDATE members SET UserName = '"
						+ tfUser.getText()
						+ "',"
						+ "Password = '"
						+ tfPass.getText()
						+ "',"
						+ "Name = '"
						+ tfName.getText()
						+ "',"
						+ "Surname = '"
						+ tfSurname.getText()
						+ "',"
						+ "Phone = '"
						+ tfPhone.getText()
						+ "'"
						+ " WHERE Username = '"
						+ tfUser.getText()
						+ "';";

				System.out.print(qry1);
				try {
					conn.stmt.execute(qry1);
				} catch (SQLException ee) {
					ee.printStackTrace();
				}
				conn.disConnect();

			}
		});
		contentPane.add(btnEdit);
		btnEdit.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\edit.png")
				.getImage()
				.getScaledInstance(btnEdit.getWidth(), btnEdit.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnEdit.setBorderPainted(false);
		btnEdit.setContentAreaFilled(false);

		JButton btnDel = new JButton("");
		btnDel.setBounds(386, 180, 38, 38);
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conn.connect();
				int confirm = JOptionPane.showConfirmDialog(null,
						"คุณต้องการจะลบคุณ " + tfUser.getText() + " ออกจากระบบหรือไม่ ?", "ยืนยันการลบผู้จัดการโปรแกรม",
						JOptionPane.OK_CANCEL_OPTION);
				if (confirm == 0) {
				String qry = "DELETE FROM members WHERE Username like '"
						+ tfSearch.getText()
						+"'";
				System.out.print(qry);
				try {
					conn.stmt.executeUpdate(qry);
					clearTf();
				} catch (SQLException e) {
					System.out.print(e);
				}
				}
				conn.disConnect();
			}
		});
		contentPane.add(btnDel);
		btnDel.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\delete.png")
				.getImage()
				.getScaledInstance(btnDel.getWidth(), btnDel.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnDel.setBorderPainted(false);
		btnDel.setContentAreaFilled(false);

		
		JButton btnInsert = new JButton("");
		btnInsert.setBounds(386, 74, 38, 38);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn.connect();
				try {
				
				qry = "INSERT INTO members(Username,Password,Name,Surname,Phone) VALUES ('" + tfUser.getText() + "','"
						+ tfPass.getText() + "','" + tfName.getText() + "','" + tfSurname.getText() + "','"
						+ tfPhone.getText() + "')";
				System.out.println(qry);
			
					conn.stmt.executeUpdate(qry);
				} catch (SQLException ee) {
					ee.printStackTrace();
				}
				conn.disConnect();

			}
		});
		contentPane.add(btnInsert);
		btnInsert.setIcon(new ImageIcon(
				new ImageIcon(Icon.getAbsolutePath()+"\\Add.png").getImage().getScaledInstance(
						btnInsert.getWidth(), btnInsert.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnInsert.setBorderPainted(false);
		btnInsert.setContentAreaFilled(false);

		JButton btnReload = new JButton("");
		btnReload.setBounds(386, 231, 38, 38);
		contentPane.add(btnReload);
		btnReload.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\reload.png")
				.getImage()
				.getScaledInstance(btnReload.getWidth(), btnReload.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnReload.setBorderPainted(false);
		btnReload.setContentAreaFilled(false);
		
		JLabel lbAdmin = new JLabel("");
		lbAdmin.setBounds(0, 0, 468, 324);
		contentPane.add(lbAdmin);

		lbAdmin.setIcon(new ImageIcon(Image.getAbsolutePath()+"\\bgAdmin.jpg"));
		contentPane.add(lbAdmin);
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfSearch.setText(null);
				clearTf();
			}
		});

	}
}
