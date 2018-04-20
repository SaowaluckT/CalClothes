package EditDelete;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

public class EditDelete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEditdelete = new JLabel("Edit/Delete");
		lblEditdelete.setForeground(Color.BLACK);
		lblEditdelete.setBackground(Color.GREEN);
		lblEditdelete.setBounds(127, 6, 107, 31);
		contentPane.add(lblEditdelete);
		
		JLabel label = new JLabel("\u0E04\u0E49\u0E19\u0E2B\u0E32\u0E23\u0E2B\u0E31\u0E2A\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		label.setBackground(Color.GREEN);
		label.setBounds(44, 44, 128, 14);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 10, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(137, 41, 140, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(304, 40, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblProid = new JLabel("Pro_ID");
		lblProid.setBounds(44, 80, 46, 14);
		contentPane.add(lblProid);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(44, 105, 46, 14);
		contentPane.add(lblType);
		
		JLabel lblTexture = new JLabel("Texture");
		lblTexture.setBounds(44, 130, 46, 14);
		contentPane.add(lblTexture);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(44, 155, 46, 14);
		contentPane.add(lblColor);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(44, 179, 46, 14);
		contentPane.add(lblPrice);
		
		JLabel lblPicture = new JLabel("Picture");
		lblPicture.setBounds(44, 204, 46, 14);
		contentPane.add(lblPicture);
		
		textField_1 = new JTextField();
		textField_1.setBounds(111, 77, 166, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(111, 102, 166, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(111, 127, 166, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(111, 152, 166, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(111, 176, 166, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(111, 201, 166, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(218, 232, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(317, 232, 89, 23);
		contentPane.add(btnEdit);
	}
}
