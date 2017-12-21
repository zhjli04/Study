public class Solution {
    /*
    
    Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?

Find all unique quadruplets in the array which gives the sum of target.

Example
Given array S = {1 0 -1 0 -2 2}, and target = 0. A solution set is:

(-1, 0, 0, 1)
(-2, -1, 1, 2)
(-2, 0, 0, 2)

     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here
        List<List<Integer>> ret = new ArrayList<List<Integer>> ();
        if (numbers == null || numbers.length == 0){
            ret.add(new ArrayList<Integer> ());
            return ret;
        }
        Arrays.sort(numbers);
        ret = sum(numbers, 0, numbers.length-1, target, 4);
        return ret;
    }
    
    private List<List<Integer>> sum(int[] nums, int start, int end, int target, int n){
        if (n == 2){
            return twoSum(nums, start, end, target);
        }
        
        List<List<Integer>> ret = new ArrayList<List<Integer>> ();
        for (int i=start; i< end - 1; i++){
           List<List<Integer>> tmp = sum (nums, i+1, end, target - nums[i], n - 1);
           if (tmp.size() > 0){
               for (List<Integer> ll : tmp){
                   List<Integer> list = new ArrayList<Integer>();
                   list.add(nums[i]);
                   list.addAll(ll);
                   ret.add(list);
               }
               while((i < end) && (nums[i] == nums[i+1])){
                   i++;
               }
           }
        }
        return ret;
    }
    
    private List<List<Integer>> twoSum(int[] nums, int start, int end, int target){
        List<List<Integer>> ret = new ArrayList<List<Integer>> ();
        while(start < end){
            int sum = nums[start] + nums[end];
            if (sum == target){
                List<Integer> list = new ArrayList<Integer>();
                list.add(nums[start]);
                list.add(nums[end]);
                ret.add(list);
                
                while((start < end) && (nums[start] == nums[start+1]) ){
                  start++;
                }
                start++;
            
                while((start < end) && (nums[end] == nums[end-1])) {
                   end--;
                }
                end--;
            }else if (sum < target){
               while((start < end) && (nums[start] == nums[start+1]) ){
                  start++;
                }
                start++;
            }else{
                while((start < end) && (nums[end] == nums[end-1])) {
                   end--;
                }
                end--;
            }
        }
        return ret;
    }
}
