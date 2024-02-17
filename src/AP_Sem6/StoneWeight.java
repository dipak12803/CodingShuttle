package AP_Sem6;
import java.util.*;
public class StoneWeight {
    public static void main(String[] args) {
        int[] stones={2,7,4,1,8,1};
        System.out.print("Given weight of stones : ");
        for(int i:stones){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("Weight of last remaining stone : "+lastStoneWeight(stones));
    }
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:stones){
            pq.add(i);
        }
        int x=0;
        int y=0;
        while(pq.size()>1){
            y=pq.poll();
            x=pq.poll();
            if(y>x){
                pq.add(y-x);
            }
        }
        return pq.isEmpty()?0:pq.peek();
    }
}
