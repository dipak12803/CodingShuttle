package Backtracking;

import java.util.ArrayList;

public class SubsequenceOfArray {
    public static void main(String[] args) {
        int[] a={5,6,4};
        ArrayList<ArrayList<Integer>> ans=subsequences(a);
        for(ArrayList<Integer> list:ans){
            System.out.println(list);
        }
    }
    static ArrayList<ArrayList<Integer>> subsequences(int[] a){
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        helperSubsequence(a,ans,0,new ArrayList<>());
        return ans;
    }
    static void helperSubsequence(int[] a,ArrayList<ArrayList<Integer>> ans,int index,ArrayList<Integer> cur){

            ArrayList<Integer> curCopy=new ArrayList<>(cur);
            ans.add(curCopy);

        for(int i=index;i<a.length;i++){
            cur.add(a[i]);
            helperSubsequence(a,ans,i+1,cur);
            cur.remove(cur.size()-1);//backtrack
        }

    }
}
