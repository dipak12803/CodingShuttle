package Tree;
import java.util.*;
public class BSTLIVE {
    public static void main(String[] args) {
        Node n1=new Node(8);
        Node n2=new Node(14);
        Node n3=new Node(10);
        Node n4=new Node(1);
        Node n5=new Node(6);
        Node n6=new Node(4);
        Node n7=new Node(7);

        Node root=n1;
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.right=n6;
        n5.right=n7;

//        System.out.println(printInRange(root,5,12));
        inorder(root);
        System.out.println();
        recoverBST(root);
        inorder(root);
        System.out.println();

    }

    static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    static Node left,mid,right;
    static void recoverBST(Node root){
        recoverBSTUTIL(root,null);
        if(left!=null && right!=null){
            swapNodes(left,right);

        }
        //left mid are swapped when there are adjacent elements anamolay
        if(left!=null && right==null){
            swapNodes(left,mid);
        }


    }
    static void swapNodes(Node a,Node b){
        int temp=a.data;
        a.data=b.data;
        b.data=temp;
    }
    static void recoverBSTUTIL(Node root,Node prev){
        if(root==null) return;
        if(prev!=null){
            if(root.data< prev.data){  //anomaly found ,root must be greater than prev
                if(left==null){ //first anomaly
                    left=prev;
                    mid=root;
                }
                else{  //second anomaly
                    right=root;
                    return;
                }

            }
        }
        prev=root;
        recoverBSTUTIL(root.right,prev);

    }

    static Node prev=null;
    static int ans=Integer.MAX_VALUE;
    static int minAbsDifferenceinBST(Node root){
        minAbsUtil(root);
        return ans;
    }
    static void minAbsUtil(Node root){
        if(root==null) return;
        minAbsUtil(root.left);
        if(prev!=null){
            ans=Math.min(ans,root.data- prev.data);
        }
        //update the previous
        prev=root;
        minAbsUtil(root.right);
    }
    static ArrayList<Integer> printInRange(Node root,int low,int high){
        ArrayList<Integer> ans=new ArrayList<>();
        printInRangeUtil(root,low,high,ans);
        return ans;

    }
    static void printInRangeUtil(Node root,int low,int high,ArrayList<Integer> ans) {
        if(root==null) return;
        if(low<root.data){
            printInRangeUtil(root.left,low,high,ans);
        }
        if(root.data>=low && root.data<=high){
            ans.add(root.data);

        }
        if(high>root.data){
            printInRangeUtil(root.right,low,high,ans);
        }



    }
}
