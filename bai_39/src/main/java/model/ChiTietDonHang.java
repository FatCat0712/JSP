package model;

public class ChiTietDonHang {
	private String maChiTietDonHang;
	private DonHang donHang;
	private Sach sach;
	private int soLuong;
	private double giaBan;
	private double giamGia;
	private double giaGoc;
	
	public ChiTietDonHang() {}

	public ChiTietDonHang(String maChiTietDonHang, DonHang donHang, Sach sach, int soLuong, double giaGoc,
			double giaBan, double giamGia) {
		this.maChiTietDonHang = maChiTietDonHang;
		this.donHang = donHang;
		this.sach = sach;
		this.soLuong = soLuong;
		this.giaGoc = giaGoc;
		this.giaBan = giaBan;
		this.giamGia = giamGia;
	}

	public String getMaChiTietDonHang() {
		return maChiTietDonHang;
	}

	public void setMaChiTietDonHang(String maChiTietDonHang) {
		this.maChiTietDonHang = maChiTietDonHang;
	}

	public DonHang getDonHang() {
		return donHang;
	}

	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}

	public Sach getSach() {
		return sach;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaGoc() {
		return giaGoc;
	}

	public void setGiaBia(double giaGoc) {
		this.giaGoc = giaGoc;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}

	@Override
	public String toString() {
		return "ChiTietDonHang [maChiTietDonHang=" + maChiTietDonHang + ", donHang=" + donHang + ", sach=" + sach
				+ ", soLuong=" + soLuong + ", giaGoc=" + giaGoc + ", giaBan=" + giaBan + ", giamGia=" + giamGia + "]";
	}
	
	
	
	
}
