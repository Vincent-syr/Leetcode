package stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

/** 
 * @ClassName: LeetCode71 
 * @Description:  简化路径
 * 给定一个文档 (Unix-style) 的完全路径，请进行路径简化。

	例如，
	path = "/home/", => "/home"
	path = "/a/./b/../../c/", => "/c"
 * @author: Vincent Sean
 * @date: 2018年5月28日 下午4:12:22  
 */

public class LeetCode71 {
	public static String simplifyPath(String path) {
        String[] eachs = path.split("/");
        System.out.println(Arrays.toString(eachs));
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        
        // empty path
        if (eachs == null) {return "/";}
        
        for(String each: eachs) {
        	
        	if("..".equals(each)) {
        		if(!stack1.empty()) {
        			stack1.pop();
        		}
        	}
        	
        	// “”和null情况跳过
        	else if(!(".".equals(each)) && (! each.isEmpty())) {
        		stack1.push(each);
        		System.out.println("push:" + each);
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack1.isEmpty()) {
        	sb.insert(0, stack1.pop()).insert(0, "/");
        }
        return !sb.toString().equals("")? sb.toString(): "/";
    }
	
	
	public static void main(String[] args) {
//		System.out.println(simplifyPath("/a/./b/../../c"));
		System.out.println(simplifyPath("/a/./b/"));
//		System.out.println(simplifyPath("//"));
	}
}
