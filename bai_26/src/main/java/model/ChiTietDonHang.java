package model;

public class ChiTietDonHang {
	private String maChiTietDonHang;
	private DonHang donHang;
	private Sach sach;
	private int soLuong;
	private double giaBia;
	private double giaBan;
	private double giamGia;
	
	public ChiTietDonHang() {}

	public ChiTietDonHang(String maChiTietDonHang, DonHang donHang, Sach sach, int soLuong, double giaBia,
			double giaBan, double giamGia) {
		this.maChiTietDonHang = maChiTietDonHang;
		this.donHang = donHang;
		this.sach = sach;
		this.soLuong = soLuong;
		this.giaBia = giaBia;
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

	public double getGiaBia() {
		return giaBia;
	}

	public void setGiaBia(double giaBia) {
		this.giaBia = giaBia;
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
	
	
	
	
}
