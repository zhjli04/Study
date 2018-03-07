class Solution {
    /*
    Using O(1) time to check whether an integer n is a power of 2.
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        if (n <= 0){
            return false;
        }
        return (n&(n-1)) == 0;
    }
};
