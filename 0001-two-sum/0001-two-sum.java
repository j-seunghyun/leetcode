class Solution {
    public int[] twoSum(int[] nums, int target) {
        /**
        nums배열에 있는 2개의 number합이 target이 되는 위치를 return
        1. num을 돌면서 2개의 합이 target과 같을 때를 찾는다. (i,j) iter -> o(n2) - bruteforce(무차별 대입 방식)
        2. Map 활용 -> Map의 contains (hashfunction으로 찾기 때문에 조회에 이점을 가진다.)
            => Map에 Integer, Integer로 각 num과 위치(i)를 넣은 뒤 이후 각 num을 돌며 get을 하며 같은지 비교
         */

         Map<Integer, Integer> twoMap = new HashMap<>();

        //초기화
         for(int i = 0; i<nums.length; i++){
             twoMap.put(nums[i], i);
         }

         for(int i=0; i<nums.length; i++){
             int key = nums[i];
             //서로 다른 2개의 합이므로 같은 수의 합은 안된다. => short circuit 로 인해 가능한 것으로
             // && 두 조건문 위치 조심 (바뀌면 오류 날 수 있다. )
             if(twoMap.containsKey(target- key) && i != twoMap.get(target-key)){
                 return new int[]{i, twoMap.get(target-nums[i])};
                 
             }
         }
         //unique value이기 때문
         return null;
    }
}