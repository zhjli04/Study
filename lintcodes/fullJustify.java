/*
Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
Example 1:

Input:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:

Input:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be",
             because the last line must be left-justified instead of fully-justified.
             Note that the second line is also left-justified becase it contains only one word.
Example 3:

Input:
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
*/
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> ans = new ArrayList<>();
        List<String> tempList = new ArrayList<>();  //to store the words that can be put in one same line
        int tempLen = 0;     // track the length of current line: wordsLen + spaces between words
        int index = 0;      //index of word in words array
        int wordsLen = 0;   // sum of all words that can be put in same line
        int spaces = 0;     // sapces that need to be filled
        
        while(index < words.length) {
            if((tempLen + words[index].length()) <= maxWidth) {   //check if cur word can be put in cur line
                tempLen += words[index].length() + 1;
                tempList.add(words[index++]);
            }else {
                StringBuilder sb = new StringBuilder();
                wordsLen = tempLen - tempList.size();
                spaces = maxWidth - wordsLen;
                if(tempList.size() == 1) {          // there's only one word at cur line, then just fill the spaces
                    sb.append(tempList.get(0));
                    for(int i = 0; i < spaces; i++) {
                        sb.append(" ");
                    }
                    ans.add(sb.toString());
                }else if(tempList.size() > 1){      // there's many words in cur line, do the evenly spaceing
                    int distance = spaces / (tempList.size() - 1);
                    int reminder = spaces % (tempList.size() - 1);
                    
                    for(int i = 0; i < tempList.size() - 1; i++) {
                        sb.append(tempList.get(i));
                        if(reminder > 0){
                            sb.append(" ");
                            reminder--;
                        }
                        for(int j = 0; j < distance; j++)
                            sb.append(" ");
                    }
                    sb.append(tempList.get(tempList.size() - 1));
                    ans.add(sb.toString());   
                }
                tempList.clear();  
                tempLen = 0;
            }
        }
        
        // dealing with last line
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < tempList.size() - 1; i++) {
            sb.append(tempList.get(i));
            sb.append(" ");
        }
        sb.append(tempList.get(tempList.size() - 1));
        for(int i = 0; i < maxWidth - (tempLen - 1); i++)
                  sb.append(" ");
        ans.add(sb.toString());
        return ans;
    }
}
