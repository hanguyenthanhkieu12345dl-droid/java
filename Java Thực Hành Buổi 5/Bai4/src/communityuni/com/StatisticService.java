package communityuni.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StatisticService {
    public static void showPublisherStatistics(Connection conn) {
        try {
            String sql = "SELECT p.PublisherCode, p.PublisherName, COUNT(b.BookCode) AS TotalBooks " +
                         "FROM tblPublisher p " +
                         "LEFT JOIN tblBook b ON p.PublisherCode = b.PublisherCode " +
                         "GROUP BY p.PublisherCode, p.PublisherName";
            
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            System.out.println("\n================ THỐNG KÊ SỐ LƯỢNG SÁCH THEO NHÀ XUẤT BẢN ================");
            System.out.printf("%-15s %-30s %-20s\n", "Mã NXB", "Tên Nhà Xuất Bản", "Số Lượng Đầu Sách");
            System.out.println("--------------------------------------------------------------------------");
            while(rs.next()) {
                System.out.printf("%-15s %-30s %-20d\n", 
                        rs.getString("PublisherCode"), 
                        rs.getString("PublisherName"), 
                        rs.getInt("TotalBooks"));
            }
            System.out.println("--------------------------------------------------------------------------");
            
        } catch (Exception e) {
            System.out.println("Lỗi thống kê: " + e.getMessage());
        }
    }
}