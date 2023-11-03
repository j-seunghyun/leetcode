class Solution {
    /**
    모든 가능한 부분집합 구하기

    {1,2} -> {}, {1}, {2}, {1,2} 
     */

    public void dfs(List<List<Integer>> results, int [] nums, LinkedList<Integer> curr, int start){

        //처음 start = 0 (index 0부터)
        for(int i = start; i<nums.length; i++){

            curr.add(nums[i]);
            dfs(results, nums, curr, i+1);
            //result에 추가하고 curr update
            results.add(curr.stream().collect(Collectors.toList()));
            curr.removeLast();
        }


    }



    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();
        dfs(results, nums, new LinkedList<>(), 0);
        //마지막으로 result에 공집합 넣어준다.
        results.add(new ArrayList<>());
        return results;
    }
}