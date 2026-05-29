package communityuni.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DataInputService {
    public static void menuNhapLieu(Connection conn, Scanner scanner) {
        while (true) {
            System.out.println("\n--- MENU NHẬP LIỆU ---");
            System.out.println("1. Thêm Khoa mới");
            System.out.println("2. Thêm Môn học mới");
            System.out.println("3. Thêm Sinh viên mới");
            System.out.println("4. Nhập Điểm thi");
            System.out.println("5. Quay lại Menu chính");
            System.out.print("Chọn chức năng (1-5): ");
            int subChoice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (subChoice) {
                    case 1:
                        System.out.print("Nhập mã khoa (nchar 6): "); String maKhoa = scanner.nextLine();
                        System.out.print("Nhập tên khoa: "); String tenKhoa = scanner.nextLine();
                        String sql1 = "INSERT INTO KHOA VALUES(?, ?)";
                        PreparedStatement pst1 = conn.prepareStatement(sql1);
                        pst1.setString(1, maKhoa); pst1.setString(2, tenKhoa);
                        pst1.executeUpdate();
                        System.out.println("-> Thêm khoa thành công!");
                        break;
                    case 2:
                        System.out.print("Nhập mã môn học (nchar 6): "); String maMH = scanner.nextLine();
                        System.out.print("Nhập tên môn học: "); String tenMH = scanner.nextLine();
                        System.out.print("Nhập số tiết: "); int soTiet = scanner.nextInt();
                        String sql2 = "INSERT INTO Mon VALUES(?, ?, ?)";
                        PreparedStatement pst2 = conn.prepareStatement(sql2);
                        pst2.setString(1, maMH); pst2.setString(2, tenMH); pst2.setInt(3, soTiet);
                        pst2.executeUpdate();
                        System.out.println("-> Thêm môn học thành công!");
                        break;
                    case 3:
                        System.out.print("Nhập mã số sinh viên (int): "); int maSo = scanner.nextInt(); scanner.nextLine();
                        System.out.print("Nhập họ tên: "); String hoTen = scanner.nextLine();
                        System.out.print("Nhập ngày sinh (YYYY-MM-DD): "); String ngaySinh = scanner.nextLine();
                        System.out.print("Giới tính (1: Nam, 0: Nữ): "); int gioiTinh = scanner.nextInt(); scanner.nextLine();
                        System.out.print("Nhập địa chỉ: "); String diaChi = scanner.nextLine();
                        System.out.print("Nhập số điện thoại: "); int sdt = scanner.nextInt(); scanner.nextLine();
                        System.out.print("Nhập mã khoa của sinh viên: "); String mKhoa = scanner.nextLine();
                        
                        String sql3 = "INSERT INTO SinhVien VALUES(?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement pst3 = conn.prepareStatement(sql3);
                        pst3.setInt(1, maSo); pst3.setString(2, hoTen); pst3.setString(3, ngaySinh);
                        pst3.setInt(4, gioiTinh); pst3.setString(5, diaChi); pst3.setInt(6, sdt); pst3.setString(7, mKhoa);
                        pst3.executeUpdate();
                        System.out.println("-> Thêm sinh viên thành công!");
                        break;
                    case 4:
                        System.out.print("Nhập mã số sinh viên: "); int ms = scanner.nextInt(); scanner.nextLine();
                        System.out.print("Nhập mã môn học: "); String mmh = scanner.nextLine();
                        System.out.print("Nhập điểm số (int): "); int diem = scanner.nextInt();
                        
                        String sql4 = "INSERT INTO KetQua VALUES(?, ?, ?)";
                        PreparedStatement pst4 = conn.prepareStatement(sql4);
                        pst4.setInt(1, ms); pst4.setString(2, mmh); pst4.setInt(3, diem);
                        pst4.executeUpdate();
                        System.out.println("-> Cập nhật điểm thành công!");
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (Exception e) {
                System.out.println("Lỗi xử lý nhập liệu: " + e.getMessage());
            }
        }
    }
}