/*
Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.

In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix

Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.

 

Example 1:

Input: "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.
Example 2:

Input: "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
Example 3:

Input: "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
Example 4:

Input: "/a/./b/../../c/"
Output: "/c"
Example 5:

Input: "/a/../../b/../c//.//"
Output: "/c"
Example 6:

Input: "/a//b////c/d//././/.."
Output: "/a/b/c"
*/
class Solution {
    public String simplifyPath(String path) {
         if (path == null || path.length() <= 1) {
	            return path;
	        }
	        
	        char[] res = new char[path.length()];
	        res[0] = path.charAt(0);
	        
	        int pos = 1;
	        for (int i=1; i<path.length(); i++) {
	            char c = path.charAt(i);
	            if (c == '/') {
	                if (pos ==  0 || res[pos-1] == '/') {
	                    continue;
	                }
	                
	                int cur = pos - 1;
	                while (cur > 0 && res[cur] != '/') {
	                	cur--;
	                }
	                
	                String s = String.valueOf(res, cur+1, pos - cur-1).trim();
	                
	                if (s.equals(".")) {
	                	pos = cur + 1;
	                	continue;
	                }
	                
	                if (s.equals("..")) {
	                	int n = cur - 1;
	                	while (n >0 && res[n] != '/') {
	                		n--;
	                	}
	                	pos = n < 0 ? 1 : n + 1 ;
	                	continue;
	                }
	                
	                res[pos++] = c;               
	                
	            }else {
	                res[pos++] = c;
	            }
	        }
	        
	        for (int i=pos; i<path.length(); i++) {
	             res[i] = ' ';
	         }
	        
	        if (pos > 0) {
	            pos--;
	        }
	        
	        if (pos > 0 && res[pos] == '/') {
	        	for (int i=pos; i<path.length(); i++) {
		             res[i] = ' ';
		         }
	        }else if (res[pos] == '.'){
	        	  
                int cur = pos - 1;
                while (cur > 0 && res[cur] != '/') {
                	cur--;
                }
                
                String s = String.valueOf(res, cur+1, pos - cur);
                
                if (s.equals(".")) {
                    if (cur <= 0) {
                        cur = 1;
                    }
                    for (int i=cur; i<path.length(); i++) {
		              res[i] = ' ';
		            }
                }else if (s.equals("..")) {
                	int n = cur - 1;
                	while (n >0 && res[n] != '/') {
                		n--;
                	}
                	pos = n;
                    if (pos <= 0) {
                        pos = 1;
                    }
                
                    for (int i=pos; i<path.length(); i++) {
		                res[i] = ' ';
		             }
                }
	        }
	        
	        return String.valueOf(res).trim();
    }
}
