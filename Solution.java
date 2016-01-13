package HW1;

public class Solution {
	
	public ListNode deleteDuplicates(ListNode head) {	//Q1
        if(head == null || head.next == null)	return head;
        ListNode tHead = new ListNode(1), pos = tHead;
        ListNode prev = head, cur = head.next;
        
        while(cur != null){
        	while(cur != null && prev.val == cur.val){
        		cur = cur.next;
        	}
        	
        	if(prev.next == cur){
        		pos.next = prev;
        		pos = pos.next;
        	}
        	
        	prev = cur;
        }
        
        pos.next = null;
        return tHead.next;
    }
	
	public ListNode reverseBetween(ListNode head, int m, int n) {	//Q2
        ListNode tHead = new ListNode(0);
        tHead.next = head;
        ListNode prev = tHead;
        int count = 1;
        while(count < m){
        	prev = prev.next;
        	count++;
        }
        
        ListNode cur = prev.next, lastNode = cur, next = null;
        while(count++ <= n){
        	next = cur.next;
        	cur.next = prev.next;
        	prev.next = cur;
        	cur = next;
        }
        lastNode.next = next;
        return tHead.next;
    }
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {	//Q3
        ListNode tHead = new ListNode(0), pos = tHead;
        while(l1 != null && l2 != null){
        	ListNode min = null;
        	if(l1.val < l2.val){
        		min = l1;
        		l1 = l1.next;
        	}
        	else{
        		min = l2;
        		l2 = l2.next;
        	}
        	pos.next = min;
        	pos = pos.next;
        }
        
        ListNode rest = (l1 == null) ? l2 : l1;
        pos.next = rest;
        return tHead.next;
    }

	public static void main(String[] args) {
		Solution so = new Solution();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next=l2;l2.next=l3;l3.next=l4;l4.next=l5;
		int m = 2, n = 4;
		ListNode res = so.reverseBetween(l1, m, n);
		while(res != null){
			System.out.print(res.val + " ");
			res = res.next;
		}
	}

}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}