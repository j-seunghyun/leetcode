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
    두 연결리스트의 합을 구하는 문제
    거꾸로 뒤집힌 2개의 연결리스트로 각 자릿수의 합을 구한다.

    풀이1. 재귀 사용
    l1과 l2로 l1이 비어있다면 l2와 (1 or 0)을 더한 값을
    l2가 비어있다면 l1과 (1 or 0)을 더한 값을
    둘다 비어있다면 null을 return
    l1, l2가 모두 있다면 l1,l2,(1 or 0)를 더한 값을 더한다.
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int upper){
        //l1과 l2가 모두 비어있다면
        if(l1 == null && l2 ==null){
            //edge case
            //l1과 l2가 모두 비어있어도, upper이 존재하는 문제
            if(upper != 0){
                ListNode last = new ListNode();
                last.val = upper;
                return last;
            }
            else{
                return null;
            }
        }

        //l1만 null이라면
        if(l1 == null){
            int newUpper = (l2.val+upper)/10;
            l2.val = (l2.val+upper)%10;
            l2.next = addTwoNumbers(l1, l2.next , newUpper);
            return l2;
        }
        //l2만 null이라면
        else if(l2 == null){
            int newUpper = (l1.val+upper)/10;
            l1.val = (l1.val+upper)%10;
            l1.next = addTwoNumbers(l1.next, l2, newUpper);
            return l1;
        }
        //둘다 null이 아니라면
        else{
            int newUpper = (l1.val+l2.val+upper)/10;
            l1.val = (l1.val+l2.val+upper)%10;
            l1.next = addTwoNumbers(l1.next, l2.next, newUpper);
            return l1;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1,l2,0);
    }
}