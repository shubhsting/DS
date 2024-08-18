// https://www.geeksforgeeks.org/problems/check-frequencies4211/1
class Solution {
    boolean sameFreq(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            char ch = s.charAt(index);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        HashMap<Integer, List<Character>> countToCharacterMap = new HashMap<>();
        for (char key : map.keySet()) {
            int count = map.get(key);
            countToCharacterMap.putIfAbsent(count, new ArrayList<>());
            countToCharacterMap.get(count).add(key);
        }
        List<Integer> keyCount = new ArrayList<Integer>(countToCharacterMap.keySet());
        if (keyCount.size() > 2) {
            return false;
        }
        if (keyCount.size() <= 1) {
            return true;
        }
        int size1 = keyCount.get(0);
        int size2 = keyCount.get(1);

        if ((size1 == 1 && countToCharacterMap.get(size1).size() == 1)
                || (size2 == 1 && countToCharacterMap.get(size2).size() == 1)) {
            return true;
        }
        if (Math.abs(size1 - size2) > 1) {
            return false;
        }

        if (size1 > size2) {
            return countToCharacterMap.get(size1).size() == 1;
        } else if (size2 > size1) {
            return countToCharacterMap.get(size2).size() == 1;
        }
        return true;
    }
}
