/*
96. Unique Binary Search Trees
Medium

1727

69

Favorite

Share
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/
class Solution {
    public int numTrees(int n) {
        if (n <= 1) return 1;       // Special case, when n = 0 or 1, only one possible combination
        int[] numUnique = new int[n+1];
        numUnique[0] = 1; 
        numUnique[1] = 1;
        for (int i=2; i<=n; i++) {
            int combine = 0;
            for (int j=1; j<=i; j++) {
                // Left * Right
                combine += numUnique[j-1] * numUnique[i-j];
            }
            numUnique[i] = combine;
        }
        return numUnique[n];     
    }
    
}
