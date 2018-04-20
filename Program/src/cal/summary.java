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
		txtPriceSummary.setHorizontalAlignment(SwingConstants.CENTER);
		txtPriceSummary.setForeground(new Color(0, 0, 0));
		txtPriceSummary.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtPriceSummary.setText("Price Summary");
		txtPriceSummary.setColumns(10);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setText("\u0E2A\u0E23\u0E38\u0E1B\u0E23\u0E32\u0E22\u0E01\u0E32\u0E23\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32");
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Price =");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("VAT 7% =");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("Total Price =");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3 = new JLabel("_________");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel label = new JLabel("_________");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel label_1 = new JLabel("_________");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btHome = new JButton("");
		btHome.setBounds(0, 0, 55, 42);
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addComponent(btHome)
							.addGap(30)
							.addComponent(txtPriceSummary, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(68)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(30)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 494, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPriceSummary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btHome))
					.addGap(31)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
