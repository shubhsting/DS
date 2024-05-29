package DP.PEPCODING_IP.JULY_15;
// https://www.geeksforgeeks.org/problems/box-stacking/1
class Solution {
    public static class Box {
        int length;
        int width;
        int height;
        int area;

        Box(int height, int length, int width) {
            this.length = length;
            this.width = width;
            this.height = height;
            this.area = length * width;
        }
    }

    public static int maxHeight(int[] height, int[] width, int[] length, int n) {
        List<Box> list = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            list.add(new Box(length[index], Math.max(width[index], height[index]),
                    Math.min(width[index], height[index])));
            list.add(new Box(width[index], Math.max(height[index], length[index]),
                    Math.min(height[index], length[index])));
            list.add(new Box(height[index], Math.max(width[index], length[index]),
                    Math.min(width[index], length[index])));
        }
        //taking all combinations will also work.
        // for(int index = 0; index<n; index++) {
        //     list.add(new Box(length[index], width[index], height[index]));
        //     list.add(new Box(length[index], height[index], width[index]));
        //     list.add(new Box(width[index], height[index], length[index]));
        //     list.add(new Box(width[index], length[index], height[index]));
        //     list.add(new Box(height[index], width[index], length[index]));
        //     list.add(new Box(height[index], length[index], width[index]));

        // }
        Collections.sort(list, (Box a, Box b) -> {
            return b.area - a.area;
        });
        return LIS(list);
    }

    public static int LIS(List<Box> list) {
        int ans = 0;
        int[] dp = new int[list.size()];
        for (int index = 0; index < list.size(); index++) {
            int current_sub = list.get(index).height;
            for (int window = 0; window < index; window++) {
                if (list.get(window).width > list.get(index).width
                        && list.get(window).length > list.get(index).length) {
                    current_sub = Math.max(current_sub, dp[window] + list.get(index).height);
                }
            }
            dp[index] = current_sub;
            ans = Math.max(ans, dp[index]);
        }
        return ans;
    }
}
