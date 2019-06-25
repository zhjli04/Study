/*
127. Word Ladder
Medium

1474

814

Favorite

Share
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*/
import javafx.util.Pair;
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        Map<String, List<String>> allDict = new HashMap<>();
        
        for (String word: wordList) {
            for (int i=0; i<len; i++) {
                String w = word.substring(0, i) + "*" + word.substring(i+1);
                List<String> transformWord = allDict.getOrDefault(w, new ArrayList<>());
                transformWord.add(word);
                allDict.put(w, transformWord);
            }
        }
        
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        while (queue.size() > 0) {
            Pair<String, Integer> p = queue.poll();
            String word = p.getKey();
            int step = p.getValue();
            for (int i=0; i<len; i++) {
                String w = word.substring(0, i) + "*" + word.substring(i+1);
                List<String> transformWord = allDict.getOrDefault(w, new ArrayList<>());
                for (String adjWord : transformWord) {
                    if (adjWord.equals(endWord)) {
                        return step + 1;
                    }
                    
                    if (!visited.contains(adjWord)) {
                        visited.add(adjWord);
                        queue.offer(new Pair(adjWord, step+1));
                    }
                }
            }
        }
        
        return 0;
    }
}
