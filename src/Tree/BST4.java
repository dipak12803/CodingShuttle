package Tree;

public class BST4 {
    public static void main(String[] args) {
//        int[] a={1,3,4,5,6,8,9};
//        Node root=createBalancedBSTFromSortedArray(a,0,a.length-1);
//        inorder(root);


        int[] preOrd={8,5,1,7,10,12};
        Node root=createBSTFromPreOrderTraversal(preOrd,0,preOrd.length-1);
        inorder(root);

    }
    static Node createBSTFromPreOrderTraversal(int[] a,int l,int r){
        if(l>r) return null;
        Node root=new Node(a[l]);
        int i=l+1;
        for(;i<=r;i++){
            if(a[i]>a[l]) break;
        }
        //loop breaks when we found just greater element than root
        // now i at partition position
        root.left=createBSTFromPreOrderTraversal(a,l+1,i-1);
        root.right=createBSTFromPreOrderTraversal(a,i,r);
        return root;
    }
    static Node createBalancedBSTFromSortedArray(int[] a,int l,int r){
        if(l>r) return null;
        int m=(l+r)/2;
        Node root=new Node(a[m]);
        root.left=createBalancedBSTFromSortedArray(a,l,m-1);
        root.right=createBalancedBSTFromSortedArray(a,m+1,r);
        return root;
    }
    static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.println(root.data+" ");
        inorder(root.right);
    }
}
