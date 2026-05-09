package communityuni.com;

import java.util.ArrayList;

public class Staff {

    private ArrayList<StaffMember> staffList;

    public Staff() {
        staffList = new ArrayList<>();
    }

    public void addMember(StaffMember member) {
        staffList.add(member);
    }

   
    public void payday() {

        for (StaffMember staff : staffList) {

            System.out.println("");
            System.out.println(staff);

            double amount = staff.pay();

            if (amount == 0)
                System.out.println("Cam on tinh nguyen vien!");
            else
                System.out.println("Luong nhan duoc: " + amount);
        }
    }
}