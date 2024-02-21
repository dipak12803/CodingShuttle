package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Lec2 {
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

//        System.out.println(areCousins(root,4,5));

//        ArrayList<Integer> ans= new ArrayList<>();
//        nodesAtLevelK(root,2,ans);
//        System.out.println(ans);

        System.out.println(nodesAtLevelKIterative(root,1));
    }

//   ----------------------------------------------------------------
    static Node xPar,yPar;
    static int xLevel,yLevel;


//    below function assigns the value for parents of x and y , and levels
    //of x and y
    static void areCousinsHelper(Node node,Node par,int x,int y,int level){
        if(node==null) return;
        if(node.data==x){
            xPar=par;    //current node assigned as parent
            xLevel=level;  //current level is assigned for x
        }
        if(node.data==y){
            yPar=par;
            yLevel=level;
        }
        areCousinsHelper(node.left,node,x,y,level+1);
        areCousinsHelper(node.right,node,x,y,level+1);
    }
    static boolean areCousins(Node root,int x,int y){
        areCousinsHelper(root,null,x,y,0);
        boolean onSameLevel=xLevel==yLevel;
        boolean differentParents=xPar!=yPar;
        return onSameLevel && differentParents;

        //if level of x and y are same   and parents are different then
        //they are cousins

    }
//    ------------------------------------------------------------------------------------------

    static void nodesAtLevelK(Node root, int level, ArrayList<Integer> ans){
        if(root==null || level<0) return;

        if(level==0){
            ans.add(root.data); return;
        }
        nodesAtLevelK(root.left,level-1,ans);
        nodesAtLevelK(root.right,level-1,ans);

    }
    static class Pair{
        Node node;
        int level;

        public Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    static ArrayList<Integer> nodesAtLevelKIterative(Node root,int level){
        ArrayList<Integer> ans=new ArrayList<>();

        //Stack implementation with custom Pair which contains node value and level number
        ArrayDeque<Pair> stack=new ArrayDeque<>();
        Pair first=new Pair(root,level);   //add root with level 0 in the stack in the beginning
        stack.push(first);

        while(!stack.isEmpty()){
            Pair cur=stack.poll();  //pop from stack
            if(cur.node==null) continue;   //if node is null at level 0 skip to prevent from NullPointerException
            if(cur.level==0){
                //if current level is 0 then add the current node data in the arraylist  then skip the iteration
                ans.add(cur.node.data);
                continue;
            }
//    if current node is not null and not 0 then push the right child with (level-1) after that
            // push left child with level-1
            stack.push(new Pair(cur.node.right,cur.level-1));
            stack.push(new Pair(cur.node.left,cur.level-1));

        }
        return ans;

    }
}
