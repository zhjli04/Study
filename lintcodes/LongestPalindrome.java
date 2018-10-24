
public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(longestPalindrome("axxxxxa"));
	}
	
	private static int start = 0;
	private static int maxLen = 1;
	private static String longestPalindrome(String s){
		if (s == null || s.length() < 2){
			return s;
		}
		int len = s.length();
		for (int i=0; i<len; i++){
			check(s, i, i);
			check(s, i, i+1);
		}
		return s.substring(start, maxLen);
	}
	
	private static void check(String s, int low, int high){
		while((low >= 0) && (high < s.length()) && (s.charAt(low) == s.charAt(high))){
			low--;
			high++;
		}
		
		if (maxLen < high - low - 1){
			start = low + 1;
			maxLen = high - low - 1;
		}
	}

}
