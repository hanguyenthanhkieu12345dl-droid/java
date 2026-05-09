package communityuni.com;

public class Main {

    public static void main(String[] args) {

        Staff staff = new Staff();

        
        Volunteer v = new Volunteer(
                "Nguyen Van A",
                "123 Quan 1",
                "0901234567"
        );
        staff.addMember(v);

        
        Executive e = new Executive(
                "Tran Thi B",
                "456 Quan 3",
                "0911223344",
                "SSN-001",
                5000.0
        );

        e.awardBonus(1500.0);
        staff.addMember(e);

        // 3. Thêm nhân viên tính lương theo giờ
        Hourly h = new Hourly(
                "Le Van C",
                "789 Quan 7",
                "0988776655",
                "SSN-002",
                20.0
        );

        h.addHours(40);
        staff.addMember(h);

        // 4. Thêm nhân viên thường
        Employee emp = new Employee(
                "Pham Minh D",
                "101 Thu Duc",
                "0977112233",
                "SSN-003",
                2500.0
        );

        staff.addMember(emp);

        // In danh sách thanh toán lương
        System.out.println("=== DANH SACH THANH TOAN LUONG ===");

        staff.payday();
    }
}