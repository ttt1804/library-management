package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Vector;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import Process.Process_PhieuMuon;
import Process.Process_Sach;
import Object.PhieuMuon;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class GUI_Phieu_muon extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	
	DefaultTableModel Model = new DefaultTableModel();
	Vector<String> columns = new Vector<String>();
	Vector<Vector<Object>> rows = new Vector<>();
	Process_PhieuMuon ppm = new Process_PhieuMuon();
	
	public void getAllPhieuMuon() {
		Model.setRowCount(0);
		ArrayList<PhieuMuon> ls = ppm.getListPhieuMuon();
		for (int i = 0; i < ls.size(); i++) {
			PhieuMuon s = (PhieuMuon) ls.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(s.getMaPhieuMuon());
			tbRow.add(s.getNgayMuon());
			tbRow.add(s.getHanTra());
			tbRow.add(s.getMaSach());
			tbRow.add(s.getMaNguoiMuon());
			tbRow.add(s.getNgayTra());
			rows.add(tbRow);
		}
		Model.setDataVector(rows, columns);
		table.setModel(Model);
	}

	public boolean insertPhieuMuon(String MaPhieuMuon, Date NgayMuon,Date HanTra, String MaSach, String MaNguoiMuon) {
		Model.setRowCount(0);
		if(ppm.insertPhieuMuon(MaPhieuMuon, NgayMuon,HanTra, MaSach, MaNguoiMuon)) {
			ArrayList<PhieuMuon> ls = ppm.getListPhieuMuon();
			for (int i = 0; i < ls.size(); i++) {
				PhieuMuon s = (PhieuMuon) ls.get(i);
				Vector<Object> tbRow = new Vector<>();
				tbRow.add(s.getMaPhieuMuon());
				tbRow.add(s.getNgayMuon());
				tbRow.add(s.getHanTra());
				tbRow.add(s.getMaSach());
				tbRow.add(s.getMaNguoiMuon());
				tbRow.add(s.getNgayTra());
				rows.add(tbRow);
			}
			Model.setDataVector(rows, columns);
			table.setModel(Model);
			
			return true;
		}
		else {
			return false;
		}
	}

	public void updatePhieuMuon(String MaPhieuMuon, Date NgayMuon,Date HanTra, String MaSach, String MaNguoiMuon) {
		Model.setRowCount(0);
		if(ppm.updatePhieuMuon(MaPhieuMuon, NgayMuon,HanTra, MaSach, MaNguoiMuon)) {
			ArrayList<PhieuMuon> ls = ppm.getListPhieuMuon();
			for (int i = 0; i < ls.size(); i++) {
				PhieuMuon s = (PhieuMuon) ls.get(i);
				Vector<Object> tbRow = new Vector<>();
				tbRow.add(s.getMaPhieuMuon());
				tbRow.add(s.getNgayMuon());
				tbRow.add(s.getHanTra());
				tbRow.add(s.getMaSach());
				tbRow.add(s.getMaNguoiMuon());
				tbRow.add(s.getNgayTra());
				rows.add(tbRow);
			}
			Model.setDataVector(rows, columns);
			table.setModel(Model);
		}
		else {
			System.out.println(false);
		}
		
	}
	
	public void updatePMNgayTra(Date NgayTra, String MaPhieuMuon) {
		Model.setRowCount(0);
		if(ppm.updatePhieuMuonNgayTra(NgayTra, MaPhieuMuon)) {
			ArrayList<PhieuMuon> ls = ppm.getListPhieuMuon();
			for (int i = 0; i < ls.size(); i++) {
				PhieuMuon s = (PhieuMuon) ls.get(i);
				Vector<Object> tbRow = new Vector<>();
				tbRow.add(s.getMaPhieuMuon());
				tbRow.add(s.getNgayMuon());
				tbRow.add(s.getHanTra());
				tbRow.add(s.getMaSach());
				tbRow.add(s.getMaNguoiMuon());
				tbRow.add(s.getNgayTra());
				rows.add(tbRow);
			}
			Model.setDataVector(rows, columns);
			table.setModel(Model);
		}
		else {
			System.out.println(false);
		}
		
	}
	
	public boolean delPhieuMuon(String MaPhieuMuon) {
		Model.setRowCount(0);
		if(ppm.delPhieuMuon(MaPhieuMuon)) {
			ArrayList<PhieuMuon> ls = ppm.getListPhieuMuon();
			for (int i = 0; i < ls.size(); i++) {
				PhieuMuon s = (PhieuMuon) ls.get(i);
				Vector<Object> tbRow = new Vector<>();
				tbRow.add(s.getMaPhieuMuon());
				tbRow.add(s.getNgayMuon());
				tbRow.add(s.getHanTra());
				tbRow.add(s.getMaSach());
				tbRow.add(s.getMaNguoiMuon());
				tbRow.add(s.getNgayTra());
				rows.add(tbRow);
			}
			Model.setDataVector(rows, columns);
			table.setModel(Model);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean delPhieuMuonDaTra() {
		Model.setRowCount(0);
		if(ppm.delPhieuMuonDaTra()) {
			ArrayList<PhieuMuon> ls = ppm.getListPhieuMuon();
			for (int i = 0; i < ls.size(); i++) {
				PhieuMuon s = (PhieuMuon) ls.get(i);
				Vector<Object> tbRow = new Vector<>();
				tbRow.add(s.getMaPhieuMuon());
				tbRow.add(s.getNgayMuon());
				tbRow.add(s.getHanTra());
				tbRow.add(s.getMaSach());
				tbRow.add(s.getMaNguoiMuon());
				tbRow.add(s.getNgayTra());
				rows.add(tbRow);
			}
			Model.setDataVector(rows, columns);
			table.setModel(Model);
			return true;
			
		}
		else {
			return false;
		}
	}
	
	public void getMaSach(JComboBox ComboBox) {
		ArrayList<String> arr = ppm.getSach();
		for (String mds : arr) {
			ComboBox.addItem(mds);
		}
	}
	
	public void getMaNguoiMuon(JComboBox ComboBox) {
		ArrayList<String> arr = ppm.getMaNguoiMuon();
		for (String mds : arr) {
			ComboBox.addItem(mds);
		}
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Phieu_muon frame = new GUI_Phieu_muon();
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
	public GUI_Phieu_muon() {
		setResizable(false);
		setTitle("Quản lý phiêu mượn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 754);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã phiếu mượn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(39, 39, 115, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNgyMn = new JLabel("Ngày mượn");
		lblNgyMn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgyMn.setBounds(39, 102, 115, 31);
		contentPane.add(lblNgyMn);
		
		JLabel lblMSch = new JLabel("Mã sách");
		lblMSch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMSch.setBounds(390, 39, 115, 31);
		contentPane.add(lblMSch);
		
		JLabel lblMNgiMn = new JLabel("Mã người mượn");
		lblMNgiMn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMNgiMn.setBounds(390, 102, 115, 31);
		contentPane.add(lblMNgiMn);
		
		JTextArea txtMaPhieuMuon = new JTextArea();
		txtMaPhieuMuon.setFont(new Font("Monospaced", Font.PLAIN, 15));
		JTextArea txtHanTra = new JTextArea();
		txtHanTra.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtHanTra.setBounds(164, 162, 149, 22);
		contentPane.add(txtHanTra);
		txtMaPhieuMuon.setBounds(164, 44, 149, 22);
		contentPane.add(txtMaPhieuMuon);
		
		JTextArea txtNgayTra = new JTextArea();
		txtNgayTra.setEnabled(false);
		txtNgayTra.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtNgayTra.setBounds(525, 162, 149, 22);
		contentPane.add(txtNgayTra);
		
		JComboBox cbbMaSach = new JComboBox();
		cbbMaSach.setBackground(SystemColor.inactiveCaption);
		cbbMaSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbbMaSach.setBounds(525, 39, 157, 28);
		contentPane.add(cbbMaSach);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(339, 21, 10, 10);
		contentPane.add(panel);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_1.setBounds(525, 102, 157, 28);
		contentPane.add(comboBox_1);
		
		JTextArea txtNgayMuon = new JTextArea();
		txtNgayMuon.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtNgayMuon.setBounds(164, 107, 149, 22);
		contentPane.add(txtNgayMuon);
		
		
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtMaPhieuMuon.getText().equals("") || txtNgayMuon.getText().equals("") || cbbMaSach.getSelectedIndex() == -1 || comboBox_1.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin!" , "Thông báo", 1);
				}
				else
				{
					if(insertPhieuMuon(txtMaPhieuMuon.getText(), Date.valueOf(txtNgayMuon.getText()),Date.valueOf(txtHanTra.getText()), (String)cbbMaSach.getSelectedItem(), (String)comboBox_1.getSelectedItem())) {
						JOptionPane.showMessageDialog(null, "Thêm thành công!" , "Thông báo", 1);
						Process_Sach ps = new Process_Sach();
						ps.updateSachTrangThai((String)cbbMaSach.getSelectedItem());
						txtMaPhieuMuon.setText(null);
						txtHanTra.setText(null);
						txtNgayTra.setText(null);
						txtNgayMuon.setText(null);
						cbbMaSach.setSelectedIndex(-1);
						comboBox_1.setSelectedIndex(-1);
					}
					else {
						JOptionPane.showMessageDialog(null, "Thêm thất bại!" , "Thông báo", 1);
						getAllPhieuMuon();
					}
				}
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(105, 194, 125, 31);
		contentPane.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setEnabled(false);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int n = JOptionPane.showConfirmDialog(panel, "Bạn muốn sửa?", "Thông báo", JOptionPane.YES_NO_OPTION);
				if(n == JOptionPane.YES_OPTION) {

					if(txtNgayTra.getText().equals(""))
					{
						updatePhieuMuon(txtMaPhieuMuon.getText(), Date.valueOf(txtNgayMuon.getText()),Date.valueOf(txtHanTra.getText()), (String)cbbMaSach.getSelectedItem(), (String)comboBox_1.getSelectedItem());
					}
					else {
						updatePMNgayTra(Date.valueOf(txtNgayTra.getText()), txtMaPhieuMuon.getText());
						Process_Sach ps = new Process_Sach();
						ps.updateSachTrangThai2((String)cbbMaSach.getSelectedItem());
						
					}
				}
				

				

			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSua.setBounds(283, 194, 125, 31);
		contentPane.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setEnabled(false);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int n = JOptionPane.showConfirmDialog(panel, "Bạn muốn xoá?", "Thông báo", JOptionPane.YES_NO_OPTION);
				if(n == JOptionPane.YES_OPTION) {
					
					if (delPhieuMuon(txtMaPhieuMuon.getText())) {
						JOptionPane.showMessageDialog(null, "Xóa thành công!" , "Thông báo", 1);
						Process_Sach ps = new Process_Sach();
						ps.updateSachTrangThai2((String)cbbMaSach.getSelectedItem());
						txtMaPhieuMuon.setEnabled(true);
						txtMaPhieuMuon.setText(null);
						txtHanTra.setText(null);
						txtNgayMuon.setText(null);
						cbbMaSach.setSelectedIndex(-1);
						comboBox_1.setSelectedIndex(-1);
						txtNgayTra.setText(null);
						btnSua.setEnabled(false);
					} else {
						JOptionPane.showMessageDialog(null, "Xóa thất bại!" , "Thông báo", 1);
					}
				}
				
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(472, 194, 125, 31);
		contentPane.add(btnXoa);
		
		JLabel lblHnTra = new JLabel("Hạn trả");
		lblHnTra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHnTra.setBounds(39, 153, 115, 31);
		contentPane.add(lblHnTra);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 275, 875, 391);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				btnThem.setEnabled(false);
				txtMaPhieuMuon.setEnabled(false);
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
				txtNgayTra.setEnabled(true);
				int index = table.getSelectedRow();
				txtMaPhieuMuon.setText((String)(Model.getValueAt(index, 0)));
				txtNgayMuon.setText( (Model.getValueAt(index, 1)).toString());
				txtHanTra.setText( (Model.getValueAt(index, 2)).toString());
				cbbMaSach.addItem((String)(Model.getValueAt(index, 3)));
				cbbMaSach.setSelectedItem((String)(Model.getValueAt(index, 3)));
				comboBox_1.setSelectedItem((String)(Model.getValueAt(index, 4)));

				try {
					txtNgayTra.setText( (Model.getValueAt(index, 5)).toString());
				} catch (Exception e2) {
					
					txtNgayTra.setText(null);
				}

			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		getMaNguoiMuon(comboBox_1);
		
		
		getMaSach(cbbMaSach);
		cbbMaSach.setSelectedIndex(-1);
		comboBox_1.setSelectedIndex(-1);
		
		JButton btnLmMi = new JButton("Làm mới");
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnThem.setEnabled(true);
				btnXoa.setEnabled(false);
				btnSua.setEnabled(false);
				txtNgayTra.setEnabled(false);
				getAllPhieuMuon();
				txtMaPhieuMuon.setEnabled(true);
				txtMaPhieuMuon.setText(null);
				txtHanTra.setText(null);
				txtNgayTra.setText(null);
				txtNgayMuon.setText(null);
				cbbMaSach.removeAllItems();
				getMaSach(cbbMaSach);
				cbbMaSach.setSelectedIndex(-1);
				comboBox_1.setSelectedIndex(-1);
			}
		});
		btnLmMi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLmMi.setBounds(631, 194, 125, 31);
		contentPane.add(btnLmMi);
		
		JLabel lblNgyTtr = new JLabel("Ngày trả");
		lblNgyTtr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgyTtr.setBounds(390, 153, 115, 31);
		contentPane.add(lblNgyTtr);
		
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
		btnThoat.setBounds(769, 676, 131, 31);
		contentPane.add(btnThoat);
		
		JButton btnXaPhiu = new JButton("Xóa phiếu đã trả");
		btnXaPhiu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(delPhieuMuonDaTra()) {
					JOptionPane.showMessageDialog(null, "Xóa thành công!" , "Thông báo", 1);
					getAllPhieuMuon();
				}
				else {
					JOptionPane.showMessageDialog(null, "Xóa thất bại!" , "Thông báo", 1);
				}
			}
		});
		btnXaPhiu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXaPhiu.setBounds(363, 234, 171, 31);
		contentPane.add(btnXaPhiu);
		
		JLabel lblNewLabel_1 = new JLabel("Danh sách phiếu mượn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(39, 242, 215, 23);
		contentPane.add(lblNewLabel_1);
		
		columns.add("Mã phiếu mượn");
		columns.add("Ngày mượn");
		columns.add("Hạn trả");
		columns.add("Mã sách");
		columns.add("Mã người mượn");
		columns.add("Ngày trả");
		getAllPhieuMuon();
	}
}
