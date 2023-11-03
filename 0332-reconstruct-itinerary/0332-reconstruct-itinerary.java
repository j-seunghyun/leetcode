class Solution {
    /**
    방향이 있는 그래프를 모두 탐색하는 것
    시작은 JFK부터
    같은것이 있다면 -> 사전순으로 정렬

    풀이
    한번에 dfs로 찾아가도록 하자
    Priority Queue를 사용해 인접리스트를 Map으로 활용하면 된다.
    */

    //bfs를 하면 바로 비교가 가능하지만, 대신에 visited가 꼬여버린다.
    public void dfs(List<String> results, Map<String, PriorityQueue<String>> adj , String node){
        
        //Node에 해당하는 PriorityQueue에서 꺼내서 추가해준다.
        //node에 해당하는 adj List가 존재하고, adj List가 안 비어져있을 동안 반복
        while(adj.containsKey(node) && !adj.get(node).isEmpty()){
            dfs(results, adj, adj.get(node).poll());
        }
        results.add(0, node);

    }

    public List<String> findItinerary(List<List<String>> tickets) {

        //인접 리스트는 Map으로 저장
        Map<String, PriorityQueue<String>> adj = new HashMap<>();

        //반복
        for(List<String> ticket : tickets){
            adj.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            //adj의 priorityQueue에 삽입 -> 사전순으로 정렬되어서 저장된다.
            adj.get(ticket.get(0)).add(ticket.get(1));
        }

        List<String> results = new LinkedList<>();
        
        dfs(results, adj, "JFK");
        

        return results;
    }
}