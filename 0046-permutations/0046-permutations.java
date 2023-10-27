class Solution {

    /**
    말 그대로 순열을 모두 return하는 문제
    dfs를 하되, adjacent list를
    모두가 자신을 제외한 모든 노드를 가지고 있으므로 적어놓고
    dfs를 하면서 
     */

    //dfs
    public void dfs(List<List<Integer>> answer, List<Integer> prevElements, List<Integer> elements){

        //리프노드에 도달하면 결과 추가
        if(elements.isEmpty()){
            answer.add(prevElements.stream().collect(Collectors.toList()));
        }

        //전달 받은 element모두 탐색
        for(Integer e : elements){
            //
            List<Integer> nextElements = new ArrayList<>(elements);
            nextElements.remove(e);

            prevElements.add(e);
            dfs(answer, prevElements, nextElements);
            prevElements.remove(e);
        }

    }
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

    
        dfs(result, new ArrayList<>(), list);

        return result;
    }
}