public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || m == n)
			return head;
		int i = 1;
		ListNode prev = null;
		ListNode start = head;
		ListNode end = head;
		while (i < n) {
			prev = i < m ? start : prev;
			start = i < m ? start.next : start;
			end = end.next;
			i++;
		}

		ListNode tail = end.next;
		end.next = null;
		reverse(start);

		if (prev != null) {
			prev.next = end;
		}

		start.next = tail;
		return m > 1 ? head : end;
	}

	private ListNode reverse(ListNode node) {
		if (node == null || node.next == null)
			return node;
		ListNode nxt = node.next;
		node.next = null;
		ListNode reverse = reverse(nxt);
		nxt.next = node;
		return reverse;
	}
}