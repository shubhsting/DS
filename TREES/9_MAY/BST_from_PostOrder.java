// https://www.geeksforgeeks.org/problems/construct-bst-from-post-order/1
class GFG {
    static int index;

    public static Node constructTree(int post[], int n) {
        index = n - 1;
        return construct(post, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static Node construct(int[] post, int minRange, int maxRange) {
        if (index < 0)
            return null;
        Node root = null;
        if (post[index] >= minRange && post[index] <= maxRange) {
            root = new Node(post[index]);
            index--;
            root.right = construct(post, root.data + 1, maxRange);
            root.left = construct(post, minRange, root.data - 1);
        }
        return root;
    }
}