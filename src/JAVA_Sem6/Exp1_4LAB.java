package JAVA_Sem6;

import java.util.*;

public class Exp1_4LAB {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter number of cards : ");
        int numCards=in.nextInt();
        char c;
        int cardNumber;
        List<Integer> l;
        int cardSum=0;
        Map<Character, List<Integer>> cardMap=new HashMap<>();
        for(int i=0;i<numCards;i++){
            System.out.println("Enter card :"+(i+1));
            c=in.next().charAt(0);
            cardNumber=in.nextInt();
            cardSum+=cardNumber;
            l=cardMap.getOrDefault(c,new ArrayList<>());
            l.add(cardNumber);
            cardMap.put(c,l);
        }
        System.out.println("Total sum of cards is "+cardSum);
        System.out.print("Distinct cards are: ");
        for(Map.Entry<Character, List<Integer>> entry: cardMap.entrySet()){
            char card=entry.getKey();
            System.out.print(card+" ");
            List<Integer> value=entry.getValue();
        }
        System.out.println();
        for(Map.Entry<Character,List<Integer>> entry:cardMap.entrySet()){
            List<Integer> values=entry.getValue();
            System.out.println();
            System.out.print("Card :"+entry.getKey()+"->");
            for(Integer value:values){
                System.out.print(" "+ value+" ");
            }
        }
    }
}
