package ListNode;

import java.nio.channels.ScatteringByteChannel;

public class LeetCode23 {
	
	
	/** 
	 * @Title: mergeKLists 
	 * https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
	 * @Description: 通过遍历的方法来解决
	 * @param lists
	 * @return 
	 */
	public static ListNode mergeKLists(ListNode[] lists) {
        ListNode retFirst = new ListNode(0);
        ListNode ptrRet = retFirst;
        // 构造指针数组，并让每个指针的next指向lists的首节点
        ListNode[] ptr = new ListNode[lists.length];
        for(int i=0; i<lists.length; i++) {
        	ptr[i] = new ListNode(0);
        	ptr[i].next = lists[i];
        	ptr[i] = ptr[i].next;
        	System.out.println("ptr" + i + "= " + ptr[i].val);
        }
        int index = 0;
        
        // 判断当前ptr[]是否全都指向空指针
		while(!(nullNodeJudge(ptr))) {
			// 最小下标
			System.out.println("-------");
			index = returnMinIndex(ptr);
			ptrRet.next = new ListNode(ptr[index].val);
			// update prtRet and ptr
			ptr[index] = ptr[index].next;
			ptrRet = ptrRet.next;
		}
			
        return retFirst.next;
    }
	
	
	
	/** 
	 * @Title: returnMinIndex 
	 * @Description: 返回当前ptr数组中，对应的value最小的ptr的下标index
	 * @param ptr
	 * @return 
	 */
	public static int returnMinIndex(ListNode[] ptr) {
		int index=-1;
		for(int i=0; i<ptr.length; i++) {
			if (ptr[i]!=null) {
				index = i;
				break;
			}
		}
		int min = ptr[index].val;
		// 如果相同，则取最前面位置的index
		for(int i=index; i<ptr.length; i++) {
			if(ptr[i] == null) {continue;}
			
			if(ptr[i].val < min) {
				index = i;
				min = ptr[i].val;
			}
		}
		return index;
			
	}
	
	/** 
	 * @Title: nullNodeJudge 
	 * @Description: 判断lists中每一个node是否都是空node
	 * @param lists
	 * @return 
	 */
	public static boolean nullNodeJudge(ListNode[] lists) {
		boolean flagEmpty = true;
		for(ListNode node: lists) {
			if(node != null) {
				flagEmpty = false;
				break;
			}
		}
		return flagEmpty;
	}
	
	
	public static void main(String[] args) {
		int[] values1 = {1,2,3};
		int[] values2 = {2,3,4};
		ListNode node1 = ListNode.createNodeWithArray(values1);
		ListNode node2 = ListNode.createNodeWithArray(values2);

		ListNode[] lists = {node1, node2};
		ListNode.printNode(mergeKLists(lists));
		//		System.out.println(returnMinIndex(values));
		
	}
}
