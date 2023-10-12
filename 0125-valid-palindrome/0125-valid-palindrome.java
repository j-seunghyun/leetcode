class Solution {
    public boolean isPalindrome(String s) {
        
        // lowercase로
        String newS = s.toLowerCase();
        int start = 0;
        int end = newS.length()-1;

        while(start < end){
            /**
            4가지 case
            1. start만 non-alpha~일 때 -> start ++
            2. end만 non-alpha~일 때 -> end --
            3. start와 end 둘다 non-alpha~일 때 -> start ++ end --
            4. start와 end 둘다 non-aplha가 아닐 때 -> 비교
            
             */
            // non-alphanumeric -> just move(start) ++
            if(!Character.isLetterOrDigit(newS.charAt(start))){
                start ++;
            }
            // non-alphanumeric -> just move(end) --
            else if(!Character.isLetterOrDigit(newS.charAt(end))){
                end --;
            }
            // 둘다 not non-alphanumeric -> 비교
            else {
                if(newS.charAt(start)!=newS.charAt(end)){
                    return false;
                }
                start++;
                end--;    
            }
        }
        return true;
    }
}