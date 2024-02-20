package AP_Sem6;
import java.util.*;
public class Exp1_4a {
    public static void main(String[] args) {
        String p1="abba";
        String s1="dog cat cat dog";
        System.out.println(wordPattern(p1,s1));

        String p2="abba";
        String s2="dog cat cat fish";
        System.out.println(wordPattern(p2,s2));

    }
    public static boolean wordPattern(String pattern, String s) {
        String[] words=s.split(" ");
        if(words.length!=pattern.length()) return false;

        Map<Character,String> charPattern=new HashMap<>();
        for(int i=0;i<words.length;i++){
            char c=pattern.charAt(i);
            String word=words[i];

            if(!charPattern.containsKey(c)){
                if(charPattern.containsValue(word)) return false;
                charPattern.put(c,word);
            }
            else if(!charPattern.get(c).equals(word)) return false;

        }
        return true;
    }
}
