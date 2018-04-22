package Stock;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import EditDelete.EditDelete;
import Home.Home;
import Insert.Insert;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class stock extends JFrame {

	private JPanel contentPane;
	private JButton btnInsert;
	private JButton btnEditdelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stock frame = new stock();
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
	public stock() {
		File Icon = new File("icon");
		File Image = new File("Image");
		
		setTitle("Stock the Product");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Icon.getAbsolutePath()+"\\wh.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 316);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnHome = new JButton("");
		btnHome.setBounds(10, 2, 60, 60);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Home home = new Home();
				home.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnHome);
		
		btnHome.setIcon(new ImageIcon(((new ImageIcon(Icon.getAbsolutePath()+"\\home.png")).getImage()).getScaledInstance(btnHome.getWidth(), btnHome.getHeight(),java.awt.Image.SCALE_AREA_AVERAGING)));
		contentPane.add(btnHome);
		btnHome.setIcon(
				new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\home.png")
						.getImage().getScaledInstance(btnHome.getWidth(), btnHome.getHeight(),
								java.awt.Image.SCALE_AREA_AVERAGING)));

		btnHome.setBorderPainted(false);
		btnHome.setContentAreaFilled(false);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(120, 160, 60, 60);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setIcon(new ImageIcon(((new ImageIcon(Icon.getAbsolutePath()+"\\edit.png")).getImage()).getScaledInstance(btnNewButton_2.getWidth(), btnNewButton_2.getHeight(),java.awt.Image.SCALE_AREA_AVERAGING)));
		
		
		JButton btnAdd = new JButton("");
		btnAdd.setBounds(120, 74, 74, 75);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBorderPainted(false);
		btnAdd.setContentAreaFilled(false);
		contentPane.add(btnAdd);
		btnAdd.setIcon(new ImageIcon(((new ImageIcon(Icon.getAbsolutePath()+"\\insert.png")).getImage()).getScaledInstance(btnAdd.getWidth(), btnAdd.getHeight(),java.awt.Image.SCALE_AREA_AVERAGING)));
		
		btnInsert = new JButton("Insert");
		btnInsert.setBounds(218, 89, 167, 34);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Insert in = new Insert();
				in.setVisible(true);
			}
		});
		btnInsert.setBackground(new Color(255, 153, 153));
		btnInsert.setForeground(new Color(255, 255, 255));
		btnInsert.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 30));
		contentPane.add(btnInsert);
		
		btnEditdelete = new JButton("Edit/Delete");
		btnEditdelete.setBounds(218, 172, 167, 41);
		btnEditdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				EditDelete ed = new EditDelete();
				ed.setVisible(true);
			}
		});
		btnEditdelete.setBackground(new Color(255, 255, 153));
		btnEditdelete.setForeground(new Color(255, 0, 0));
		btnEditdelete.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 30));
		contentPane.add(btnEditdelete);
		
		JLabel lblNewLabel = new JLabel("Stock");
		lblNewLabel.setBounds(143, 21, 142, 41);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 40));
		contentPane.add(lblNewLabel);
		
		JLabel lbStock = new JLabel("");
		lbStock.setBounds(0, -79, 460, 366);
		
		lbStock.setIcon(new ImageIcon(Image.getAbsolutePath()+"\\bgStock.jpg"));
		contentPane.add(lbStock);
		
		
	}
}
