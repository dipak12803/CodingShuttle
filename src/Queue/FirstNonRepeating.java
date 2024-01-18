package Queue;

import java.util.*;

public class FirstNonRepeating {
    public static void main(String[] args) {
        String s="mdwfxytmt";
        System.out.println(firstNonRepeatingInStream(s));
    }
    public static String firstNonRepeatingInStream(String s){
        StringBuilder sb=new StringBuilder();
        int frequency[]=new int[26];
        Queue<Character> q=new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);

            q.offer(c);
            frequency[c-'a']++;     //it gives index for current character eg.'c'-'a'=2

                                    //frequency of top element is greater than 1
            while(!q.isEmpty() && frequency[q.peek()-'a']>1){
                q.poll();
            }
            if(q.isEmpty()){
                sb.append("#");
            }
            else{
                sb.append(q.peek());
            }
        }
        return sb.toString();
    }
}
