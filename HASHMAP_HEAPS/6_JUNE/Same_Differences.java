import java.util.*;

//https://codeforces.com/contest/1520/problem/D
public class Solution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tc = scn.nextInt();
        while (tc-- > 0) {
            int n = scn.nextInt();
            long ans = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int index = 0; index < n; index++) {
                int num = scn.nextInt();
                if (map.containsKey(num - index)) {
                    ans += map.get(num - index);
                    map.put(num - index, map.get(num - index) + 1);
                } else {
                    map.put(num - index, 1);
                }
            }
            System.out.println(ans);
        }
    }
}