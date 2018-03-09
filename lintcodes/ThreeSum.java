public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (numbers == null || numbers.length < 3){
            return ret;
        }
        Arrays.sort(numbers);
        int len = numbers.length;
        for(int i=0; i<len - 2; i++){
            if ((i>0) && (numbers[i] == numbers[i-1])){
                continue;
            }
            int val = numbers[i];
            ArrayList<ArrayList<Integer>> tmp = twoSum(numbers, i+1, len-1, -val);
            for (ArrayList<Integer> al : tmp){
                ArrayList<Integer> li = new ArrayList<Integer>();
                li.add(val);
                li.addAll(al);
                ret.add(li);
            }
        }
        return ret;
    }
    
    public ArrayList<ArrayList<Integer>> twoSum(int[] numbers, int start, int end, int target){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        while(start < end){
            if (numbers[start] + numbers[end] == target){
                ArrayList<Integer> li = new ArrayList<Integer>();
                li.add(numbers[start]);
                li.add(numbers[end]);
                ret.add(li);
                
                start++;
                while((start < end) && (numbers[start] == numbers[start-1])){
                    start++;
                }
                
                end--;
                while((start < end) && (numbers[end] == numbers[end+1])){
                    end--;
                }
                
            }else if (numbers[start] + numbers[end] < target){
                start++;
            }else{
                end--;
            }
        }
        return ret;
    }
}
