//https://leetcode.com/problems/insert-delete-getrandom-o1/description/
class RandomizedSet {
    HashMap<Integer, Integer> valueToListIndexMap;
    ArrayList<Integer> list;

    public RandomizedSet() {
        valueToListIndexMap = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (valueToListIndexMap.containsKey(val)) {
            return false;
        }
        list.add(val);
        valueToListIndexMap.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!valueToListIndexMap.containsKey(val)) {
            return false;
        }
        int index = valueToListIndexMap.get(val);
        int toBeSwapped = list.get(list.size() - 1);
        valueToListIndexMap.put(toBeSwapped, index);
        list.set(index, toBeSwapped);
        list.remove(list.size() - 1);
        valueToListIndexMap.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */