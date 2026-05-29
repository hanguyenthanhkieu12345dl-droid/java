package communityuni.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ReportService {
    public static void menuThongKe(Connection conn, Scanner scanner) {
        while (true) {
            System.out.println("\n--- MENU TRA CỨU & THỐNG KÊ ---");
            System.out.println("1. Xem danh sách sinh viên kèm ĐIỂM SỐ tương ứng");
            System.out.println("2. Xem danh sách sinh viên thuộc một KHOA");
            System.out.println("3. Quay lại Menu chính");
            System.out.print("Chọn chức năng (1-3): ");
            int subChoice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (subChoice) {
                    case 1:
                        String queryDiem = "SELECT sv.MaSo, sv.HoTen, m.TenMH, kq.Diem " +
                                           "FROM SinhVien sv " +
                                           "INNER JOIN KetQua kq ON sv.MaSo = kq.MaSo " +
                                           "INNER JOIN Mon m ON kq.MaMH = m.MaMH";
                        Statement st1 = conn.createStatement();
                        ResultSet rs1 = st1.executeQuery(queryDiem);

                        System.out.println("\n================ BẢNG ĐIỂM SINH VIÊN ================");
                        System.out.printf("%-10s %-20s %-20s %-10s\n", "Mã Số", "Họ Tên", "Tên Môn Học", "Điểm");
                        System.out.println("-----------------------------------------------------");
                        while (rs1.next()) {
                            System.out.printf("%-10d %-20s %-20s %-10d\n", 
                                    rs1.getInt("MaSo"), rs1.getString("HoTen"), 
                                    rs1.getString("TenMH"), rs1.getInt("Diem"));
                        }
                        System.out.println("-----------------------------------------------------");
                        break;

                    case 2:
                        System.out.print("Nhập mã khoa cần tra cứu (ví dụ CNTT): ");
                        String targetKhoa = scanner.nextLine();

                        String queryKhoa = "SELECT MaSo, HoTen, NgaySinh, GioiTinh, DiaChi FROM SinhVien WHERE MaKhoa = ?";
                        PreparedStatement pst2 = conn.prepareStatement(queryKhoa);
                        pst2.setString(1, targetKhoa);
                        ResultSet rs2 = pst2.executeQuery();

                        System.out.println("\n========== DANH SÁCH SINH VIÊN KHOA: " + targetKhoa + " ==========");
                        System.out.printf("%-10s %-20s %-15s %-10s %-15s\n", "Mã Số", "Họ Tên", "Ngày Sinh", "Phái", "Địa Chỉ");
                        System.out.println("----------------------------------------------------------------------");
                        while (rs2.next()) {
                            String phai = rs2.getBoolean("GioiTinh") ? "Nam" : "Nữ";
                            System.out.printf("%-10d %-20s %-15s %-10s %-15s\n", 
                                    rs2.getInt("MaSo"), rs2.getString("HoTen"), 
                                    rs2.getString("NgaySinh"), phai, rs2.getString("DiaChi"));
                        }
                        System.out.println("----------------------------------------------------------------------");
                        break;

                    case 3:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (Exception e) {
                System.out.println("Lỗi tra cứu dữ liệu: " + e.getMessage());
            }
        }
    }
}