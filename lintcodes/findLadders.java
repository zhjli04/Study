/*
126. Word Ladder II
Hard

973

184

Favorite

Share
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*/
class Solution {
    Map<String, List<String>> allDict = new HashMap<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return res;
        }
        
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        for (String word : wordList) {
            for (int i=0; i < word.length(); i++) {
                String w = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> transformWords = allDict.getOrDefault(w, new ArrayList<>());
                transformWords.add(word);
                allDict.put(w, transformWords);
            }
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(beginWord, null, 1));
        
        findLadders(res, queue, endWord, visited);
        return res;
    }
    
     public void findLadders(List<List<String>> res, Queue<Node> queue, String endWord, Set<String> visited) {
         if (queue.size() == 0) {
             return;
         }
         
         Queue<Node> next = new LinkedList<>();
         boolean find = false;
         while (queue.size() > 0) {
             Node node = queue.poll();
             String word = node.word;
             int step = node.step;
             if (word.equals(endWord)) {
                 insert(res, node);
                 find = true;
             }else{
                 for (int i=0; i<word.length(); i++) {
                      String w = word.substring(0, i) + "*" + word.substring(i + 1);
                      List<String> transformWords = allDict.getOrDefault(w, new ArrayList<>());
                      for (String adjWord : transformWords) {
                          if (!visited.contains(adjWord)) {
                             next.offer(new Node(adjWord, node, step+1));
                         }
                      }
                 }
             }
             visited.add(word);
         }
         
         if (!find) {
             findLadders(res, next, endWord, visited);
         }
     }
    
    public void insert(List<List<String>> res, Node node) {
        List<String> list = new ArrayList<>();
        while (node != null) {
            list.add(0, node.word);
            node = node.pre;
        }
        res.add(list);
    }
    
    static class Node{
        String word;
        Node pre;
        int step;
        public Node(String word, Node pre, int step){
            this.word = word;
            this.pre = pre;
            this.step = step;
        }
    }
}
