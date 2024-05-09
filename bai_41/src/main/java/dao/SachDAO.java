package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Sach;
import model.TacGia;
import model.TheLoai;

public class SachDAO implements DAO<Sach>{
	
	
	public static SachDAO getInstance() {
		return new SachDAO();
	}
	
		
	@Override
	public ArrayList<Sach> selectAll() {
		ArrayList<Sach> sachList = new ArrayList<Sach>();
		Connection c = JDBCUtil.connect();
		try {
			String sql = "SELECT * FROM sach";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String maSach = rs.getString("masach");
				String tenSach = rs.getString("tensach");
				String tacgia = rs.getString("matacgia");
				int namXuatBan = rs.getInt("namxuatban");
				double giaNhap = rs.getDouble("gianhap");
				double giaGoc = rs.getDouble("giagoc");
				double giaBan = rs.getDouble("giaban");
				int soLuong = rs.getInt("soluong");
				String theLoai = rs.getString("matheloai");
				String ngonNgu = rs.getString("ngonngu");
				String mota = rs.getString("mota");
				
				Sach sach = new Sach(maSach, tenSach, new TacGia(tacgia,"",null,""), namXuatBan, giaNhap, giaGoc, giaBan, soLuong, new TheLoai(theLoai,""), ngonNgu, mota);
				sachList.add(sach);
				
			}
			JDBCUtil.disconnect(c);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return sachList;
	}

	@Override
	public Sach selectById(String object) {
		Sach target = null;
		Connection c = JDBCUtil.connect();
		try {
			String sql = "SELECT * FROM sach WHERE masach=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, object);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String maSach = rs.getString("masach");
				String tenSach = rs.getString("tensach");
				String tacgia = rs.getString("matacgia");
				int namXuatBan = rs.getInt("namxuatban");
				double giaNhap = rs.getDouble("gianhap");
				double giaGoc = rs.getDouble("giagoc");
				double giaBan = rs.getDouble("giaban");
				int soLuong = rs.getInt("soluong");
				String theLoai = rs.getString("matheloai");
				String ngonNgu = rs.getString("ngonngu");
				String mota = rs.getString("mota");
				target = new Sach(maSach, tenSach, new TacGia(tacgia,"",null,""), namXuatBan, giaNhap, giaGoc, giaBan, soLuong, new TheLoai(theLoai,""), ngonNgu, mota);
			}
			JDBCUtil.disconnect(c);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return target;
	}

	@Override
	public boolean insert(Sach object) {
		Sach target = selectById(object.getMaSach());
		boolean status = false;
		if(target != null)
			return false;
		Connection c = JDBCUtil.connect();
		try {
			
			String sql = "INSERT INTO sach VALUE(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, object.getMaSach());
			pst.setString(2, object.getTenSach());
			pst.setString(3, object.getTacGia().getMaTacGia());
			pst.setInt(4, object.getNamXuatBan());
			pst.setDouble(5, object.getGiaNhap());
			pst.setDouble(6, object.getGiaGoc());
			pst.setDouble(7, object.getGiaBan());
			pst.setInt(8, object.getSoLuong());
			pst.setString(9, object.getTheLoai().getMaTheLoai());
			pst.setString(10,object.getNgonNgu());
			pst.setString(11, object.getMoTa());
			
			int result = pst.executeUpdate();
			JDBCUtil.disconnect(c);
			if(result > 0) {
				System.out.println("Insert successfully");
				status = true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean insertAll(ArrayList<Sach> object) {
		int dem = 0;
		for(Sach s : object) {
				insert(s);
				++dem;
		}
		if(dem == object.size()) {
			System.out.println("Insert all successfully");
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Sach object) {
		Sach target = selectById(object.getMaSach());
		boolean status = false;
		if(target == null)
			return false;
		
		Connection c = JDBCUtil.connect();
		try {
			String sql = "DELETE FROM sach WHERE masach=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, object.getMaSach());
			int result = pst.executeUpdate();
			JDBCUtil.disconnect(c);
			if(result > 0) {
				status = true;
				System.out.println("Delete successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	
	@Override
	public boolean deleteAll(ArrayList<Sach> object) {
		int dem = 0;
		for(Sach s : object) {
			delete(s);
			++dem;
		}
		if(dem == object.size()) {
			System.out.println("Delete all successfully");
			return true;
		}
		return false;
	}
	
	
	@Override
	public boolean update(Sach object) {
		Sach target = selectById(object.getMaSach());
		if(target == null)
			return false;
		
		boolean status = false;
		Connection c = JDBCUtil.connect();
		try {
			String sql = "UPDATE sach SET tensach=?,matacgia=?,namxuatban=?,gianhap=?,giagoc=?,giaban=?,soluong=?,matheloai=?,ngonngu=?,mota=? WHERE masach=?";
			PreparedStatement pst = c.prepareStatement(sql);
			
			pst.setString(1, object.getTenSach());
			pst.setString(2, object.getTacGia().getMaTacGia());
			pst.setInt(3, object.getNamXuatBan());
			pst.setDouble(4, object.getGiaNhap());
			pst.setDouble(5, object.getGiaGoc());
			pst.setDouble(6, object.getGiaBan());
			pst.setInt(7, object.getSoLuong());
			pst.setString(8, object.getTheLoai().getMaTheLoai());
			pst.setString(9,object.getNgonNgu());
			pst.setString(10, object.getMoTa());
			pst.setString(11, object.getMaSach());
			
			int result = pst.executeUpdate();
			JDBCUtil.disconnect(c);
			
			if(result > 0) {
				status = true;
				System.out.println("Update successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	
	
	
}
