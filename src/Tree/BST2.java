package Tree;

public class BST2 {
    public static void main(String[] args) {
        Node n1=new Node(8);
        Node n2=new Node(3);
        Node n3=new Node(10);
        Node n4=new Node(1);
        Node n5=new Node(6);
        Node n6=new Node(14);
        Node n7=new Node(4);
        Node n8=new Node(7);

        Node root=n1;
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.right=n6;
        n5.left=n7;
        n5.right=n8;

//        System.out.println(validBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
//        Node pred=inorderPredecessor(root,10,null);
//        if(pred==null){
//            System.out.println("Predecessor not found");
//        }else{
//
//        System.out.println(pred.data);
//        }

//  by the method of striver
        Node pred=inorderPredecessor(root,new Node(7));
        System.out.println(pred.data);


    }
    static boolean validBST(Node root,int min,int max){
        if(root==null) return true;
        if(root.data<=min || root.data>=max) return false;

        //if above if condition is not met it means the root value lies between min and max
        return validBST(root.left,min,root.data) && validBST(root.right,root.data,max);
    }
    static Node inorderPredecessor(Node root,int key,Node predecessor){
        if(root==null) return null;
        if(root.data>key){  //going to the left
            return inorderPredecessor(root.left,key,predecessor);

        }
        else if(root.data<key){//going to the right
            predecessor=root;
            return inorderPredecessor(root.right,key,predecessor);
        }
        else{  //we are currently at key node
            if(root.left==null){
                return predecessor;
            }
            else{
                return getMax(root.left);
            }
        }
    }

    static Node getMax(Node root){
        while(root.right!=null){
            root=root.right;
        }
        return root;
    }
    //STRIVER YOUTUBE
    static Node inOrderSuccessor(Node root,Node target){
        Node successor=null;
        while(root!=null){
            if(target.data>= root.data){
                root=root.right;
            }
            else{
                successor=root;
                root=root.left;
            }
        }
        return successor;
    }
    static Node inorderPredecessor(Node root,Node target){
        Node predecessor=null;
        while(root!=null){
            //if target is less than or equal to root than predecessor must be in left
            if(target.data<=root.data){
                root=root.left;
            }
            else{  //when target is greater than root
                //it means the predecessor may be root but still check in right
                predecessor=root;
                root=root.right;
            }
        }
        return predecessor;
    }

}
