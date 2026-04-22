package communityuni.com;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class baitap3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> books = new HashMap<>();
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sách");
            System.out.println("2. Xuất danh sách");
            System.out.println("3. Sửa sách");
            System.out.println("4. Xóa sách");
            System.out.println("5. Tìm kiếm");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = sc.nextInt();
            sc.nextLine(); // tránh lỗi nhập chuỗi

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã sách: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nhập tên sách: ");
                    String name = sc.nextLine();
                    books.put(id, name);
                    System.out.println("Đã thêm!");
                    break;

                case 2:
                    if (books.isEmpty()) {
                        System.out.println("Danh sách trống!");
                    } else {
                        System.out.println("Danh sách sách:");
                        for (Map.Entry<Integer, String> entry : books.entrySet()) {
                            System.out.println("Mã: " + entry.getKey() + " - Tên: " + entry.getValue());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã sách cần sửa: ");
                    int editId = sc.nextInt();
                    sc.nextLine();
                    if (books.containsKey(editId)) {
                        System.out.print("Nhập tên mới: ");
                        String newName = sc.nextLine();
                        books.put(editId, newName);
                        System.out.println("Đã sửa!");
                    } else {
                        System.out.println("Không tìm thấy mã sách!");
                    }
                    break;

                case 4:
                    System.out.print("Nhập mã sách cần xóa: ");
                    int delId = sc.nextInt();
                    if (books.containsKey(delId)) {
                        books.remove(delId);
                        System.out.println("Đã xóa!");
                    } else {
                        System.out.println("Không tìm thấy!");
                    }
                    break;

                case 5:
                    System.out.print("Nhập mã sách cần tìm: ");
                    int findId = sc.nextInt();
                    if (books.containsKey(findId)) {
                        System.out.println("Tên sách: " + books.get(findId));
                    } else {
                        System.out.println("Không tìm thấy!");
                    }
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