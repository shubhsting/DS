import java.util.*;
import java.io.*;
// https://www.naukri.com/code360/problems/line-reflection_1467109?leftPanelTabValue=PROBLEM
public class Solution {
    public static boolean lineReflection(int[][] points) {
        HashMap<String, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] point : points) {
            String key = point[0] + "#" + point[1];
            min = Math.min(min, point[0]);
            max = Math.max(max, point[0]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int mirror = min + max;
        for (int[] point : points) {
            int new_x = mirror - point[0];
            String point_a = point[0] + "#" + point[1];
            String mirror_image = new_x + "#" + point[1];
            if (map.containsKey(mirror_image) && map.containsKey(point_a)) {
                map.remove(point_a);
                map.remove(mirror_image);
            }
        }
        return map.keySet().size() == 0;
    }
}
