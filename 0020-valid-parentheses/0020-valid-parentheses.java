class Solution {
    /**
    brackets로 이루어진 String이 올바른지 판단하는 문제

    1. 항상 같은 type으로 닫혀야 한다.
    2. 열려야지 닫을 수 있다.
    
    '(', '{', '['

    풀이 1. Stack사용
    s로 만든 char[] 로 s의 끝까지 반복하며
    open bracket을 만나면 Stack에 넣고 close bracket을 만나면 
    Stack에서 빼낸 open bracket이 close bracket과 매칭되는지 확인 후 넘어가는 식
    다르면 false 바로 return

    open bracket과 close bracket이 어떻게 매칭되었는지 확인하는가?
    Ascii code로 +1만큼 차이남을 이용한다. -> 이상하게 { }는 2가 차이가 난다 (이렇게 풀면 안 됨)

    is -else 혹은 case문으로 비교한다.


     */

    public boolean isOpenBracket(char c){
        if(c == '(' || c == '{' || c == '[')
            return true;
        return false;
    }
    
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque();

        //존재하는 만큼 반복
        for(char c : chars){
            if(isOpenBracket(c)){
                stack.offerLast(c);
            }
            // openBracket이 아니라면 Stack에서 뺀 값과 현재 값을 비교해서 case로 비교한다.
            else{
                // edge case - stack에는 아무것도 없는데 close bracket만 계속 나온 경우 -> false
                if(stack.isEmpty())
                    return false; //바로 false리턴
                char open = stack.pollLast();

                switch(open){
                    case '(':
                        if(c != ')'){
                            return false;
                        }
                        break;
                    case '[':
                        if(c!= ']'){
                            return false;
                        }
                        break;
                    case '{':
                        if(c!= '}'){
                            return false;
                        }
                        break;
                    default:
                        break;
                }
            }
        }

        //edge case - for문이 끝났는데 Stack이 다 안비워져있을 경우
        if(stack.size() >= 1){
            return false;
        }

        return true;
    }
}