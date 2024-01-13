import java.util.Scanner;
// https://codeforces.com/contest/1497/problem/C2
public class K_LCM_2 {
    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();

            while (n-- > 0) {
                StringBuilder sb = new StringBuilder();
                int number = scn.nextInt();
                int noOfBuckets = scn.nextInt();
                int noOfOnes = noOfBuckets - 3;
                number = number - noOfOnes;

                if (!isEven(number)) {
                    int element = (number - 1) / 2;
                    sb.append(1 + " " + element + " " + element);

                } else {
                    if (isEven(number / 2)) {
                        sb.append(number / 2 + " " + number / 4 + " " + number / 4);

                    } else {
                        int element = (number - 2) / 2;
                        sb.append(2 + " " + element + " " + element);

                    }
                }
                System.out.println(appendOnesToAns(sb, noOfOnes));
            }
        }
    }

    public static String appendOnesToAns(StringBuilder ans, int noOfOnes) {
        for (int index = 1; index <= noOfOnes; index++) {
            ans.append(" " + 1);
        }
        return ans.toString();
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
