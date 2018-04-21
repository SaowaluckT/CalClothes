package Calculate;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Home.Home;
import Stock.stock;
import Calculate.calculate2;
import java.awt.Toolkit;

public class calculate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculate frame = new calculate();
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
	public calculate() {
		File Icon = new File("icon");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Icon.getAbsolutePath()+"\\p.png"));
		setTitle("Product Page1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 527);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnHome = new JButton("");
		btnHome.setBounds(10, 11, 60, 60);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Home home = new Home();
				home.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnHome);
		btnHome.setIcon(new ImageIcon(((new ImageIcon(Icon.getAbsolutePath()+"\\home.png")).getImage()).getScaledInstance(
						btnHome.getWidth(), btnHome.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnHome.setBorderPainted(false);
		btnHome.setContentAreaFilled(false);

		JButton btnCal = new JButton("");
		btnCal.setBounds(663, 314, 80, 60);
		btnCal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				cal.summary cal1 = new cal.summary();
				cal1.setVisible(true);
			}
		});
		
		btnCal.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(btnCal);
		btnCal.setIcon(new ImageIcon(((new ImageIcon(Icon.getAbsolutePath()+"\\cal2.png")).getImage()).getScaledInstance(
						btnCal.getWidth(), btnCal.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		btnCal.setBorderPainted(false);
		btnCal.setContentAreaFilled(false);
		

		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(34, 207, 46, 19);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblId);

		textField = new JTextField();
		textField.setBounds(95, 208, 115, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setBounds(34, 237, 46, 14);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblPrice);

		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setBounds(10, 269, 73, 22);
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblQuantity);

		textField_1 = new JTextField();
		textField_1.setBounds(95, 236, 115, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(95, 272, 46, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBounds(78, 97, 100, 100);
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		contentPane.add(btnNewButton_3);
		
		JButton button = new JButton("");
		button.setBounds(331, 97, 100, 100);
		button.setBackground(Color.WHITE);
		contentPane.add(button);
		
		JLabel label = new JLabel("ID :");
		label.setBounds(287, 207, 46, 19);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(label);
		
		textField_3 = new JTextField();
		textField_3.setBounds(348, 208, 115, 20);
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		
		JLabel label_1 = new JLabel("Price :");
		label_1.setBounds(287, 237, 46, 14);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(label_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(348, 236, 115, 20);
		textField_4.setColumns(10);
		contentPane.add(textField_4);
		
		JLabel label_2 = new JLabel("Quantity :");
		label_2.setBounds(263, 269, 73, 22);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(label_2);
		
		textField_5 = new JTextField();
		textField_5.setBounds(348, 272, 46, 20);
		textField_5.setColumns(10);
		contentPane.add(textField_5);
		
		JButton button_3 = new JButton("");
		button_3.setBounds(611, 97, 100, 100);
		button_3.setBackground(Color.WHITE);
		contentPane.add(button_3);
		
		JLabel label_3 = new JLabel("ID :");
		label_3.setBounds(567, 207, 46, 19);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(label_3);
		
		textField_6 = new JTextField();
		textField_6.setBounds(628, 208, 115, 20);
		textField_6.setColumns(10);
		contentPane.add(textField_6);
		
		JLabel label_4 = new JLabel("Price :");
		label_4.setBounds(567, 237, 46, 14);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(label_4);
		
		textField_7 = new JTextField();
		textField_7.setBounds(628, 236, 115, 20);
		textField_7.setColumns(10);
		contentPane.add(textField_7);
		
		JLabel label_5 = new JLabel("Quantity :");
		label_5.setBounds(543, 269, 73, 22);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(label_5);
		
		textField_8 = new JTextField();
		textField_8.setBounds(628, 272, 46, 20);
		textField_8.setColumns(10);
		contentPane.add(textField_8);
		
		JLabel lblNewLabel = new JLabel("Calculate the Product");
		lblNewLabel.setBounds(116, 14, 319, 57);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 35));
		contentPane.add(lblNewLabel);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				calculate2 st = new calculate2();
				st.setVisible(true);
			}
		});
		btnNext.setBounds(682, 419, 80, 58);
		contentPane.add(btnNext);
		contentPane.add(btnNext);
		btnNext.setIcon(new ImageIcon(new ImageIcon(Icon.getAbsolutePath()+"\\next.png").getImage()
				.getScaledInstance(btnNext.getWidth(), btnNext.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));

		btnNext.setBorderPainted(false);
		btnNext.setContentAreaFilled(false);
		
		JLabel lblGoToCalculate = new JLabel("go to calculate");
		lblGoToCalculate.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 20));
		lblGoToCalculate.setBounds(659, 373, 105, 35);
		contentPane.add(lblGoToCalculate);
	}
}
