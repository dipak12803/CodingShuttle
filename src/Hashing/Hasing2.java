package Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Hasing2 {
    public static void main(String[] args) {
        int[] a={1,2,3,3,4,4,5,6,7,7};
        System.out.println(countDistinctElements(a));
        frequencyOfElements(a);
        int x=6;
        int[] ans=twoSumUsingMap(a,x);
        System.out.println(ans[0]+" "+ans[1]);

    }
    static int countDistinctElements(int[] a){
        HashSet<Integer> set=new HashSet<>();
        for(int e:a){
            set.add(e);
        }
        return set.size();
    }
    static void frequencyOfElements(int[] a){
        Map<Integer,Integer> map=new HashMap<>();
        for(int e:a){
                map.put(e,map.getOrDefault(e,0)+1);
//                if(map.containsKey(e)){
//                    map.put(e,map.get(e)+1);
//                }

//            else{
//                map.put(e,1);
//            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+" --> "+entry.getValue());
        }
    }
    static boolean twoSumUsingHash(int[] a,int x){
        Set<Integer> set=new HashSet<>();
        for(int e:a){
            if(set.contains(x-e)){
                return true;
            }
            else{
                set.add(e);
            }
        }
        return false;
    }
    static int[]  twoSumUsingMap(int[] a,int x){
        Map<Integer,Integer> map=new HashMap<>();
        int ans[]={-1,-1};
        for(int i=0;i<a.length;i++){
            if(map.containsKey(x-a[i])){
                ans[0]=map.get(x-a[i]);
                ans[1]=i;
                return ans;
            }
            else{
                map.putIfAbsent(a[i],i);
            }
        }
        return ans;
    }

}
