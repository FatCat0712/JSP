package database;

import java.util.ArrayList;
import java.util.Objects;

import model.DonHang;

public class DonHangDAO implements DAO<DonHang>{
	private ArrayList<DonHang> donHangList = new ArrayList<DonHang>();

	@Override
	public ArrayList<DonHang> selectAll() {
		return donHangList;
	}

	@Override
	public DonHang selectById(String object) {
		DonHang donHang = null;
		for(DonHang d: donHangList) {
			if(d.getMaDonHang().equals(object)) {
				donHang = d;
				break;
			}
		}
		return donHang;
	}

	@Override
	public boolean insert(DonHang object) {
		boolean checkExist = donHangList.contains(object);
		if(checkExist == false) {
			donHangList.add(object);
			return true;
		}
		return false;
	}

	@Override
	public boolean insertAll(ArrayList<DonHang> object) {
		int dem = 0;
		for(DonHang dh : object) {
			boolean checkExist = donHangList.contains(dh);
			if(checkExist == false) {
				donHangList.add(dh);
				++dem;
			}
		}
		if(dem == object.size())
			return true;
		return false;
	}

	@Override
	public boolean delete(DonHang object) {
		for(DonHang dh : donHangList) {
			if(dh.getMaDonHang().equals(object.getMaDonHang())) {
				// xoa chi tiet don hang
				ChiTietDonHangDAO ctdh = new ChiTietDonHangDAO();
				ctdh.deleteAll(dh);
				
				
				// xoa don hang
				donHangList.remove(dh);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean update(DonHang object) {
		for(DonHang dh : donHangList) {
			if(dh.getMaDonHang().equals(object.getMaDonHang())) {
				donHangList.remove(dh);
				donHangList.add(object);
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(donHangList);
	}

	
	
	
}
