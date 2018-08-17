package ListNode;
import java.awt.List;
import java.awt.print.Printable;
import java.util.Currency;

import javax.xml.soap.Node;

import org.omg.CORBA.PUBLIC_MEMBER;



// 通过 2018.05.24

public class Leetcode2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode sum = new ListNode(0);
		ListNode returnNode = sum;
		int i = 0;
		while(l1!=null || l2!=null || i!=0) {
			if(l1 == null) {
				l1 = new ListNode(0);
			}
			if(l2 == null) {
				l2 = new ListNode(0);
			}
			if(l1.val + l2.val + i < 10) {
				sum.next = new ListNode(l1.val + l2.val + i);
				sum = sum.next;
				i = 0;
			}else {
				sum.next = new ListNode(l1.val + l2.val + i - 10);
				sum = sum.next;
				i = 1;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		return returnNode.next;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
	}
}
