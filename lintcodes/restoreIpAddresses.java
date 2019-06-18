/*
93. Restore IP Addresses
Medium

678

273

Favorite

Share
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
*/
class Solution {
    public List<String> restoreIpAddresses(String s) {
         List<String> result = new ArrayList<>();
        if(s.length()>12 || s.length()<4) return result;
        findAddress(s, result,new StringBuilder(),0,0);
        return result;
      /*  List<String> results = new ArrayList<>();
	    int n = s.length();

	    for (int firstDot = 1; firstDot <= 3 && firstDot < n; firstDot++) {
		    for (int secondDot = firstDot+1; secondDot <= firstDot+3 && secondDot < n; secondDot++) {
		    	for (int thirdDot = secondDot+1; thirdDot <= secondDot+3 && thirdDot < n; thirdDot++) {
			    	String firstPart = s.substring(0, firstDot);
			    	String secondPart = s.substring(firstDot, secondDot);
			    	String thirdPart = s.substring(secondDot, thirdDot);
			    	String fourthPart = s.substring(thirdDot);

			    	if (isValidPartialIp(firstPart)
				       && isValidPartialIp(secondPart)
				       && isValidPartialIp(thirdPart)
				       && isValidPartialIp(fourthPart)) {

				    	results.add(firstPart + "." + secondPart + "." + thirdPart + "." + fourthPart);
			    	}
	  	    	}
	    	}
    	}

	    return results;*/
    }
    
     private void findAddress(String s, List<String> result, StringBuilder curr,int i, int count){
        if(count>4) return;
        
        if(count==4 && i==s.length()){
            result.add(curr.toString().substring(0,curr.length()-1));
            return;
        }
        
        // use 1 digit
        if(i<s.length()){
            curr.append(s.substring(i,i+1)+".");
            findAddress(s,result,curr,i+1,count+1);
            curr.delete(curr.length()-2,curr.length());
        }
        
        //use 2 digits
        if(i+1<s.length()&& s.charAt(i)!='0'){
            curr.append(s.substring(i,i+2)+".");
            findAddress(s,result,curr,i+2,count+1);
            curr.delete(curr.length()-3,curr.length());
        }
        
        //use 3 digits
        if(i+2<s.length()&& s.charAt(i)!='0' &&Integer.parseInt(s.substring(i,i+3))<=255){
            curr.append(s.substring(i,i+3)+".");
            findAddress(s,result,curr,i+3,count+1);
            curr.delete(curr.length()-4,curr.length());
        }
    }
    
    private static boolean isValidPartialIp(String partialIp) {
	if (partialIp.isEmpty() || partialIp.length() > 3 || (partialIp.length() > 1 && partialIp.charAt(0) == '0')) {
		return false;
	}

	return Integer.parseInt(partialIp) < 256;
}
}
