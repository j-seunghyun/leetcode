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

    풀이3. 러너기법 사용
    빠른 러너 -> 2칸씩 이동
    느린 러너 -> 1칸씩 이동

    Node의 Element수가 홀수였다면 빠른 러너가 끝에 도달했을 떄, 느린 러너는 딱 중간에 위치
    Node의 Element수가 짝수였다면 중간의 2개의 index중 2번쨰 index에 느린 러너가 도달하게 된다.

    짝수였다면 현재 느린러너 위치부터 마지막까지 느린 러너가 움직이는 곳이 rev가 된다.
    홀수였다면 현재 느린러너 위치.next 부터 마지막까지 느린러너가 움직이는 곳이 rev가 된다.
    
    rev 연결리스트를 생성한 다음 head로 처음부터 시작해
    rev 연결리스트의 각 노드의 val와 head 연결리스트의 각 노드의 val을 비교하면 된다.

    */
    public boolean isPalindrome(ListNode head) {

        ListNode fast = head; ListNode slow = head;
        
        // 1. 빠른 러너가 끝에 도달할때까지 반복
        // 홀수개 였다면 빠른러너는 2칸씩 매번 이동가능하고, 마지막에 도달하면 fast.next가 null이 된다.
        // 짝수개 였다면, 빠른 러너는 마지막 에서 두번째 element에서 끝난다. 
        // 1 2 3 4
        // x   x   x
        //     o
        // 1 2 3 4 5
        // x   x   x x
        //     o o
        while(fast != null && fast.next != null){
            // fast는 2칸씩, slow는 1칸씩 이동
            fast = fast.next.next;
            slow = slow.next;
        }

        // rev 연산을 같이 하기 위해서 일부러 홀수의 경우 한번 더 움직여준다.
        if(fast != null){
            //slow를 한번 더 움직여 주어야 한다.
            slow = slow.next;
        }

        //2. rev 연결리스트 생성
        // 연결리스트에 Node를 추가할때는 맨 앞에 (addFirst한다는 것을 잊지 말자)
        // 짝수개 였으면 현재 느린러너 위치부터 마지막까지 느린 러너가 움직이는 곳이 rev가 된다.
        ListNode rev = null;

        while(slow != null){
            ListNode tmp = slow.next; //지금의 slow.next를 tmp에 저장해 두고 ** (그래야 포인터 움직일 수 있다.)
            slow.next = rev;
            rev = slow;
            slow = tmp;
        }

        // 연결리스트의 addFirst를 사용했기에 역순으로 들어가게 된다.
        // 4 5를 집어넣으면 -> 5 4 순으로 들어가있다.
        // 고로, 2개의 list가 서로가 같아야지 palindrome이라고 할 수 잇음

        while(rev != null){
            if(head.val != rev.val){
                return false;
            }
            head = head.next;
            rev = rev.next;
        }



        return true;
    }
}