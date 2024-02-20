package AP_Sem6;
import java.util.*;
public class Exp1_4b {
    public static void main(String[] args) {
        int[] arr={9,6,4,2,3,5,7,0,1};
        System.out.println("Missing number is : "+missingNumber(arr));
    }
    public static int missingNumber(int[] nums) {
        int n=nums.length;
        int ans=0;
        Set<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        for(int i=0;i<=n;i++){
            if(!set.contains(i)){
                ans=i;
            }
        }
        return ans;
    }
}
