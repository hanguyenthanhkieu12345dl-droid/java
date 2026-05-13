package communityuni.com;

class Hinh {
	protected String mau;

	public Hinh(String mau) {
		this.mau = mau;
	}

	public double TinhDienTich() {
		return 0;
	}

	public double TinhChuVi() {
		return 0;
	}

	public String LayThongTin() {
		return "Mau sac: " + mau;
	}
}

class HinhChuNhat extends Hinh {
	protected double chieudai;
	protected double chieurong;

	public HinhChuNhat(String mau, double chieudai, double chieurong) {
		super(mau);
		this.chieudai = chieudai;
		this.chieurong = chieurong;
	}

	public double TinhDienTich() {
		return chieudai * chieurong;
	}

	
	public double TinhChuVi() {
		return (chieudai + chieurong) * 2;
	}

	
	public String LayThongTin() {
		return super.LayThongTin() +
			   ", Chieu dai: " + chieudai +
			   ", Chieu rong: " + chieurong;
	}
}

class HinhTron extends Hinh {
	private double bankinh;

	public HinhTron(String mau, double bankinh) {
		super(mau);
		this.bankinh = bankinh;
	}

	public double TinhDienTich() {
		return Math.PI * bankinh * bankinh;
	}

	public double TinhChuVi() {
		return 2 * Math.PI * bankinh;
	}
	
	public String LayThongTin() {
		return super.LayThongTin() +
			   ", Ban kinh: " + bankinh;
	}
}


class HinhVuong extends HinhChuNhat {

	public HinhVuong(String mau, double canh) {
		super(mau, canh, canh);
	}


	public String LayThongTin() {
		return "Hinh Vuong -> " + super.LayThongTin();
	}
}


public class BTjava4 {

	public static void main(String[] args) {

		HinhChuNhat hcn = new HinhChuNhat("Xanh", 10, 5);

	
		HinhTron ht = new HinhTron("Do", 7);

		HinhVuong hv = new HinhVuong("Vang", 4);

	
		System.out.println("===== HINH CHU NHAT =====");
		System.out.println(hcn.LayThongTin());
		System.out.println("Dien tich: " + hcn.TinhDienTich());
		System.out.println("Chu vi: " + hcn.TinhChuVi());

		
		System.out.println("\n===== HINH TRON =====");
		System.out.println(ht.LayThongTin());
		System.out.println("Dien tich: " + ht.TinhDienTich());
		System.out.println("Chu vi: " + ht.TinhChuVi());

		
		System.out.println("\n===== HINH VUONG =====");
		System.out.println(hv.LayThongTin());
		System.out.println("Dien tich: " + hv.TinhDienTich());
		System.out.println("Chu vi: " + hv.TinhChuVi());
	}
}