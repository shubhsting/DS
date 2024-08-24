// https://leetcode.com/problems/find-median-from-data-stream/
class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>((Integer a, Integer b) -> {
            return b - a;
        });
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (left.size() == right.size()) {
            right.add(num);
            left.add(right.remove());
        } else {
            left.add(num);
            right.add(left.remove());
        }
    }

    public double findMedian() {

        if (left.size() == right.size())
            return (1.0 * left.peek() + 1.0 * right.peek()) / 2;
        return 1.0 * left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */