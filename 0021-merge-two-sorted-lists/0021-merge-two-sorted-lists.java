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
    
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode answer = null;
        ListNode tail = answer;

        while(!(list1 == null && list2 == null)){

            //list1은 순회가 끝났으면 -> list2요소만 삽입(addLast해야 한다.)
            if(list1 == null){
                
                //answer의 head를 위해
                if(answer == null){
                    ListNode next = list2.next;
                    list2.next = null;
                    answer = list2;
                    list2 = next;
                    tail = answer;
                }
                //tail만 신경써주면 된다.
                else{
                    ListNode next = list2.next;
                    list2.next = null;  
                    tail.next = list2;
                    tail = tail.next;
                    list2 = next;
                }
            }
            //list2는 순회가 끝났으면 -> list1요소만 삽입
            else if(list2 == null){
                if(answer == null){
                    ListNode next = list1.next;
                    list1.next = null;
                    answer = list1;
                    list1 = next;
                    tail = answer;
                }else{
                    ListNode next = list1.next;
                    list1.next = null;
                    tail.next = list1;
                    tail = tail.next;
                    list1 = next;
                }
            }
            //둘다 순회가 아직 안끝났으면 -> 대소 비교해서 삽입
            else{
                //list1이 작거나 같다면 list1의 value삽입
                if(list1.val <= list2.val){

                    //마찬가지로 answer이 null인 경우를 고려한다.
                    if(answer == null){
                        ListNode next = list1.next;
                        list1.next = null;
                        answer = list1;
                        list1 = next;
                        tail = answer;
                    }else{
                        ListNode next = list1.next;
                        list1.next = null;
                        tail.next = list1;
                        tail = tail.next;
                        list1 = next;
                    }
                }
                // list2가 더 작을때 list2의 value삽입
                else{

                    if(answer == null){
                        ListNode next = list2.next;
                        list2.next = null;
                        answer = list2;
                        list2 = next;
                        tail = answer;
                    }
                    else{
                        ListNode next = list2.next;
                        list2.next = null;
                        tail.next = list2;
                        tail = tail.next;
                        list2 = next;
                    }
                }

            }

        }

        return answer;
    }
}