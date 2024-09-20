import java.util.*;
public class APLAB {
    public static void main(String[] args){
        int[] nums={1,2,3};
        List<List<Integer>> ans=subsets(nums);
        System.out.println(ans);
    }
    public static List<List<Integer>> subsets(int[] arr){
        List<Integer> curr=new ArrayList<Integer>();
        List<List<Integer>> ans=new ArrayList<>();
        helper(arr,0,curr,ans);
        return ans;
    }
    public static void helper(int[] arr,int i,List<Integer> curr,List<List<Integer>> ans){
        if(i== arr.length){
            ans.add(new ArrayList<Integer>(curr));
            return;
        }
        curr.add(arr[i]);
        helper(arr,i+1,curr,ans);
        curr.remove(curr.size()-1);
        helper(arr,i+1,curr,ans);
    }
}
