class Solution {
    /**
    채워질 수 있는 물의 양 계산 (trapped 시킬)
    조건
    1. 처음과 끝에는 물이 찰 수 없다.
    input -> [0,1,0,2,1,0,1,3,2,1~] 배열
    output -> sum of trapped water 

    풀이
    투 포인터 사용
    높이가 가장 높은 곳으로 left와 right가 움직여서 좌우 포인터가 만날때까지 반복
    => 물은 [directionMaxHeight - currentHeight]을 sum해주면서 마지막에 sum반환
    각 directionMaxHeight은 포인터가 움직일때마다 계산해준다. 현재와 지금까지의 max를
    현재와 지금까지의 Max가 같다면 0이 될 것이기에 이치에 맞다.
    
     */
    public int trap(int[] height) {

        int right = height.length-1;
        int left = 0;
        int leftMax = height[left];
        int rightMax = height[right];
        int sum =0; //결과 값

        //기둥 중 가장 큰 기둥으로 left와 right포인터를 각각 업데이트 즉 겹치면 끝
        while(left < right){

            // 매 iteration마다 leftMax와 rightMax 업데이트
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            // leftMax의 값이 rightMax보다 같거나 작다면 (left 이동 right으로 한칸)
            // + sum에 현재 leftMax와 - currentHeight을 더해준다.
            if(leftMax <= rightMax){
                sum += leftMax-height[left];
                left ++;
            }
            // rightMax의 값이 leftMax보다 작다면 right 이동 left로 한칸
            // + right side에서 sum값을 업데이트 (rightMax - currentHeight)
            else{
                sum += rightMax - height[right];
                right--;
            }
        }
        return sum;

    }
}