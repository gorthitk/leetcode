/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
const mergeTwoLists = function (l1, l2) {
    const result = new ListNode();

    let current = result;

    while (l1 && l2) {
        if (l1.val > l2.val) {
            current.next = new ListNode(l2.val);
            l2 = l2.next;
        } else {
            current.next = new ListNode(l1.val);
            l1 = l1.next;
        }

        current = current.next;
    }

    current.next = l1 || l2;
    return result.next;
};
