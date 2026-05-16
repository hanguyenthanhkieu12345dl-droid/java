package communityuni.com;

import java.util.ArrayList;
import java.util.Scanner;

public class InvoiceTest {

    static ArrayList<Invoice> ds = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Kiểm tra trùng mã
    public static boolean trungMa(String ma) {
        for (Invoice i : ds) {
            if (i.getPartNumber().equalsIgnoreCase(ma)) {
                return true;
            }
        }
        return false;
    }

    // Nhập danh sách
    public static void nhapDanhSach() {
        System.out.print("Nhập số lượng Invoice: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\nInvoice thứ " + (i + 1));

            String ma;
            do {
                System.out.print("Nhập mã mặt hàng: ");
                ma = sc.nextLine();

                if (trungMa(ma)) {
                    System.out.println("Mã bị trùng, nhập lại!");
                }

            } while (trungMa(ma));

            System.out.print("Nhập mô tả: ");
            String mota = sc.nextLine();

            System.out.print("Nhập số lượng: ");
            int sl = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập giá: ");
            double gia = Double.parseDouble(sc.nextLine());

            Invoice iv = new Invoice(ma, mota, sl, gia);
            ds.add(iv);
        }
    }

    // Xuất danh sách
    public static void xuatDanhSach() {
        if (ds.size() == 0) {
            System.out.println("Danh sách rỗng!");
            return;
        }

        for (Invoice i : ds) {
            i.display();
        }
    }

    // Sắp xếp theo mã mặt hàng
    public static void sapXepTheoMa() {
        for (int i = 0; i < ds.size() - 1; i++) {
            for (int j = i + 1; j < ds.size(); j++) {

                if (ds.get(i).getPartNumber()
                        .compareToIgnoreCase(ds.get(j).getPartNumber()) > 0) {

                    Invoice temp = ds.get(i);
                    ds.set(i, ds.get(j));
                    ds.set(j, temp);
                }
            }
        }

        System.out.println("Đã sắp xếp theo mã mặt hàng!");
    }

    // Tìm kiếm
    public static void timKiem() {
        System.out.print("Nhập mã cần tìm: ");
        String ma = sc.nextLine();

        boolean found = false;

        for (Invoice i : ds) {
            if (i.getPartNumber().equalsIgnoreCase(ma)) {
                i.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy!");
        }
    }

    // Xóa
    public static void xoaInvoice() {
        System.out.print("Nhập mã cần xóa: ");
        String ma = sc.nextLine();

        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getPartNumber().equalsIgnoreCase(ma)) {
                ds.remove(i);
                System.out.println("Đã xóa!");
                return;
            }
        }

        System.out.println("Không tìm thấy để xóa!");
    }

    public static void main(String[] args) {

        int chon;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập danh sách Invoice");
            System.out.println("2. Xuất danh sách");
            System.out.println("3. Sắp xếp theo mã");
            System.out.println("4. Tìm Invoice");
            System.out.println("5. Xóa Invoice");
            System.out.println("0. Thoát");

            System.out.print("Chọn: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {

            case 1:
                nhapDanhSach();
                break;

            case 2:
                xuatDanhSach();
                break;

            case 3:
                sapXepTheoMa();
                break;

            case 4:
                timKiem();
                break;

            case 5:
                xoaInvoice();
                break;

            case 0:
                System.out.println("Thoát chương trình!");
                break;

            default:
                System.out.println("Chọn không hợp lệ!");
            }

        } while (chon != 0);
    }
}