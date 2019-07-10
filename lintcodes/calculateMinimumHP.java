/*
174. Dungeon Game
Hard

718

17

Favorite

Share
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

 

Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)	-3	3
-5	-10	1
10	30	-5 (P)
 
*/
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 1;
        }
        
        int row = dungeon.length;
        int col = dungeon[0].length;
        
        if (row == 1 && col == 1) {
            if (dungeon[0][0] >= 0) {
                return 1;
            }else{
                return 1 - dungeon[0][0];
            }
        }
        
        dungeon[row-1][col-1] = 1 - dungeon[row-1][col-1];
        dungeon[row-1][col-1] = dungeon[row-1][col-1] <= 0 ? 1 : dungeon[row-1][col-1];
        
        for (int i=row-1; i>=0; i--) {
            for (int j=col-1; j>=0; j--) {
                if (i==row-1 && j== col-1) {
                    continue;
                }
                
                if (i == row - 1) {
                    dungeon[i][j] =  dungeon[i][j+1] - dungeon[i][j];
                }else if (j == col-1) {
                    dungeon[i][j] = dungeon[i+1][j] - dungeon[i][j];
                }else{
                    int min = Math.min(dungeon[i][j+1], dungeon[i+1][j]);
                     dungeon[i][j] =  min -  dungeon[i][j];
                }
                dungeon[i][j] =  dungeon[i][j] <= 0 ? 1 :  dungeon[i][j]; 
            }
        }
        return dungeon[0][0];
    }
}
