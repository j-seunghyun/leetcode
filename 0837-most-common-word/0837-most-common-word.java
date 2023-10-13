class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        /**
        ban 되지 않았지만, paragraph에서 가장 frequent한 word 찾기
        paragraph -> split 필요 (regrex 제거) String array or List
        Map -> String , Integer(count)
        */

        //정규 표현식 사용 -> alphabet이 아닌 기준으로 split
         String [] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

         Set<String> ban = new HashSet<>(Arrays.asList(banned));
         // HashMap 사용
         Map<String, Integer> wordMap = new HashMap<>();

         //각 word count 입력
         for(String word : words){
            //금지 단어가 아니라면
             if(!ban.contains(word)){
                 wordMap.put(word, wordMap.getOrDefault(word, 0)+1);
             }
         }
         
         //가장 빈도 높은 단어 반환
         return Collections.max(wordMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}