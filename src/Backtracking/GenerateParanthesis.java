package Backtracking;

public class GenerateParanthesis {
    public static void main(String[] args) {
        int n=2;
        generateparenthesis(n,"",0,0,0);
    }
    static void generateparenthesis(int n,String cur,int i, int open,int close){
        if(i==2*n){
            System.out.println(cur);
            return;
        }
        if(open<n){
            cur=cur+'(';
            generateparenthesis(n,cur,i+1,open+1,close);
            cur=cur.substring(0,cur.length()-1); //backtracking , removes the latest added paranthesis
        }
        if(close<open){
            cur=cur+')';
            generateparenthesis(n,cur,i+1,open,close+1);
        }
    }
}
