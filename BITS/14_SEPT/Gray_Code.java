// https://leetcode.com/problems/gray-code/
class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 1) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(0);
            ans.add(1);
            return ans;
        }

        List<Integer> temp = grayCode(n - 1);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int no : temp) {
            ans.add(no);
        }
        for (int index = temp.size() - 1; index >= 0; index--) {
            ans.add(temp.get(index) | 1 << n - 1);
        }
        return ans;
    }
}