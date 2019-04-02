/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        if (nums.length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            res.add(list);
            return res;
        }
        
        List<Integer> pos = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            pos.add(i);
        }
        
        // if (pos.size() == 2) {
        //     return twoNum(nums, pos.get(0), pos.get(1));
        // }
        
        permu(res, nums, pos);
        return res;
    }
    
    private void permu (List<List<Integer>> res, int[] nums, List<Integer> pos) {
        if (pos.size() == 2) {
            twoNum(res, nums, pos.get(0), pos.get(1));
            return;
        }
        
        for (int i=0; i<pos.size(); i++){
            List<Integer> list = new ArrayList<>();
            list.addAll(pos);
            list.remove(pos.get(i));
            
            List<List<Integer>> next = new ArrayList<>();
            permu(next, nums, list);
            for (int j=0; j<next.size(); j++){
                List<Integer> cur = new ArrayList<>();
                cur.add(nums[pos.get(i)]);
                List<Integer> ls = next.get(j);
                cur.addAll(ls);
                res.add(cur);
            }
        }
    }
    
    private void twoNum(List<List<Integer>> res, int[] nums, int start, int end){
        List<Integer> list1 = new ArrayList<>();
        list1.add(nums[start]);
        list1.add(nums[end]);
        res.add(list1);
        
        List<Integer> list2 = new ArrayList<>();
        list2.add(nums[end]);
        list2.add(nums[start]);
        res.add(list2);
    }
}
