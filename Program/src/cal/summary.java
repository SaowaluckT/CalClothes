package cal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Home.Home;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class summary extends JFrame {

	private JPanel contentPane;
	private JTextField txtPriceSummary;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					summary frame = new summary();
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
	public summary() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtPriceSummary = new JTextField();
		txtPriceSummary.setBounds(146, 36, 333, 47);
		txtPriceSummary.setHorizontalAlignment(SwingConstants.CENTER);
		txtPriceSummary.setForeground(new Color(0, 0, 0));
		txtPriceSummary.setFont(new Font("5103_tLU_JIUMJIUM", Font.BOLD, 35));
		txtPriceSummary.setText("Price Summary");
		txtPriceSummary.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(73, 118, 494, 199);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setText("\u0E2A\u0E23\u0E38\u0E1B\u0E23\u0E32\u0E22\u0E01\u0E32\u0E23\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Price =");
		lblNewLabel.setBounds(364, 347, 72, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("VAT 7% =");
		lblNewLabel_1.setBounds(330, 390, 94, 25);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("Total Price =");
		lblNewLabel_2.setBounds(310, 426, 126, 25);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3 = new JLabel("_________");
		lblNewLabel_3.setBounds(454, 347, 113, 25);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel label = new JLabel("_________");
		label.setBounds(454, 390, 113, 25);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel label_1 = new JLabel("_________");
		label_1.setBounds(454, 426, 113, 25);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btHome = new JButton("");
		btHome.setBounds(29, 36, 87, 51);
		btHome.setIcon(new ImageIcon(new ImageIcon("D:\\CalClothes\\Program\\src\\Home\\home.png")
				.getImage().getScaledInstance(btHome.getWidth(), btHome.getHeight(), java.awt.Image.SCALE_AREA_AVERAGING)));
		 
		btHome.setBorderPainted(false); 
		btHome.setContentAreaFilled(false);
		btHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Home home = new Home();
				home.setVisible(true);
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btHome);
		contentPane.add(txtPriceSummary);
		contentPane.add(lblNewLabel_1);
		contentPane.add(label);
		contentPane.add(textField);
		contentPane.add(lblNewLabel_2);
		contentPane.add(label_1);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_3);
		
		JLabel lbBG = new JLabel("");
		lbBG.setBounds(0, 0, 634, 466);
		contentPane.add(lbBG);
		
		lbBG.setIcon(new ImageIcon(new ImageIcon("D:\\\\CalClothes\\\\image\\\\bgLogin.jpg")
					.getImage().getScaledInstance(lbBG.getWidth(), lbBG.getHeight(),java.awt.Image.SCALE_AREA_AVERAGING)));

	}
}
