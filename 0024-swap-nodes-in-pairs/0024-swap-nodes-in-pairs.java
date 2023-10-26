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
    현재 연결리스트의 각 pair를 swap하는 문제
    풀이1. while루프 사용
    while(head ==null)로 반복
    head는 매 iteration이 끝난 뒤 head.next.next로 이동한다.
    node의 수가 짝수 개였을 경우, head ==null이 되어 종료
    node의 수가 홀수 개였을 경우, head가 마지막 element를 가리키고 있을 때,
        다음 iteration으로 head.next.next가 실행될 수 없으므로, iteration의 끝에서 판단 뒤에 head.next가 null이라면 종료하는 식으로

    기본적으로 swap을 하는 것이기 때문에, 현재까지의 연결리스트 node를 가리키는 head,
    새로운 연결리스트의 현재 노드를 가리키는 curPtr, 새로운 연결리스트의 head를 가리키는 newHead가 필요하다.

    또한 , 아직 한번도 채워지지 않은 경우

     */
    public ListNode swapPairs(ListNode head) {

        //swap할 node가 아예 없다면 null return
        if(head == null) return null;

        //head.next가 없다면 swap할 필요없기 때문에 head return
        if(head.next == null) return head;
        ListNode newHead = null;
        ListNode curr = newHead;

        //head가 null일때까지 반복
        while(head != null){

            //만약 newHead가 null이라면
            if(newHead == null){
                ListNode next = head.next.next; //다음 iteration으로 옮길 노드 저장
                curr = head.next;
                newHead = curr; //newHead 저장해 줌
                head.next = null;   //cycle방지
                curr.next = head;
                curr = curr.next;
                head = next;
            }
            //newHead가 null이 아닐때
            //head.next가 현재 존재하지 않는 홀수개였을 경우를 생각해야 한다.
            else{
                //마지막 요소라면 swap x
                if(head.next == null){
                    ListNode next = head.next; //다음 iteration으로 옮길 노드 저장
                    head.next = null;   //cycle방지
                    curr.next = head;
                    head = head.next;
                }

                //마지막 요소가 아니라면 swap진행
                else{
                    ListNode next = head.next.next; //다음 iteration으로 옮길 노드 저장
                    curr.next = head.next;
                    head.next = null; //cycle 방지
                    curr.next.next = head;
                    curr = curr.next.next;
                    head = next;
                }
            }

        }

        return newHead;
        
    }
}