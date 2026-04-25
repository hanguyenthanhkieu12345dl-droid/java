package communityuni.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Bai1 {

    public static void main(String[] args) {

        ArrayList<String> danhSach = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int chon;

        do {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Xuất danh sách sinh viên");
            System.out.println("3. Xóa sinh viên theo tên");
            System.out.println("4. Tìm sinh viên có chữ 'An'");
            System.out.println("5. Sắp xếp danh sách");
            System.out.println("6. Đếm số lượng sinh viên");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            chon = sc.nextInt();
            sc.nextLine(); // xóa bộ nhớ đệm

            switch (chon) {

                case 1:
                    System.out.print("Nhập tên sinh viên: ");
                    String ten = sc.nextLine();
                    danhSach.add(ten);
                    System.out.println("→ Đã thêm!");
                    break;

                case 2:
                    System.out.println("\nDanh sách sinh viên:");
                    if (danhSach.isEmpty()) {
                        System.out.println("Danh sách rỗng!");
                    } else {
                        for (int i = 0; i < danhSach.size(); i++) {
                            System.out.println((i + 1) + ". " + danhSach.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập tên cần xóa: ");
                    String tenXoa = sc.nextLine();
                    if (danhSach.remove(tenXoa)) {
                        System.out.println("→ Xóa thành công!");
                    } else {
                        System.out.println("→ Không tìm thấy!");
                    }
                    break;

                case 4:
                    System.out.println("Sinh viên có chữ 'An':");
                    boolean found = false;
                    for (String sv : danhSach) {
                        if (sv.contains("An")) {
                            System.out.println(sv);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Không có sinh viên nào!");
                    }
                    break;

                case 5:
                    Collections.sort(danhSach);
                    System.out.println("→ Đã sắp xếp!");
                    break;

                case 6:
                    System.out.println("→ Tổng số sinh viên: " + danhSach.size());
                    break;

                case 0:
                    System.out.println("Thoát chương trình!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (chon != 0);

        sc.close();
    }
}