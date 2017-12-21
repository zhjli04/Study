public class Solution {
    /*
    
    Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary

Example
Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
[
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
    
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
     List<List<String>> results;
	List<String> list;
	Map<String,List<String>> map;
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    /*    results= new ArrayList<List<String>>();
	        if (dict.size() == 0)
				return results;
	        
	        int curr=1,next=0;	        
	        boolean found=false;	        
	        list = new LinkedList<String>();	       
			map = new HashMap<String,List<String>>();
			
			Queue<String> queue= new ArrayDeque<String>();
			Set<String> unvisited = new HashSet<String>(dict);
			Set<String> visited = new HashSet<String>();
			
			queue.add(start);			
			unvisited.add(end);
			unvisited.remove(start);
			//BFS
			while (!queue.isEmpty()) {
			   
				String word = queue.poll();
				curr--;				
				for (int i = 0; i < word.length(); i++){
				   StringBuilder builder = new StringBuilder(word); 
					for (char ch='a';  ch <= 'z'; ch++){
						builder.setCharAt(i,ch);
						String new_word=builder.toString();	
						if (unvisited.contains(new_word)){
							//Handle queue
							if (visited.add(new_word)){//Key statement,Avoid Duplicate queue insertion
								next++;
								queue.add(new_word);
							}
							
							if (map.containsKey(new_word))//Build Adjacent Graph
								map.get(new_word).add(word);
							else{
								List<String> l= new LinkedList<String>();
								l.add(word);
								map.put(new_word, l);
							}
							
							if (new_word.equals(end)&&!found) found=true;		
														
						}

					}//End:Iteration from 'a' to 'z'
				}//End:Iteration from the first to the last
				if (curr==0){
					if (found) break;
					curr=next;
					next=0;
					unvisited.removeAll(visited);
					visited.clear();
				}
			}//End While

			backTrace(end,start);
			
			return results;        
			*/
        // write your code here
        List<List<String>> ret = new ArrayList<List<String>>();
        
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(null, start, 1));
 
        dict.add(end);
        int step = Integer.MAX_VALUE;
        
        HashSet<String> visited = new HashSet<String>();  
        HashSet<String> unvisited = new HashSet<String>();  
        unvisited.addAll(dict);
        
         int preNumSteps = 0;
 
        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;
            
            int currNumSteps = top.numSteps;
 
            if(word.equals(end)){
            	if (top.numSteps <= step){
            		step = top.numSteps;
            		insert(ret, top);
            	}else{
            		return ret;
            	}
            }
            
            if(preNumSteps < currNumSteps){
                unvisited.removeAll(visited);
            }
 
            preNumSteps = currNumSteps;
        
            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }else{
                        continue;
                    }
 
                    String newWord = new String(arr);
                      if (unvisited.contains(newWord) ){
                        WordNode w = new WordNode(top, newWord, top.numSteps + 1);
                    	queue.add(w);
                        visited.add(newWord);
                    }
 
                    arr[i]=temp;
                }
            }
        }
 
        return ret;
        
    }
    
    private void backTrace(String word,String start){
	    	if (word.equals(start)){
	    		list.add(0,start);
	    		results.add(new ArrayList<String>(list));
	    		list.remove(0);
	    		return;
	    	}
	    	list.add(0,word);
	    	if (map.get(word)!=null)
	    		for (String s:map.get(word))
	    			backTrace(s,start);
	    	list.remove(0);
	    }
    
    private  boolean include( LinkedList<WordNode> queue, WordNode word){
		for (WordNode w: queue){
			if (w.word.equals(word.word)){
				return true;
			}
		}
		return false;
	}
    
    public void insert( List<List<String>> ret, WordNode top){
        List<String> list = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        WordNode word = top;
        while(word != null){
            stack.push(word.word);
            word = word.next;
        }
        
        while(stack.size() > 0){
            list.add(stack.pop());
        }
        ret.add(list);
    }
    
    public class WordNode{
	    String word;
	    WordNode next;
	    int numSteps;
	 
	    public WordNode(WordNode node, String word, int numSteps){
	        this.next  = node;
	        this.word = word;
	        this.numSteps = numSteps;
	    }
	}
}
