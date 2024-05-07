package model;

import java.sql.Date;

public class KhachHang {
	private String maKhachHang;
	private String tenDangNhap;
	private String matKhau;
	private String hoTen;
	private String diaChi;
	private String diaChiNhanHang;
	private String diaChiMuaHang;
	private Date ngaySinh;
	private String soDienThoai;
	private String gioiTinh;
	private boolean nhanBanTin;
	
	public KhachHang() {
		
	}

	public KhachHang(String maKhachHang, String tenDangNhap, String matKhau, String hoTen, String diaChi,
			String diaChiMuaHang, String diaChiNhanHang, Date ngaySinh, String soDienThoai,
			String gioiTinh, boolean nhanBanTin) {
		this.maKhachHang = maKhachHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.diaChiMuaHang = diaChiMuaHang;
		this.diaChiNhanHang = diaChiNhanHang;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.gioiTinh = gioiTinh;
		this.nhanBanTin = nhanBanTin;
	}
	

	public KhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public void setDiaChiMuaHang(String diaChiMuaHang) {
		this.diaChiMuaHang = diaChiMuaHang;
	}
	public String getDiaChiMuaHang() {
		return diaChiMuaHang;
	}
	
	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}
	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}

	

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}


	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public boolean isNhanBanTin() {
		return nhanBanTin;
	}

	public void setNhanBanTin(boolean nhanBanTin) {
		this.nhanBanTin = nhanBanTin;
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau
				+ ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", diaChiNhanHang=" + diaChiNhanHang + ", diaChiMuaHang="
				+ diaChiMuaHang + ", ngaySinh=" + ngaySinh + ", soDienThoai=" + soDienThoai + ", gioiTinh=" + gioiTinh
				+ ", nhanBanTin=" + nhanBanTin + "]";
	}
	
	
	
	
	
}
