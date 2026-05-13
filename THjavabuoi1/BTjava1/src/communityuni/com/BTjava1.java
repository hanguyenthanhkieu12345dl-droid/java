package communityuni.com;

import java.util.Scanner;

public class BTjava1 {

    public static int ucln(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

  
    public static boolean soHoanThien(int n) {
        int tong = 0;

        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                tong += i;
            }
        }

        return tong == n;
    }

   
    public static boolean toanChuSoChan(int n) {

        while (n > 0) {
            int digit = n % 10;

            if (digit % 2 != 0) {
                return false;
            }

            n /= 10;
        }

        return true;
    }

   
    public static long giaiThua(int n) {
        long gt = 1;

        for (int i = 1; i <= n; i++) {
            gt *= i;
        }

        return gt;
    }

    
    public static double tinhS(double x, int n) {
        double s = 0;

        for (int i = 0; i <= n; i++) {

            int mu = 2 * i + 1;

            double tu = Math.pow(x, mu);

            long mau = giaiThua(mu);

            s += tu / mau;
        }

        return s;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        System.out.print("Nhap a = ");
        int a = sc.nextInt();

        System.out.print("Nhap b = ");
        int b = sc.nextInt();

        System.out.println("UCLN = " + ucln(a, b));

        
        System.out.print("\nNhap n de kiem tra so hoan thien: ");
        int n1 = sc.nextInt();

        if (soHoanThien(n1)) {
            System.out.println(n1 + " la so hoan thien");
        } else {
            System.out.println(n1 + " khong phai la so hoan thien");
        }

        
        System.out.print("\nNhap n de kiem tra chu so chan: ");
        int n2 = sc.nextInt();

        if (toanChuSoChan(n2)) {
            System.out.println(n2 + " co toan chu so chan");
        } else {
            System.out.println(n2 + " khong phai toan chu so chan");
        }

        
        System.out.print("\nNhap x = ");
        double x = sc.nextDouble();

        System.out.print("Nhap n = ");
        int n = sc.nextInt();

        double ketQua = tinhS(x, n);

        System.out.println("S(" + x + "," + n + ") = " + ketQua);

        sc.close();
    }
}