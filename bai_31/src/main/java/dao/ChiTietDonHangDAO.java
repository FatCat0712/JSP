package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.ChiTietDonHang;
import model.DonHang;
import model.Sach;

public class ChiTietDonHangDAO implements DAO<ChiTietDonHang>{
	
	public static DonHangDAO getInstance() {
		return new DonHangDAO();
	}
	
	
	@Override
	public ArrayList<ChiTietDonHang> selectAll() {
		ArrayList<ChiTietDonHang> chiTietDonHangList = new ArrayList<ChiTietDonHang>();
		Connection c = JDBCUtil.connect();
		try {
			String sql = "SELECT * FROM chitietdonhang";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String maChiTietDonHang = rs.getString("machitietdonhang");
				String donHang = rs.getString("donhang");
				String maSach = rs.getString("sanpham");
				int soLuong = rs.getInt("soluong");
				double gianBan = rs.getDouble("giaban");
				double giamGia = rs.getDouble("giamgia");
				double giaGoc = rs.getDouble("giagoc");
				
				chiTietDonHangList.add(new ChiTietDonHang(maChiTietDonHang, new DonHang(donHang), new Sach(maSach), soLuong, gianBan, giamGia, giaGoc));
			}
			JDBCUtil.disconnect(c);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return chiTietDonHangList;
	}

	@Override
	public ChiTietDonHang selectById(String object) {
		ChiTietDonHang target = null;
		Connection c = JDBCUtil.connect();
		try {
			String sql = "SELECT * FROM chitietdonhang";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String maChiTietDonHang = rs.getString("machitietdonhang");
				String donHang = rs.getString("donhang");
				String maSach = rs.getString("sanpham");
				int soLuong = rs.getInt("soluong");
				double gianBan = rs.getDouble("giaban");
				double giamGia = rs.getDouble("giamgia");
				double giaGoc = rs.getDouble("giagoc");
				
				target = new ChiTietDonHang(maChiTietDonHang, new DonHang(donHang), new Sach(maSach), soLuong, gianBan, giamGia, giaGoc);
			}
			JDBCUtil.disconnect(c);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return target;
	}

	@Override
	public boolean insert(ChiTietDonHang object) {
		ChiTietDonHang target = selectById(object.getMaChiTietDonHang());
		boolean status = false;
		if(target != null)
			return false;
		Connection c = JDBCUtil.connect();
		try {
			
			String sql = "INSERT INTO tacgia VALUE(?,?,?,?,?,?,?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, object.getMaChiTietDonHang());
			pst.setString(2, object.getDonHang().getMaDonHang());
			pst.setString(3, object.getSach().getMaSach());
			pst.setInt(4, object.getSoLuong());
			pst.setDouble(5,object.getGiaBan());
			pst.setDouble(6, object.getGiamGia());
			pst.setDouble(7, object.getGiaGoc());
			
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
	public boolean insertAll(ArrayList<ChiTietDonHang> object) {
		int dem = 0;
		for(ChiTietDonHang ctdh : object) {
	    	 insert(ctdh);
	    	 ++dem; 
		}
		if(dem == object.size())
			return true;
		return false;
	}

	@Override
	public boolean delete(ChiTietDonHang object) {
		ChiTietDonHang target = selectById(object.getMaChiTietDonHang());
		boolean status = false;
		if(target == null)
			return false;
		
		Connection c = JDBCUtil.connect();
		try {
			String sql = "DELETE FROM tacgia WHERE machitietdonhang=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, object.getMaChiTietDonHang());
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
	public boolean deleteAll(ArrayList<ChiTietDonHang> object) {
		int dem = 0;
		for(ChiTietDonHang ctdh : object) {
			delete(ctdh);
			++dem;
		}
		if(dem == object.size()) {
			System.out.println("Delete all successfully");
			return true;
		}
		return false;
	}

	@Override
	public boolean update(ChiTietDonHang object) {
		ChiTietDonHang target = selectById(object.getMaChiTietDonHang());
		if(target == null)
			return false;
		
		boolean status = false;
		Connection c = JDBCUtil.connect();
		try {
			String sql = "UPDATE tacgia SET donhang=?,sanpham=?,soluong=?,giaban=?,giamgia=?,giagoc=? WHERE machitietdonhang=?";
			PreparedStatement pst = c.prepareStatement(sql);
			
			pst.setString(1, object.getDonHang().getMaDonHang());
			pst.setString(2, object.getSach().getMaSach());
			pst.setInt(3, object.getSoLuong());
			pst.setDouble(4,object.getGiaBan());
			pst.setDouble(5, object.getGiamGia());
			pst.setDouble(6, object.getGiaGoc());
			pst.setString(7, object.getMaChiTietDonHang());
			
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
	
	public void xoaChiTietDonHang(DonHang dh) {
		ArrayList<ChiTietDonHang> ctdhList = selectAll();
		for(ChiTietDonHang ctdh : ctdhList) {
			if(ctdh.getDonHang().equals(dh)) {
				delete(ctdh);
			}
		}
	}
	

	
	
}
