/*
Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return new int[0][0];
        }
          
        if (intervals.length == 1) {
            return intervals;
        }
        
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for (int i=0; i<intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        List<List<Integer>> lr = new ArrayList<>();
        int j=0;
        for (int i=0; i<intervals.length; i++) {
            if (i == intervals.length-1 || start[i+1] > end[i]) {
                List<Integer> list = new ArrayList<>();
                list.add(start[j]);
                list.add(end[i]);
                lr.add(list);
                j = i+1;
            }
        }
        
        int[][] res = new int[lr.size()][2];
        for (int i=0; i<lr.size(); i++) {
            List<Integer> list = lr.get(i);
            res[i][0] = list.get(0);
            res[i][1] = list.get(1);
        }
        return res;
        
        
      /*  sort(intervals);
        
        int[][] res = new int[intervals.length][2];
        int count = 1;
        int start = intervals[0][0];
        int end = intervals[0][1];
        int pos = 0;
        
        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] > end) {
                res[pos][0] = start;
                res[pos][1] = end;
                pos++;
                start = intervals[i][0];
                end = intervals[i][1];
                count++;
                continue;
            }
            
            if (intervals[i][1] > end) {
                end = intervals[i][1];
            }
        }
        
        res[pos][0] = start;
        res[pos][1] = end;
        
        int[][] rr = new int[count][2];
        for (int i=0; i<count; i++) {
            rr[i][0] = res[i][0];
            rr[i][1] = res[i][1];
        }
        return rr;
        */
    }
    
    private void sort(int[][] intervals) {
        for (int i=1; i<intervals.length; i++) {
            for (int j=i; j>=1; j--) {
                if (intervals[j][0] < intervals[j-1][0]) {
                    swap(intervals, j, j-1);
                }
            }
        }
    }
    
    private void swap(int[][] intervals, int i, int j) {
        int tmp = intervals[i][0];
        intervals[i][0] = intervals[j][0];
        intervals[j][0] = tmp;
        tmp = intervals[i][1];
        intervals[i][1] = intervals[j][1];
        intervals[j][1] = tmp;
        
    }
}
