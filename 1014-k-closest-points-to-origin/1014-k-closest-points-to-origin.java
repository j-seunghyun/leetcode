class Solution {
    /**
    k closet point를 반환하는 문제 (원점으로부터 거리가)
    -> 유클리디안 거리 계산

    풀이 . Priority Queue 사용
    대신 겹치는게 있을 때까지 return 배열에 넣어주어야 한다.
    => Comparator로는 point의 유클리디안 거리를 계산해서 넣어준다.
     */

    static class Point {
        double distance;
        int [] point;

        public Point(double distance, int... point){
            this.distance = distance;
            this.point = point;
        }

        public double getDistance(){
            return this.distance;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        
        //Point의 distance로 오름차순
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>(){

            @Override
            public int compare(Point p1, Point p2){
                //유클리디안 거리 계산
                //유클리디안 거리가 작은 순으로 넣는다.
                if(p1.getDistance() > p2.getDistance()){
                    return 1;
                }
                else if(p1.getDistance() == p2.getDistance()){
                    return 0;
                }else{
                    return -1;
                }
            }
        });

        //Priority Queue에 삽입
        for(int [] point : points){
            double distance = Math.sqrt((long) point[0] *point[0] + (long)point[1]*point[1]);
            pq.offer(new Point(distance, point));

        }

        //PriorityQueue에서 꺼내서 확인해보면서 k개의 element를 넣어서 return
        int [][]answer = new int[k][];

        for(int i =0; i<k; i++){
            answer[i] = pq.poll().point;
        }
        return answer;
    }
}