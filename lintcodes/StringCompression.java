class Entry{
    char ch;
    int count;
    Entry(char ch, int c){
        this.ch = ch;
        count = c;
    }
}

public class Solution {
    /**
     * Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3.

If the "compressed" string would not become smaller than the original string, your method should return the original string.

You can assume the string has only upper and lower case letters (a-z).

Example
str=aabcccccaaa return a2b1c5a3
str=aabbcc return aabbcc
str=aaaa return a4

     * @param str: a string
     * @return: a compressed string
     */
    public String compress(String str) {
        // write your code here
        if (str == null || str.length() <= 2){
            return str;
        }
        List<Entry> list = new ArrayList<Entry>();
        int count = 1;
        for (int i=1; i<str.length(); i++){
            if (str.charAt(i) != str.charAt(i-1)){
                Entry e = new Entry(str.charAt(i-1), count);
                list.add(e);
                count = 1;
            }else{
                count++;
            }
        }
        
        Entry ee = new Entry(str.charAt(str.length()-1), count);
        list.add(ee);
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<list.size(); i++){
           Entry e = list.get(i);
            sb.append(e.ch);
            sb.append(String.valueOf(e.count));
        }
        
        if (sb.length() >= str.length()){
            return str;
        }
        return sb.toString();
}
