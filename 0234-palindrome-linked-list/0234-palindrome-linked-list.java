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
    Deque의 특징은 양쪽으로 element를 빼낼 수 있다는 것이 특징이기에 이를 활용해 풀이를 한다.
    양쪽을 빼내서 서로 비교하는 것
    size가 홀수라면 -> 양 옆을 size/2-1 번 만큼 반복
    size가 짝수라면 -> size/2-1번 만큼 반복

    push() -> offerLast()
    pop() -> pollLast()
    peek() -> peekLast()

    풀이3. 
    */
    public boolean isPalindrome(ListNode head) {
        int size = 0; // LinkedList 요소의 개수
        ListNode tmp = head;
        Deque<Integer> stack = new ArrayDeque<>();
        boolean isPalin = true;
        
        // 미리 deque에 적재해 놓고 빼서 사용하는 것
        while(tmp != null){
            size++;
            stack.offerLast(tmp.val);
            tmp = tmp.next;
        }
        // 반복할 count
        int count = size/2 -1;

        //count가 0이 될때까지 반복
        while(count >= 0){
            //deque에서 마지막 element와 첫번째 element가 같지 않다면 false and break
            if(stack.pollFirst() != stack.pollLast()){
                isPalin = false;
                break;
            }
            count--;
        }
        
    
        return isPalin;
    }
}