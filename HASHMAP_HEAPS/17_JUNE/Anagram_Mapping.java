import java.util.*;
import java.io.*;
// https://www.naukri.com/code360/problems/anagram-mapping_3125901?leftPanelTabValue=PROBLEM
public class Solution {
    public static int[] anagramMapping(int n, int[] a, int[] b) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < b.length; index++) {
            map.put(b[index], index);
        }

        int[] ans = new int[n];
        for (int index = 0; index < n; index++) {
            ans[index] = map.get(a[index]);
        }
        return ans;
    }
}