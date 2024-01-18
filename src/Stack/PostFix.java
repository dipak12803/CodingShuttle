package Stack;

import java.util.ArrayDeque;

public class PostFix {
    public static void main(String[] args) {
//        String expression="3 4 * 2 5 * +";
//        System.out.println(evaluatePostFix(expression));
        String expression="a + b - d * ( e + f ) * g";
        System.out.println(infixToPostFix(expression));
    }
    static boolean isOperator(String s){
        return s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")||s.equals("^");
    }
    static  int evaluatePostFix(String s){
        String tokens[]=s.split(" ");
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        for(String token:tokens){
            if(isOperator(token)){
                int second=stack.pop();
                int first=stack.pop();
                int result=0;
                switch(token){
                    case "+":
                        result=first+second;
                        break;
                    case "-":
                        result=first-second;
                        break;
                    case "*":
                        result=first*second;
                        break;
                    case "/":
                        result=first/second;
                        break;
                    case "^":
                        result= (int) Math.pow(first,second);
                        break;
                }
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    static int precedence(String s){
        switch (s){
            case "^":
                return 3;
            case "*":
            case "/":
                return 2;
            case "+":
            case "-":
                return 1;
            default:
                return -1;
        }
    }
    static String infixToPostFix(String s){
        String tokens[]=s.split(" ");
        ArrayDeque<String> stack=new ArrayDeque<>();
        StringBuilder sb=new StringBuilder();
        for(String token:tokens){
            if(token.equals("(")){
                stack.push(token);
            } else if (isOperator(token)) {
                while(!stack.isEmpty() && precedence(stack.peek())>= precedence(token)){
                    String temp=stack.pop();
                    sb.append(temp).append(" ");
                }
                stack.push(token);
            } else if (token.equals(")")) {
                while(!stack.isEmpty() && !stack.peek().equals("(")){
                    String temp=stack.pop();
                    sb.append(temp).append(" ");
                }
                stack.pop();  // "(" is popped
            }else{ //operand
                sb.append(token).append(" ");
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        return sb.toString();
    }
}
