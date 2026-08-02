/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals==null||intervals.size()==0){
            return 0;
        }
        Collections.sort(intervals, (x,y)->{
            return Integer.compare(x.start,y.start);
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int rooms=1;
        pq.offer(intervals.get(0).end);
        for(int i=1;i<intervals.size();i++){
            //(0,40)
            //(5,10)
            //(15,20)
            if(intervals.get(i).start<pq.peek()){
                rooms++;
            } else {
                pq.poll();
            }
            pq.offer(intervals.get(i).end);
        }
        return rooms;
    }
}
