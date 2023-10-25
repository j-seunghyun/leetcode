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
    정렬된 2개의 list를 병합하는 문제
    정렬된 상태로 병합해야 한다.
    
    풀이1.
    list1과 list2를 순회하는 ListNode curA, curB를 잡아
    매 iteration마다 curA.val과 curB.val을 계산해 더 작거나 같은 것을 삽입
    curA와 curB모두 다 순회되어서 null일때까지 반복 (즉 curA != null && curB != null)
    
    풀이2. 재귀 사용
    merge Sort의 마지막 조합과 동일하게 (첫 번째 부터 비교하면서 리턴하면 쉽게 풀 수 있다.)

     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        // list1의 val이 list2의 val보다 작다면 현재 iter에서 list1이 선택되어야 한다. 
        if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}