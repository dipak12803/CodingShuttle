package Stack;

import java.util.ArrayDeque;

public class StockSpan {
    public static void main(String[] args) {
//        int a[]={100,80,60,70,60,75,85};
//        int s[]=stockSpan(a);
//        for(int e:s){
//            System.out.println(e+" ");
//        }

        String exp="(({})[])(";
        System.out.println(validParanthesis(exp));
    }
    static boolean validParanthesis(String s){
        ArrayDeque<Character> stack=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char cur=s.charAt(i);
            if(cur=='(' || cur=='{' || cur=='['){
                stack.push(cur);
            }
            else{
                if(stack.isEmpty()) return false;
                char opening=stack.pop();
                if((opening=='(' && cur==')')|| (opening=='{' && cur=='}')|| (opening=='[' && cur==']')){
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    static int[] stockSpan(int[] a){
        int n=a.length;
        int[] s=new int[n];
        s[0]=1;
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        stack.push(0);
        for(int i=1;i<n;i++){
            while(!stack.isEmpty()){
                int top=stack.peek();
                if(a[top]>a[i]){
                    break;
                }else{
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                s[i]=i+1;
            }
            else{
                s[i]=i-stack.peek();
            }
        stack.push(i);
        }
        return s;

    }
}
