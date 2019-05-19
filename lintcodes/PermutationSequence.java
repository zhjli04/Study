/*
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
*/
class Solution {
    int count = 0;
    int k = 0;
    List<Integer> res;
    public String getPermutation(int n, int k) {
        this.k = k;
        boolean [] used = new boolean[n];
        dfs(n, used, new ArrayList<Integer>());
        StringBuilder sb = new StringBuilder();
        for (int i : res) {
            sb.append(i);
        }
        return sb.toString();
    }
    
    private void dfs(int n,  boolean [] used, List<Integer> list) {
        if (count >= k) {
            return;
        }
        
        if (list.size() == n) {
            count++;
            if (count == k) {
                res = list;
            }
            return;
        }
        
        for (int i=1; i<=n ;i++) {
            if (used[i-1]) {
                continue;
            }
            used[i-1] = true;
            List<Integer> ll = new ArrayList<>();
            ll.addAll(list);
            ll.add(i);
            dfs(n, used, ll);
            used[i-1] = false;
        }
    }
}
