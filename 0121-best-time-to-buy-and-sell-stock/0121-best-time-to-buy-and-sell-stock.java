import java.util.Arrays;
class Solution {

    /**
    주식을 사고 팔아서 최대 이익을 반환하는 문제

    조건 1. 사야지 팔 수 있다.
    즉, min의 position이 max의 position보다 앞 서 있어야 한다.
    이 조건에 의해 min과 max 벨류를 먼저 찾아낸 뒤, index를 비교하면 안된다.
    즉, 돌면서 min과 max또한 바뀌어야 함.
    
    조건 2. 최대 이익이 없다면 0을 반환해야 한다. 

    풀이1.
    brute force -> i 와 j를 사용해 하나씩 다 살펴보면서 maxProfit을 업데이트
    O(n2) -> timeout

    풀이2.
    minValue 현재까지의 저점을 update해가면서
    현재 값과 저점까지의 차이가 (최대 이익)인 경우 교체하는 방법을 사용

     */
    public int maxProfit(int[] prices) {
        // 최대이익, 저점값 초기화
        int maxProfit = 0; int minValue = prices[0];   

        // 최대 이익에만 초점을 맞추어
        // 지금까지의 저점가격을 업데이트 하고, 현재까지의 가격-저점가격과 현재의 최대이익을 비교해서
        // 최대이익만을 업데이트 하는 방법
        for(int price: prices){
            minValue = Math.min(price,minValue);
            maxProfit = Math.max(maxProfit, price-minValue);
        }

        return maxProfit;
    }
}