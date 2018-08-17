package stack;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/** 
 * @ClassName: LeetCode394 
 * @Description: 394. 字符串解码
 * @author: Vincent Sean
 * @date: 2018年5月29日 下午2:57:40  
 */
public class LeetCode394 {
    public static String decodeString(String s) {
    	String temp;
    	char[] cArrays = s.toCharArray();
    	Stack<String> stack1 = new Stack<>();
    	Stack<Integer> stack2 = new Stack<>();
    	int j = 0;
    	Stack<Integer> stack3 = new Stack<>();
    	for(char c: cArrays) {
    		// 考虑数字是多位的情况
    		if(c >= '0' && c<='9' ) {
    			System.out.println("j=" + j);
    			if(stack3.isEmpty()) {
    				stack2.push(Integer.parseInt(""+c));
                    stack3.push(j);
    			}
    			else if(stack3.peek().equals(j-1)) {
    				int num = 10*stack2.pop() + Integer.parseInt(""+c);
    				stack2.push(num);
    				stack3.push(j);
    			}
    			else {
    				stack2.push(Integer.parseInt(""+c));
                    stack3.push(j);
    			}
    		}
    		else if(c==']') {
    			// initial lize
    	    	StringBuilder each= new StringBuilder();
    			while(!(temp=stack1.pop()).equals("[")) {
    				each.insert(0, temp);
    			}
    			System.out.println("each=" + each);
    			int nums = stack2.pop();
//    			System.out.println("***peek: " + stack1.peek());
    			
    			for(int i=0; i<nums; i++) {
    				stack1.push(each.toString());
    			}
    			
    			System.out.println("***push: " + nums + each);
    			
    		}else {
    			stack1.push(""+c);
    			System.out.println("stack1 push:" + c);
    		}
    		j++;
    	}
    	StringBuilder ret = new StringBuilder();
    	for(String item: stack1) {
    		ret.append(item);
    	}
    	return ret.toString();
    }	
    public static void main(String[] args) {
		System.out.println(decodeString("2[2[b]]"));
	}
    
}
