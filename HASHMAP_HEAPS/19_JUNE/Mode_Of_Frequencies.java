import java.util.*;
import java.lang.*;
import java.io.*;
// https://www.codechef.com/problems/MODEFREQ?tab=statement
class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scn = new Scanner(System.in);
        int tc = scn.nextInt();
        while (tc-- > 0) {
            int n = scn.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            int maxNumber = Integer.MAX_VALUE;
            int maxCount = 0;
            for (int index = 0; index < n; index++) {
                int number = scn.nextInt();
                map.put(number, map.getOrDefault(number, 0) + 1);

            }
            HashMap<Integer, Integer> freqMap = new HashMap<>();
            for (int key : map.keySet()) {
                int freq = map.get(key);
                freqMap.put(freq, freqMap.getOrDefault(freq, 0) + 1);
                if (freqMap.get(freq) >= maxCount) {

                    maxNumber = freqMap.get(freq) > maxCount ? freq : Math.min(maxNumber, freq);
                    maxCount = freqMap.get(freq);
                }
            }
            System.out.println(maxNumber);
        }

    }
}
