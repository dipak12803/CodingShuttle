package Tree;
import java.util.*;
public class Lec3 {
    public static void main(String[] args) {

        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);

        Node root=n1;
        n1.left=n2;
        n1.right=n3;
        n2.right=n4;
        n3.right=n5;
//        ArrayList<Integer> ans=new ArrayList<>();
//        rightView(root,0,ans);


        ArrayList<Integer> ans=levelOrderTraversal(root);
        System.out.println(ans);
        ArrayList<ArrayList<Integer>> anss=levelOrderTraversalinArray(root);

        System.out.println(anss);

    }
    static void rightView(Node root,int level,ArrayList<Integer> ans){
        if(root==null) return;
        if(level>=ans.size()){
            ans.add(root.data);
        }
        rightView(root.right,level+1,ans);
        rightView(root.left,level+1,ans);
    }
    static ArrayList<Integer> levelOrderTraversal(Node root){
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();

        if(root==null) return ans;

        q.add(root);
        while(!q.isEmpty()){
            Node cur=q.poll();
            ans.add(cur.data);
            if(cur.left!=null) q.add(cur.left);
            if(cur.right!=null) q.add(cur.right);
        }
        return ans;
    }

    //below function returns the level traversal in the separate arrayList
    static ArrayList<ArrayList<Integer>> levelOrderTraversalinArray(Node root){
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        if(root==null) return ans;
        q.add(root);
        q.add(null);
        ArrayList<Integer> curList=new ArrayList<>();

        while(!q.isEmpty()){
            Node cur=q.poll();
            if(cur==null){
                ans.add(curList);
                if(q.isEmpty()){
                    break;
                }
                curList=new ArrayList<>();
                q.add(null);
            }
            else{
                curList.add(cur.data);
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
        }
        return ans;
    }static ArrayList<ArrayList<Integer>> levelOrderTraversalinArray2(Node root){
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        if(root==null) return ans;
        q.add(root);


        while(!q.isEmpty()){
            int n=q.size();
            ArrayList<Integer> curList=new ArrayList<>();
            for(int i=0;i<n;i++){
                Node cur=q.poll();
                curList.add(cur.data);
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
             ans.add(curList);
        }
        return ans;
    }
}
