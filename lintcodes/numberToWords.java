/*
273. Integer to English Words
Hard

569

1586

Favorite

Share
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

Example 1:

Input: 123
Output: "One Hundred Twenty Three"
Example 2:

Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Example 4:

Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
*/
class Solution {
    static String[] units = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
	static String[] tens =  {"","Ten ","Twenty ","Thirty ","Forty ","Fifty ","Sixty ","Seventy ","Eighty ","Ninety "," Hundred "};
	static String[] hundreds = {" Thousand "," Million "," Billion "};   
    
    public String numberToWords(int num) {
//           String[] Thousands = {"", " Thousand", " Million", " Billion"};
//         String[] Tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
//         String[] LessThanTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", 
//                                    "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        
//         if (num == 0) return "Zero";
//         int count = 0;
//         String res = "";
//         while (num > 0) {
//             int rem = num % 1000;
//             if (rem != 0) {
//                 String cur = convertHundreds(rem, LessThanTwenty, Tens);
//                 cur += Thousands[count];
//                 res = res.length() > 0 ? cur + " " + res : cur;
//             }
            
//             num /= 1000;
//             count++;
//         }
        
//         return res;
         if(num==0)
			return "Zero";

		return helper(num);
    }
    public String helper(int num){
		if(num==0)
			return "";
		StringBuilder sb = new StringBuilder(); 
		
		if(num >= 1000000000)//Billion
		{
			sb.append(helper(num/1000000000)+hundreds[2]+helper(num%1000000000));
		}
		else if(num >= 1000000)//Million
		{
			sb.append(helper(num/1000000)+hundreds[1]+helper(num%1000000));
		}
		else if(num >= 1000)//Thousand
		{
			sb.append(helper(num/1000)+hundreds[0]+helper(num%1000));
		}
		else if(num >= 100)//Hundred
		{
			sb.append(helper(num/100)+tens[10]+helper(num%100));
		}
		else if(num >= 20)//Tens
		{
			sb.append(tens[num/10]+(num%10>0?helper(num%10):""));
		}
		else if(num < 20){
			sb.append(units[num]);
		}
		return sb.toString().trim();
	}
    
    private String convertHundreds(int num, String[] LessThanTwenty, String[] Tens) {
        String res = "";
        if (num >= 100) {
            res = LessThanTwenty[num / 100] + " " + "Hundred";
            res += num % 100 == 0 ? "" : " ";
            num %= 100;
        }
        
        if (num >= 20) {
            res += Tens[num / 10];
            res += num % 10 == 0 ? "" : " ";
            num %= 10;
        }
        
        if (num > 0) {
            res += LessThanTwenty[num];
        }
        
        return res;
    }
}
