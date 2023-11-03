class Solution {
    /**
    candidates의 조합 중 , 그들의 합이 target이 되는 것들을 반환
    중요한 것은 중복이 허용된 다는 것이다 -> 중복 조합임

    그리고 , K가 없다 (즉 꼭 k번 뽑아야 한다는 제약 조건이 없음)
    몇 개가 뽑히든 (중복 허용해서) -> 그의 합이 target이 되는 것을 찾아야 한다.

    즉 dfs를 하되, 그들의 sum이 target이면 정답에 넣고, 더 크다면 그냥 return해야 한다.
    dfs는 어떻게 시킬 것인가? (중복이 허용되어야 한다.)
    
    종료 조건 : 현재의 totalSum이 target보다 크거나 같을 때 (같다면 리스트에 넣어준다.)

    dfs -> candidates에 있는 element마다 dfs를 돌린다.
    원할하게 돌아갈 수 있도록 dfs호출이 끝나면 element를 제거해준다.

    중요한 것은 candidates 또한 업데이트를 해주어야 하다. (answer에 들어갈 리스트가 중복되지 않도록)
    만약 1에서 부터 시작해 dfs를 다 돌리면 1이 포함된 모든 조합은 이미 끝난 것 
    -> 2로 시작할때는 1이 포함되지 않도록 candidates에서 아예 뺴주어야 한다.
    이는 현재 List가 비었으며 prev element가 1이 아닐때 실행시켜 준다 (처음에 일부러 1로 넣어줌)

     */

    public void dfs(List<List<Integer>> results, int target, int currSum, LinkedList<Integer> curr, int start, int [] candidates){

        if(currSum > target){
            return;
        }
        if(currSum == target){
            //현재 list를 추가해준다.
            results.add(curr.stream().collect(Collectors.toList()));
            return;
        }


        for(int i =start; i<candidates.length; i++){
            
            curr.add(candidates[i]);
            dfs(results, target, currSum + candidates[i], curr, start, candidates);
            //dfs가 끝난 후에는 curr에 마지막 요소 제거
            curr.removeLast();
            //dfs가 끝난 후에 start를 업데이트
            start = i+1;
        }


    }
    


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();

        //초기 start는 0
        dfs(results, target, 0, new LinkedList<>(), 0, candidates);

        return results;
    }
}