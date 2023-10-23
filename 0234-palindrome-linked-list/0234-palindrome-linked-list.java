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
    singly Linked List를 순회하면서 palindrome인지 아닌지 파악하는 문제

    풀이 1. Stack사용
    LinkedList의 전체 갯수가 필요 (size)
    i = 0 1 2 3 4 => size/2 = 2
        2 3 4 5 6 
    size/2의 결과가 홀수라면 -> i = 0부터 size/2-1까지 순회하면서 stack에 push
    그 후, size/2 +1부터 head가 null까지 탐색하면서 pop한 결과와 node의 val을 비교
    i = 0 1 2 3
    size/2의 결과가 짝수라면 -> i=0부터 size/2-2까지 순회하면서 stack에 push
    그 후, size/2 부터 head가 null까지 탐색하면서 pop한 결과와 node의 val을 비교


    풀이 2. Deque 인터페이스 -> ArrayDeque 사용
    ArrayDeque는 큐와 스택으로 사용할 때 각각 Queue와 Stack보다 빠르며
    자바에서 Stack은 Synchronized되어 느리기에 보통의 경우 Stack은 ArrayDeque클래스를 사용한다.

    push() -> offerLast()
    pop() -> pollLast()
    peek() -> peekLast()
    */
    public boolean isPalindrome(ListNode head) {
        int size = 0; // LinkedList 요소의 개수
        ListNode tmp = head;
        Deque<Integer> stack = new ArrayDeque<>();
        int stackVar = 0;
        boolean isPalin = true;
        
        while(tmp != null){
            size++;
            tmp = tmp.next;
        }

        tmp = head;
        
        //edge case
        //1인건 무조건 true
        if(size == 1){
            return true;
        }
        //2일때는 2개의 element를 본다.
        if(size == 2){
            if(tmp.val == tmp.next.val){
                return true;
            }
            else
                return false;
        }

        int mid = size/2; //중앙 index
        tmp = head; //다시 초기화
        //홀수 일때
        if(size%2 == 1){
            // stack에 요소 넣기
            for(int i =0; i<mid; i++){
                stack.offerLast(tmp.val);
                tmp = tmp.next; //포인터 이동
            }

            tmp = tmp.next; // 포인터 size/2+1로 이동
            // stack의 요소와 LinkedList value 비교
            // 포인터는 이미 size/2+1에 와 있다.
            for(int i = mid+1; i<size; i++){
                stackVar = stack.pollLast();
                if(stackVar != tmp.val){
                    isPalin = false; // 비교 결과가 같지 않으면 false인 것
                    break;
                }
                tmp = tmp.next;
            }
        }
        //짝수 일 때
        if(size%2 == 0){
            //stack에 요소 넣기
            for(int i=0; i<mid; i++){
                stack.offerLast(tmp.val);
                tmp = tmp.next;
            }
            for(int i = mid; i<size; i++){
                stackVar = stack.pollLast();
                if(stackVar != tmp.val){
                    isPalin = false;
                    break;
                }
                tmp = tmp.next;
            }
        }

        return isPalin;
    }
}