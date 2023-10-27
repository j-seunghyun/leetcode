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
    만약 병합 정렬로 해결한다면
    k * 리스트 개수만큼 반복하게 된다.

    풀이 -> Priority Queue를 Comparator을 통해 내림차순으로 정렬해서 정의한 뒤에
    나중에 ListNode로 빼내와서 사용할때 addFirst를 해준 뒤 head를 반환하면 된다.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        //안에 모두 넣기
        for(ListNode list : lists){
            while(list != null){
                pq.offer(list.val);
                list = list.next;
            }
        }

        ListNode head = null;
        //하나씩 꺼내면서 연결
        while(!pq.isEmpty()){
            ListNode node = new ListNode(pq.poll());
            node.next = head;
            head = node;

        }
        return head;
    }
}