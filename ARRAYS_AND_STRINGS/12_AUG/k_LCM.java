import java.util.Scanner;
// https://codeforces.com/contest/1497/problem/C1
public class k_LCM {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        while (n-- > 0) {
            int number = scn.nextInt();
            int noOfBuckets = scn.nextInt();
            if (!isEven(number)) {
                int element = (number - 1) / 2;
                System.out.println(1 + " " + element + " " + element);
            } else {
                if (isEven(number / 2)) {
                    System.out.println(number / 2 + " " + number / 4 + " " + number / 4);
                } else {
                    int element = (number - 2) / 2;
                    System.out.println(2 + " " + element + " " + element);
                }
            }
        }
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
