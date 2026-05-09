package communityuni.com;

public class StaffMember {
    protected String name;
    protected String address;
    protected String phone;

    public StaffMember(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public double pay() {
        return 0;
    }

    
    public String toString() {
        return "Tên: " + name +
               "\nĐịa chỉ: " + address +
               "\nSĐT: " + phone;
    }
}