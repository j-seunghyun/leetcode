class Solution {

    /**
    pair들의 min값의 sum이 최대화가 될 수 있도록 하는 문제
    min값이 최대화가 되면 되기 때문에 쉽게 생각해서
    sort를 오름차순으로 한 뒤 2개씩 순서대로 pair를 이루게 하면 된다.
    min의 sum이 최대가 되려면 작은 것끼리 pair, 큰 것은 큰 것 끼리 min (손실 극소화) 

    ex) 1,4,3,2 => 1,2,3,4
    (1,2) , (3,4) => 1+3 = 4 
    6,2,6,5,1,2 => 1,2,2,5,6,6
    (1,2) (2,5) (6,6) -> 1+2+6 = 9

     */
    public int arrayPairSum(int[] nums) {

        //정렬 (기본이 오름차순)
        Arrays.sort(nums);
        int sum = 0;

        //2개씩 pair를 잡아 min 값을 더할것이기 때문에 i = i+2씩 증가
        //문제 조건에서 배열의 길이가 홀수인 것은 없기 때문에 예외 생각 x
        for(int i = 0; i<nums.length; i=i+2){

            //2개씩 잡아서 sum에 더해준다.
            sum += Math.min(nums[i], nums[i+1]);
        }
        return sum;
    }
}