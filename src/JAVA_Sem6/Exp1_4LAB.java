package JAVA_Sem6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
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
            c=in.next().charAt(0);
            cardNumber=in.nextInt();
            cardSum+=cardNumber;
            l=cardMap.getOrDefault(c,new ArrayList<>());
            l.add(cardNumber);
            cardMap.put(c,l);


        }

        for(Map.Entry<Character, List<Integer>> entry: cardMap.entrySet()){
            char card=entry.getKey();
            List<Integer> value=entry.getValue();


            System.out.println("Key :"+card+" Value : "+value);

        }
        System.out.println("Total sum of cards is "+cardSum);



    }

}
