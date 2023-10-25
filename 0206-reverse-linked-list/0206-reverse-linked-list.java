/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
    linked List를 뒤집어서 반환

    풀이1. 
    ListNode ans_head를 만들어서
    addFirst하는 방식으로 head가 null이 아닌 동안 반복
     */
    public ListNode reverseList(ListNode head) {
        
        ListNode ans_head = null;

        while(head != null){

            ListNode tmp = head.next;
            head.next = ans_head;
            ans_head = head;
            head = tmp;

        }
        return ans_head;
    }
}