package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;
import Process.Process_DauSach;
import Object.DauSach;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class GUI_Dau_sach extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaDauSach;
	private JTextField txtTenSach;
	private JTextField txtSoLuong;
	private JTextField txtTheLoai;
	private JTextField txtTacGia;
	private JTable table;
	
	DefaultTableModel Model = new DefaultTableModel();
	Vector<String> columns = new Vector<String>();
	Vector<Vector<Object>> rows = new Vector<>();
	 Process_DauSach pds = new Process_DauSach();
	 private JTextField txtNXB;
	 private JTextField txtNamXB;
	
	public void getAllDauSach() {
		Model.setRowCount(0);
		ArrayList<DauSach> ls = pds.getListDauSach();
		for (int i = 0; i < ls.size(); i++) {
			DauSach s = (DauSach) ls.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(s.getMaDauSach());
			tbRow.add(s.getTenSach());
			tbRow.add(s.getSoLuong());
			tbRow.add(s.getTheLoai());
			tbRow.add(s.getTacGia());
			tbRow.add(s.getNXB());	
			tbRow.add(s.getNamXB());
			rows.add(tbRow);
		}
		Model.setDataVector(rows, columns);
		table.setModel(Model);
	}
	
	public void insertDauSach(String MaDauSach, String TenSach, int SoLuong, String TheLoai, String TacGia, String NXB, int NamXB) {
		Model.setRowCount(0);
		if (pds.insertDauSach(MaDauSach, TenSach, SoLuong, TheLoai, TacGia, NXB, NamXB)== true) {
			getAllDauSach();
		}
		else {
			getAllDauSach();
		}
	}
	
	public void updateDauSach(String MaDauSach, String TenSach, int SoLuong, String TheLoai, String TacGia, String NXB, int NamXB) {
		Model.setRowCount(0);
		if (pds.updateDauSach(MaDauSach, TenSach, SoLuong, TheLoai, TacGia, NXB, NamXB)== true) {
			getAllDauSach();
		}
	}
	
	public void delDauSach(String MaDauSach) {
		Model.setRowCount(0);
		if (pds.delDauSach(MaDauSach) == true) {
			ArrayList<DauSach> ls = pds.getListDauSach();
			for (int i = 0; i < ls.size(); i++) {
				DauSach s = (DauSach) ls.get(i);
				Vector<Object> tbRow = new Vector<>();
				tbRow.add(s.getMaDauSach());
				tbRow.add(s.getTenSach());
				tbRow.add(s.getSoLuong());
				tbRow.add(s.getTheLoai());
				tbRow.add(s.getTacGia());
				tbRow.add(s.getNXB());	
				tbRow.add(s.getNamXB());
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
					GUI_Dau_sach frame = new GUI_Dau_sach();
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
	public GUI_Dau_sach() {
		setResizable(false);
		setTitle("Quản lý đầu sách");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 761);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã đầu sách");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(37, 28, 107, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblTnSch = new JLabel("Tên đầu sách");
		lblTnSch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnSch.setBounds(37, 92, 107, 38);
		contentPane.add(lblTnSch);
		
		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSLng.setBounds(37, 158, 107, 38);
		contentPane.add(lblSLng);
		
		JLabel lblThLoi = new JLabel("Thể loại");
		lblThLoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThLoi.setBounds(421, 28, 79, 38);
		contentPane.add(lblThLoi);
		
		JLabel lblTcGi = new JLabel("Tác giả");
		lblTcGi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTcGi.setBounds(431, 76, 69, 38);
		contentPane.add(lblTcGi);
		
		JLabel lblTrngThi = new JLabel("Nhà xuất bản");
		lblTrngThi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrngThi.setBounds(425, 124, 92, 38);
		contentPane.add(lblTrngThi);
		
		txtMaDauSach = new JTextField();
		txtMaDauSach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaDauSach.setBounds(153, 37, 202, 29);
		contentPane.add(txtMaDauSach);
		txtMaDauSach.setColumns(10);
		
		txtTenSach = new JTextField();
		txtTenSach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTenSach.setColumns(10);
		txtTenSach.setBounds(153, 101, 202, 29);
		contentPane.add(txtTenSach);
		
		txtSoLuong = new JTextField();
		txtSoLuong.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
			}
		});
		txtSoLuong.addHierarchyListener(new HierarchyListener() {
			public void hierarchyChanged(HierarchyEvent e) {
			}
		});
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(153, 167, 202, 29);
		contentPane.add(txtSoLuong);
		
		txtTheLoai = new JTextField();
		txtTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTheLoai.setColumns(10);
		txtTheLoai.setBounds(542, 37, 202, 29);
		contentPane.add(txtTheLoai);
		
		txtTacGia = new JTextField();
		txtTacGia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTacGia.setColumns(10);
		txtTacGia.setBounds(542, 82, 202, 29);
		contentPane.add(txtTacGia);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(376, 10, 10, 10);
		contentPane.add(panel);
		
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setEnabled(false);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int n = JOptionPane.showConfirmDialog(panel, "Bạn muốn sửa?", "Thông báo", JOptionPane.YES_NO_OPTION);
				if(n == JOptionPane.YES_OPTION) {
					updateDauSach(txtMaDauSach.getText(), txtTenSach.getText(), Integer.parseInt(txtSoLuong.getText()), txtTheLoai.getText(), txtTacGia.getText(), txtNXB.getText(), Integer.parseInt(txtNamXB.getText()));
				}
			}
		});
		
		
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSua.setBounds(251, 230, 132, 43);
		contentPane.add(btnSua);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(63, 230, 132, 43);
		contentPane.add(btnThem);
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setEnabled(false);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int n = JOptionPane.showConfirmDialog(panel, "Bạn muốn xóa?", "Thông báo", JOptionPane.YES_NO_OPTION);
				if(n == JOptionPane.YES_OPTION) {
					delDauSach(txtMaDauSach.getText());
					txtMaDauSach.setEnabled(true);
					txtTenSach.setText(null);
					txtTacGia.setText(null);
					txtMaDauSach.setText(null);
					txtSoLuong.setText(null);
					txtTheLoai.setText(null);
					txtTenSach.setText(null);
					txtNamXB.setText(null);
					txtNXB.setText(null);
					btnXoa.setEnabled(false);
					btnSua.setEnabled(false);
					btnThem.setEnabled(true);
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(434, 230, 132, 43);
		contentPane.add(btnXoa);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtMaDauSach.getText().equals("") || txtSoLuong.getText().equals("") || txtTacGia.getText().equals("") ||txtTheLoai.getText().equals("") || txtNamXB.getText().equals("") || txtNXB.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ thông tin!" , "Thông báo", 1);
				}
				else
				{
					insertDauSach(txtMaDauSach.getText(), txtTenSach.getText(), Integer.parseInt(txtSoLuong.getText()), txtTheLoai.getText(), txtTacGia.getText(), txtNXB.getText(), Integer.parseInt(txtNamXB.getText()));
					txtTenSach.setText("");
					txtTacGia.setText("");
					txtMaDauSach.setText("");
					txtSoLuong.setText("");
					txtTheLoai.setText("");
					txtNamXB.setText(null);
					txtNXB.setText(null);
					btnSua.setEnabled(false);
					btnXoa.setEnabled(false);
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 313, 855, 357);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
				btnThem.setEnabled(false);
				txtMaDauSach.setEnabled(false);
				int index = table.getSelectedRow();
				txtMaDauSach.setText((String)(Model.getValueAt(index, 0)));
				txtTenSach.setText((String)(Model.getValueAt(index, 1)));
				txtSoLuong.setText(String.valueOf(Model.getValueAt(index, 2)));
				txtTheLoai.setText((String)(Model.getValueAt(index, 3)));
				txtTacGia.setText((String)(Model.getValueAt(index, 4)));
				txtNXB.setText((String)(Model.getValueAt(index, 5)));
				txtNamXB.setText(String.valueOf(Model.getValueAt(index, 6)));
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnSua.setEnabled(false);
				btnXoa.setEnabled(false);
				btnThem.setEnabled(true);
	
				txtMaDauSach.setEnabled(true);
				txtTenSach.setText(null);
				txtTacGia.setText(null);
				txtMaDauSach.setText(null);
				txtSoLuong.setText(null);
				txtTheLoai.setText(null);
				txtTenSach.setText(null);
				txtNamXB.setText(null);
				txtNXB.setText(null);

				getAllDauSach();
				
			}
		});
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLamMoi.setBounds(601, 230, 132, 43);
		contentPane.add(btnLamMoi);
		
		JLabel lblNmXutBn = new JLabel("Năm xuất bản");
		lblNmXutBn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNmXutBn.setBounds(421, 173, 96, 38);
		contentPane.add(lblNmXutBn);
		
		txtNXB = new JTextField();
		txtNXB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNXB.setColumns(10);
		txtNXB.setBounds(542, 124, 202, 31);
		contentPane.add(txtNXB);
		
		txtNamXB = new JTextField();
		txtNamXB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNamXB.setColumns(10);
		txtNamXB.setBounds(542, 167, 202, 29);
		contentPane.add(txtNamXB);
		
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
		btnThoat.setBounds(724, 676, 132, 38);
		contentPane.add(btnThoat);
		
		JLabel lblNewLabel_1 = new JLabel("Danh sách đầu sách");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(21, 283, 190, 23);
		contentPane.add(lblNewLabel_1);
		columns.add("Mã đầu sách");
		columns.add("Tên sách");
		columns.add("Số lượng");
		columns.add("Thể loại");
		columns.add("Tác giả");
		columns.add("Nhà xuất bản");
		columns.add("Năm xuất bản");
		
		getAllDauSach();
	}
}
