package Tree;

import java.util.ArrayList;
import java.util.*;


public class Lec4 {
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
//        System.out.println(verticalOrderTraversal(root)) ;

//        System.out.println(topViewOfTree(root));

        height(root);
        System.out.println(diameter);
    }



    static int diameterOfBinaryTree(Node root){
        if(root==null) return 0;
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);

        int diameterMiddle=leftHeight+rightHeight;
        int leftDiameter=diameterOfBinaryTree(root.left);
        int rightDiameter=diameterOfBinaryTree(root.right);
        return Math.max(Math.max(leftDiameter,rightDiameter),diameterMiddle);


    }

    //height function is modified/optimised so we get diameter directly in that method
    static int diameter=0;
    static int height(Node root){
        if(root==null) return 0;
        int hl=height(root.left);
        int hr=height(root.right);
        diameter=Math.max(diameter,hl+hr);
        return Math.max(hl,hr)+1;

    }


//    ----------------------------------------------------------------------------------------------------------------------

    static ArrayList<Integer> topViewOfTree(Node root){
        Queue<Pair> q=new LinkedList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
//      Integer contains the horizontal distance between nodes ,
//      ,and second Integer contains Nodes which are viewed from Top.
//   from top at each horizontal distance only one Node is visible  from Top.

        q.add(new Pair(0,root));
//Traversal will level wise and first occured Node at each horizontal distance will be added
        while(!q.isEmpty()){
            Pair cur=q.poll();

            //Node is added in map only its first occurred in its horizontal distance
            map.putIfAbsent(cur.hd,cur.node.data);
// that's why putIfAbsent is used it adds the horizontal distance with the Node if that (hd) is not present in TreeMap

            //after that check if left and right is not null then add that node with (hd-1) for left  and (hd+1) for right
            if(cur.node.left!=null){
                q.add(new Pair(cur.hd-1,cur.node.left));

            }
            if(cur.node.right!=null){
                q.add(new Pair(cur.hd+1,cur.node.right));
            }
        }
        return new ArrayList<>(map.values());
        //values will be added in the sorted order(increasing) of horizontal distance
    }




//-------------------------------------------------------------------------------------------------------

    static ArrayList<ArrayList<Integer>> verticalOrderTraversal(Node root){

        Queue<Pair> q=new LinkedList<>();
        TreeMap<Integer,ArrayList<Integer>> map=new TreeMap<>();
//      Integer contains the horizontal distance between nodes ,
//      ,and Arraylist contains Nodes at particular horizontal distance means all nodes at vertical order for every horizontal distance

        q.add(new Pair(0,root));

        while(!q.isEmpty()){
            Pair cur=q.poll();

            //now check if there is key of that horizontal distance in TreeMap if it not then put that
            //horizontal distance with the new ArrayList that stores all the nodes
            if(!map.containsKey(cur.hd)){
                map.put(cur.hd,new ArrayList<>());
            }

            //now we have added the node with respective horizontal distance in the treemap
            map.get(cur.hd).add(cur.node.data);
            //get keyword fetch the Value from the Map

            //after that check if left and right is not null then add that node with (hd-1) for left  and (hd+1) for right
            if(cur.node.left!=null){
                q.add(new Pair(cur.hd-1,cur.node.left));

            }
            if(cur.node.right!=null){
                q.add(new Pair(cur.hd+1,cur.node.right));
            }
        }
        return new ArrayList<>(map.values());
        //values will be added in the sorted order(increasing) of horizontal distance


    }
    static class Pair{
        int hd;  //horizontal distance
        Node node;

        public Pair(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }
}
