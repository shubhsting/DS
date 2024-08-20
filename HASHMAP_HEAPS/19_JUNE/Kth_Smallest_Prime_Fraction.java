// https://leetcode.com/problems/k-th-smallest-prime-fraction/description/
class Solution {
    class Element {
        int numIdx;
        int denIdx;

        Element(int numIdx, int denIdx) {
            this.numIdx = numIdx;
            this.denIdx = denIdx;
        }
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>((Element a, Element b) -> {
            return arr[a.numIdx] * arr[b.denIdx] - arr[b.numIdx] * arr[a.denIdx];
        });
        for (int index = 0; index < arr.length - 1; index++) {
            pq.add(new Element(index, arr.length - 1));
        }
        int index = 0;

        while (pq.size() != 0) {
            Element ele = pq.remove();
            if (ele.denIdx - 1 > ele.numIdx) {
                pq.add(new Element(ele.numIdx, ele.denIdx - 1));
            }
            index++;
            if (index == k) {
                return new int[] { arr[ele.numIdx], arr[ele.denIdx] };
            }
        }
        return new int[2];
    }
}