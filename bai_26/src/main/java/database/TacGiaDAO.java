package database;

import java.util.ArrayList;

import model.TacGia;

public class TacGiaDAO implements DAO<TacGia>{
	
	private ArrayList<TacGia> tacGiaList = new ArrayList<TacGia>();

	@Override
	public ArrayList<TacGia> selectAll() {
		return tacGiaList;
	}

	@Override
	public TacGia selectById(String object) {
		TacGia target = null;
		for(TacGia tg : tacGiaList) {
			if(tg.getMaTacGia().equals(object)) {
				target = tg;
				break;
			}
		}
		return target;
	}

	@Override
	public boolean insert(TacGia object) {
		boolean isExist = tacGiaList.contains(object);
		if(isExist == false) {
			tacGiaList.add(object);
			return true;
		}
		return false;
	}

	@Override
	public boolean insertAll(ArrayList<TacGia> object) {
		int dem = 0;
		for(TacGia tg : object) {
			boolean isExist = tacGiaList.contains(tg);
			if(isExist == false) {
				tacGiaList.add(tg);
				++dem;
			}
		}
		if(dem == object.size()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(TacGia object) {
		for(TacGia tg : tacGiaList) {
			if(tg.getMaTacGia().equals(object.getMaTacGia())) {
				tacGiaList.remove(tg);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean update(TacGia object) {
		for(TacGia tg: tacGiaList) {
			if(tg.getMaTacGia().equals(object.getMaTacGia())) {
				tacGiaList.remove(tg);
				tacGiaList.add(object);
				return true;
			}
		}
		return false;
	}

}
