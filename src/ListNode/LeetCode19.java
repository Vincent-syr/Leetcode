package ListNode;

import java.awt.List;

public class LeetCode19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		// 建立哨兵节点
		ListNode first = new ListNode(0);
		first.next = head;
		
		ListNode ptr1 = first, ptr2 = first;
		int i = 0;
		while(ptr1 != null) {
			if(i > n) {
				ptr2 = ptr2.next;
			}
			ptr1 = ptr1.next;
			i++;
		}
		ptr2.next = ptr2.next.next;
		System.out.println("ptr2 = " + ptr2.val);
		return first.next;
    }
}
