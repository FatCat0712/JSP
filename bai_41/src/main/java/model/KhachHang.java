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
	private String email;
	private String gioiTinh;
	private boolean nhanBanTin;
	private String maXacThuc;
	private Date thoiGianHieuLuc;
	private int trangThaiXacThuc;
	private String hinhAnh;
	
	
	public KhachHang() {
		
	}

	public KhachHang(String maKhachHang, String tenDangNhap, String matKhau, String hoTen, String diaChi,
			String diaChiMuaHang, String diaChiNhanHang, Date ngaySinh, String soDienThoai,String email,
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
		this.email = email;
		this.gioiTinh = gioiTinh;
		this.nhanBanTin = nhanBanTin;
	}
	

	public KhachHang(String maKhachHang, String tenDangNhap, String matKhau, String hoTen, String diaChi,
			String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, String soDienThoai,String email, String gioiTinh,
			boolean nhanBanTin, String maXacThuc, Date thoiGianHieuLuc, int trangThaiXacThuc) {
		this.maKhachHang = maKhachHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiMuaHang = diaChiMuaHang;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.gioiTinh = gioiTinh;
		this.nhanBanTin = nhanBanTin;
		this.maXacThuc = maXacThuc;
		this.thoiGianHieuLuc = thoiGianHieuLuc;
		this.trangThaiXacThuc = trangThaiXacThuc;
	}

	
	public KhachHang(String maKhachHang, String tenDangNhap, String matKhau, String hoTen, String diaChi,
			String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, String soDienThoai, String email,
			String gioiTinh, boolean nhanBanTin, String maXacThuc, Date thoiGianHieuLuc, int trangThaiXacThuc,
			String hinhAnh) {
		this.maKhachHang = maKhachHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiMuaHang = diaChiMuaHang;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.gioiTinh = gioiTinh;
		this.nhanBanTin = nhanBanTin;
		this.maXacThuc = maXacThuc;
		this.thoiGianHieuLuc = thoiGianHieuLuc;
		this.trangThaiXacThuc = trangThaiXacThuc;
		this.hinhAnh = hinhAnh;
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

	public String getMaXacThuc() {
		return maXacThuc;
	}

	public void setMaXacThuc(String maXacThuc) {
		this.maXacThuc = maXacThuc;
	}

	public Date getThoiGianHieuLuc() {
		return thoiGianHieuLuc;
	}

	public void setThoiGianHieuLuc(Date thoiGianHieuLuc) {
		this.thoiGianHieuLuc = thoiGianHieuLuc;
	}

	public int getTrangThaiXacThuc() {
		return trangThaiXacThuc;
	}

	public void setTrangThaiXacThuc(int trangThaiXacThuc) {
		this.trangThaiXacThuc = trangThaiXacThuc;
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau
				+ ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", diaChiNhanHang=" + diaChiNhanHang + ", diaChiMuaHang="
				+ diaChiMuaHang + ", ngaySinh=" + ngaySinh + ", soDienThoai=" + soDienThoai + ", gioiTinh=" + gioiTinh
				+ ", nhanBanTin=" + nhanBanTin + "]";
	}
	
	
	
	
	
}
