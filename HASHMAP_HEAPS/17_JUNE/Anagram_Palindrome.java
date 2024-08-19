// https://www.geeksforgeeks.org/problems/anagram-palindrome4720/1
class Sol {
    int isPossible(String S) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int index = 0; index < S.length(); index++) {
            char ch = S.charAt(index);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int odd = 0;
        for (char key : map.keySet()) {
            if (map.get(key) % 2 != 0)
                odd++;
        }

        if (S.length() % 2 == 0) {
            return odd == 0 ? 1 : 0;
        }
        return odd == 1 ? 1 : 0;
    }
}
