package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.TheLoai;

public class TheLoaiDAO implements DAO<TheLoai>{
	
	
	public static TheLoaiDAO getInstance() {
		return new TheLoaiDAO();
	}

	@Override
	public ArrayList<TheLoai> selectAll() {
		ArrayList<TheLoai> theLoaiList = new ArrayList<TheLoai>();
		Connection c = JDBCUtil.connect();
		try {
			String sql = "SELECT * FROM theloai";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String maTheLoai = rs.getString("matheloai");
				String tenTheLoai = rs.getString("tentheloai");
				theLoaiList.add(new TheLoai(maTheLoai,tenTheLoai));
			}
			JDBCUtil.disconnect(c);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return theLoaiList;
	}

	@Override
	public TheLoai selectById(String object) {
		TheLoai target = null;
		Connection c = JDBCUtil.connect();
		try {
			String sql = "SELECT * FROM theloai WHERE matheloai=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, object);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String maTheLoai = rs.getString("matheloai");
				String tenTheLoai = rs.getString("tentheloai");
				target = new TheLoai(maTheLoai, tenTheLoai);
			}
			JDBCUtil.disconnect(c);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return target;
	}

	@Override
	public boolean insert(TheLoai object) {
		TheLoai target = selectById(object.getMaTheLoai());
		boolean status = false;
		if(target != null)
			return false;
		Connection c = JDBCUtil.connect();
		try {
			
			String sql = "INSERT INTO theloai VALUE(?,?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, object.getMaTheLoai());
			pst.setString(2, object.getTenTheLoai());
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
	public boolean insertAll(ArrayList<TheLoai> object) {
		int dem = 0;
		for(TheLoai tl : object) {
				insert(tl);
				++dem;
		}
		if(dem == object.size()) {
			System.out.println("Insert all successfully");
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(TheLoai object) {
		TheLoai target = selectById(object.getMaTheLoai());
		boolean status = false;
		if(target == null)
			return false;
		
		Connection c = JDBCUtil.connect();
		try {
			String sql = "DELETE FROM theloai WHERE matheloai=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, object.getMaTheLoai());
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
	public boolean deleteAll(ArrayList<TheLoai> object) {
		int dem = 0;
		for(TheLoai tl : object) {
			delete(tl);
			++dem;
		}
		if(dem == object.size()) {
			System.out.println("Delete all successfully");
			return true;
		}
		return false;
	}
	
	@Override
	public boolean update(TheLoai object) {
		TheLoai target = selectById(object.getMaTheLoai());
		if(target == null)
			return false;
		
		boolean status = false;
		Connection c = JDBCUtil.connect();
		try {
			String sql = "UPDATE theloai SET tentheloai=? WHERE matheloai=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, object.getTenTheLoai());
			pst.setString(2, object.getMaTheLoai());
			
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
