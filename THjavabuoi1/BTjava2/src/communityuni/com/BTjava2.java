package communityuni.com;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BTjava2 {

    public static void NegativeNumberInStrings(String str) {

        Pattern pattern = Pattern.compile("-\\d+");

        Matcher matcher = pattern.matcher(str);

        boolean found = false;

        System.out.println("Cac so am trong chuoi:");

        while (matcher.find()) {

            System.out.println(matcher.group());

            found = true;
        }

        if (found == false) {
            System.out.println("Khong co so am trong chuoi");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap chuoi: ");
        String str = sc.nextLine();

        NegativeNumberInStrings(str);

        sc.close();
    }

}