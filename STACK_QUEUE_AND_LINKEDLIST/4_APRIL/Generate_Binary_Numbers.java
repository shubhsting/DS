class solve {
    // https://www.geeksforgeeks.org/problems/generate-binary-numbers-1587115620/1
    // Function to generate binary numbers from 1 to N using a queue.
    static ArrayList<String> generate(int N) {
        LinkedList<String> queue = new LinkedList<>();
        ArrayList<String> ans = new ArrayList<>();
        queue.addLast("1");
        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- > 0) {
                String ele = queue.removeFirst();
                ans.add(ele);
                if (ans.size() == N)
                    return ans;
                queue.addLast(ele + "0");
                queue.addLast(ele + "1");
            }
        }
        return ans;
    }

}
