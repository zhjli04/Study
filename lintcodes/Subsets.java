public class Solution {
    
    /*
    Given a set of distinct integers, return all possible subsets.

 Notice
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.

Example
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> ls = new ArrayList<Integer>();
        ret.add(ls);
        if (nums == null || nums.length == 0){
            return ret;
        }
        Arrays.sort(nums);
        subsets(ret, nums, 0, nums.length-1);
        return ret;
    }
    
    public void subsets(List<List<Integer>> ret, int[] nums, int start, int end){
        if (start > end){
            return;
        }
        
        if (start == end){
            List<Integer> ls = new ArrayList<Integer>();
            ls.add(nums[start]);
            ret.add(ls);
            return;
        }
        
        for (int i=start; i<=end; i++){
            List<Integer> ls = new ArrayList<Integer>();
            ls.add(nums[i]);
            ret.add(ls);
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            subsets(tmp, nums, i+1, end);
            for (List<Integer> list : tmp){
                List<Integer> l = new ArrayList<Integer>();
                l.add(nums[i]);
                l.addAll(list);
                ret.add(l);
            }
        }
    }
}
