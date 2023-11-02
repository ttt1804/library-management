package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Vector;
import Process.Connect_database;
import Process.Process_DauSach;
import Process.Process_Sach;
import Object.Sach;



import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.SystemColor;

public class GUI_Sach extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	DefaultTableModel Model = new DefaultTableModel();
	Vector<String> columns = new Vector<String>();
	Vector<Vector<Object>> rows = new Vector<>();
	Process_Sach ps = new Process_Sach();
	
	public void getAllSach() {
		Model.setRowCount(0);

		ArrayList<Sach> ls = ps.getListSach();
		for (int i = 0; i < ls.size(); i++) {
			Sach s = (Sach) ls.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(s.getMaSach());
			tbRow.add(s.getTenSach());
			tbRow.add(s.getTrangThai());	
			tbRow.add(s.getMaDauSach());
			rows.add(tbRow);
		}
		Model.setDataVector(rows, columns);
		table.setModel(Model);
	}
	
	
	public boolean insertSach(String MaSach, String TenSach, String TrangThai, String MaDauSach) {
		Model.setRowCount(0);
		if (ps.insertSach(MaSach, TenSach, TrangThai, MaDauSach) == true) {
			ArrayList<Sach> ls = ps.getListSach();
			for (int i = 0; i < ls.size(); i++) {
				Sach s = (Sach) ls.get(i);
				Vector<Object> tbRow = new Vector<>();
				tbRow.add(s.getMaSach());
				tbRow.add(s.getTenSach());
				tbRow.add(s.getTrangThai());	
				tbRow.add(s.getMaDauSach());	
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
	public void updateSach(String MaSach, String TenSach, String TrangThai, String MaDauSach) {
		if (ps.updateSach(MaSach, TenSach, TrangThai, MaDauSach) == true) {
			Model.setRowCount(0);
			ArrayList<Sach> ls = ps.getListSach();
			for(int i = 0; i< ls.size(); i++) {
				Sach s = (Sach) ls.get(i);
				Vector<Object> tbRow = new Vector<>();
				tbRow.add(s.getMaSach());
				tbRow.add(s.getTenSach());
				tbRow.add(s.getTrangThai());
				tbRow.add(s.getMaDauSach());
				rows.add(tbRow);
				
			}
			Model.setDataVector(rows, columns);
			table.setModel(Model);
		}
	}
	
	public void delSach(String MaSach) {
		if(ps.delSach(MaSach) == true) {
			Model.setRowCount(0);
			ArrayList<Sach> ls = ps.getListSach();
			for(int i = 0; i<ls.size(); i++) {
				Sach s = (Sach) ls.get(i);
				Vector<Object> tbRow = new Vector<>();
				tbRow.add(s.getMaSach());
				tbRow.add(s.getTenSach());
				tbRow.add(s.getTrangThai());
				tbRow.add(s.getMaDauSach());
				rows.add(tbRow);
			}
			Model.setDataVector(rows, columns);
			table.setModel(Model);
		}
	}
	
	public void getMaDauSach(JComboBox ComboBox) {
		ArrayList<String> arr = ps.getMaDauSach();
		for (String mds : arr) {
			ComboBox.addItem(mds);
		}	
	}
	
	public void getTenSach(JComboBox ComboBox) {
		ArrayList<String> arr = ps.getTenSach();
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
					GUI_Sach frame = new GUI_Sach();
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
	public GUI_Sach() {
		setResizable(false);
		setTitle("Quản lý sách");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 733);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã sách");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(52, 45, 79, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblTnSch = new JLabel("Tên sách");
		lblTnSch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnSch.setBounds(52, 109, 79, 28);
		contentPane.add(lblTnSch);
		
		JTextArea txtMaDauSach = new JTextArea();
		txtMaDauSach.setEnabled(false);
		txtMaDauSach.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtMaDauSach.setBounds(521, 109, 157, 24);
		contentPane.add(txtMaDauSach);
		JComboBox cbbTenSach = new JComboBox();
		cbbTenSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbbTenSach.setBounds(141, 126, 173, 21);
		cbbTenSach.setSelectedIndex(-1);
		contentPane.add(cbbTenSach);
		JLabel lblTrngThi = new JLabel("Trạng thái");
		lblTrngThi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrngThi.setBounds(419, 55, 79, 28);
		contentPane.add(lblTrngThi);
		
		JLabel lblMuSch = new JLabel("Mã đầu sách");
		lblMuSch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMuSch.setBounds(403, 109, 98, 28);
		contentPane.add(lblMuSch);
		
		JTextArea txtMaSach = new JTextArea();
		txtMaSach.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtMaSach.setBounds(139, 49, 175, 22);
		contentPane.add(txtMaSach);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Còn", "Đã mượn"}));
		comboBox.setBounds(521, 45, 157, 35);
		contentPane.add(comboBox);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(346, 24, 10, 10);
		contentPane.add(panel);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtMaSach.getText().equals("") || cbbTenSach.getSelectedIndex() == -1 || comboBox.getSelectedIndex() == -1 || txtMaDauSach.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin!" , "Thông báo", 1);
				}
				else
				{
					if (insertSach(txtMaSach.getText(), (String)cbbTenSach.getSelectedItem(), (String)comboBox.getSelectedItem(), txtMaDauSach.getText())) {
						Process_DauSach pds  = new Process_DauSach();
						pds.updateDauSachSoLuong(txtMaDauSach.getText());
						txtMaSach.setText(null);
						comboBox.setSelectedIndex(-1);
						cbbTenSach.setSelectedIndex(-1);
						txtMaDauSach.setText(null);
						JOptionPane.showMessageDialog(null, "Thêm thành công!" , "Thông báo", 1);
						
					} else {
						JOptionPane.showMessageDialog(null, "Thêm thất bại!" , "Thông báo", 1);
						getAllSach();
					}

				
				
				
				}
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(158, 168, 98, 28);
		contentPane.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setEnabled(false);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int n = JOptionPane.showConfirmDialog(panel, "Bạn muốn sửa?", "Thông báo", JOptionPane.YES_NO_OPTION);
				if(n == JOptionPane.YES_OPTION) {
					
					updateSach(txtMaSach.getText(), (String)cbbTenSach.getSelectedItem(), (String)comboBox.getSelectedItem(), txtMaDauSach.getText());
				}
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSua.setBounds(298, 168, 98, 28);
		contentPane.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setEnabled(false);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int n = JOptionPane.showConfirmDialog(panel, "Bạn muốn xóa?", "Thông báo", JOptionPane.YES_NO_OPTION);
				if(n == JOptionPane.YES_OPTION) {
					
					delSach(txtMaSach.getText());
					btnXoa.setEnabled(false);
					btnSua.setEnabled(false);
					txtMaSach.setEnabled(true);
					txtMaSach.setText(null);
					comboBox.setSelectedIndex(-1);
					cbbTenSach.setSelectedIndex(-1);
					txtMaDauSach.setText(null);
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(443, 168, 98, 28);
		contentPane.add(btnXoa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 240, 741, 402);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
				btnThem.setEnabled(false);
				txtMaSach.setEnabled(false);
				int index = table.getSelectedRow();
				txtMaSach.setText((String)(Model.getValueAt(index, 0)));
				comboBox.setSelectedItem((String)(Model.getValueAt(index, 2)));
				txtMaDauSach.setText((String)(Model.getValueAt(index, 3)));
				cbbTenSach.setSelectedItem((String)(Model.getValueAt(index, 1)));
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbbTenSach.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					String string = cbbTenSach.getSelectedItem().toString();
					txtMaDauSach.setText(ps.getMaDauSach2(string));
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
	
		comboBox.setSelectedIndex(-1);

		
		getTenSach(cbbTenSach);
		cbbTenSach.setSelectedIndex(-1);
		txtMaDauSach.setText(null);

	
		JButton btnLmMi = new JButton("Làm mới");
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAllSach();
				btnThem.setEnabled(true);
				btnSua.setEnabled(false);
				btnXoa.setEnabled(false);
				
				txtMaSach.setEnabled(true);
				txtMaSach.setText(null);
				comboBox.setSelectedIndex(-1);
				cbbTenSach.setSelectedIndex(-1);
				txtMaDauSach.setText(null);
			}
		});
		btnLmMi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLmMi.setBounds(580, 168, 98, 28);
		contentPane.add(btnLmMi);
		
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
		btnThoat.setBounds(666, 652, 127, 28);
		contentPane.add(btnThoat);
		
		JLabel lblNewLabel_1 = new JLabel("Danh sách sách");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(52, 206, 167, 21);
		contentPane.add(lblNewLabel_1);
		
		
		columns.add("Mã sách");
		columns.add("Tên sách");
		columns.add("Trạng thái");
		columns.add("Mã đầu sách");
		getAllSach();
	}
}
