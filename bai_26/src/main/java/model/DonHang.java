package model;

import java.sql.Date;
import java.util.Objects;

public class DonHang {
	private String maDonHang;
	private KhachHang khachHang;
	private String diaChiNguoiMua;
	private String diaChiNhanHang;
	private String trangThai;
	private String hinhThucThanhToan;
	private String trangThaiThanhToan;
	private double tienDaThanhToan;
	private double tienConThieu;
	private Date ngayDatHang;
	private Date ngayGiaoHang;
	public DonHang() {
		
	}
	
	public DonHang(String maDonHang, KhachHang khachHang, String diaChiNguoiMua, String diaChiNhanHang,
			String trangThai, String hinhThucThanhToan, String trangThaiThanhToan, double tienDaThanhToan,
			double tienConThieu, Date ngayDatHang, Date ngayGiaoHang) {
		super();
		this.maDonHang = maDonHang;
		this.khachHang = khachHang;
		this.diaChiNguoiMua = diaChiNguoiMua;
		this.diaChiNhanHang = diaChiNhanHang;
		this.trangThai = trangThai;
		this.hinhThucThanhToan = hinhThucThanhToan;
		this.setTrangThaiThanhToan(trangThaiThanhToan);
		this.tienDaThanhToan = tienDaThanhToan;
		this.tienConThieu = tienConThieu;
		this.ngayDatHang = ngayDatHang;
		this.ngayGiaoHang = ngayGiaoHang;
	}

	public String getMaDonHang() {
		return maDonHang;
	}
	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public String getDiaChiNguoiMua() {
		return diaChiNguoiMua;
	}
	public void setDiaChiNguoiMua(String diaChiNguoiMua) {
		this.diaChiNguoiMua = diaChiNguoiMua;
	}
	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}
	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}
	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}
	public double getTienDaThanhToan() {
		return tienDaThanhToan;
	}
	public void setTienDaThanhToan(double tienDaThanhToan) {
		this.tienDaThanhToan = tienDaThanhToan;
	}
	public double getTienConThieu() {
		return tienConThieu;
	}
	public void setTienConThieu(double tienConThieu) {
		this.tienConThieu = tienConThieu;
	}
	public Date getNgayDatHang() {
		return ngayDatHang;
	}
	public void setNgayDatHang(Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}
	public Date getNgayGiaoHang() {
		return ngayGiaoHang;
	}
	public void setNgayGiaoHang(Date ngayGiaoHang) {
		this.ngayGiaoHang = ngayGiaoHang;
	}

	public String getTrangThaiThanhToan() {
		return trangThaiThanhToan;
	}

	public void setTrangThaiThanhToan(String trangThaiThanhToan) {
		this.trangThaiThanhToan = trangThaiThanhToan;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDonHang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DonHang other = (DonHang) obj;
		return Objects.equals(maDonHang, other.maDonHang);
	}
	
	
	
	
	
	
	
}
