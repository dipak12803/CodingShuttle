package Tree;
import java.util.*;
public class LiveClass {
    public static void main(String[] args) {
        Node n1=new Node(3);
        Node n2=new Node(5);
        Node n3=new Node(1);
        Node n4=new Node(6);
        Node n5=new Node(2);
        Node n6=new Node(0);
        Node n7=new Node(8);
        Node n8=new Node(7);
        Node n9=new Node(4);

        Node root=n1; n1.left=n2;
        n1.right=n3;  n2.left=n4;
        n2.right=n5;  n3.left=n6;
        n3.right=n7;  n5.left=n8;
        n5.right=n9;

        Node head=convertBinaryTreeToDoublyLinkedList(root);
        while(head!=null){
            System.out.println(head.data+" ");
            head=head.right;
        }
    }
    static Node convertBinaryTreeToDoublyLinkedList(Node root){
        if(root==null) return null;
        convertBinaryTreeToDoublyLinkedListUTIL(root);
//this method transforms BTTODLL in place
        //now for head of the DLL we have to traverse the leftmost child of tree ,
        while(root.left!=null){
            root=root.left;
        }
        return root;  //it acts as header of doubly linked list

    }
    static Node convertBinaryTreeToDoublyLinkedListUTIL(Node root){
        if(root==null) return null;
        if(root.left!=null){
            Node leftRoot=convertBinaryTreeToDoublyLinkedListUTIL(root.left);
            while(leftRoot.right!=null){
                leftRoot=leftRoot.right;
            }
            leftRoot.right=root;   //doubly linkedlist thats why left and right are connecting to each other
            root.left=leftRoot;
//above we are finding the rightmost node of left subtree then connecting that rightmost Node with root
        }
        if(root.right!=null){
            Node rightRoot=convertBinaryTreeToDoublyLinkedListUTIL(root.right);
            while(rightRoot.left!=null){
                rightRoot=rightRoot.left;
            }
            root.right=rightRoot;
            rightRoot.left=root;
        }
        return root;

    }
//    Youtube Channel:CODEBIX Method for NodesAtDistance K
    //because Anuj bhaiya way was too difficult to understand
    /*
    import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.val = data;
        left = null;
        right = null;
    }
}

public class Solution {
    public static List<Integer> distanceK(TreeNode root, int target, int k) {
        List<Integer> ans = new ArrayList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
//this map contains child node as key and parent as value,basically we are storing child parent to keep track of upper node ,because we directly can not access parent
        Queue<TreeNode> q = new LinkedList<>();
//it will store the treenodes for every k distance

        HashSet<TreeNode> visited = new HashSet<>();
//it contains the nodes which are visited once so that they can not be added again to avoid duplicate value

        // Function to build parentMap
        findParent(parentMap, root);

        // Find the target node
        TreeNode targetNode = findTargetNode(root, target);

        if (targetNode == null)
            return ans; // If target not found, return empty list

//initially add target node in queue as we have to travel k distance from that node
        q.add(targetNode);
        visited.add(targetNode);

        while (!q.isEmpty() && k >= 0) {
            int size = q.size();
//for loop will iterate for size times
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
//if k==0 it means we have reached at K distance from target,add its current value in the answer
                if (k == 0) {
                    ans.add(cur.val);
                }
								// if parentMap contains the current node key and its parent is not visited then add its parent in queue
                if (parentMap.containsKey(cur) && !visited.contains(parentMap.get(cur))) {
                    q.add(parentMap.get(cur));
                    visited.add(parentMap.get(cur));
                }
//check for left and right of current node if it is not null and they are not visited then add them in queue
                if (cur.left != null && !visited.contains(cur.left)) {
                    q.add(cur.left);
                    visited.add(cur.left);
                }

                if (cur.right != null && !visited.contains(cur.right)) {
                    q.add(cur.right);
                    visited.add(cur.right);
                }
//decerement k when for loop ends
            }
            k--;
        }
				Collections.sort(ans);
        return ans;
    }

    public static void findParent(Map<TreeNode, TreeNode> parentMap, TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            parentMap.put(root.left, root);
        }
        if (root.right != null) {
            parentMap.put(root.right, root);
        }
				//then recursively call for left and right node
        findParent(parentMap, root.left);
        findParent(parentMap, root.right);
    }
//this function returns the targetNode of given target,
//we have to make this function because we have been given int target in the question but we want target Node ,
//IN LEETCODE target NODE is given instead of int target
    public static TreeNode findTargetNode(TreeNode root, int target) {
        if (root == null || root.val == target)
            return root;

        TreeNode left = findTargetNode(root.left, target);
        if (left != null)
            return left;

        TreeNode right = findTargetNode(root.right, target);
        if (right != null)
            return right;

        return null;
    }
}

     */
}
