package Tree;

import java.util.ArrayList;

public class Lec5 {
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

//        ArrayList<Integer> ans=new ArrayList<>();
//        ancestors(root,ans,0);
//        System.out.println(ans);

//        Node ans=lca(root,7,4);
//        System.out.println(ans.data);

        System.out.println(distanceBetweenTwoNodes(root,7,0));
        System.out.println(distanceOfTwoNodeSecondMethod(root,7,0));


    }
    static boolean ancestors(Node root, ArrayList<Integer> ans,int target){
        if(root==null) return false;
        if(root.data==target) return true;
        boolean isPresentLeft=ancestors(root.left,ans,target);
        boolean isPresentRight=ancestors(root.right,ans,target);
        if(isPresentLeft||isPresentRight){
            ans.add(root.data);
            return true;
        }
        return false;
    }
    static Node lca(Node root,int a,int b){
        if(root==null) return null;
        if(root.data==a || root.data==b) return root;
        Node left=lca(root.left,a,b);
        Node right=lca(root.right,a,b);

        if(left==null) return right;
        if(right==null) return left;

        //if both of them not null
         return root;
    }
    static int distanceBetweenTwoNodes(Node root,int a,int b){
        Node lca=lca(root,a,b);
        Integer distanceA=distance(root,a);
        Integer distanceB=distance(root,b);
        Integer distanceLCA=distance(root,lca.data);

        return distanceA+distanceB-2*distanceLCA;

    }
    static int distanceOfTwoNodeSecondMethod(Node root,int a,int b){
        Node lca=lca(root, a, b);
        return distance(lca,a)+distance(lca,b);
    }
    static Integer distance(Node root,int a){
        if(root==null) return null;
        if(root.data==a){
            return 0;
        }
        Integer left=distance(root.left,a);
        Integer right=distance(root.right,a);
        if(left==null && right==null) return null;
        if(left==null) return right+1;
        if(right==null) return left+1;

        return null;
    }
}
