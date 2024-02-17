package AP_Sem6;

import java.util.*;

public class Exp1_2 {
    public static void main(String[] args) {
        System.out.println("Rotate String");
        String a="abcde";
        String b="cdeab";
        System.out.println("Given Strings are : "+a+" and "+b+" ");
        System.out.println(rotateString(a,b));
        System.out.println();

        System.out.println("Find the Index of the First Occurrence in a String");
        String haystack="sadbutsad";
        String needle="sad";
        System.out.println("String : "+haystack);
        System.out.println("Pattern : "+needle);
        System.out.println(strStr(haystack,needle));
    }
//    Rotate String
    public static boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        String newString=s+s;
        if(newString.contains(goal)) return true;
        else{
            return false;
        }
    }
        //Find the Index of the First Occurrence in a String
    public static int strStr(String haystack, String needle) {
        int n=haystack.length();
        int m=needle.length();
        if(n<m) return -1;

        for(int i=0;i<n;i++){
            int temp=i;
            int j=0;
            for(j=0;j<m;j++){
                if(haystack.charAt(temp)!=needle.charAt(j)){
                    break;
                }
                if(temp<n-1) temp++;
                // temp++;
            }
            if(j==m){
                return i;
            }

        }
        return -1;
    }
}
