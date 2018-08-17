package ListNode;


public class Leetcode61 {
	public static ListNode rotateRight(ListNode head, int k) {
		if(head == null) {return null;	}
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode ptr1 = first, ptr2 = first;

        
        // traverse listNode and get the length of listnode
        int len = -1;
        while(ptr1 != null) {
        	ptr1 = ptr1.next;
        	len++;
        }
        System.out.println("len = " + len);
        
        //traverse listNode and ptr2.next is to be near first
        ptr1 = first;
        int kReal = k % len;
        if(kReal != 0) {
        	int i = 0;
            boolean ptr2Flag = false;
            while(ptr1.next != null) {
            	// update
            	ptr1 = ptr1.next;
            	if(ptr2Flag) {
            		ptr2 = ptr2.next;
            		System.out.println("&&&&&&&&7");
            	}
            	i++;
            	//
            	if(i == kReal && (!ptr2Flag)) {
            		ptr2Flag = true;
            		System.out.println("********");
            	}
            	System.out.println("-----------");
            }
            // change node structure
           ListNode tempNode = first.next;
           ptr1.next = tempNode;
           first.next = ptr2.next;
           ptr2.next = null;
        }
        
       System.out.println("after process, head = " + first.next.val);
       
       System.out.println(ListNode.getLength(first.next));
       
       System.out.println("++++++++");
       return first.next;
    }
	
	public static void main(String[] args) {
		
		int[] nodeArray = {1,2,3};
		ListNode head = ListNode.createNodeWithArray(nodeArray);
		ListNode retNode = rotateRight(head, 2);
		
	}
}
