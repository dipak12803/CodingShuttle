package Recursion;

public class countOccurence {
    public static void main(String[] args) {
        System.out.println(count("aba","ababbabac"));
    }
    public static int count(String text, String s) {
        //You can code here
        return helper(text,s,0);
    }
    static int helper(String text, String s, int i){
        if(i>text.length()-s.length()) return 0; //if s size is greater than string size
        int subProblemAns=helper(text,s,i+1);
        boolean doStartingCharMatch=text.substring(i,s.length()).equals(s);
        if(doStartingCharMatch){
            return subProblemAns+1;
        }
        else{
            return subProblemAns;
        }

    }
}
