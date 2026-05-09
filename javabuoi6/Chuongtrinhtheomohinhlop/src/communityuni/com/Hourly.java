package communityuni.com;

public class Hourly extends Employee {
    private int hoursWorked;

    public Hourly(String name, String address, String phone,
                  String socialSecurityNumber,
                  double payRate) {
        super(name, address, phone, socialSecurityNumber, payRate);
        hoursWorked = 0;
    }

    public void addHours(int moreHours) {
        hoursWorked += moreHours;
    }

  
    public double pay() {
        double salary = payRate * hoursWorked;
        hoursWorked = 0;
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nSố giờ làm: " + hoursWorked;
    }
}