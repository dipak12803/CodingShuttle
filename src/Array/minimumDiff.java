package Array;
import java.util.*;
public class minimumDiff {
    public static void main(String[] args) {
        int a[]={12,9,8,2,11};
//        List<List<Integer>> ans=minDiff(a);
        System.out.println(maxDifference(a));
    }
    static int maxDifference(int a[]){
        int n=a.length;
        int minaipi=Integer.MAX_VALUE;
        int maxaipi=Integer.MIN_VALUE;
        int minaimi=Integer.MAX_VALUE;
        int maxaimi=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            minaipi=Math.min(minaipi,a[i]+i);
            maxaipi=Math.max(maxaipi,a[i]+i);

            minaimi=Math.min(minaimi,a[i]-i);
            maxaimi=Math.max(maxaipi,a[i]-i);
        }
        int diffaipi=maxaipi-minaipi;
        int diffaimi=maxaimi-minaimi;
        return Math.max(diffaipi,diffaimi);
    }
    static List<List<Integer>> minDiff(int a[]){
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(a);
        int minDif=Integer.MAX_VALUE;
        int n=a.length;
        for(int i=1;i<n;i++){
            minDif=Math.min(minDif,a[i]-a[i-1]);
        }
        for(int i=1;i<n;i++){
            if(a[i]-a[i-1]==minDif){
                List<Integer> temp=new ArrayList<>();
                temp.add(a[i-1]);
                temp.add(a[i]);
                ans.add(temp);

            }
        }
        return ans;
    }
}
