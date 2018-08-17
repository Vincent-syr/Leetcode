package ListNode;

import java.awt.List;
import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.regex.Pattern;

public class ListNode {
	
	
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
	
	public static ListNode createNodeWithArray(int[] nodeArray) {
		ListNode first = new ListNode(0);
		ListNode ptr = first;
		if(nodeArray == null) {
			return null;
		}
		for(int i=0; i<nodeArray.length; i++) {
			ptr.next = new ListNode(nodeArray[i]);

			ptr = ptr.next;
		}
		return first.next;
	}
	
	
	public static void printNode(ListNode head) {
		ListNode ptr = head;
		if(ptr == null) {
			System.out.println("empty node");
			return;
		}
		while(ptr != null) {
			System.out.println(ptr.val);
			ptr = ptr.next;
		}
	}
	
	public static int getLength(ListNode head) {
		int len = 0;
		ListNode ptr = head;
		while(ptr != null) {
			len++;
			ptr =ptr.next;
		}
		System.out.println("length of ListNode = " + len);
		return len;
	}
	
	
	public static void main(String[] args) {
		
		int[] nodeArray = {1,2,3,4};
		System.out.println(Arrays.toString(nodeArray));
		
		ListNode head = createNodeWithArray(nodeArray);
		printNode(head);
		System.out.println(getLength(head));
	}
	
}
