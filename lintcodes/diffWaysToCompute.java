/*
241. Different Ways to Add Parentheses
Medium

965

50

Favorite

Share
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

Example 1:

Input: "2-1-1"
Output: [0, 2]
Explanation: 
((2-1)-1) = 0 
(2-(1-1)) = 2
Example 2:

Input: "2*3-4*5"
Output: [-34, -14, -10, -10, 10]
Explanation: 
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
*/
class Solution {
    Map<String, List<Integer>> visitedMap = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0) {
            return new ArrayList<>();
        }
        
    if(visitedMap.containsKey(input)) return visitedMap.get(input);
	List<Integer> list = new ArrayList<>();
	if(!input.contains("+") && !input.contains("-") && !input.contains("*"))
		list.add(Integer.valueOf(input));
	else 
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if(!Character.isDigit(c)) {
				List<Integer> left = diffWaysToCompute(input.substring(0, i));
				List<Integer> right = diffWaysToCompute(input.substring(i+1));
				for(int x : left)
					for(int y : right) 
						if(c == '+') list.add(x+y);
						else if(c == '-') list.add(x-y);
						else if(c == '*') list.add(x*y);                        
			}
		}
	visitedMap.put(input, list);
	return list;
        
  /*      List<Character> sig = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        int opt = 0;
        for (int i=0; i<input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                opt = opt * 10 + (ch - '0');
            }else{
                sig.add(ch);
                nums.add(opt);
                opt = 0;
            }
        }
        nums.add(opt);
        if (sig.size() == 0) {
            return nums;
        }
        
        return  compute(sig, 0, nums, 0);
        */
    }
    
    private List<Integer> compute(List<Character> sig, int st, List<Integer> nums, int nt) {
         List<Integer> ret = new ArrayList<>();
        if (nt >= nums.size()) {
            return ret;
        }
        if (nt == nums.size()-1) {
            ret.add(nums.get(nums.size()-1));
            return ret;
        }
        
         if (st == sig.size()-1) {
             char ch = sig.get(st);
             int m = nums.get(nt);
             int n = nums.get(nt + 1);
             if (ch == '*') {
                 ret.add(m * n);
             }else if (ch == '+'){
                     ret.add(m+n);
             }else if (ch == '-') {
                     ret.add(m-n);
             }
             return ret;
         }
        
        int m = nums.get(nt);
        int n = nums.get(nt + 1);
        char ch = sig.get(st);
        int val = 0;
        if (ch == '*') {
            val = m * n;
        }else if (ch == '+') {
                val = m + n;
        }else if (ch == '-') {
                val = m - n;
        }
        
        char c = sig.get(st+1);
        
        List<Integer> one = compute(sig, st+1, nums, nt+1);     
        for (int i : one) {
             int sum = 0;
             if (ch == '*') {
                sum = m * i;
             }else if (ch == '+') {
                    sum = m + i;
            }else if (ch == '-') {
                    sum = m - i;
            }
            ret.add(sum);
        }
        
        List<Integer> two = compute(sig, st + 2, nums, nt +2);
        for (int i : two) {
             int sum = 0;
             if (c == '*') {
                sum = val * i;
             }else if (c == '+') {
                    sum = val + i;
            }else if (c == '-') {
                    sum = val- i;
            }
            ret.add(sum);
        }
        return ret;
    }
}
