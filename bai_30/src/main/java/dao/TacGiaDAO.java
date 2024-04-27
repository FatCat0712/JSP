package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.TacGia;

public class TacGiaDAO implements DAO<TacGia>{
	
	public static TacGiaDAO getInstance() {
		return new TacGiaDAO();
	}
	
	@Override
	public  ArrayList<TacGia> selectAll() {
		ArrayList<TacGia> tacGiaList = new ArrayList<TacGia>();
		Connection c = JDBCUtil.connect();
		try {
			String sql = "SELECT * FROM tacgia";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String maTacGia = rs.getString("matacgia");
				String hoTen = rs.getString("hoten");
				Date ngaySinh = rs.getDate("ngaysinh");
				String tieuSu = rs.getString("tieusu");
				tacGiaList.add(new TacGia(maTacGia, hoTen, ngaySinh, tieuSu));
			}
			JDBCUtil.disconnect(c);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return tacGiaList;
	}

	@Override
	public TacGia selectById(String object) {
		TacGia target = null;
		Connection c = JDBCUtil.connect();
		try {
			String sql = "SELECT * FROM tacgia WHERE matacgia=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, object);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String maTacGia = rs.getString("matacgia");
				String hoTen = rs.getString("hoten");
				Date ngaySinh = rs.getDate("ngaysinh");
				String tieuSu = rs.getString("tieusu");
				target = new TacGia(maTacGia, hoTen, ngaySinh, tieuSu);
			}
			JDBCUtil.disconnect(c);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return target;
	}

	@Override
	public boolean insert(TacGia object) {
		TacGia target = selectById(object.getMaTacGia());
		boolean status = false;
		if(target != null)
			return false;
		Connection c = JDBCUtil.connect();
		try {
			
			String sql = "INSERT INTO tacgia VALUE(?,?,?,?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, object.getMaTacGia());
			pst.setString(2, object.getHoTen());
			pst.setDate(3, object.getNgaySinh());
			pst.setString(4, object.getTieuSu());
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
	public boolean insertAll(ArrayList<TacGia> object) {
		int dem = 0;
		for(TacGia tacGia : object) {
				insert(tacGia);
				++dem;
		}
		if(dem == object.size()) {
			System.out.println("Insert all successfully");
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(TacGia object) {
		TacGia target = selectById(object.getMaTacGia());
		boolean status = false;
		if(target == null)
			return false;
		
		Connection c = JDBCUtil.connect();
		try {
			String sql = "DELETE FROM tacgia WHERE matacgia=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, object.getMaTacGia());
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
	public boolean deleteAll(ArrayList<TacGia> object) {
		int dem = 0;
		for(TacGia tg : object) {
			delete(tg);
			++dem;
		}
		if(dem == object.size()) {
			System.out.println("Delete all successfully");
			return true;
		}
		return false;
	}

	@Override
	public boolean update(TacGia object) {
		TacGia target = selectById(object.getMaTacGia());
		if(target == null)
			return false;
		
		boolean status = false;
		Connection c = JDBCUtil.connect();
		try {
			String sql = "UPDATE tacgia SET hoten=?,ngaysinh=?,tieusu=? WHERE matacgia=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, object.getHoTen());
			pst.setDate(2, object.getNgaySinh());
			pst.setString(3, object.getTieuSu());
			pst.setString(4, object.getMaTacGia());
			
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
