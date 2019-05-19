/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int [] start = new int[intervals.length+1];
        int [] end = new int[intervals.length+1];
        
        for (int i=0; i<intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        start[intervals.length] = newInterval[0];
        end[intervals.length] = newInterval[1];
        
        for (int i=intervals.length; i >=1; i--) {
            if (start[i] < start[i-1]) {
                swap(start, i, i-1);
            }
        }
        
        for (int i=intervals.length; i >=1; i--) {
            if (end[i] < end[i-1]) {
                swap(end, i, i-1);
            }
        }
        
        List<List<Integer>> lr = new ArrayList<>();
        int j=0;
        for (int i=0; i<=intervals.length; i++) {
            if (i == intervals.length || start[i+1] > end[i]) {
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
    }
    
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
