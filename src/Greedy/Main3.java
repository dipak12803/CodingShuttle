package Greedy;

import java.util.Arrays;
import java.util.Collections;

public class Main3 {
    public static void main(String[] args) {
        int[] a={3,1,4,2,1,3};
        System.out.println(candyDistribution(a));

        Integer[] h ={4,1,2};
        Integer[] v ={2,1,3,1,4};
        System.out.println(minCostToCutBoard(h,v)) ;
    }
    static int candyDistribution(int[] a){
        int n=a.length;
        int[] candy =new int[n];
        Arrays.fill(candy,1);
        for(int i=1;i<n;i++){
            if(a[i]>a[i-1]){
                candy[i]=candy[i-1]+1;


            }
        }
        for(int i=n-2;i>=0;i--){
            if(a[i]>a[i+1] && candy[i]<=candy[i+1]){
                candy[i]=candy[i+1]+1;
            }
        }
        int sum=0;
        for(int e:candy){
            sum+=e;
        }
        return sum;

    }
    static int minCostToCutBoard(Integer[] h, Integer[] v){
        int horBoardCount=1,verBoardCount=1;
        Arrays.sort(h, Collections.reverseOrder());
        Arrays.sort(v,Collections.reverseOrder());
        int cost=0;
        int i=0,j=0;   //i  for vertical , j is for horizontal
        while(i<v.length && j<h.length){
            if(h[j]<v[i]){
                cost+=horBoardCount*v[i];
                verBoardCount++;
                i++;
            }
            else{
                cost+=verBoardCount*h[j];
                horBoardCount++;
                j++;
            }


            }

        int totalVerticalCost=0;
        while(i<v.length){
            totalVerticalCost+=v[i];
            i++;
        }
        cost+=totalVerticalCost*horBoardCount;

        int totalHorizontalCost=0;
        while(j<h.length){
            totalHorizontalCost+=h[j];
            j++;
        }
        cost+=totalHorizontalCost*verBoardCount;
        return cost;

    }
}

