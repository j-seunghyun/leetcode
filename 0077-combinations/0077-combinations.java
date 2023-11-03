class Solution {
    /**
    조합 구하기
    1~n까지의 수 중 k개의 조합을 구해야 하는 문제

    풀이1. brute force
    모든 depth에서 1~n까지 다 탐색 -> o(n^k)

    풀이2. 
    + Set자료구조 혹은 List의 contains 메서드 사용
    -> Set은 나중에 정답 반환할때 바꿔주어야 하기 때문에 list의 contains메서드를 사용한다.
     */

    public void dfs(List<List<Integer>> results , int k, LinkedList<Integer> elements, int start ,int n){

        //종료 조건은 k가 0이 될 때 (즉 k번 다 수행)
        if(k == 0){
            //curr을 List로 변환하고 존재하지 않는다면 추가한다.
            List<Integer> tmp = elements.stream().collect(Collectors.toList());
            results.add(tmp);
            return;
        }
        //1~n까지 나올 수 있다. -> 하지만 start를 업데이트 해서 start부터 n까지의 원소만 나오게 하자
        //중복 없게 만들수 있다.
        for(int i =start; i<=n; i++){

            elements.add(i);
            //count를 높혀주고 dfs 재귀 호출
            dfs(results, k-1, elements ,i+1, n);
            //재귀 호출이 끝난 후에는 맨 뒤 element를 제거해주면서 끝까지 탐색할 수 있게 해준다.
            elements.removeLast();
            
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();

        //초기 시작은 1과 빈 LinkedList를 넘겨줘서 시작한다.
        dfs(results, k, new LinkedList<>(), 1, n);
        return results;
    }
}