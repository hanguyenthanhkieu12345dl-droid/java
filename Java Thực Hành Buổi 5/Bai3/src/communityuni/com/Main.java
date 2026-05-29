package communityuni.com;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection conn = null;

        try {
            conn = DBConnection.getConnection();
            System.out.println("=== KẾT NỐI HỆ THỐNG QUẢN LÝ SINH VIÊN THÀNH CÔNG ===");

            while (true) {
                System.out.println("\n===== MENU CHÍNH HỆ THỐNG =====");
                System.out.println("1. CHỨC NĂNG NHẬP LIỆU");
                System.out.println("2. CHỨC NĂNG TRA CỨU & THỐNG KÊ");
                System.out.println("3. Thoát chương trình");
                System.out.print("Mời bạn chọn phân hệ (1-3): ");
                int mainChoice = scanner.nextInt();
                scanner.nextLine(); 

                if (mainChoice == 1) {
                    DataInputService.menuNhapLieu(conn, scanner);
                } else if (mainChoice == 2) {
                    ReportService.menuThongKe(conn, scanner);
                } else if (mainChoice == 3) {
                    System.out.println("Đã đóng hệ thống. Tạm biệt!");
                    break;
                } else {
                    System.out.println("Lựa chọn không hợp lệ!");
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi kết nối hoặc thực thi hệ thống: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
                scanner.close();
            } catch (Exception e) {
                System.out.println("Lỗi khi đóng kết nối: " + e.getMessage());
            }
        }
    }
}