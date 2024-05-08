package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.DonHang;
import model.KhachHang;


public class DonHangDAO implements DAO<DonHang>{
	
	
	public static DonHangDAO getInstance() {
		return new DonHangDAO();
	}

	@Override
	public ArrayList<DonHang> selectAll() {
		ArrayList<DonHang> donHangList = new ArrayList<DonHang>();
		Connection c = JDBCUtil.connect();
		try {
			String sql = "SELECT * FROM donhang";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String maDonHang = rs.getString("madonhang");
				String maKhachHang = rs.getString("khachhang");
				String diaChiNguoiMua = rs.getString("diachinguoimua");
				String diaChiNhanHang = rs.getString("diaChiNhanHang");
				String trangThai = rs.getString("trangthai");
				String hinhThucThanhToan = rs.getString("hinhthucthanhtoan");
				String trangThaiThanhToan = rs.getString("trangthaithanhtoan");
				double tienDaThanhToan = rs.getDouble("tiendathanhtoan");
				double tienConThieu = rs.getDouble("tienconthieu");
				Date ngayGiaoHang = rs.getDate("ngaygiaohang");
				Date ngayNhanHang = rs.getDate("ngaynhanhang");
			
				DonHang dh = new DonHang(maDonHang, new KhachHang(maKhachHang), diaChiNguoiMua, diaChiNhanHang, trangThai, hinhThucThanhToan, trangThaiThanhToan, tienDaThanhToan, tienConThieu, ngayGiaoHang, ngayNhanHang);
				donHangList.add(dh);
				
			}
			JDBCUtil.disconnect(c);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return donHangList;
	}

	@Override
	public DonHang selectById(String object) {
		DonHang target = null;
		Connection c = JDBCUtil.connect();
		try {
			String sql = "SELECT * FROM donhang WHERE madonhang=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, object);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String maDonHang = rs.getString("madonhang");
				String maKhachHang = rs.getString("khachhang");
				String diaChiNguoiMua = rs.getString("diachinguoimua");
				String diaChiNhanHang = rs.getString("diaChiNhanHang");
				String trangThai = rs.getString("trangthai");
				String hinhThucThanhToan = rs.getString("hinhthucthanhtoan");
				String trangThaiThanhToan = rs.getString("trangthaithanhtoan");
				double tienDaThanhToan = rs.getDouble("tiendathanhtoan");
				double tienConThieu = rs.getDouble("tienconthieu");
				Date ngayGiaoHang = rs.getDate("ngaygiaohang");
				Date ngayNhanHang = rs.getDate("ngaynhanhang");
				
				target = new DonHang(maDonHang, new KhachHang(maKhachHang), diaChiNguoiMua, diaChiNhanHang, trangThai, hinhThucThanhToan, trangThaiThanhToan, tienDaThanhToan, tienConThieu, ngayGiaoHang, ngayNhanHang);
				
			}
			JDBCUtil.disconnect(c);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return target;
	}

	@Override
	public boolean insert(DonHang object) {
		DonHang target = selectById(object.getMaDonHang());
		boolean status = false;
		if(target != null)
			return false;
		Connection c = JDBCUtil.connect();
		try {
			
			String sql = "INSERT INTO sach VALUE(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = c.prepareStatement(sql);
			
			pst.setString(1, object.getMaDonHang());
			pst.setString(2, object.getKhachHang().getMaKhachHang());
			pst.setString(3, object.getDiaChiNguoiMua());
			pst.setString(4, object.getDiaChiNhanHang());
			pst.setString(5, object.getTrangThai());
			pst.setString(6, object.getHinhThucThanhToan());
			pst.setString(7, object.getTrangThaiThanhToan());
			pst.setDouble(8, object.getTienDaThanhToan());
			pst.setDouble(9, object.getTienConThieu());
			pst.setDate(10,object.getNgayDatHang());
			pst.setDate(11, object.getNgayGiaoHang());
			
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
	public boolean insertAll(ArrayList<DonHang> object) {
		int dem = 0;
		for(DonHang dh : object) {
				insert(dh);
				++dem;
		}
		if(dem == object.size()) {
			System.out.println("Insert all successfully");
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(DonHang object) {
		DonHang target = selectById(object.getMaDonHang());
		boolean status = false;
		if(target == null)
			return false;
		
		Connection c = JDBCUtil.connect();
		try {
			String sql = "DELETE FROM donhang WHERE madonhang=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, object.getMaDonHang());
			
			ChiTietDonHangDAO.getInstance().delete(object);
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
	public boolean deleteAll(ArrayList<DonHang> object) {
		int dem = 0;
		for(DonHang s : object) {
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
	public boolean update(DonHang object) {
		DonHang target = selectById(object.getMaDonHang());
		if(target == null)
			return false;
		
		boolean status = false;
		Connection c = JDBCUtil.connect();
		try {
			String sql = "UPDATE sach SET khachhang=?,diachinguoimua=?,diachinhanhang=?,trangthai=?,hinhthucthanhtoan=?,trangthaithanhtoan=?,tiendathanhtoan=?,tienconthieu=?,ngaydathang=?,ngaygiaohang=? WHERE madonhang=?";
			PreparedStatement pst = c.prepareStatement(sql);
			
			
			pst.setString(1, object.getKhachHang().getMaKhachHang());
			pst.setString(2, object.getDiaChiNguoiMua());
			pst.setString(3, object.getDiaChiNhanHang());
			pst.setString(4, object.getTrangThai());
			pst.setString(5, object.getHinhThucThanhToan());
			pst.setString(6, object.getTrangThaiThanhToan());
			pst.setDouble(7, object.getTienDaThanhToan());
			pst.setDouble(8, object.getTienConThieu());
			pst.setDate(9,object.getNgayDatHang());
			pst.setDate(10, object.getNgayGiaoHang());
			pst.setString(11, object.getMaDonHang());
			
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
