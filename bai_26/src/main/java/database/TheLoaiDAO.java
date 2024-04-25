package database;

import java.util.ArrayList;

import model.TheLoai;

public class TheLoaiDAO implements DAO<TheLoai>{
	private ArrayList<TheLoai> theLoaiList = new ArrayList<TheLoai>();

	@Override
	public ArrayList<TheLoai> selectAll() {
		return theLoaiList;
	}

	@Override
	public TheLoai selectById(String object) {
		TheLoai target = null;
		for(TheLoai tl : theLoaiList) {
			if(tl.getMaTheLoai().equals(object)) {
				target = tl;
				break;
			}
		}
		return target;
	}

	@Override
	public boolean insert(TheLoai object) {
		boolean checkExist = theLoaiList.contains(object);
		if(checkExist==false) {
			theLoaiList.add(object);
			return true;
		}
		return false;
	}

	@Override
	public boolean insertAll(ArrayList<TheLoai> object) {
		int dem = 0;
		for(TheLoai tl : object) {
			boolean checkExist = theLoaiList.contains(tl);
			if(checkExist==false) {
				theLoaiList.add(tl);
				++dem;
			}
		}
		if(dem == object.size())
			return true;
		return false;
	}

	@Override
	public boolean delete(TheLoai object) {
		for(TheLoai tl : theLoaiList) {
			if(tl.getMaTheLoai().equals(object.getMaTheLoai())) {
				theLoaiList.remove(tl);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean update(TheLoai object) {
		for(TheLoai tl : theLoaiList) {
			if(tl.getMaTheLoai().equals(object.getMaTheLoai())) {
				theLoaiList.remove(tl);
				theLoaiList.add(object);
				return true;
			}
		}
		return false;
	}
	
	
}
