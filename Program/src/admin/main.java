package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class main extends JFrame {

	private JPanel contentPane;
	private JTextField tfUser;
	private JTextField tfPass;
	private JTextField tfName;
	private JTextField tfSurname;
	private JTextField tfPhone;
	Connect conn = new Connect();
	String qry = null;
	ResultSet result = null;
	int Rowsize;
	private JTextField tfSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
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
	public void clearTf() {
		tfUser.setText(null);
		tfPass.setText(null);
		tfName.setText(null);
		tfSurname.setText(null);
		tfPhone.setText(null);
	}

	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 353);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox cbbOption = new JComboBox();
		cbbOption.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 16));
		cbbOption.setModel(new DefaultComboBoxModel(new String[] {"Username", "Name", "Surname", "Phone"}));
		cbbOption.setSelectedIndex(0);
		cbbOption.setBounds(10, 49, 86, 20);
		contentPane.add(cbbOption);

		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 30));
		lblAdmin.setBounds(114, 12, 192, 26);
		contentPane.add(lblAdmin);

		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home home = new Home();
				home.setVisible(true);
			}

		});
		btnHome.setBounds(0, 0, 65, 38);
		contentPane.add(btnHome);
		btnHome.setIcon(
				new ImageIcon(new ImageIcon("D:\\CalClothes\\Program\\bin\\Home\\home.png")
						.getImage().getScaledInstance(btnHome.getWidth(), btnHome.getHeight(),
								java.awt.Image.SCALE_AREA_AVERAGING)));

		btnHome.setBorderPainted(false);
		btnHome.setContentAreaFilled(false);

		JLabel lblUser = new JLabel("Username");
		lblUser.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 16));
		lblUser.setBounds(32, 91, 73, 14);
		contentPane.add(lblUser);

		JLabel lblPass = new JLabel("Password");
		lblPass.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 16));
		lblPass.setBounds(32, 128, 73, 14);
		contentPane.add(lblPass);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 16));
		lblName.setBounds(32, 165, 73, 14);
		contentPane.add(lblName);

		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 16));
		lblSurname.setBounds(32, 203, 73, 14);
		contentPane.add(lblSurname);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 16));
		lblPhone.setBounds(32, 235, 73, 14);
		contentPane.add(lblPhone);

		tfUser = new JTextField();
		tfUser.setBounds(105, 85, 201, 26);
		contentPane.add(tfUser);
		tfUser.setColumns(10);

		tfPass = new JTextField();
		tfPass.setColumns(10);
		tfPass.setBounds(105, 122, 201, 26);
		contentPane.add(tfPass);

		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(105, 159, 201, 26);
		contentPane.add(tfName);

		tfSurname = new JTextField();
		tfSurname.setColumns(10);
		tfSurname.setBounds(105, 197, 201, 27);
		contentPane.add(tfSurname);

		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(105, 229, 201, 26);
		contentPane.add(tfPhone);

		tfSearch = new JTextField();
		tfSearch.setColumns(10);
		tfSearch.setBounds(106, 49, 183, 26);
		contentPane.add(tfSearch);

		JLabel label = new JLabel("0/0");
		label.setBounds(177, 276, 46, 27);
		contentPane.add(label);

		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
						Rowsize = result.getRow();
						result.beforeFirst();
					}
					// ---------------------------end------------------------------

					if (result.next()) {
						tfUser.setText(result.getString("Username"));
						tfName.setText(result.getString("Name"));
						tfSurname.setText(result.getString("Surname"));
						tfPhone.setText(result.getString("Phone"));
					}
					label.setText(Integer.toString(result.getRow()) + "/" + Integer.toString(Rowsize));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnSearch.setBounds(302, 37, 38, 38);
		contentPane.add(btnSearch);
		btnSearch.setIcon(new ImageIcon(new ImageIcon("D:\\CalClothes\\icon\\search.png")
				.getImage()
				.getScaledInstance(btnSearch.getWidth(), btnSearch.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnSearch.setBorderPainted(false);
		btnSearch.setContentAreaFilled(false);

		JButton btnEdit = new JButton("");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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

			}
		});
		btnEdit.setBounds(386, 128, 38, 38);
		contentPane.add(btnEdit);
		btnEdit.setIcon(new ImageIcon(new ImageIcon("D:\\CalClothes\\icon\\edit.png")
				.getImage()
				.getScaledInstance(btnEdit.getWidth(), btnEdit.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnEdit.setBorderPainted(false);
		btnEdit.setContentAreaFilled(false);

		JButton btnDel = new JButton("");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
			}
		});
		btnDel.setBounds(386, 180, 38, 38);
		contentPane.add(btnDel);
		btnDel.setIcon(new ImageIcon(new ImageIcon("D:\\CalClothes\\icon\\delete.png")
				.getImage()
				.getScaledInstance(btnDel.getWidth(), btnDel.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnDel.setBorderPainted(false);
		btnDel.setContentAreaFilled(false);

		JButton btnFirst = new JButton("");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (result.first()) {
						tfUser.setText(result.getString("Username"));
						tfName.setText(result.getString("Name"));
						tfSurname.setText(result.getString("Surname"));
						tfPhone.setText(result.getString("Phone"));

						tfUser.setText(result.getString("Username"));
						tfName.setText(result.getString("Name"));
						tfSurname.setText(result.getString("Surname"));
						tfPhone.setText(result.getString("Phone"));

					}

					label.setText(Integer.toString(result.getRow()) + "/" + Integer.toString(Rowsize));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnFirst.setBounds(59, 266, 46, 37);
		contentPane.add(btnFirst);
		btnFirst.setIcon(new ImageIcon(new ImageIcon("D:\\CalClothes\\icon\\first.png")
				.getImage()
				.getScaledInstance(btnFirst.getWidth(), btnFirst.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnFirst.setBorderPainted(false);
		btnFirst.setContentAreaFilled(false);

		JButton btnPrevious = new JButton("");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (result.previous()) {
						tfUser.setText(result.getString("Username"));
						tfName.setText(result.getString("Name"));
						tfSurname.setText(result.getString("Surname"));
						tfPhone.setText(result.getString("Phone"));

						tfUser.setText(result.getString("Username"));
						tfName.setText(result.getString("Name"));
						tfSurname.setText(result.getString("Surname"));
						tfPhone.setText(result.getString("Phone"));
					}

					label.setText(Integer.toString(result.getRow()) + "/" + Integer.toString(Rowsize));
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});
		btnPrevious.setBounds(117, 266, 46, 38);
		contentPane.add(btnPrevious);
		btnPrevious
				.setIcon(new ImageIcon(new ImageIcon("D:\\CalClothes\\icon\\previous.png")
						.getImage().getScaledInstance(btnPrevious.getWidth(), btnPrevious.getHeight(),
								java.awt.Image.SCALE_AREA_AVERAGING)));
		btnPrevious.setBorderPainted(false);
		btnPrevious.setContentAreaFilled(false);

		JButton btnLast = new JButton("");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (result.last()) {
						tfUser.setText(result.getString("Username"));
						tfName.setText(result.getString("Name"));
						tfSurname.setText(result.getString("Surname"));
						tfPhone.setText(result.getString("Phone"));

						tfUser.setText(result.getString("Username"));
						tfName.setText(result.getString("Name"));
						tfSurname.setText(result.getString("Surname"));
						tfPhone.setText(result.getString("Phone"));
					}

					label.setText(Integer.toString(result.getRow()) + "/" + Integer.toString(Rowsize));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnLast.setBounds(274, 265, 46, 38);
		contentPane.add(btnLast);
		btnLast.setIcon(new ImageIcon(new ImageIcon("D:\\CalClothes\\icon\\last.png")
				.getImage()
				.getScaledInstance(btnLast.getWidth(), btnLast.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnLast.setBorderPainted(false);
		btnLast.setContentAreaFilled(false);

		JButton btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (result.next()) {
						tfUser.setText(result.getString("Username"));
						tfName.setText(result.getString("Name"));
						tfSurname.setText(result.getString("Surname"));
						tfPhone.setText(result.getString("Phone"));

						tfUser.setText(result.getString("Username"));
						tfName.setText(result.getString("Name"));
						tfSurname.setText(result.getString("Surname"));
						tfPhone.setText(result.getString("Phone"));
					}

					label.setText(Integer.toString(result.getRow()) + "/" + Integer.toString(Rowsize));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNext.setBounds(217, 266, 46, 37);
		contentPane.add(btnNext);
		btnNext.setIcon(new ImageIcon(new ImageIcon("D:\\CalClothes\\icon\\next2.png")
				.getImage()
				.getScaledInstance(btnNext.getWidth(), btnNext.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnNext.setBorderPainted(false);
		btnNext.setContentAreaFilled(false);

		JButton btnInsert = new JButton("");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
				qry = "INSERT INTO members(Username,Password,Name,Surname,Phone) VALUES ('" + tfUser.getText() + "','"
						+ tfPass.getText() + "','" + tfName.getText() + "','" + tfSurname.getText() + "','"
						+ tfPhone.getText() + "')";
				System.out.println(qry);
			
					conn.stmt.executeUpdate(qry);
				} catch (SQLException ee) {
					ee.printStackTrace();
				}

			}
		});
		btnInsert.setBounds(386, 74, 38, 38);
		contentPane.add(btnInsert);
		btnInsert.setIcon(new ImageIcon(
				new ImageIcon("D:\\CalClothes\\icon\\Add.png").getImage().getScaledInstance(
						btnInsert.getWidth(), btnInsert.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnInsert.setBorderPainted(false);
		btnInsert.setContentAreaFilled(false);

		JButton btnReload = new JButton("");
		btnReload.setBounds(386, 231, 38, 38);
		contentPane.add(btnReload);
		btnReload.setIcon(new ImageIcon(new ImageIcon("D:\\CalClothes\\icon\\reload.png")
				.getImage()
				.getScaledInstance(btnReload.getWidth(), btnReload.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnReload.setBorderPainted(false);
		btnReload.setContentAreaFilled(false);
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfSearch.setText(null);
				clearTf();
			}
		});

	}
}
