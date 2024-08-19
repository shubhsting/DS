// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
class RandomizedCollection {
    HashMap<Integer, Set<Integer>> noToListIndicesMap;
    ArrayList<Integer> numbers;

    public RandomizedCollection() {
        noToListIndicesMap = new HashMap<>();
        numbers = new ArrayList<>();
    }

    public boolean insert(int val) {
        boolean ans = false;
        if (!noToListIndicesMap.containsKey(val))
            ans = true;
        noToListIndicesMap.putIfAbsent(val, new HashSet<>());
        numbers.add(val);
        noToListIndicesMap.get(val).add(numbers.size() - 1);
        return ans;
    }

    public boolean remove(int val) {
        if (!noToListIndicesMap.containsKey(val))
            return false;
        Set<Integer> idxSet = noToListIndicesMap.get(val);
        int index = idxSet.iterator().next();
        idxSet.remove(index);
        int lastElementToBeSwapped = numbers.get(numbers.size() - 1);
        numbers.set(index, lastElementToBeSwapped);
        noToListIndicesMap.get(lastElementToBeSwapped).add(index);
        // remove index of last element from map
        noToListIndicesMap.get(lastElementToBeSwapped).remove(numbers.size() - 1);
        numbers.remove(numbers.size() - 1);
        if (idxSet.size() == 0)
            noToListIndicesMap.remove(val);
        return true;
    }

    public int getRandom() {
        int start = 0;
        int end = numbers.size() - 1;
        int range = end - start + 1;
        int index = (int) (Math.random() * range) + start;
        return numbers.get(index);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */