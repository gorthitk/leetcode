class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            stack.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next != null) {
            stack.add(slow.val);
        }

        ListNode tail = slow.next;

        while (tail != null) {
            if (tail.val != stack.pop()) {
                return false;
            }
            tail = tail.next;
        }

        return stack.isEmpty();
    }
}