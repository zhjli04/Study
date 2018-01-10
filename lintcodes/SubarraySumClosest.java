public class Solution {
    /*
    
    Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.
    
    Example
Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].
    相比于Subarray Sum问题，这里同样可以记录下位置i的sum，存入一个数组或者链表中，按照sum的值sort，再寻找相邻两个sum差值绝对值最小的那个，也就得到了subarray sum closest to 0。
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
       int [] ret = new int[2];
        if (nums == null || nums.length < 1){
            return ret;
        }
        
        if (nums.length == 1){
            ret[0] = ret[1] = 0;
            return ret;
        }
        
        ret[0] = 0;
        ret[1] = 0;
        
     //   long sum = Math.abs(nums[0] + nums[1]);;
       int len = nums.length;
       Sum [] sums = new Sum[len + 1];
       sums[0] = new Sum(0, 0);
       
       for (int i=1; i<=len; i++){
           sums[i] = new Sum(sums[i-1].sum + nums[i-1], i);
       }
       
       Arrays.sort(sums, (s1, s2) -> s1.sum - s2.sum);
       
       int min = Integer.MAX_VALUE;//sums[1].sum - sums[0].sum;
    //   if (sums[1].index < sums[0].index){
    //           ret[0] = sums[1].index + 1;
    //           ret[1] = sums[0].index;
    //       }else{
    //           ret[0] = sums[0].index + 1;
    //           ret[1] = sums[1].index;
    //       }
           
       for (int i=1; i<=len; i++){
           if (sums[i].sum - sums[i-1].sum < min){
               min = sums[i].sum - sums[i-1].sum;
               if (sums[i].index < sums[i-1].index){
                   ret[0] = sums[i].index ;
                   ret[1] = sums[i-1].index - 1;
               }else{
                   ret[0] = sums[i-1].index ;
                   ret[1] = sums[i].index - 1;
               }
           }
       }
       
        return ret;
        
        
  /*       int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }

        int len = nums.length;
        if(len == 1) {
            res[0] = res[1] = 0;
            return res;
        }
        Pair[] sums = new Pair[len+1];
        int prev = 0;
        sums[0] = new Pair(0, 0);
        for (int i = 1; i <= len; i++) {
            sums[i] = new Pair(sums[i-1].sum + nums[i-1], i);
            prev = sums[i].sum;
        }
        Arrays.sort(sums, new Comparator<Pair>() {
           public int compare(Pair a, Pair b) {
               return a.sum - b.sum;
           }
        });
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {

            if (ans > sums[i].sum - sums[i-1].sum) {
                ans = sums[i].sum - sums[i-1].sum;
                int[] temp = new int[]{sums[i].index - 1, sums[i - 1].index - 1};
                Arrays.sort(temp);
                res[0] = temp[0] + 1;
                res[1] = temp[1];
            }
        }

        return res;*/
    }
    
    class Sum{
        int sum;
        int index;
        
        public Sum(int s, int i){
            sum = s;
            index = i;
        }
    }
    
    class Pair {
    int sum;
    int index;
    public Pair(int s, int i) {
        sum = s;
        index = i;
    }
}
}
