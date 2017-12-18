public class Solution {
    /*
    
    Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary

Example
Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.


    
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
     private int count(String in, String out){
		 char[] ci = in.toCharArray();
	   //    Arrays.sort(ci);
	       
	       char[] co = out.toCharArray();
	//       Arrays.sort(co);
	       
	       int len = ci.length;
	       int count = 0;
	       for (int i=0; i<len; i++){
	           if (ci[i] != co[i]){
	               count++;
	           }
	       }
	       
	       return count;
	    }
   //  static int times = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        // write your code here
        // if (dict.contains(end)){
        //     return 2;
        // }
        
  /*      List<Stack<String>> ret = new ArrayList<Stack<String>>();
        Stack<String> st = new Stack<String>();
        st.push(start);
        search(ret, end, st, dict);
        
        if (ret.size() < 1){
            return -1;
        }
        
        int count = ret.get(0).size();
        for (int i=1; i<ret.size(); i++){
            if (ret.get(i).size() < count){
                count = ret.get(i).size();
            }
        }
        return count;*/
         LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(beginWord, 1));
 
        wordDict.add(endWord);
 
        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;
 
            if(word.equals(endWord)){
                return top.numSteps;
            }
            
             Iterator it = wordDict.iterator();
   /*         while(it.hasNext()){
            	String v = (String) it.next();
            	if (count(v, word) == 1){
            		 queue.add(new WordNode(v, top.numSteps+1));
            		 it.remove();
            	}
            }*/
 
            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }
 
                    String newWord = new String(arr);
                    if(wordDict.contains(newWord)){
                        queue.add(new WordNode(newWord, top.numSteps+1));
                        wordDict.remove(newWord);
                    }
 
                    arr[i]=temp;
                }
            }
        }
 
        return 0;
    }
    
/*    public void search(List<Stack<String>> ret, String end, Stack<String>st, Set<String> dict){
         if (st.size() >= times){
	        	return;
	        }
	        
        String v = st.peek();
        
        Iterator<String> it = dict.iterator();
        while(it.hasNext()){
            String s = it.next();
            
            
            if (st.contains(s)){
	          	continue;
	        }
	        
            
            if (match(v, s)){
                Stack<String> t = new Stack<String>();
	                t.addAll(st);
	                t.push(s);
	                if (s.equals(end)){
	                    if (t.size() < times ){
	                    	ret.add(t);
	                    	times = t.size();
	                    }
	                	continue;
	                }else if (match(s, end)){
	                	t.push(end);
	                	if (t.size() < times){
	                		ret.add(t);
	                		times = t.size();
	                	}
	                	continue;
	                }
	                search(ret, end, t, dict);
            }
        }
    }
    
    private boolean match(String in, String out){
       char[] ci = in.toCharArray();
       char[] co = out.toCharArray();
      
       int len = ci.length;
       int count = 0;
       for (int i=0; i<len; i++){
           if (ci[i] != co[i]){
               count++;
           }
       }
       
       return count == 1;
    }*/
    
     class WordNode{
	    String word;
	    int numSteps;
	 
	    public WordNode(String word, int numSteps){
	        this.word = word;
	        this.numSteps = numSteps;
	    }
	}
}
