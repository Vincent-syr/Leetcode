package stack;

import java.util.Stack;

public class LeetCode150 {
    
    public static int evalRPN(String[] tokens) {
    	if(tokens==null||tokens.length==0){  
            return 0;  
        }  
        if(tokens.length==1){  
            return Integer.parseInt(tokens[0]);  
        } 
    	
    	Stack<Integer> stack = new Stack<>();
        int value1 = 0, value2 = 0;
        for(String str: tokens) {
        	if("+".equals(str)) {
        		value1 = stack.pop();
        		value2 = stack.pop();
        		stack.push(value2 + value1);
        		System.out.println("after+, push:" + (value1+value2));
        	}else if("-".equals(str)) {
        		value1 = stack.pop();
        		value2 = stack.pop();
        		stack.push(value2 - value1);
        		System.out.println("after-, push:" + (value2-value1));

        	}else if("*".equals(str)) {
        		value1 = stack.pop();
        		value2 = stack.pop();
        		stack.push(value2 * value1);
        		System.out.println("after*, push:" + (value1*value2));

        	}else if("/".equals(str)) {
        		value1 = stack.pop();
        		value2 = stack.pop();
        		stack.push(value2 / value1);
        		System.out.println("after/, push:" + (value2/value1));

        	}else {
        		stack.push(Integer.parseInt(str));
        		System.out.println("only push:"+ Integer.parseInt(str));
        	}
        }
        return stack.pop();
        	
    }
    public static void main(String[] args) {
		String[] tokens = {"10", "6", "9", "3", "+", "-11", 
				"*", "/", "*", "17", "+", "5", "+"};
		System.out.println(evalRPN(tokens));
	}
    
    
//    public static int operator(String value1, String value2, String op) {
//    	int ret = 0;
//    	if("+".equals(op)) {
//    		ret =  Integer.parseInt(value1) + Integer.parseInt(value2);
//    	}
//    	else if("-".equals(op)) {
//    		ret = Integer.parseInt(value1) - Integer.parseInt(value2);
//    	}
//    	else if("*".equals(op)) {
//    		ret = Integer.parseInt(value1) * Integer.parseInt(value2);
//    	}
//    	else {
//    		ret = Integer.parseInt(value1) / Integer.parseInt(value2);
//    	}
//    	
//    	
//    	return ret;
//    }
}
