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
		
		setTitle("Stock the Product");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Icon.getAbsolutePath()+"\\wh.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 470);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Home home = new Home();
				home.setVisible(true);
			}
		});

		btnHome.setBounds(10, 2, 60, 60);
		contentPane.add(btnHome);
		
		btnHome.setIcon(new ImageIcon(((new ImageIcon(Icon.getAbsolutePath()+"\\home.png")).getImage()).getScaledInstance(btnHome.getWidth(), btnHome.getHeight(),java.awt.Image.SCALE_AREA_AVERAGING)));
		btnHome.setBounds(10, 2, 60, 60);
		contentPane.add(btnHome);
		btnHome.setIcon(
				new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\home.png")
						.getImage().getScaledInstance(btnHome.getWidth(), btnHome.getHeight(),
								java.awt.Image.SCALE_AREA_AVERAGING)));

		btnHome.setBorderPainted(false);
		btnHome.setContentAreaFilled(false);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBackground(new Color(224, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(120, 174, 60, 60);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_2.setIcon(new ImageIcon(((new ImageIcon(Icon.getAbsolutePath()+"\\edit.png")).getImage()).getScaledInstance(btnNewButton_2.getWidth(), btnNewButton_2.getHeight(),java.awt.Image.SCALE_AREA_AVERAGING)));
		
		
		JButton btnAdd = new JButton("");
		btnAdd.setBackground(new Color(224, 255, 255));
		btnAdd.setBounds(120, 89, 60, 60);
		contentPane.add(btnAdd);
		
		btnAdd.setIcon(new ImageIcon(((new ImageIcon(Icon.getAbsolutePath()+"\\insert.png")).getImage()).getScaledInstance(btnAdd.getWidth(), btnAdd.getHeight(),java.awt.Image.SCALE_AREA_AVERAGING)));
		
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Insert in = new Insert();
				in.setVisible(true);
			}
		});
		btnInsert.setBackground(new Color(250, 235, 215));
		btnInsert.setForeground(new Color(0, 0, 255));
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInsert.setBounds(218, 109, 90, 30);
		contentPane.add(btnInsert);
		
		btnEditdelete = new JButton("Edit/Delete");
		btnEditdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				EditDelete ed = new EditDelete();
				ed.setVisible(true);
			}
		});
		btnEditdelete.setBackground(new Color(250, 235, 215));
		btnEditdelete.setForeground(new Color(255, 0, 0));
		btnEditdelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEditdelete.setBounds(218, 198, 135, 30);
		contentPane.add(btnEditdelete);
		
		JLabel lblNewLabel = new JLabel("Stock");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 35));
		lblNewLabel.setBounds(92, 21, 120, 41);
		contentPane.add(lblNewLabel);
		
		
	}
}
