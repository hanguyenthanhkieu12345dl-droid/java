package communityuni.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/QuanAnNhanhDB";
    private static final String USER = "root"; 
    private static final String PASSWORD = "Kobietgihet1904";

    private static Connection conn = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("=== KẾT NỐI HỆ THỐNG E-ORDER THÀNH CÔNG ===");

            while (true) {
                System.out.println("\n--- GIAO DIỆN PDA PHỤC VỤ ---");
                System.out.println("1. Xem danh sách món ăn");
                System.out.println("2. Tạo Order mới cho khách tại bàn");
                System.out.println("3. Thoát hệ thống");
                System.out.print("Chọn chức năng (1-3): ");
                int luaChon = scanner.nextInt();

                switch (luaChon) {
                    case 1:
                        hienThiDanhSachMonAn();
                        break;
                    case 2:
                        thucHienOrder();
                        break;
                    case 3:
                        System.out.println("Đang tắt thiết bị PDA. Tạm biệt!");
                        if (conn != null) conn.close();
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            }
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void hienThiDanhSachMonAn() throws Exception {
        String sql = "SELECT * FROM MonAn";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\n===== THỰC ĐƠN QUÁN ĂN =====");
        System.out.printf("%-10s %-25s %-10s\n", "Mã Món", "Tên Món Ăn", "Giá (VNĐ)");
        System.out.println("----------------------------------------------");
        while (rs.next()) {
            System.out.printf("%-10d %-25s %-10.0f\n", 
                    rs.getInt("ma_mon"), 
                    rs.getString("ten_mon"), 
                    rs.getDouble("gia"));
        }
        System.out.println("----------------------------------------------");
    }

    private static void thucHienOrder() {
        try {
            System.out.print("\nNhập số bàn của khách: ");
            int soBan = scanner.nextInt();

            String sqlOrder = "INSERT INTO PhieuOrder (so_ban, trang_thai) VALUES (?, 'Đã gửi xuống bếp')";
            PreparedStatement pstmtOrder = conn.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS);
            pstmtOrder.setInt(1, soBan);
            pstmtOrder.executeUpdate();

            ResultSet rsKeys = pstmtOrder.getGeneratedKeys();
            int maOrderMoi = -1;
            if (rsKeys.next()) {
                maOrderMoi = rsKeys.getInt(1);
            }

            hienThiDanhSachMonAn();
            while (true) {
                System.out.print("Nhập MÃ MÓN ăn khách gọi (Nhập 0 để kết thúc chọn món): ");
                int maMon = scanner.nextInt();
                if (maMon == 0) {
                    break;
                }

                System.out.print("Nhập số lượng: ");
                int soLuong = scanner.nextInt();
                if (soLuong <= 0) {
                    System.out.println("Số lượng không hợp lệ, vui lòng chọn lại!");
                    continue;
                }

                String sqlChiTiet = "INSERT INTO ChiTietOrder (ma_order, ma_mon, so_luong) VALUES (?, ?, ?)";
                PreparedStatement pstmtChiTiet = conn.prepareStatement(sqlChiTiet);
                pstmtChiTiet.setInt(1, maOrderMoi);
                pstmtChiTiet.setInt(2, maMon);
                pstmtChiTiet.setInt(3, soLuong);
                pstmtChiTiet.executeUpdate();
                
                System.out.println("-> Đã thêm món vào danh sách chờ.");
            }

            System.out.println("\n[PDA] Đang kích hoạt chức năng 'SEND ORDER'...");
            System.out.println("[Wireless] Đang truyền dữ liệu xuống nhà bếp...");
            System.out.println("=== THÀNH CÔNG: Bếp đã nhận được dữ liệu của bàn số " + soBan + "! ===");

        } catch (Exception e) {
            System.out.println("Lỗi trong quá trình Order: " + e.getMessage());
        }
    }
}