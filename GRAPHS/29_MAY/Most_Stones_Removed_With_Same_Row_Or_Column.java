import java.util.HashMap;
// complexity: O(E)
class Solution {
    // https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/
    class UnionFind {
        HashMap<String, String> parent;
        HashMap<String, Integer> rank;

        UnionFind(HashMap<String, String> parent, HashMap<String, Integer> rank) {
            this.parent = parent;
            this.rank = rank;
        }

        public String find(String element) {
            if (!parent.containsKey(element)) {
                parent.put(element, element);
            }
            if (parent.get(element) == element) {
                return element;
            }

            String found_parent = find(parent.get(element));
            return found_parent;
        }

        public void merge(String element_1, String element_2) {
            String parent_1 = find(element_1);
            String parent_2 = find(element_2);

            if (parent_1.equals(parent_2)) {
                return;
            }
            if (rank.get(parent_1) > rank.get(parent_2)) {
                parent.put(parent_2, parent_1);
            } else if (rank.get(parent_2) > rank.get(parent_1)) {
                parent.put(parent_1, parent_2);
            } else {
                parent.put(parent_1, parent_2);
                rank.put(parent_2, rank.get(parent_2) + 1);
            }
        }
    }

    public int removeStones(int[][] stones) {

        HashMap<String, String> parent = new HashMap<>();
        HashMap<String, Integer> rank = new HashMap<>();
        UnionFind uf = new UnionFind(parent, rank);
        int noOfComponents = 0;
        for (int[] stone : stones) {
            String row = "row_" + stone[0];
            String col = "column_" + stone[1];
            if (!parent.containsKey(row)) {
                parent.putIfAbsent(row, row);
                rank.putIfAbsent(row, 1);
                noOfComponents++;
            }
            if (!parent.containsKey(col)) {
                parent.putIfAbsent(col, col);
                rank.putIfAbsent(col, 1);
                noOfComponents++;
            }

            if (!uf.find(row).equals(uf.find(col))) {
                uf.merge(row, col);
                noOfComponents--;
            }

        }
        return stones.length - noOfComponents;
    }
}
