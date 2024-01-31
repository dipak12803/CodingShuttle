package Hashing;

import java.util.*;

public class Hashing3 {
    public static void main(String[] args) {
//        int[] a={1,4,-5,2,3,-3};
//        System.out.println(countSubArraywithZeroSum(a));
//        System.out.println(countSubArraywithGivenSum(a,5));
            int[] arr={1,2,3};
            int sum=3;
        System.out.println(countSubArraywithGivenSum(arr,sum));
//        int[] arr={1,0,-1,0,-2,2};
//        int sum=0;
//        System.out.println(findAllQuadrupleswithGivenSum(arr,sum));
    }
    static int countSubArraywithZeroSum(int[] a){
         Set<Integer> set=new HashSet<>();
         int cs=0;//cumulative sum
        int count=0;
        set.add(0); //initially zero will be there so if starting subarray sums to
        //0 it will increment the count
        for(int e:a){
            cs+=e;
            if(set.contains(cs)){
                count++;
            }
            else{
                set.add(cs);
            }

        }
        return count;
    }
    static int countSubArraywithGivenSum(int[] a,int k){
        Set<Integer> set=new HashSet<>();
        int cs=0;
        int count=0;
        set.add(0);
        for(int e:a){
            cs+=e;
            if(set.contains(cs-k)){
                count++;

            }
            else{
                set.add(cs);
            }
        }
        return count;
    }
    static List<List<Integer>> findAllQuadrupleswithGivenSum(int[] a,int k){
        if(a.length<3) return null;
        Set<List<Integer>> ans=new HashSet<>();
        Arrays.sort(a);
        int n=a.length;
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                List<List<Integer>> temp=findAllTwoSum(a,k-a[i]-a[j],j+1);
                for(List<Integer> list:temp){
                    List<Integer> tempAns=new ArrayList<>();
                    tempAns.add(a[i]);  //a
                    tempAns.add(a[j]);  //b
                    tempAns.addAll(list); //c d
                    ans.add(tempAns);
                }
            }
        }
        return new ArrayList<>(ans);

    }
    static List<List<Integer>> findAllTwoSum(int[] a,int sum,int start){
        int i=start,j=a.length-1;
        List<List<Integer>> ans=new ArrayList<>();
        while(i<j){
            if(a[i]+a[j]==sum){
                List<Integer> temp=new ArrayList<>();
                temp.add(a[i]);
                temp.add(a[j]);
                ans.add(temp);
                i++;j--;
            }
            else if(a[i]+a[j]<sum){
                i++;
            }
            else{
                j--;
            }
        }
        return ans;

    }
}
