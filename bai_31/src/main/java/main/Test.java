package main;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import dao.DonHangDAO;
import dao.KhachHangDAO;
import dao.SachDAO;
import dao.TacGiaDAO;
import dao.TheLoaiDAO;
import database.JDBCUtil;
import model.DonHang;
import model.KhachHang;
import model.Sach;
import model.TacGia;
import model.TheLoai;

public class Test {
	public static void main(String[] args) {
//		ArrayList<DonHang> data = DonHangDAO.getInstance().selectAll();
//		for(DonHang tg : data) {
//			System.out.println(tg);
//		}
		
//		Sach tl = SachDAO.getInstance().selectById("SP1");
//		System.out.println(tl);
		
//	    Sach s = new Sach("SP6","Conan",new TacGia("TG3","",null,""),2024,200000,150000,230000,10,new TheLoai("TT",""),"Tiếng Việt","Dành cho trẻ em");
//	    SachDAO.getInstance().insert(s);
		
//		ArrayList<TheLoai> data = new ArrayList<TheLoai>();
//		data.add(new TheLoai("TC","Tài Chính"));
//		data.add(new TheLoai("DS","Đời sống"));
		
//		TheLoaiDAO.getInstance().insertAll(data);
		
	//	Sach tl = new Sach("SP6","");
	//	SachDAO.getInstance().delete(s);
		
//		TheLoaiDAO.getInstance().deleteAll(data);
		
//	    Sach s = new Sach("SP6","Doraemon",new TacGia("TG4","",null,""),2024,200000,150000,230000,10,new TheLoai("TT",""),"Tiếng Việt","Dành cho trẻ em");
//		SachDAO.getInstance().update(s);
		
		boolean result = KhachHangDAO.getInstance().containUser("sonhai");
		System.out.println(result);
	}
}
