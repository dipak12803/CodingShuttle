package Greedy;
import java.util.*;

public class Main {
    static class Item{
        int wt,value;
        public Item(int value,int wt){
            this.wt=wt;
            this.value=value;
        }


    }

    static double fractionalKnapsack(Item items[],int capacity){
        Arrays.sort(items,(o1,o2)->{
            double ratioThis=(double) o1.value/o1.wt;
            double ratioThat=(double) o2.value/o2.wt;

            if(ratioThis>ratioThat) return -1;
            if(ratioThat>ratioThis) return 1;
            return 0;
        });
        double profit=0;
        for(int i=0;i<items.length;i++){
            if(items[i].wt<=capacity){
                profit+=items[i].value;
                capacity-=items[i].wt;
            }
            else{
                double fractionProfit= (double) (items[i].value * capacity) /items[i].wt;
                profit+=fractionProfit;
                break;
            }
        }
        return profit;
    }
    public static void main(String[] args) {
//        int[] a={3,3,4,2,4,4,2,4,4};
//        System.out.println(majorityElement(a));

        Item i1=new Item(60,10);
        Item i2=new Item(100,20);
        Item i3=new Item(120,30);

        Item items[]={i1,i2,i3};

        int capacity=50;
        System.out.println(fractionalKnapsack(items,capacity));



    }
//    Moore Voting Algorithm
    static int majorityElement(int[] a){
        int count=1;
        int majority=a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]==majority){
                count++;
            }
            else{
                count--;
            }
            if(count==0){
                majority=a[i];
                count=1;
            }
        }
        //checking if majority element occurs more than N/2 times
        int freq=0;
        for(int e:a){
            if(e==majority) freq++;
        }
        return freq>a.length/2?majority:-1;
    }
}
