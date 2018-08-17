package stack;

import java.util.Stack;

/** 
 * @ClassName: LeetCode155 
 * @Description: 155. 最小栈
 * @author: Vincent Sean
 * @date: 2018年5月30日 下午5:46:04  
 */

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


class MinStack{

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    
    /** initialize your data structure here. */
    public MinStack() {}
    
    public void push(int x) {
        s1.push(x);   // 插入首节点
        if (s2.isEmpty() || s2.peek() >= x) s2.push(x);
    }
    
    public void pop() {
        // Cannot write like the following:
        // if (s2.peek() == s1.peek()) s2.pop();
        // s1.pop();
        int x = s1.pop();   // 删除首节点
        if (s2.peek() == x) s2.pop();
    }
    
    public int top() {   // 返回首节点
        return s1.peek();
    }
    
    public int getMin() {
        return s2.peek();
    }
}
    



public class LeetCode155 {
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());   
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}
}
