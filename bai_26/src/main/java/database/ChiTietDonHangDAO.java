package database;

import java.util.ArrayList;

import model.ChiTietDonHang;
import model.DonHang;

public class ChiTietDonHangDAO implements DAO<ChiTietDonHang>{
	
	private ArrayList<ChiTietDonHang> chiTietDonHangList = new ArrayList<ChiTietDonHang>();
	
	
	@Override
	public ArrayList<ChiTietDonHang> selectAll() {
		return chiTietDonHangList;
	}

	@Override
	public ChiTietDonHang selectById(String object) {
		ChiTietDonHang target = null;
		for(ChiTietDonHang ctdh : chiTietDonHangList) {
			if(ctdh.getMaChiTietDonHang().equals(object)) {
				target = ctdh;
				break;
			}
		}
		return target;
	}

	@Override
	public boolean insert(ChiTietDonHang object) {
		boolean checkExist = chiTietDonHangList.contains(object);
		if(checkExist == false) {
			chiTietDonHangList.add(object);
			return true;
		}
		return false;
	}

	@Override
	public boolean insertAll(ArrayList<ChiTietDonHang> object) {
		int dem = 0;
		for(ChiTietDonHang ctdh : object) {
		     boolean checkExist = chiTietDonHangList.contains(ctdh);
		     if(checkExist == false) {
		    	 chiTietDonHangList.add(ctdh);
		    	 ++dem;
		     }
		}
		if(dem == object.size())
			return true;
		return false;
	}

	@Override
	public boolean delete(ChiTietDonHang object) {
		boolean checkExist = chiTietDonHangList.contains(object);
		if(checkExist == false) {
			return false;
		}
		for(ChiTietDonHang ctdh : chiTietDonHangList) {
			if(ctdh.getMaChiTietDonHang().equals(object.getMaChiTietDonHang())) {
				chiTietDonHangList.remove(ctdh);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean update(ChiTietDonHang object) {
		boolean checkExist = chiTietDonHangList.contains(object);
		if(checkExist == false) {
			return false;
		}
		for(ChiTietDonHang ctdh : chiTietDonHangList) {
			if(ctdh.getMaChiTietDonHang().equals(object.getMaChiTietDonHang())) {
				chiTietDonHangList.remove(ctdh);
				chiTietDonHangList.add(object);
				return true;
			}
		}
		return false;
	}
	
	public void deleteAll(DonHang dh) {
		for(ChiTietDonHang ctdh : chiTietDonHangList) {
			if(ctdh.getDonHang().equals(dh)) {
				chiTietDonHangList.remove(ctdh);
			}
		}
	}
	
}
