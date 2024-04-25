package database;

import java.util.ArrayList;

import model.KhachHang;

public class KhachHangDAO implements DAO<KhachHang>{
	
	private ArrayList<KhachHang> khachHangList = new ArrayList<KhachHang>();

	@Override
	public ArrayList<KhachHang> selectAll() {
		return khachHangList;
	}

	@Override
	public KhachHang selectById(String object) {
		KhachHang target = null;
		for(KhachHang kh : khachHangList) {
			if(kh.getMaKhachHang().equals(object)) {
				target = kh;
				break;
			}
		}
		return target;
	}

	@Override
	public boolean insert(KhachHang object) {
		boolean checkExist = khachHangList.contains(object);
		if(checkExist == false) {
			khachHangList.add(object);
			return true;
		}
		return false;
	}

	@Override
	public boolean insertAll(ArrayList<KhachHang> object) {
		int dem = 0;
		for(KhachHang kh : object) {
		     boolean checkExist = khachHangList.contains(kh);
		     if(checkExist == false) {
		    	 khachHangList.add(kh);
		    	 ++dem;
		     }
		}
		if(dem == object.size())
			return true;
		return false;
	}

	@Override
	public boolean delete(KhachHang object) {
		boolean checkExist = khachHangList.contains(object);
		if(checkExist == false) {
			return false;
		}
		for(KhachHang kh : khachHangList) {
			if(kh.getMaKhachHang().equals(object.getMaKhachHang())) {
				khachHangList.remove(kh);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean update(KhachHang object) {
		boolean checkExist = khachHangList.contains(object);
		if(checkExist == false) {
			return false;
		}
		for(KhachHang kh : khachHangList) {
			if(kh.getMaKhachHang().equals(object.getMaKhachHang())) {
				khachHangList.remove(kh);
				khachHangList.add(object);
				return true;
			}
		}
		return false;
	}

}
