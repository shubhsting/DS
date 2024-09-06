// https://leetcode.com/problems/range-sum-query-mutable/description/
class NumArray {
    int[] segmentTree;
    int size;

    public NumArray(int[] nums) {
        segmentTree = new int[4 * nums.length];
        size = nums.length - 1;
        construct(nums, 0, 0, nums.length - 1);
    }

    public void update(int index, int val) {
        update(0, 0, size, index, val);
    }

    public int sumRange(int left, int right) {
        return query(0, 0, size, left, right);
    }

    public void construct(int[] nums, int idx, int start, int end) {
        if (start == end) {
            segmentTree[idx] = nums[start];
            return;
        }
        int mid = start + (end - start) / 2;
        construct(nums, 2 * idx + 1, start, mid);
        construct(nums, 2 * idx + 2, mid + 1, end);
        segmentTree[idx] = segmentTree[2 * idx + 1] + segmentTree[2 * idx + 2];
    }

    public int query(int index, int si, int ei, int qsi, int qei) {
        if (qsi > ei || qei < si)
            return 0;
        if (si >= qsi && ei <= qei)
            return segmentTree[index];
        int mid = si + (ei - si) / 2;
        int left = query(2 * index + 1, si, mid, qsi, qei);
        int right = query(2 * index + 2, mid + 1, ei, qsi, qei);
        return left + right;
    }

    public int update(int index, int si, int ei, int updateIdx, int newNo) {
        if (si == ei) {
            segmentTree[index] = si == updateIdx ? newNo : segmentTree[index];
            return segmentTree[index];
        }
        if (updateIdx >= si && updateIdx <= ei) {
            int mid = si + (ei - si) / 2;
            int left = update(2 * index + 1, si, mid, updateIdx, newNo);
            int right = update(2 * index + 2, mid + 1, ei, updateIdx, newNo);
            segmentTree[index] = left + right;
        }
        return segmentTree[index];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */