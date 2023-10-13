class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        /**
        아나그램 그룹
        -> word의 각 문자로 생성 가능한 문자
        word 문자열을 -> char [] 배열로 변환후 정렬한 것을 key로 해서
        Map 자료구조에 삽입 Map <String, List<String>>
         */

         Map<String, List<String>> resultMap = new HashMap<>();

         for(String str : strs){

            char [] charArr = str.toCharArray();
            Arrays.sort(charArr);
            
            String key = String.valueOf(charArr);
            
            //key를 이미 가지고 있다면 아나그램 -> 추가해주면 된다.
            if(resultMap.containsKey(key)){
                List<String> originList = resultMap.get(key);
                originList.add(str);
                resultMap.put(key, originList);
            }
            // key x
            else{
                List<String> newList = new ArrayList<>();
                newList.add(str);
                resultMap.put(key, newList);
            }
         }

         // List<List<String>>을 반환해야 한다.
         List<List<String>> resultList = new ArrayList<>();

         for(String key : resultMap.keySet()){
             resultList.add(resultMap.get(key));
         }
         return resultList;

    }
}