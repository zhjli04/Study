/*
207. Course Schedule
Medium

1866

90

Favorite

Share
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
*/
class Solution {
     Map<Integer,List<Integer>> adjList = new HashMap<>();
  Set<Integer> visitedPerm = new HashSet<>();
  Set<Integer> visitedTmp = new HashSet<>();
    
     private void buildAdjList(int[][] p) {
      for(int i = 0; i < p.length; i++) {
      if(!adjList.containsKey(p[i][1]))
        adjList.put(p[i][1], new ArrayList<>());
      adjList.get(p[i][1]).add(p[i][0]);
    }
  }
  
  private boolean dfsHelper(int node) {
    if(visitedTmp.contains(node))
      return false;
    if(visitedPerm.contains(node))
      return true;

    visitedTmp.add(node);
    visitedPerm.add(node);
    
    if(adjList.containsKey(node)) {
      for(int v : adjList.get(node)) {
        if(!dfsHelper(v))
          return false;
      }
    }

    visitedTmp.remove(node);
    return true;
  }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0 || prerequisites == null)
        return true;

        buildAdjList(prerequisites);

        Set<Integer> keySet = adjList.keySet();
        for(int u : keySet) {
          if(!dfsHelper(u))
            return false;
        }

        return true;
    }
}
