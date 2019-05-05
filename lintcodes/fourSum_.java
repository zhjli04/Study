/*
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<> ();
        for (int i=0; i<nums.length-3; i++) {
             if (i>0 && nums[i] == nums[i-1]) {
                continue;
             }
             int val = nums[i];
             int t = target - val;
             List<List<Integer>> three = threeSum(nums, t, i+1);
             for (List<Integer> list: three) {
                 List<Integer> l = new ArrayList<>();
                 l.add(val);
                 l.addAll(list);
                 res.add(l);
             }
        }
            
        return res;
    }
    
    private List<List<Integer>> threeSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<> ();
        for (int i=start; i<nums.length-2; i++) {
            if (i>start && nums[i] == nums[i-1]) {
                continue;
            }
            
            int val = nums[i];
            int t = target - val;
            int s = i+1;
            int e = nums.length - 1;
            while (s < e) {
                int sum = nums[s] + nums[e];
                if (sum == t) {
                    List<Integer> list = new ArrayList<>();
                    list.add(val);
                    list.add(nums[s]);
                    list.add(nums[e]);
                    res.add(list);
                    while (s < e && nums[s+1] == nums[s]) {
                        s++;
                    }
                    s++;
                    while (e > s && nums[e] == nums[e-1]) {
                        e--;
                    }
                    e--;
                }
                
                if (sum < t) {
                    while (s < e && nums[s+1] == nums[s]) {
                        s++;
                    }
                    s++;
                }
                
                if (sum > t) {
                    while (e > s && nums[e] == nums[e-1]) {
                        e--;
                    }
                    e--;
                }
            }
        }
        return res;
    } 
}
