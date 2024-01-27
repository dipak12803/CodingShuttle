package Greedy;

import java.util.Arrays;
//JUST CHECKING HOW TO UPDATE IN GITHUB
public class Main2 {
    static class Activity{
        int start,finish;

        public Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    public static void main(String[] args) {
        int[] s={5,10,20,40,45};
        int[] f={15,25,35,42,55};
        System.out.println(activitySelection(s,f));

    }
    static int activitySelection(int[] s,int[] f){
        int n=s.length;
        Activity activities[]=new Activity[n];
        for(int i=0;i<n;i++){
            activities[i]=new Activity(s[i],f[i]);

        }
        //sort on the basis of finishing time
        //which have less finishing time will be chosen first
        Arrays.sort(activities,(o1, o2) ->o1.finish-o2.finish) ;
        int count=1;
        int currFinish=activities[0].finish;
        for(int i=1;i<n;i++){
            if(activities[i].start>=currFinish){
                count++;
                currFinish=activities[i].finish;
            }
        }
        return count;

    }
    static int minPlatforms(int[] arr,int[] dep){
        int n=arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0,j=0;
        int count=0;
        int maxCount=0;
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                count++;
                maxCount=Math.max(maxCount,count);
                i++;
            }
            else{
                count--;
                j++;
            }
        }
        return maxCount;
    }
}
