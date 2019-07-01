/*
134. Gas Station
Medium

772

296

Favorite

Share
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.

Note:

If there exists a solution, it is guaranteed to be unique.
Both input arrays are non-empty and have the same length.
Each element in the input arrays is a non-negative integer.
Example 1:

Input: 
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]

Output: 3

Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
Example 2:

Input: 
gas  = [2,3,4]
cost = [3,4,3]

Output: -1

Explanation:
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
Therefore, you can't travel around the circuit once no matter where you start.
*/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i=0; i<gas.length; i++) {
            if (gas[i] >= cost[i]) {
                if (pass(gas,cost, i)) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public boolean pass(int[] gas, int[] cost, int idx) {
        int next = idx + 1;
        int sum = gas[idx] - cost[idx];
        while (next != idx) {
            if (next == gas.length) {
                next = 0;
            }
            sum += gas[next];
            if (sum < cost[next]) {
                return false;
            }
            if (next == idx - 1 || (idx == 0 && next == gas.length-1)) {
                return true;
            }
            sum -= cost[next];
            next++;
            
        }
        return false;
    }
}
