class Solution {

    /**
    가능한 문자열 조합 문제
    2~9까지 사용할 수 있는 모든 조합을 HashMap에 저장해 놓고
    dfs로 탐색하면서 (문자열 순서가 dfs여야만 함) -> 가능한 문자열 저장

    풀이. visited로 checking하는것이 아니라 번호 길이만큼 다 탐색했으면 add하고 return하는 식의 dfs
    
    */

    public void dfs(List<String> result, Map<Character,List<Character>> hm, String digits, int index, StringBuilder path){
        //끝까지 탐색했으면 결과 저장 후 리턴
        if(path.length() == digits.length()){
            result.add(String.valueOf(path));
            return;
        }

        for(Character c : hm.get(digits.charAt(index))){
            //현재에서 +1, 지금까지 구성된 문자열 path이용 dfs
            dfs(result, hm, digits, index +1, new StringBuilder(path).append(c));
        }


    }
    public List<String> letterCombinations(String digits) {

        Map<Character, List<Character>> hm = new HashMap<>();

        List<String> answer = new ArrayList<>();

        //edge case
        if(digits.length() == 0){
            return answer;
        }

        //Map에 값 넣기 (2-9까지)
        hm.put('2', List.of('a','b','c'));
        hm.put('3', List.of('d','e','f'));
        hm.put('4', List.of('g','h','i'));
        hm.put('5', List.of('j','k','l'));
        hm.put('6', List.of('m','n','o'));
        hm.put('7', List.of('p','q','r','s'));
        hm.put('8', List.of('t','u','v'));
        hm.put('9', List.of('w','x','y','z'));

        //현재 자리 0, 빈 문자열 이용 DFS 시작
        dfs(answer, hm, digits, 0, new StringBuilder());


        return answer;
    }
}