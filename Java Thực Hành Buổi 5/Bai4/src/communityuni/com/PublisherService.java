package communityuni.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PublisherService {
    public static void handlePublisherMenu(Connection conn, Scanner scanner) {
        while (true) {
            System.out.println("\n--- QUẢN LÝ NHÀ XUẤT BẢN ---");
            System.out.println("1. Xem danh sách nhà xuất bản");
            System.out.println("2. Thêm nhà xuất bản mới");
            System.out.println("3. Xóa nhà xuất bản");
            System.out.println("4. Cập nhật thông tin NXB");
            System.out.println("5. Quay lại");
            System.out.print("Mời chọn (1-5): ");
            int option = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (option) {
                    case 1:
                        showAllPublishers(conn);
                        break;
                    case 2:
                        System.out.print("Nhập mã NXB: "); String code = scanner.nextLine();
                        System.out.print("Nhập tên NXB: "); String name = scanner.nextLine();
                        System.out.print("Nhập địa chỉ: "); String addr = scanner.nextLine();
                        System.out.print("Nhập số điện thoại: "); String phone = scanner.nextLine();
                        String ins = "INSERT INTO tblPublisher VALUES(?, ?, ?, ?)";
                        PreparedStatement pIns = conn.prepareStatement(ins);
                        pIns.setString(1, code); pIns.setString(2, name); pIns.setString(3, addr); pIns.setString(4, phone);
                        pIns.executeUpdate();
                        System.out.println("-> Thêm NXB mới thành công!");
                        break;
                    case 3:
                        System.out.print("Nhập mã NXB muốn xóa: "); String delCode = scanner.nextLine();
                        String del = "DELETE FROM tblPublisher WHERE PublisherCode = ?";
                        PreparedStatement pDel = conn.prepareStatement(del);
                        pDel.setString(1, delCode);
                        int checkDel = pDel.executeUpdate();
                        System.out.println(checkDel > 0 ? "-> Xóa NXB thành công!" : "-> Không tìm thấy mã NXB.");
                        break;
                    case 4:
                        System.out.print("Nhập mã NXB cần sửa: "); String upCode = scanner.nextLine();
                        System.out.print("Nhập tên mới: "); String upName = scanner.nextLine();
                        System.out.print("Nhập địa chỉ mới: "); String upAddr = scanner.nextLine();
                        System.out.print("Nhập số ĐT mới: "); String upPhone = scanner.nextLine();
                        String up = "UPDATE tblPublisher SET PublisherName=?, Address=?, Phone=? WHERE PublisherCode=?";
                        PreparedStatement pUp = conn.prepareStatement(up);
                        pUp.setString(1, upName); pUp.setString(2, upAddr); pUp.setString(3, upPhone); pUp.setString(4, upCode);
                        int checkUp = pUp.executeUpdate();
                        System.out.println(checkUp > 0 ? "-> Cập nhật thành công!" : "-> Không tìm thấy mã NXB.");
                        break;
                    case 5:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Lỗi xử lý nhà xuất bản: " + e.getMessage());
            }
        }
    }

    public static void showAllPublishers(Connection conn) throws Exception {
        String sql = "SELECT * FROM tblPublisher";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        System.out.println("\n=================================== DANH SÁCH NHÀ XUẤT BẢN ===================================");
        System.out.printf("%-15s %-25s %-45s %-15s\n", "Mã NXB", "Tên NXB", "Địa Chỉ", "Điện Thoại");
        System.out.println("----------------------------------------------------------------------------------------------");
        while(rs.next()) {
            System.out.printf("%-15s %-25s %-45s %-15s\n", rs.getString("PublisherCode"), rs.getString("PublisherName"), rs.getString("Address"), rs.getString("Phone"));
        }
    }
}