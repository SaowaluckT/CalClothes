package Calculate;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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
		setBounds(100, 100, 1235, 834);
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

		btnNewButton.setIcon(
				new ImageIcon(((new ImageIcon("D:\\Proj\\CalClothes\\icon\\home.png")).getImage()).getScaledInstance(
						btnNewButton.getWidth(), btnNewButton.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));

		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setForeground(new Color(255, 69, 0));
		btnCalculate.setBackground(new Color(0, 250, 154));
		btnCalculate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCalculate.setBounds(643, 314, 124, 33);
		contentPane.add(btnCalculate);

		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(34, 207, 46, 19);
		contentPane.add(lblId);

		textField = new JTextField();
		textField.setBounds(95, 208, 115, 20);
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
		textField_1.setBounds(95, 236, 115, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(133, 272, 46, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(78, 270, 45, 20);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("+");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setBounds(189, 270, 45, 20);
		contentPane.add(btnNewButton_2);

		JButton btnCalculateTheProduct = new JButton("Calculate the Product");
		btnCalculateTheProduct.setForeground(new Color(255, 69, 0));
		btnCalculateTheProduct.setBackground(new Color(175, 238, 238));
		btnCalculateTheProduct.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCalculateTheProduct.setBounds(133, 22, 260, 40);
		contentPane.add(btnCalculateTheProduct);

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setBounds(78, 97, 100, 100);
		contentPane.add(btnNewButton_3);
		
		JButton button = new JButton("");
		button.setBackground(Color.WHITE);
		button.setBounds(331, 97, 100, 100);
		contentPane.add(button);
		
		JLabel label = new JLabel("ID :");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(287, 207, 46, 19);
		contentPane.add(label);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(348, 208, 115, 20);
		contentPane.add(textField_3);
		
		JLabel label_1 = new JLabel("Price :");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(287, 237, 46, 14);
		contentPane.add(label_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(348, 236, 115, 20);
		contentPane.add(textField_4);
		
		JLabel label_2 = new JLabel("Quantity :");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(263, 269, 73, 22);
		contentPane.add(label_2);
		
		JButton button_1 = new JButton("-");
		button_1.setForeground(Color.RED);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBounds(331, 270, 45, 20);
		contentPane.add(button_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(386, 272, 46, 20);
		contentPane.add(textField_5);
		
		JButton button_2 = new JButton("+");
		button_2.setForeground(Color.RED);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_2.setBounds(442, 270, 45, 20);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(611, 97, 100, 100);
		contentPane.add(button_3);
		
		JLabel label_3 = new JLabel("ID :");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(567, 207, 46, 19);
		contentPane.add(label_3);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(628, 208, 115, 20);
		contentPane.add(textField_6);
		
		JLabel label_4 = new JLabel("Price :");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(567, 237, 46, 14);
		contentPane.add(label_4);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(628, 236, 115, 20);
		contentPane.add(textField_7);
		
		JLabel label_5 = new JLabel("Quantity :");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(543, 269, 73, 22);
		contentPane.add(label_5);
		
		JButton button_4 = new JButton("-");
		button_4.setForeground(Color.RED);
		button_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_4.setBounds(611, 270, 45, 20);
		contentPane.add(button_4);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(666, 272, 46, 20);
		contentPane.add(textField_8);
		
		JButton button_5 = new JButton("+");
		button_5.setForeground(Color.RED);
		button_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_5.setBounds(722, 270, 45, 20);
		contentPane.add(button_5);
	}
}
