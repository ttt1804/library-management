package GUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_TrangChu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_TrangChu frame = new GUI_TrangChu();
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
	public GUI_TrangChu() {
		setTitle("Trang chủ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 504);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.text);
		menuBar.setBounds(0, 0, 330, 34);
		contentPane.add(menuBar);
		
		JMenu mnHethong = new JMenu("Hệ thống");
		mnHethong.setBackground(SystemColor.activeCaption);
		mnHethong.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnHethong);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Thông tin tài khoản");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnHethong.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		mnHethong.add(separator);
		
		JMenuItem mntmDangxuat = new JMenuItem("Đăng xuất");
		mntmDangxuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_Dang_nhap dang_nhap = new GUI_Dang_nhap();
				dang_nhap.setLocationRelativeTo(null);  // Giua man hinh
				dang_nhap.setVisible(true);
				dispose();
			}
		});

		mntmDangxuat.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnHethong.add(mntmDangxuat);
		
		JMenu mnNewMenu_1 = new JMenu("Chức năng");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmQLDS = new JMenuItem("Quản lý đầu sách");
		mntmQLDS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_Dau_sach dauSach = new GUI_Dau_sach();
				dauSach.setLocationRelativeTo(null);  // Giua man hinh
				dauSach.setVisible(true);
				dispose();
				
			}
		});
		mntmQLDS.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_1.add(mntmQLDS);
		
		JMenuItem mntmQLS = new JMenuItem("Quản lý sách");
		mntmQLS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_Sach sach = new GUI_Sach();
				sach.setLocationRelativeTo(null);  // Giua man hinh
				sach.setVisible(true);
				dispose();
			}
		});
		mntmQLS.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_1.add(mntmQLS);
		
		JMenuItem mntmQLMN = new JMenuItem("Quản lý người mượn");
		mntmQLMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_Nguoi_muon nguoi_muon = new GUI_Nguoi_muon();
				nguoi_muon.setLocationRelativeTo(null);  // Giua man hinh
				nguoi_muon.setVisible(true);
				dispose();
			}
		});
		mntmQLMN.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_1.add(mntmQLMN);
		
		JMenuItem mntmQLPM = new JMenuItem("Quản lý phiếu mượn");
		mntmQLPM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_Phieu_muon phieu_muon = new GUI_Phieu_muon();
				phieu_muon.setLocationRelativeTo(null);  // Giua man hinh
				phieu_muon.setVisible(true);
				dispose();
			}
		});
		mntmQLPM.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_1.add(mntmQLPM);
		
		JMenuItem mntmThongke = new JMenuItem("Thống kê");
		mntmThongke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_ThongKe thongKe = new GUI_ThongKe();
				thongKe.setLocationRelativeTo(null);  // Giua man hinh
				thongKe.setVisible(true);
				dispose();
			}
		});
		mntmThongke.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_1.add(mntmThongke);
		
		JMenu mnNewMenu_2 = new JMenu("Trợ giúp");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Thông tin");
		mnNewMenu_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Phần mền quản lý thư viện!" , "Thông tin", 1);
			}
		});
		mnNewMenu_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu_3);
		
		JButton btnQLDS = new JButton("Quản lý đầu sách");
		btnQLDS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_Dau_sach dauSach = new GUI_Dau_sach();
				dauSach.setLocationRelativeTo(null);  // Giua man hinh
				dauSach.setVisible(true);
				dispose();
				
			}
		});
		btnQLDS.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnQLDS.setBounds(74, 75, 229, 60);
		contentPane.add(btnQLDS);
		
		JButton btnQLS = new JButton("Quản lý sách");
		btnQLS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_Sach sach = new GUI_Sach();
				sach.setLocationRelativeTo(null);  // Giua man hinh
				sach.setVisible(true);
				dispose();
			}
		});
		btnQLS.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnQLS.setBounds(389, 75, 229, 60);
		contentPane.add(btnQLS);
		
		JButton btnQLMN = new JButton("Quản lý người mượn");
		btnQLMN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_Nguoi_muon nguoi_muon = new GUI_Nguoi_muon();
				nguoi_muon.setLocationRelativeTo(null);  // Giua man hinh
				nguoi_muon.setVisible(true);
				dispose();
			}
		});
		btnQLMN.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnQLMN.setBounds(74, 187, 229, 60);
		contentPane.add(btnQLMN);
		
		JButton btnQLPM = new JButton("Quản lý phiếu mượn");
		btnQLPM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_Phieu_muon phieu_muon = new GUI_Phieu_muon();
				phieu_muon.setLocationRelativeTo(null);  // Giua man hinh
				phieu_muon.setVisible(true);
				dispose();
			}
		});
		btnQLPM.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnQLPM.setBounds(389, 187, 229, 60);
		contentPane.add(btnQLPM);
		
		JButton btnTK = new JButton("Thống kê");
		btnTK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_ThongKe thongKe = new GUI_ThongKe();
				thongKe.setLocationRelativeTo(null);  // Giua man hinh
				thongKe.setVisible(true);
				dispose();
			}
		});
		btnTK.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTK.setBounds(240, 296, 229, 60);
		contentPane.add(btnTK);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_Dang_nhap dang_nhap = new GUI_Dang_nhap();
				dang_nhap.setLocationRelativeTo(null);  // Giua man hinh
				dang_nhap.setVisible(true);
				dispose();
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThoat.setBounds(570, 388, 131, 43);
		contentPane.add(btnThoat);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GUI_TrangChu.class.getResource("/img/imagestock_10463851.jpg")));
		lblNewLabel.setBounds(0, 0, 732, 467);
		contentPane.add(lblNewLabel);
	}
}
