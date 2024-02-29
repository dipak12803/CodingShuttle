package AP_Sem6.Unit2;

public class Exp2_1a {
    public static void main(String[] args) {
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(2);
        TreeNode n4=new TreeNode(3);
        TreeNode n5=new TreeNode(4);
        TreeNode n6=new TreeNode(4);
        TreeNode n7=new TreeNode(3);
        TreeNode root=n1;
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;
        n3.right=n7;
        System.out.println(isSymmetric(root));


    }
    public static boolean checkSymmetricHelper(TreeNode l,TreeNode r){
        if(l==null || r==null) return l==r;
        if(l.val!=r.val) return false;

        return checkSymmetricHelper(l.left,r.right) && checkSymmetricHelper(l.right,r.left);
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root==null) return false;
        else{
            return checkSymmetricHelper(root.left,root.right);
        }
    }

}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

