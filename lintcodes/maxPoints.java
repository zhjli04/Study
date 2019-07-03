/*
149. Max Points on a Line
Hard

488

1339

Favorite

Share
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example 1:

Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o  
+------------->
0  1  2  3  4
Example 2:

Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
*/
class Solution {
    public int maxPoints(int[][] points) {
         if (points.length == 0) {
            return 0;
        }
        
        Map<String, Set<int[]>> map = new HashMap<>();;
        
        for (int i = 0; i < points.length; i++) { // For each point i
            for (int j = i + 1; j < points.length; j++) { // For each point j
                
                int yDiff = points[j][1] - points[i][1];
                int xDiff = points[j][0] - points[i][0];
                
                if (xDiff == 0) { // Point j and i are parallel
                    String key = "x-" + points[i][0];
                    if (!map.containsKey(key)) {
                        map.put(key, new HashSet<>());
                    }
                    map.get(key).add(points[i]);
                    map.get(key).add(points[j]);
                } else {
                    String key = getKey(points[i], points[j]);
                    if (!map.containsKey(key)) {
                        map.put(key, new HashSet<>());
                    }
                    map.get(key).add(points[i]);
                    map.get(key).add(points[j]);
                }
            }
        }
        
        int max = points.length > 0 ? 1 : 0;
        for(Set<int[]> values : map.values()) {
            max = Math.max(max,values.size());
        }
        return max;
    }
    
    private String getKey(int[] p1, int[] p2) {
        int aNum = p1[1]-p2[1];
        int aDen = p1[0]-p2[0];
        int gcdA = getGCD(aNum,aDen);
        aNum /= gcdA;
        aDen /= gcdA;
        int bNum = (aDen*p1[1]) - (aNum*p1[0]);
        int bDen = aDen;
        int gcdB = getGCD(bNum,bDen);
        bNum /= gcdB;
        bDen /= gcdB;
        return String.format("%d/%d-%d/%d",aNum,aDen,bNum,bDen);
    }
    
     private int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }
}
