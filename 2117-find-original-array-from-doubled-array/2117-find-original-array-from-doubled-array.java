class Solution {
    /**
    Original Array와 original array의 모든 element를 정확히 2배한 doubled array가 합쳐진
    changed Array에서 -> Original array만 빼서 반환하기
    doubled array가 아니라면 -> 빈 array반환하기
    
    풀이 -> 정렬과 큐를 활용하자
    정렬을 한 뒤에 queue에 origin으로 예상되는 element*2를 넣고
    큐의 element와 현재 값이 일치한다면 빼는 식으로 활용
     */
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2 != 0)
            return new int[]{};
        Arrays.sort(changed);
        Queue<Integer> queue = new LinkedList<>();
        int[] res = new int[changed.length/2];
        int i = 0;
        for(int ele : changed){
            if(!queue.isEmpty() && queue.peek() == ele){
                res[i++] = queue.poll()/2;
            }else{
                queue.add(ele*2);
            }
        }
        return (queue.size() == 0)?res: new int[]{};

    }
}