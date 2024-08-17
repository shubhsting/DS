// https://leetcode.com/problems/brick-wall/description/
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int temp = 0;
        for (int row = 0; row < wall.size(); row++) {
            int rowcoordinate = 0;
            for (int column = 0; column < wall.get(row).size() - 1; column++) {
                rowcoordinate += wall.get(row).get(column);
                map.put(rowcoordinate, map.getOrDefault(rowcoordinate, 0) + 1);
                temp = Math.max(map.get(rowcoordinate), temp);
            }
        }
        return wall.size() - temp;
    }
}
