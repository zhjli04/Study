public class Solution {
    /**
     * Given a list of integers and find the smallest prime number that doesn't appear in this list.
     * 
     * Example
Given a list [2,3,5,7,11,13,17,23,29]
return 19

     * @param nums: an array of integer
     * @return: the first missing prime number
     */
    public int firstMissingPrime(int[] nums) {
        if (nums == null || nums.length == 0){
            return 2;
        }
        
        if (nums[0] != 2){
            return 2;
        }
        
        for (int i=1; i<nums.length; i++){
            int cur = nums[i-1]+1;
            for (int j=cur; j<nums[i]; j++){
                if (isPrime(j)){
                    return j;
                }
            }
        }
        
        int start = nums[nums.length-1]+1;
        while(true){
            if (isPrime(start)){
                return start;
            }
            start++;
        }
    }
    
    public boolean isPrime(int n){
        if (n == 2){
            return true;
        }
        
        if (n % 2 == 0){
            return false;
        }
        
        int upper = (int)Math.sqrt(n);
        for (int i=3; i<=upper; i+=2){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
