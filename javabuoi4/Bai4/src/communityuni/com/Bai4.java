package communityuni.com;

public class Bai4 {

    // Hàm kiểm tra số nguyên tố
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        // Mảng theo đề bài
        int[] M = {3,6,7,8,11,17,2,90,2,5,4,5,8};

        int demLe = 0, demChan = 0;

        // Dòng 1: Số lẻ
        System.out.print("Dòng 1 (Số lẻ): ");
        for (int x : M) {
            if (x % 2 != 0) {
                System.out.print(x + " ");
                demLe++;
            }
        }
        System.out.println("→ Có " + demLe + " số lẻ");

        // Dòng 2: Số chẵn
        System.out.print("\nDòng 2 (Số chẵn): ");
        for (int x : M) {
            if (x % 2 == 0) {
                System.out.print(x + " ");
                demChan++;
            }
        }
        System.out.println("→ Có " + demChan + " số chẵn");

        // Dòng 3: Số nguyên tố
        System.out.print("\nDòng 3 (Số nguyên tố): ");
        for (int x : M) {
            if (isPrime(x)) {
                System.out.print(x + " ");
            }
        }

        // Dòng 4: Không phải số nguyên tố
        System.out.print("\nDòng 4 (Không phải số nguyên tố): ");
        for (int x : M) {
            if (!isPrime(x)) {
                System.out.print(x + " ");
            }
        }
    }
}