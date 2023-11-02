package Process;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Object.PhieuMuon;

public class Process_PhieuMuon {
	Connect_database cd = new Connect_database();
	public ArrayList<PhieuMuon> getListPhieuMuon() {
		Connection cn = cd.getCon();
		ArrayList<PhieuMuon> ls = new ArrayList<>();
		String sql = "SELECT * FROM tb_phieumuon;";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PhieuMuon st = new PhieuMuon();
				st.setMaPhieuMuon(rs.getString("MaPhieuMuon"));
				st.setNgayMuon(rs.getDate("NgayMuon"));
				st.setHanTra(rs.getDate("HanTra"));
				st.setMaSach(rs.getString("MaSach"));
				st.setMaNguoiMuon(rs.getString("MaNguoiMuon"));
				st.setNgayTra(rs.getDate("NgayTra"));
				ls.add(st);
			}
		} catch (Exception e) {
			
		}
		return ls;
	}
	public boolean insertPhieuMuon(String MaPhieuMuon, Date NgayMuon, Date HanTra, String MaSach, String MaNguoiMuon) {
		Connection cn = cd.getCon();
		String sql = "INSERT INTO `qltv`.`tb_phieumuon` (`MaPhieuMuon`, `NgayMuon`, `HanTra`, `MaSach`, `MaNguoiMuon`) VALUES (?, ?, ?, ?, ?);";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, MaPhieuMuon);
			ps.setDate(2, NgayMuon);
			ps.setDate(3, HanTra);
			ps.setString(4, MaSach);
			ps.setString(5, MaNguoiMuon);
			ps.executeUpdate();
			ps.close();

			return true;
		}catch (Exception e) {

			return false;
		}
	}
	
	public boolean updatePhieuMuon(String MaPhieuMuon, Date NgayMuon, Date HanTra, String MaSach, String MaNguoiMuon) {
		Connection cn = cd.getCon();
		String sql = "UPDATE `qltv`.`tb_phieumuon` SET NgayMuon = ?, HanTra = ? , MaSach = ? , MaNguoiMuon = ? where MaPhieuMuon = ?";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(5, MaPhieuMuon);
			ps.setDate(1, NgayMuon);
			ps.setDate(2, HanTra);
			ps.setString(3, MaSach);
			ps.setString(4, MaNguoiMuon);
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Cập nhật thành công!" , "Thông báo", 1);
			return true;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cập nhật thất bại!" , "Thông báo", 1);
			return false;
		}
	}
	

	
	public boolean delPhieuMuon(String MaPhieuMuon) {
		Connection cn = cd.getCon();
		String sql = "delete from tb_phieumuon where MaPhieuMuon = ?";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, MaPhieuMuon);
			ps.executeUpdate();
			ps.close();

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	public boolean updatePhieuMuonNgayTra(Date NgayTra, String MaPhieuMuon) {
		Connection cn = cd.getCon();
		String sql = "UPDATE `qltv`.`tb_phieumuon` SET NgayTra = ? where MaPhieuMuon = ?";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setDate(1, NgayTra);
			ps.setString(2, MaPhieuMuon);
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Cập nhật thành công!" , "Thông báo", 1);
			return true;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cập nhật thất bại!" , "Thông báo", 1);
			return false;
		}
	}
	
	
	public boolean delPhieuMuonDaTra() {
		Connection cn = cd.getCon();
		String sql = "delete from tb_phieumuon where NgayTra is not NULL";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean delSach(String MaSach) {
		Connection cn = cd.getCon();
		String sql = "delete from tb_sach where MaSach = ?";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, MaSach);
			ps.executeUpdate();
			ps.close();
			return true;
			
		}catch (Exception e) {
			return false;
		}
	}
	
	public ArrayList<String> getSach(){
		Connection cn = cd.getCon();
		ArrayList< String> arr = new ArrayList<>();
				
		String sql = "Select distinct MaSach from tb_Sach  where TrangThai  = 'Còn' order by MaSach ASC;";
	//	String sql = "Select distinct MaSach from tb_Sach order by MaSach ASC;";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				arr.add(rs.getString("MaSach"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	
	public ArrayList<String> getMaNguoiMuon(){
		Connection cn = cd.getCon();
		ArrayList< String> arr = new ArrayList<>();
				
		String sql = "Select distinct MaNguoiMuon from tb_NguoiMuon order by MaNguoiMuon";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				arr.add(rs.getString("MaNguoiMuon"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
}
