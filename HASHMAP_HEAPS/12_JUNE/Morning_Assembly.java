class Solution{
    static int sortingCost(int N, int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        int temp = 0;
        for(int element: arr) {
            map.put(element, map.getOrDefault(element - 1, 0) + 1);
            temp = Math.max(temp, map.get(element));
        }
        return N - temp;
    }
}
