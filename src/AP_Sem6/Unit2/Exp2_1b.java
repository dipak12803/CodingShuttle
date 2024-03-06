package AP_Sem6.Unit2;

public class Exp2_1b {
    public static void main(String[] args) {
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);

        TreeNode root=n1;
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        System.out.println("Diameter of binary tree is: "+diameterOfBinaryTree(root));
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);

        int diameterMiddle=leftHeight+rightHeight;
        int leftDiameter=diameterOfBinaryTree(root.left);
        int rightDiameter=diameterOfBinaryTree(root.right);
        return Math.max(Math.max(leftDiameter,rightDiameter),diameterMiddle);
    }
    static int height(TreeNode root){
        if(root==null) return 0;
        int hl=height(root.left);
        int hr=height(root.right);

        return Math.max(hl,hr)+1;
    }

}
