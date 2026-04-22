package communityuni.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class baitap2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập danh sách");
            System.out.println("2. Thêm phần tử");
            System.out.println("3. Sửa phần tử");
            System.out.println("4. Xóa phần tử");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Sắp xếp");
            System.out.println("7. Hiển thị");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng phần tử: ");
                    int n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
                        list.add(sc.nextInt());
                    }
                    break;

                case 2:
                    System.out.print("Nhập số cần thêm: ");
                    int x = sc.nextInt();
                    list.add(x);
                    break;

                case 3:
                    System.out.print("Nhập vị trí cần sửa: ");
                    int pos = sc.nextInt();
                    if (pos >= 0 && pos < list.size()) {
                        System.out.print("Nhập giá trị mới: ");
                        int newVal = sc.nextInt();
                        list.set(pos, newVal);
                    } else {
                        System.out.println("Vị trí không hợp lệ!");
                    }
                    break;

                case 4:
                    System.out.print("Nhập vị trí cần xóa: ");
                    int del = sc.nextInt();
                    if (del >= 0 && del < list.size()) {
                        list.remove(del);
                    } else {
                        System.out.println("Vị trí không hợp lệ!");
                    }
                    break;

                case 5:
                    System.out.print("Nhập số cần tìm: ");
                    int find = sc.nextInt();
                    if (list.contains(find)) {
                        System.out.println("Tìm thấy tại vị trí: " + list.indexOf(find));
                    } else {
                        System.out.println("Không tìm thấy!");
                    }
                    break;

                case 6:
                    Collections.sort(list);
                    System.out.println("Đã sắp xếp tăng dần!");
                    break;

                case 7:
                    System.out.println("Danh sách: " + list);
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Chọn sai!");
            }

        } while (choice != 0);

        sc.close();
    }
}