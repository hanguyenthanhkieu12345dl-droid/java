package communityuni.com;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection conn = null;

        try {
            conn = DBConnection.getConnection();
            System.out.println("=== KẾT NỐI HỆ THỐNG QUẢN LÝ THƯ VIỆN THÀNH CÔNG ===");

            while (true) {
                System.out.println("\n========== MENU QUẢN LÝ THƯ VIỆN ==========");
                System.out.println("1. Quản lý thông tin SÁCH (Thêm, Xóa, Sửa, Xem)");
                System.out.println("2. Tìm kiếm sách nhanh (Theo Tên/Mã)");
                System.out.println("3. Xem danh sách nhà xuất bản hiện có");
                System.out.println("4. Quản lý danh mục NHÀ XUẤT BẢN");
                System.out.println("5. Thống kê số lượng sách theo từng NXB");
                System.out.println("6. Thoát chương trình");
                System.out.print("Mời bạn chọn chức năng (1-6): ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        BookService.handleBookMenu(conn, scanner);
                        break;
                    case 2:
                        System.out.print("Nhập từ khóa tìm kiếm nhanh: ");
                        String kw = scanner.nextLine();
                        String searchSql = "SELECT * FROM tblBook WHERE BookCode LIKE ? OR BookName LIKE ?";
                        java.sql.PreparedStatement ps = conn.prepareStatement(searchSql);
                        ps.setString(1, "%" + kw + "%");
                        ps.setString(2, "%" + kw + "%");
                        java.sql.ResultSet rs = ps.executeQuery();
                        System.out.println("\n============ KẾT QUẢ TÌM KIẾM NHANH ============");
                        while(rs.next()) {
                            System.out.println("[" + rs.getString("BookCode") + "] " + rs.getString("BookName"));
                        }
                        break;
                    case 3:
                        PublisherService.showAllPublishers(conn);
                        break;
                    case 4:
                        PublisherService.handlePublisherMenu(conn, scanner);
                        break;
                    case 5:
                        StatisticService.showPublisherStatistics(conn);
                        break;
                    case 6:
                        System.out.println("Đang tắt hệ thống thư viện. Tạm biệt!");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi vận hành hệ thống: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
                scanner.close();
            } catch (Exception e) {
                System.out.println("Lỗi đóng kết nối: " + e.getMessage());
            }
        }
    }
}