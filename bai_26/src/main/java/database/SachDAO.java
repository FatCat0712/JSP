package database;

import java.util.ArrayList;

import model.Sach;

public class SachDAO implements DAO<Sach>{
	private ArrayList<Sach> sachList = new ArrayList<Sach>();
		
	@Override
	public ArrayList<Sach> selectAll() {
		return sachList;
	}

	@Override
	public Sach selectById(String object) {
		Sach target = null;
		for(Sach s : sachList) {
			if(s.getMaSach().equals(object)) {
				target = s;
				break;
			}
		}
		return target;
	}

	@Override
	public boolean insert(Sach object) {
		boolean checkExist = sachList.contains(object);
		if(checkExist == false) {
			sachList.add(object);
			return true;
		}
		return false;
	}

	@Override
	public boolean insertAll(ArrayList<Sach> object) {
		int dem = 0;
		for(Sach s: object) {
			boolean checkExist = sachList.contains(s);
			if(checkExist == false) {
				sachList.add(s);
				++dem;
			}
		}
		if(dem == object.size())
			return true;
		return false;
	}

	@Override
	public boolean delete(Sach object) {
		for(Sach s : sachList) {
			if(s.getMaSach().equals(object.getMaSach())) {
				sachList.remove(s);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean update(Sach object) {
		for(Sach s : sachList) {
			if(s.getMaSach().equals(object.getMaSach())) {
				sachList.remove(s);
				sachList.add(object);
				return true;
			}
		}
		return false;
	}
	
}
