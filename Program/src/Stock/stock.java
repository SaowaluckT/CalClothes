package Stock;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class stock extends JFrame {

	private JPanel contentPane;
	private JButton btnStock;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(224, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 2, 60, 60);
		contentPane.add(btnNewButton);
		
		btnNewButton.setIcon(new ImageIcon(((new ImageIcon("D:\\Proj\\knicon\\dog-house.png")).getImage()).getScaledInstance(btnNewButton.getWidth(), btnNewButton.getHeight(),java.awt.Image.SCALE_AREA_AVERAGING)));
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBackground(new Color(224, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(120, 174, 60, 60);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_2.setIcon(new ImageIcon(((new ImageIcon("D:\\Proj\\knicon\\notes-pen-writing-document-article-correspondence-paper-signature-contract-agreement-37d67c9719ffe2fc-512x512.png")).getImage()).getScaledInstance(btnNewButton_2.getWidth(), btnNewButton_2.getHeight(),java.awt.Image.SCALE_AREA_AVERAGING)));
		
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(new Color(224, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(120, 89, 60, 60);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.setIcon(new ImageIcon(((new ImageIcon("D:\\Proj\\knicon\\User-Interface-Plus-icon.png")).getImage()).getScaledInstance(btnNewButton_1.getWidth(), btnNewButton_1.getHeight(),java.awt.Image.SCALE_AREA_AVERAGING)));
		
		btnStock = new JButton("Stock");
		btnStock.setForeground(new Color(255, 140, 0));
		btnStock.setBackground(new Color(250, 235, 215));
		btnStock.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnStock.setBounds(120, 11, 90, 30);
		contentPane.add(btnStock);
		
		btnInsert = new JButton("Insert");
		btnInsert.setBackground(new Color(250, 235, 215));
		btnInsert.setForeground(new Color(0, 0, 255));
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInsert.setBounds(218, 109, 90, 30);
		contentPane.add(btnInsert);
		
		btnEditdelete = new JButton("Edit/Delete");
		btnEditdelete.setBackground(new Color(250, 235, 215));
		btnEditdelete.setForeground(new Color(255, 0, 0));
		btnEditdelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEditdelete.setBounds(218, 198, 120, 30);
		contentPane.add(btnEditdelete);
		
		
	}
}
