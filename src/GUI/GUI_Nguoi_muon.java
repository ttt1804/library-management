package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.PseudoColumnUsage;
import java.util.ArrayList;
import java.util.Vector;
import Process.Connect_database;
import Process.Process_NguoiMuon;
import Object.NguoiMuon;


import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class GUI_Nguoi_muon extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	DefaultTableModel Model = new DefaultTableModel();
	Vector<String> columns = new Vector<String>();
	Vector<Vector<Object>> rows = new Vector<>();
	Process_NguoiMuon pmn = new Process_NguoiMuon();
	
	public void getAllNguoiMuon() {
		Model.setRowCount(0);

		ArrayList<NguoiMuon> ls = pmn.getListNguoiMuon();
		for (int i = 0; i < ls.size(); i++) {
			NguoiMuon s = (NguoiMuon) ls.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(s.getMaNguoiMuon());
			tbRow.add(s.getTenNguoiMuon());
			tbRow.add(s.getDiaChi());
			tbRow.add(s.getGmail());
			tbRow.add(s.getSDT());	
			rows.add(tbRow);
		}
		Model.setDataVector(rows, columns);
		table.setModel(Model);
	}
	public void insertNguoiMuon(String MaNguoiMuon, String TenNguoiMuon, String DiaChi, String Gmail, String SDT) {
		Model.setRowCount(0);
		if(pmn.insertNguoiMuon(MaNguoiMuon.trim(), TenNguoiMuon.trim(), DiaChi.trim(), Gmail.trim(), SDT.trim()) == true) {
			ArrayList<NguoiMuon> ls = pmn.getListNguoiMuon();
			for (int i = 0; i < ls.size(); i++) {
				NguoiMuon s = (NguoiMuon) ls.get(i);
				Vector<Object> tbRow = new Vector<>();
				tbRow.add(s.getMaNguoiMuon());
				tbRow.add(s.getTenNguoiMuon());
				tbRow.add(s.getDiaChi());
				tbRow.add(s.getGmail());
				tbRow.add(s.getSDT());	
				rows.add(tbRow);
			}
			Model.setDataVector(rows, columns);
			table.setModel(Model);
		}
		else {
			getAllNguoiMuon();
		}
	}
	public void updateNguoiMuon(String MaNguoiMuon, String TenNguoiMuon, String DiaChi,String Gmail, String SDT) {
		Model.setRowCount(0);
		if(pmn.updateNguoiMuon(MaNguoiMuon, TenNguoiMuon, DiaChi, Gmail, SDT) == true) {
			ArrayList<NguoiMuon> ls = pmn.getListNguoiMuon();
			for(int i = 0; i< ls.size(); i++) {
				NguoiMuon s = (NguoiMuon) ls.get(i);
				Vector<Object> tbRow = new Vector<>();
				tbRow.add(s.getMaNguoiMuon());
				tbRow.add(s.getTenNguoiMuon());
				tbRow.add(s.getDiaChi());
				tbRow.add(s.getGmail());
				tbRow.add(s.getSDT());
				rows.add(tbRow);
			}
			Model.setDataVector(rows, columns);
			table.setModel(Model);
		}
	}
	public void delNguoiMuon(String MaNguoiMuon) {
		Model.setRowCount(0);
		if(pmn.delNguoiMuon(MaNguoiMuon) == true) {
			ArrayList<NguoiMuon> ls = pmn.getListNguoiMuon();
			for(int i = 0; i<ls.size(); i++) {
				NguoiMuon s = (NguoiMuon) ls.get(i);
				Vector<Object> tbRow = new Vector<>();
				tbRow.add(s.getMaNguoiMuon());
				tbRow.add(s.getTenNguoiMuon());
				tbRow.add(s.getDiaChi());
				tbRow.add(s.getGmail());
				tbRow.add(s.getSDT());
				rows.add(tbRow);
			}
			Model.setDataVector(rows, columns);
			table.setModel(Model);
		}
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Nguoi_muon frame = new GUI_Nguoi_muon();
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
	public GUI_Nguoi_muon() {
		setResizable(false);
		setTitle("Quản lý người mượn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 735);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã người mượn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(49, 42, 115, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblTnNgiMn = new JLabel("Tên người mượn");
		lblTnNgiMn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnNgiMn.setBounds(49, 108, 115, 31);
		contentPane.add(lblTnNgiMn);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblaCh.setBounds(49, 182, 115, 31);
		contentPane.add(lblaCh);
		
		JLabel lblGmail = new JLabel("Gmail");
		lblGmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGmail.setBounds(378, 53, 105, 31);
		contentPane.add(lblGmail);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSinThoi.setBounds(378, 108, 115, 31);
		contentPane.add(lblSinThoi);
		
		JTextArea txtMaNguoiMuon = new JTextArea();
		txtMaNguoiMuon.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtMaNguoiMuon.setBounds(174, 42, 147, 27);
		contentPane.add(txtMaNguoiMuon);
		
		JTextArea txtTenNguoiMuon = new JTextArea();
		txtTenNguoiMuon.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtTenNguoiMuon.setBounds(174, 108, 147, 27);
		contentPane.add(txtTenNguoiMuon);
		
		JTextArea txtDiaChi = new JTextArea();
		txtDiaChi.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtDiaChi.setBounds(174, 182, 147, 27);
		contentPane.add(txtDiaChi);
		
		JTextArea txtGmail = new JTextArea();
		txtGmail.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtGmail.setBounds(507, 45, 160, 27);
		contentPane.add(txtGmail);
		
		JTextArea txtSDT = new JTextArea();
		txtSDT.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtSDT.setBounds(503, 110, 164, 25);
		contentPane.add(txtSDT);
		
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(txtMaNguoiMuon.getText().equals("")  || txtTenNguoiMuon.getText().equals("") || txtDiaChi.getText().equals("") || txtGmail.getText().equals("") || txtSDT.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin" , "Thông báo", 1);
				}
				else {
				insertNguoiMuon(txtMaNguoiMuon.getText(), txtTenNguoiMuon.getText(), txtDiaChi.getText(), txtGmail.getText(), txtSDT.getText());
				txtDiaChi.setText("");
				txtGmail.setText("");
				txtSDT.setText("");
				txtTenNguoiMuon.setText("");
				txtMaNguoiMuon.setText("");
				}
				
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(348, 183, 99, 28);
		contentPane.add(btnThem);
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(437, 33, 10, 10);
		contentPane.add(panel);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setEnabled(false);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(panel, "Bạn muốn sửa?", "Thông báo", JOptionPane.YES_NO_OPTION);
				if(n == JOptionPane.YES_OPTION) {
					updateNguoiMuon(txtMaNguoiMuon.getText(), txtTenNguoiMuon.getText(), txtDiaChi.getText(), txtGmail.getText(), txtSDT.getText());
				}
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSua.setBounds(461, 183, 99, 28);
		contentPane.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setEnabled(false);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int n = JOptionPane.showConfirmDialog(panel, "Bạn muốn xóa?", "Thông báo", JOptionPane.YES_NO_OPTION);
				if(n == JOptionPane.YES_OPTION) {
					delNguoiMuon(txtMaNguoiMuon.getText());
					txtMaNguoiMuon.setEnabled(true);
					txtGmail.setText(null);
					txtDiaChi.setText(null);
					txtMaNguoiMuon.setText(null);
					txtSDT.setText(null);
					txtTenNguoiMuon.setText(null);
					btnSua.setEnabled(false);
					btnXoa.setEnabled(false);
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(583, 183, 99, 28);
		contentPane.add(btnXoa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 265, 785, 372);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
				btnThem.setEnabled(false);
				txtMaNguoiMuon.setEnabled(false);
				int index = table.getSelectedRow();
				
				txtMaNguoiMuon.setText((String)(Model.getValueAt(index, 0)));
				txtTenNguoiMuon.setText((String)(Model.getValueAt(index, 1)));
				txtDiaChi.setText((String)(Model.getValueAt(index, 2)));
				txtGmail.setText((String)(Model.getValueAt(index, 3)));
				txtSDT.setText((String)(Model.getValueAt(index, 4)));
				
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnLm = new JButton("Làm mới");
		btnLm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThem.setEnabled(true);
				btnSua.setEnabled(false);
				btnXoa.setEnabled(false);
				txtMaNguoiMuon.setEnabled(true);
				getAllNguoiMuon();
				txtGmail.setText(null);
				txtDiaChi.setText(null);
				txtMaNguoiMuon.setText(null);
				txtSDT.setText(null);
				txtTenNguoiMuon.setText(null);
			}
		});
		btnLm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLm.setBounds(705, 183, 99, 28);
		contentPane.add(btnLm);
		
		JButton btnThoat = new JButton("Về trang chủ");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_TrangChu trangChu = new GUI_TrangChu();
				trangChu.setLocationRelativeTo(null);  // Giua man hinh
				trangChu.setVisible(true);
				dispose();
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThoat.setBounds(678, 647, 140, 28);
		contentPane.add(btnThoat);
		
		JLabel lblNewLabel_1 = new JLabel("Danh sách người mượn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(28, 224, 153, 27);
		contentPane.add(lblNewLabel_1);
		columns.add("Mã người mượn");
		columns.add("Tên người mượn");
		columns.add("Địa chỉ");
		columns.add("Gmail");
		columns.add("SDT");
		
		getAllNguoiMuon();
	}
}
