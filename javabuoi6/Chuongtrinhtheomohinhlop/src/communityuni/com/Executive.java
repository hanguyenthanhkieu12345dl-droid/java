package communityuni.com;

public class Executive extends Employee {
    private double bonus;

    public Executive(String name, String address, String phone,
                     String socialSecurityNumber,
                     double payRate) {
        super(name, address, phone, socialSecurityNumber, payRate);
        bonus = 0;
    }

    public void awardBonus(double execBonus) {
        bonus += execBonus;
    }

    public double pay() {
        return payRate + bonus;
    }
}