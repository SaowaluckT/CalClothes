package Calculate;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class calculate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculate frame = new calculate();
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
	public calculate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 389);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 11, 60, 60);
		contentPane.add(btnNewButton);
		
		btnNewButton.setIcon(new ImageIcon(((new ImageIcon("D:\\Proj\\knicon\\dog-house.png")).getImage()).getScaledInstance(btnNewButton.getWidth(), btnNewButton.getHeight(),java.awt.Image.SCALE_AREA_AVERAGING)));
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setForeground(new Color(255, 69, 0));
		btnCalculate.setBackground(new Color(0, 250, 154));
		btnCalculate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCalculate.setBounds(300, 306, 124, 33);
		contentPane.add(btnCalculate);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(34, 207, 46, 19);
		contentPane.add(lblId);
		
		textField = new JTextField();
		textField.setBounds(95, 208, 142, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrice.setBounds(34, 237, 46, 14);
		contentPane.add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuantity.setBounds(10, 269, 73, 22);
		contentPane.add(lblQuantity);
		
		textField_1 = new JTextField();
		textField_1.setBounds(95, 236, 142, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(151, 272, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(95, 263, 50, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("+");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setBounds(247, 263, 50, 30);
		contentPane.add(btnNewButton_2);
		
		JButton btnCalculateTheProduct = new JButton("Calculate the Product");
		btnCalculateTheProduct.setForeground(new Color(255, 69, 0));
		btnCalculateTheProduct.setBackground(new Color(175, 238, 238));
		btnCalculateTheProduct.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCalculateTheProduct.setBounds(133, 22, 260, 40);
		contentPane.add(btnCalculateTheProduct);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setBounds(45, 96, 100, 100);
		contentPane.add(btnNewButton_3);
	}
}
