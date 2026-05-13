package communityuni.com;

class Hinh {
    protected String mau;

    public Hinh(String mau) {
        this.mau = mau;
    }

    public double TinhDienTich() {
        return 0.0;
    }

    public double TinhChuVi() {
        return 0.0;
    }

    public String LayThongTin() {
        return "Mau sac: " + this.mau;
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
               ", Chieu rong: " + chieurong + 
               ", Dien tich: " + TinhDienTich() + 
               ", Chu vi: " + TinhChuVi();
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


public class BTjava3 {

    public static void main(String[] args) {
      
        HinhChuNhat hcn = new HinhChuNhat("Xanh duong", 10.0, 5.0);
        System.out.println("Thong tin HCN: " + hcn.LayThongTin());

        HinhVuong hv = new HinhVuong("Do", 4.0);
        System.out.println("Thong tin HV: " + hv.LayThongTin());
        
        
    }
}