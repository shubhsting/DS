
// https://codeforces.com/contest/1526/problem/C2
import java.util.PriorityQueue;
import java.util.Scanner;

public class Potions {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long diff = 0;
        int ans = 0;
        for (int index = 0; index < n; index++) {
            int num = scn.nextInt();
            if (num > 0) {
                ans++;
                diff += num;
            } else {
                if (diff + num >= 0) {
                    pq.add(num);
                    diff += num;
                } else {
                    if (pq.size() > 0 && pq.peek() < num) {
                        diff -= pq.remove();
                        pq.add(num);
                        diff += num;
                    }
                }
            }
        }

        System.out.println(ans + pq.size());
    }
}
