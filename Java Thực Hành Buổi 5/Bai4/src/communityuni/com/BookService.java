package communityuni.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BookService {
    public static void handleBookMenu(Connection conn, Scanner scanner) {
        while (true) {
            System.out.println("\n--- QUẢN LÝ THÔNG TIN SÁCH ---");
            System.out.println("1. Xem toàn bộ danh sách sách");
            System.out.println("2. Thêm sách mới");
            System.out.println("3. Xóa sách");
            System.out.println("4. Cập nhật tên sách");
            System.out.println("5. Tìm kiếm sách (theo tên hoặc mã)");
            System.out.println("6. Quay lại");
            System.out.print("Mời chọn (1-6): ");
            int option = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (option) {
                    case 1:
                        showAllBooks(conn);
                        break;
                    case 2:
                        System.out.print("Nhập mã sách: "); String code = scanner.nextLine();
                        System.out.print("Nhập tên sách: "); String name = scanner.nextLine();
                        System.out.print("Nhập mã nhà xuất bản: "); String pubCode = scanner.nextLine();
                        String ins = "INSERT INTO tblBook VALUES(?, ?, ?)";
                        PreparedStatement pIns = conn.prepareStatement(ins);
                        pIns.setString(1, code); pIns.setString(2, name); pIns.setString(3, pubCode);
                        pIns.executeUpdate();
                        System.out.println("-> Thêm sách mới thành công!");
                        break;
                    case 3:
                        System.out.print("Nhập mã sách muốn xóa: "); String delCode = scanner.nextLine();
                        String del = "DELETE FROM tblBook WHERE BookCode = ?";
                        PreparedStatement pDel = conn.prepareStatement(del);
                        pDel.setString(1, delCode);
                        int checkDel = pDel.executeUpdate();
                        System.out.println(checkDel > 0 ? "-> Xóa thành công!" : "-> Không tìm thấy mã sách này.");
                        break;
                    case 4:
                        System.out.print("Nhập mã sách cần sửa: "); String upCode = scanner.nextLine();
                        System.out.print("Nhập tên sách mới: "); String newName = scanner.nextLine();
                        String up = "UPDATE tblBook SET BookName = ? WHERE BookCode = ?";
                        PreparedStatement pUp = conn.prepareStatement(up);
                        pUp.setString(1, newName); pUp.setString(2, upCode);
                        int checkUp = pUp.executeUpdate();
                        System.out.println(checkUp > 0 ? "-> Cập nhật thành công!" : "-> Không tìm thấy mã sách này.");
                        break;
                    case 5:
                        System.out.print("Nhập từ khóa tìm kiếm (Mã hoặc Tên): ");
                        String keyword = scanner.nextLine();
                        String search = "SELECT * FROM tblBook WHERE BookCode LIKE ? OR BookName LIKE ?";
                        PreparedStatement pSearch = conn.prepareStatement(search);
                        pSearch.setString(1, "%" + keyword + "%");
                        pSearch.setString(2, "%" + keyword + "%");
                        ResultSet rs = pSearch.executeQuery();
                        
                        System.out.println("\n============ KẾT QUẢ TÌM KIẾM ============");
                        System.out.printf("%-15s %-55s %-15s\n", "Mã Sách", "Tên Sách", "Mã NXB");
                        System.out.println("---------------------------------------------------------------------------------");
                        while(rs.next()) {
                            System.out.printf("%-15s %-55s %-15s\n", rs.getString("BookCode"), rs.getString("BookName"), rs.getString("PublisherCode"));
                        }
                        break;
                    case 6:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Lỗi xử lý sách: " + e.getMessage());
            }
        }
    }

    private static void showAllBooks(Connection conn) throws Exception {
        String sql = "SELECT * FROM tblBook";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        System.out.println("\n=================================== DANH SÁCH SÁCH HIỆN CÓ ===================================");
        System.out.printf("%-15s %-60s %-15s\n", "Mã Sách", "Tên Sách", "Mã NXB");
        System.out.println("----------------------------------------------------------------------------------------------");
        while(rs.next()) {
            System.out.printf("%-15s %-60s %-15s\n", rs.getString("BookCode"), rs.getString("BookName"), rs.getString("PublisherCode"));
        }
    }
}