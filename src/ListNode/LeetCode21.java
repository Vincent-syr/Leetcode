package ListNode;

//通过 2018.05.24

public class LeetCode21 {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode mergeCurrent = new ListNode(0);
		ListNode retNode = mergeCurrent;
		while(l1!=null || l2!= null ) {
			if(l1 == null) {
				mergeCurrent.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			else if(l2 == null) {
				mergeCurrent.next = new ListNode(l1.val);
				l1 = l1.next;
			}
			else {
				if(l1.val >= l2.val) {
					mergeCurrent.next = new ListNode(l2.val);
					l2 = l2.next;
				}else {
					mergeCurrent.next = new ListNode(l1.val);
					l1 = l1.next;
				}
			}
			System.out.println("add " + mergeCurrent.next.val);
			mergeCurrent = mergeCurrent.next;
		}
		return retNode.next;
	}
}
