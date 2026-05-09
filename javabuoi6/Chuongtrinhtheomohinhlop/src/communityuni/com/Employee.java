package communityuni.com;

public class Employee extends StaffMember {
    protected String socialSecurityNumber;
    protected double payRate;

    public Employee(String name, String address, String phone,
                    String socialSecurityNumber, double payRate) {
        super(name, address, phone);
        this.socialSecurityNumber = socialSecurityNumber;
        this.payRate = payRate;
    }

    
    public double pay() {
        return payRate;
    }

    
    public String toString() {
        return super.toString() +
                "\nMã BHXH: " + socialSecurityNumber +
                "\nLương cơ bản: " + payRate;
    }
}