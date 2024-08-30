// class Node  
// { 
//     int data; 
//     Node left, right; 

//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }
// 
// https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
class Solution {
    ArrayList<Integer> printBoundary(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(node.data);
        leftside(node.left, ans);
        bottomView(node, ans);
        rightside(node.right, ans);
        return ans;
    }

    void leftside(Node node, ArrayList<Integer> ans) {
        if (node == null)
            return;
        if (node.left == null && node.right == null)
            return;
        ans.add(node.data);
        if (node.left != null)
            leftside(node.left, ans);
        else if (node.right != null)
            leftside(node.right, ans);
    }

    void rightside(Node node, ArrayList<Integer> ans) {
        if (node == null)
            return;
        if (node.left == null && node.right == null)
            return;
        if (node.right != null)
            rightside(node.right, ans);
        else if (node.left != null)
            rightside(node.left, ans);
        ans.add(node.data);
    }

    void bottomView(Node node, ArrayList<Integer> ans) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            ans.add(node.data);
            return;
        }
        if (node.left != null)
            bottomView(node.left, ans);
        if (node.right != null)
            bottomView(node.right, ans);

    }
}
