class Solution {
    /**
    answer[i] => 자기 자신을 제외한 모든 element의 곱

    1. bruteforce
    for i = 0 to n
        for j = 0 to n
            if (j!= i)
              answer[i] *= nums[j]
    O(n2)

    O(n) time안에 해결 가능한 알고리즘을 사용해야 한다.
    
    2. idea : 자신을 제외한 모든 element의 곱을 담아야 하기 때문에
    미리 모든 요소를 곱해 놓고, 모든 요소의 곱에 자기자신을 나눈 값을 저장

    문제 - 어느 한 요소가 0이라면 요소들의 곱이 무조건 0이 되는 현상
    곱이 0이 된다면, answer 배열에 들어갈 모든 요소는 0이 되고, i번째 answer은 다른 요소들의 곱 저장
    + 문제 조건에서 /연산을 제외하고라고 했음 (X)

    3. 왼쪽 곱과 오른쪽 곱셈 결과를 곱하는 방법
    ex)    1 3 5 7
    left 1 1 3 15       (왼쪽 누적곱 마지막요소 제외까지)
    right   105 35 7 1   (오른쪽 누적곱 첫번째요소 제외까지)

    즉, 서로 겹치지 않게 i-1 번째까지의 곱과 i+1 to n-1까지의 곱을 미리 구해놓은 다음
    2개의 곱을 답으로 내리는 방법

      1 2 3 4
    1 1 2 6
        24 12 4 1

     */
    public int[] productExceptSelf(int[] nums) {

        int [] answer = new int[nums.length];
        
        int rightMultValue = 1;
        answer[0] = 1;

        //left 누적곱 연산
        for(int i = 0; i<nums.length-1; i++){
            answer[i+1] = nums[i]*answer[i];  
        }

        //right 누적곱 * left
        for(int i = nums.length-1; i> 0; i--){
            answer[i] *= rightMultValue;
            rightMultValue *= nums[i];
        }
        
        answer[0] *= rightMultValue;
        return answer;
    }
}