public class Solution {
    /**
     * There is a building of n floors. If an egg drops from the k th floor or above, it will break. If it's dropped from any floor below, it will not break.

You're given two eggs, Find k while minimize the number of drops for the worst case. Return the number of drops in the worst case.

Clarification
For n = 10, a naive way to find k is drop egg from 1st floor, 2nd floor ... kth floor. But in this worst case (k = 10), you have to drop 10 times.

Notice that you have two eggs, so you can drop at 4th, 7th & 9th floor, in the worst case (for example, k = 9) you have to drop 4 times.

Example
Given n = 10, return 4.
Given n = 100, return 14.

     * @param n: An integer
     * @return: The sum of a and b
     */
    public int dropEggs(int k) {
        // write your code here
        
        long start = 1;
        long end = k;
        int min = Integer.MAX_VALUE;
        while(start <= end){
            long mid = (start + end) / 2;
            long sum = mid * (mid + 1) /2;
            if (sum >= k){
                if (mid < min){
                    min = (int)mid;
                }
                end = (int)mid - 1;
            }else{
                start = (int)mid + 1;
            }
        }
        
    /*    for (int i=1; i<k; i++){
            if (i * (i + 1) /2 >= k){
                return i;
            }
        }
        return k;*/
        return min;
//return eggDrop2(2, k);

    }
    
    int eggDrop2(int n, int k)
    {
       /* A 2D table where entery eggFloor[i][j] will represent minimum
       number of trials needed for i eggs and j floors. */
        int eggFloor[][] = new int[n+1][k+1];
        int res = 0;
        int i, j, x;
          
        // We need one trial for one floor and0 trials for 0 floors
        for (i = 1; i <= n; i++)
        {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }
          
       // We always need j trials for one egg and j floors.
        for (j = 1; j <= k; j++)
            eggFloor[1][j] = j;
          
        // Fill rest of the entries in table using optimal substructure
        // property
        for (i = 2; i <= n; i++)
        {
            for (j = 2; j <= k; j++)
            {
                eggFloor[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x++)
                {
                     res = 1 + max(eggFloor[i-1][x-1], eggFloor[i][j-x]);
                     if (res < eggFloor[i][j])
                        eggFloor[i][j] = res;
                }
            }
        }
          
        // eggFloor[n][k] holds the result
        return eggFloor[n][k];
 
    }
    
    int eggDrop(int n, int k)  
{  
    // If there are no floors, then no trials needed. OR if there is  
    // one floor, one trial needed.  
    if (k == 1 || k == 0)  
        return k;  
   
    // We need k trials for one egg and k floors  
    if (n == 1)  
        return k;  
   
    int min = Integer.MAX_VALUE;
    int x = 0;
    int res = 0;  
   
    // Consider all droppings from 1st floor to kth floor and  
    // return the minimum of these values plus 1.  
    for (x = 1; x <= k; x++)  
    {  
        res = max(eggDrop(n-1, x-1), eggDrop(n, k-x));  
        if (res < min)  
            min = res;  
    }  
   
     return min + 1;  
   }  
    
    int max(int a, int b) { return (a > b)? a: b; }

}
