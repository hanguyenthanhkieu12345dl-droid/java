package communityuin.com;

import java.util.Scanner;

public class Hocscanner {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		// 1. Nhập số nguyên
		System.out.print("Nhập số nguyên: ");
		int a = sc.nextInt();

		// 2. Nhập số thực
		System.out.print("Nhập số double: ");
		double d = sc.nextDouble();

		System.out.print("Nhập số float: ");
		float f = sc.nextFloat();

		sc.nextLine(); // 🔥 bỏ Enter dư

		// 3. Nhập tên
		System.out.print("Mời bạn nhập tên: ");
		String ten = sc.nextLine();

		// 4. Nhập địa chỉ
		System.out.print("Mời bạn nhập địa chỉ: ");
		String diaChi = sc.nextLine();

		// 5. Nhập mã số (đã fix lỗi)
		System.out.print("Mời bạn nhập mã số: ");
		String maSo = sc.nextLine();

		// In kết quả
		System.out.println("\n--- THÔNG TIN ---");
		System.out.println("Số nguyên: " + a);
		System.out.println("Double: " + d);
		System.out.println("Float: " + f);
		System.out.println("Tên: " + ten);
		System.out.println("Địa chỉ: " + diaChi);
		System.out.println("Mã số: " + maSo);

		sc.close();
	}
}