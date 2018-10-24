/**
 * Given some points and a point origin in two dimensional space, find k points out of the some points which are nearest to origin.
Return these points sorted by distance, if they are same with distance, sorted by x-axis, otherwise sorted by y-axis.

Example
Given points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3
return [[1,1],[2,5],[4,4]]


 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */


public class Solution {
    /*
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, final Point origin, int k) {
        // write your code here
        PriorityQueue<Point> maxHeap = new PriorityQueue<>(k + 1, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                long d = distance(origin, o2) - distance(origin, o1);
              /*  if (d == 0){
                    return o2.x - o1.x;
                }*/
                return (int)d;
            }
        });
        
        for (Point p : points) {
         //   if (maxHeap.size() < k){
               maxHeap.offer(p);
        //    }else{
       //         if (){
                    
         //       }
           // }
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        Point[] ans = new Point[k];
        int i = k-1;
        Point p = null;
        while(( p=maxHeap.poll()) != null){
            ans[i--] = p;
        }
      /*  Iterator<Point> it = maxHeap.iterator();
        while (it.hasNext()) {
            ans[i--] = it.next();
        }*/
        
        int [] dis = new int[k];
        for (int j=0; j<k; j++){
            dis[j] = (int)distance(ans[j], origin);
        }
        
        for (int x=1; x<k; x++){
            if (dis[x] == dis[x-1]){
                for (int j=x; j>0; j--){
                    if (dis[j] == dis[j-1]){
                       if (ans[j].x < ans[j-1].x){
                           swap(ans, j, j-1);
                       }
                    }else{
                        break;
                    }
                }
               
            }
        }
        
        return ans;
    }
    
    public long distance(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }
    
    public void swap(Point[] ans, int i, int j){
        Point p = ans[i];
        ans[i] = ans[j];
        ans[j] = p;
    }
}
