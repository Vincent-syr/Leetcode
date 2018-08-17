package ListNode;

import java.awt.List;
import java.util.function.IntPredicate;

public class Leetcode24 {
	
	public static ListNode swapPairs(ListNode head) {
	    ListNode first = new ListNode(0);
	    first.next = head;
	    ListNode ptr = first;
	    // 额外空间
	    ListNode temp1, temp2;
	    while(ptr.next != null) {
	    	// 留下的最后一个点
	    	if(ptr.next.next == null) {
	    		System.out.println("the last node = " + ptr.next.val);
	    		break;
	    	}
	    	temp1 = ptr.next;
	    	temp2 = ptr.next.next.next;
	    	// change position of the near nodes
	    	ptr.next = temp1.next;
	    	ptr.next.next = temp1;
	    	ptr.next.next.next = temp2;
	    	// print and check
	    	System.out.println(ptr.next.val + "--" + ptr.next.next.val);
	    	
	    	// update ptr in the loop
	    	ptr = temp1;
	    }
        return first.next;

	}
	
	
	public static void main(String[] args) {
		int[] nodeArray = {1};
		ListNode head = ListNode.createNodeWithArray(nodeArray);
		ListNode.printNode(swapPairs(head));
	}
}
