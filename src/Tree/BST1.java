package Tree;

public class BST1 {
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

//        System.out.println(search(root,6));

//        printInOrder(root);
//        System.out.println();
//        insert(root,12);
//        printInOrder(root);

         printInOrder(root);
        System.out.println();
        delete(root,6);
        printInOrder(root);
    }

    static boolean search(Node root,int key){
        if(root==null) return false;

        if(root.data>key){
            return search(root.left,key);
        }
        if(root.data<key){
            return search(root.right,key);
        }
//        if(root.data==key) return true;
        return true;
    }
    static Node insert(Node root,int key){
        if(root==null){
            return new Node(key);
        }
        if(root.data>key){
            root.left=insert(root.left,key);
        }
        else if(root.data<key){
            root.right=insert(root.right,key);
        }
        return root;
    }
    static void printInOrder(Node root){
        if(root==null) return;
        printInOrder(root.left);
        System.out.print(root.data+" ");
        printInOrder(root.right);


    }
    static Node delete(Node root,int key){
        if(root==null) return null;
        if(root.data>key){
            root.left=delete(root.left,key);
        }
        else if(root.data<key){
            root.right=delete(root.right,key);
        }
        else{
            //case 1
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }
            Node inOrderSuccessor=findSmallest(root.right);
            root.data=inOrderSuccessor.data;

            root.right=delete(root.right,inOrderSuccessor.data);
        }
        return root;
    }
    static Node findSmallest(Node root){
        Node temp=root;
        while(temp.left!=null){
            temp=temp.left;
        }
        return temp;
    }
}

