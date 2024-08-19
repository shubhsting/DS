// https://www.geeksforgeeks.org/problems/rearrange-characters4649/1
class Solution {
    static class CharElement {
        char ch;
        int freq;

        CharElement(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public static String rearrangeCharacters(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int index = 0; index < str.length(); index++) {
            char ch = str.charAt(index);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<CharElement> pq = new PriorityQueue<>((CharElement a, CharElement b) -> {
            return b.freq - a.freq;
        });
        for (char key : map.keySet()) {
            pq.add(new CharElement(key, map.get(key)));
        }
        String ans = "";
        CharElement prev = null;
        while (pq.size() != 0) {
            CharElement current = pq.remove();
            ans = ans + current.ch;
            if (prev != null)
                pq.add(prev);
            prev = current.freq - 1 > 0 ? new CharElement(current.ch, current.freq - 1) : null;
        }
        return pq.size() == 0 && prev == null ? ans : "-1";
    }
}
