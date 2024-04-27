package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.KhachHang;

public class KhachHangDAO implements DAO<KhachHang>{
	public static KhachHangDAO getInstance() {
		return new KhachHangDAO();
	}
	@Override
	public ArrayList<KhachHang> selectAll() {
		ArrayList<KhachHang> khachHangList = new ArrayList<KhachHang>();
		Connection c = JDBCUtil.connect();
		try {
			String sql = "SELECT * FROM khachhang";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String maKhachHang = rs.getString("makhachhang");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String hoTen = rs.getString("hoten");
				String diaChi = rs.getString("diachi");
				String diaChiMuaHang = rs.getString("diachimuahang");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String gioiTinh = rs.getString("gioitinh");
				int nhan = rs.getInt("nhanbantin");
				boolean nhanBanTin = false;
				if(nhan == 1) {
					nhanBanTin = true;
				}
				
				khachHangList.add(new KhachHang(maKhachHang, tenDangNhap, matKhau, hoTen, diaChi, diaChiMuaHang, diaChiNhanHang, ngaySinh, soDienThoai, gioiTinh, nhanBanTin));
			}
			JDBCUtil.disconnect(c);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return khachHangList;
	}

	@Override
	public KhachHang selectById(String object) {
		KhachHang target = null;
		Connection c = JDBCUtil.connect();
		try {
			String sql = "SELECT * FROM khachhang WHERE makhachhang=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, object);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String maKhachHang = rs.getString("makhachhang");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String hoTen = rs.getString("hoten");
				String diaChi = rs.getString("diachi");
				String diaChiMuaHang = rs.getString("diachimuahang");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String gioiTinh = rs.getString("gioitinh");
				int nhan = rs.getInt("nhanbantin");
				boolean nhanBanTin = false;
				if(nhan == 1) {
					nhanBanTin = true;
				}
				target = new KhachHang(maKhachHang, tenDangNhap, matKhau, hoTen, diaChi, diaChiMuaHang, diaChiNhanHang, ngaySinh, soDienThoai, gioiTinh, nhanBanTin);
			}
			JDBCUtil.disconnect(c);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return target;
	}

	@Override
	public boolean insert(KhachHang object) {
		KhachHang target = selectById(object.getMaKhachHang());
		boolean status = false;
		if(target != null)
			return false;
		Connection c = JDBCUtil.connect();
		try {
			
			String sql = "INSERT INTO tacgia VALUE(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = c.prepareStatement(sql);
			
			pst.setString(1, object.getMaKhachHang());
			pst.setString(2, object.getTenDangNhap());
			pst.setString(3, object.getMatKhau());
			pst.setString(4, object.getHoTen());
			pst.setString(5, object.getDiaChi());
			pst.setString(6, object.getDiaChiMuaHang());
			pst.setString(7, object.getDiaChiNhanHang());
			pst.setDate(8, object.getNgaySinh());
			pst.setString(9, object.getSoDienThoai());
			pst.setString(10,object.getGioiTinh());
			if(object.isNhanBanTin()==true) {
				pst.setInt(11, 1);
			}
			else {
				pst.setInt(11, 0);
			}
			
			
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
	public boolean insertAll(ArrayList<KhachHang> object) {
		int dem = 0;
		for(KhachHang kh : object) {
	    	 insert(kh);
	    	 ++dem;
	     }
		
		if(dem == object.size()) {
			System.out.println("Insert all successfully");
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(KhachHang object) {
		KhachHang target = selectById(object.getMaKhachHang());
		boolean status = false;
		if(target == null)
			return false;
		
		Connection c = JDBCUtil.connect();
		try {
			String sql = "DELETE FROM khachhang WHERE makhachhang=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, object.getMaKhachHang());
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
	public boolean deleteAll(ArrayList<KhachHang> object) {
		int dem = 0;
		for(KhachHang kh : object) {
			delete(kh);
			++dem;
		}
		if(dem == object.size()) {
			System.out.println("Delete all successfully");
			return true;
		}
		return false;
	}
	
	@Override
	public boolean update(KhachHang object) {
		KhachHang target = selectById(object.getMaKhachHang());
		if(target == null)
			return false;
		
		boolean status = false;
		Connection c = JDBCUtil.connect();
		try {
			String sql = "UPDATE tacgia SET tendangnhap=?,matkhau=?,hoten=?,diachi=?,diachimuahang=?,diachinhanhang=?,ngaysinh=?,sodienthoai=?,gioitinh=?,nhanbantin=? WHERE makhachhang=?";
			PreparedStatement pst = c.prepareStatement(sql);
			
			
			pst.setString(1, object.getTenDangNhap());
			pst.setString(2, object.getMatKhau());
			pst.setString(3, object.getHoTen());
			pst.setString(4, object.getDiaChi());
			pst.setString(5, object.getDiaChiMuaHang());
			pst.setString(6, object.getDiaChiNhanHang());
			pst.setDate(7, object.getNgaySinh());
			pst.setString(8, object.getSoDienThoai());
			pst.setString(9,object.getGioiTinh());
			if(object.isNhanBanTin()==true) {
				pst.setInt(10, 1);
			}
			else {
				pst.setInt(10, 0);
			}
			
			pst.setString(11, object.getMaKhachHang());
			
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
