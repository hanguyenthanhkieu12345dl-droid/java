package communityuni.com;

import java.util.Scanner;

// Lớp NhanVien
class NhanVien {
    private String ho;
    private String ten;
    private int soSP;

    // Constructor
    public NhanVien(String ho, String ten, int soSP) {
        this.ho = ho;
        this.ten = ten;
        this.soSP = (soSP < 0) ? 0 : soSP;
    }

    // Getter
    public int getSoSP() {
        return soSP;
    }

    // Đơn giá
    public double getDonGia() {
        if (soSP >= 1 && soSP <= 199)
            return 0.5;
        else if (soSP <= 399)
            return 0.55;
        else if (soSP <= 599)
            return 0.6;
        else
            return 0.65;
    }

    // Tính lương
    public double getLuong() {
        return soSP * getDonGia();
    }

    // Xuất thông tin
    public void xuat() {
        System.out.println(ho + " " + ten +
                " | SP: " + soSP +
                " | Lương: " + getLuong());
    }
}

// Class main
public class bai1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập NV1
        System.out.println("Nhập nhân viên 1:");
        System.out.print("Họ: ");
        String ho1 = sc.nextLine();
        System.out.print("Tên: ");
        String ten1 = sc.nextLine();
        System.out.print("Số sản phẩm: ");
        int sp1 = sc.nextInt();
        sc.nextLine();

        NhanVien nv1 = new NhanVien(ho1, ten1, sp1);

        // Nhập NV2
        System.out.println("\nNhập nhân viên 2:");
        System.out.print("Họ: ");
        String ho2 = sc.nextLine();
        System.out.print("Tên: ");
        String ten2 = sc.nextLine();
        System.out.print("Số sản phẩm: ");
        int sp2 = sc.nextInt();

        NhanVien nv2 = new NhanVien(ho2, ten2, sp2);

        // Xuất kết quả
        System.out.println("\n--- Thông tin nhân viên ---");
        nv1.xuat();
        nv2.xuat();

        sc.close();
    }
}