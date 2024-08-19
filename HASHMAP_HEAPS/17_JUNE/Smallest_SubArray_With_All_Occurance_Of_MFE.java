// https://www.geeksforgeeks.org/problems/smallest-subarray-with-all-occurrences-of-a-most-frequent-element2258/1
class Solution {

    class Element {
        int si;
        int ei;
        int frequency;

        Element(int si, int ei, int frequency) {
            this.si = si;
            this.ei = ei;
            this.frequency = frequency;
        }
    }

    ArrayList<Integer> smallestSubsegment(int a[], int n) {
        HashMap<Integer, Element> map = new HashMap<>();
        Element ans = new Element(0, 0, Integer.MIN_VALUE);
        for (int index = 0; index < n; index++) {
            Element defaultElement = new Element(index, index, 1);
            Element element = map.getOrDefault(a[index], defaultElement);
            Element newElement = new Element(Math.min(index, element.si), Math.max(index, element.ei),
                    element.frequency + 1);
            map.put(a[index], newElement);
            boolean freqgreater = (newElement.frequency > ans.frequency);
            boolean freqsame = (newElement.frequency == ans.frequency);
            boolean eleCount = (newElement.ei - newElement.si) < (ans.ei - ans.si);
            boolean eleSame = (newElement.ei - newElement.si) == (ans.ei - ans.si);
            boolean siCondition = newElement.si < ans.si;
            if ((freqgreater) || (freqsame && eleCount) || (freqsame && eleSame && siCondition)) {
                ans = newElement;
            }
        }

        ArrayList<Integer> ans2 = new ArrayList<>();
        for (int index = ans.si; index <= ans.ei; index++) {
            ans2.add(a[index]);
        }
        return ans2;
    }

}
