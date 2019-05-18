/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>  res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            String key = sort(str);
            if (map.containsKey(key)) {
                List<String> val = map.get(key);
                val.add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            res.add((List<String>)entry.getValue());
        }
        // Iterator it = map.keySet().iterator();
        // while (it.hasNext()) {
        //     String key = (String)it.next();
        //     res.add(map.get(key));
        // }
        
        return res;
    }
    
    private String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
