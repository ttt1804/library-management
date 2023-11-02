package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Process.Connect_database;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.Color;


public class GUI_Dang_nhap extends JFrame {

	private JPanel contentPane;
	
	Connect_database cd = new Connect_database();
	private JPasswordField passwordField;
	public void login(String user, String pass) {
		StringBuffer sb = new StringBuffer();		
		if(user.length() == 0) {
			sb.append("Tài khoản không được để trống\n");
		}
		if(pass.length() == 0) {
			sb.append("Mật khẩu không được để trống");
		}
		if(sb.length()>0) {
			JOptionPane.showMessageDialog(this, sb.toString());
		}
		if(cd.login(user, pass)) {
			JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
			GUI_TrangChu trangChu = new GUI_TrangChu();
			trangChu.setLocationRelativeTo(null);  // Giua man hinh
			trangChu.setVisible(true);
			dispose();	
		}
		else {
			JOptionPane.showMessageDialog(this, "Đăng nhập thất bại");
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Dang_nhap frame = new GUI_Dang_nhap();
					frame.setLocationRelativeTo(null);  // Giua man hinh
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
	public GUI_Dang_nhap() {
		setBackground(SystemColor.inactiveCaption);
		setResizable(false);
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 391);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tài khoản");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(65, 93, 87, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(65, 173, 62, 40);
		contentPane.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea.setBounds(170, 103, 188, 30);
		contentPane.add(textArea);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(170, 181, 188, 30);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login(textArea.getText().trim(), passwordField.getText());
			}
		});
		btnNewButton.setBounds(190, 259, 128, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Đăng nhập");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(203, 28, 112, 47);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Thoát\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(420, 323, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
