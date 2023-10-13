class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        /**
        1. 로그의 가장 앞부분은 식별자 -> 순서 영향 x
        2. 문자로 구성된 로그가 숫자 로그보다 앞에, 문자 로그는 사전순
        3. 문자가 동일한 경우 -> 식별자순
        4. 숫자 로그는 입력순
         */

        // 숫자와 문자 따로 정렬
         List<String> alphaList = new ArrayList<>();
         List<String> numList = new ArrayList<>();

         for(String log : logs){

            // 숫자 로그가 먼저 나오면 문자 로그일리가 없음
            if(Character.isDigit(log.split(" ")[1].charAt(0))){
                numList.add(log);
            }
            else{
                alphaList.add(log);
            }
         }

         alphaList.sort((s1, s2) -> {
             // limit 2로 식별자와 식별자가 아닌 문자열 2개로 나눈다.
             String[] str1 = s1.split(" ", 2);
             String[] str2 = s2.split(" ",2);

             // 문자가 같다면 -> 식별자로 정렬
             //compareTo 메서드는 같으면 0을 반환
             if(str1[1].compareTo(str2[1]) == 0){

                 return str1[0].compareTo(str2[0]);
             }
             // 안같으면 -> 문자로 정렬 알파벳순
             else{
                 return str1[1].compareTo(str2[1]);
             }
         });

        //숫자는 정렬없이 그냥 붙힘
         alphaList.addAll(numList);
         
         return alphaList.toArray(new String[0]);
    }
}