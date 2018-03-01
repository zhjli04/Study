public class Solution {
    /*
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
         List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0){
	            return ret;
	        }
	        
	        Arrays.sort(num);
	   /*     if (target < num[0]){
	            return ret;
	        }
	        
	        if (target == num[0]){
	            List<Integer> ls = new ArrayList<Integer>();
	            ls.add(num[0]);
	            ret.add(ls);
	            return ret;
	        }
	        
	        int end = num.length - 1;
	        while((end >= 0) && (num[end] > target)){
	        	end--;
	        }
	        sum(ret, new ArrayList<Integer>(), num, 0, end, target);
	        return ret;*/
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> path = new ArrayList<Integer>();
            dfs_com(num, 0, target, path, res);
            return res;
    }
    
   public void dfs_com(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return ;
         }
         if (target < 0) return;
         for (int i = cur; i < cand.length; i++){
            if (i > cur && cand[i] == cand[i-1]) continue;
            List<Integer> ls = new ArrayList<Integer>();
           //  path.add(cand[i]);
           ls.addAll(path);
           ls.add(cand[i]);
             dfs_com(cand, i+1, target - cand[i], ls, res);
           //   path.remove(path.size()-1);
         }
     }
    
     public  void sum(List<List<Integer>> ret, List<Integer> list, int[] num, int start, int end, int target){
	        if ( (start >= end) || (num[start] > (target - num[start]))){
	            return;
	        }
	        
	        if (num[start] == target){
	            list.add(num[start]);
	            ret.add(list);
	            return;
	        }
	        
	        
	        for (int i=start; i<=end; i++){
	            if ((i>start) && (num[i] == num[i-1])){
	                continue;
	            }
	            
	            for (int j=1; j<=end-i; j++){
	            	List<List<Integer>> tmp = sumx(num, i+1, end, target-num[i], j);
	            	 if ((tmp != null) && (!tmp.isEmpty())){
	 	                for (List<Integer> ll : tmp){
	 	                	List<Integer> ls = new ArrayList<Integer>();
	 	                	ls.add(num[i]);
	 	                    ls.addAll(ll);
	 	                    ret.add(ls);
	 	                }
	 	            }
	            }
	            
	        }
	        
	    }
	    
       private  List<List<Integer>> sumx(int[] nums, int start, int end, int target, int n){
	    	List<List<Integer>> ret = new ArrayList<List<Integer>> ();
	    	if (n == 1){
	    		for (int j=start; j<=end; j++){
	    			if (nums[j] == target){
	    				 List<Integer> list = new ArrayList<Integer>();
	    				 list.add(nums[j]);
	    				 ret.add(list);
	    				 return ret;
	    			}
	    		}
	    	}
	    	
	        if (n == 2){
	            return twoSum(nums, start, end, target);
	        }
	        
	        
	        for (int i=start; i< end - 1; i++){
	           List<List<Integer>> tmp = sumx (nums, i+1, end, target - nums[i], n - 1);
	           if (tmp.size() > 0){
	               for (List<Integer> ll : tmp){
	                   List<Integer> list = new ArrayList<Integer>();
	                   list.add(nums[i]);
	                   list.addAll(ll);
	                   ret.add(list);
	               }
	               while((i < end) && (nums[i] == nums[i+1])){
	                   i++;
	               }
	           }
	        }
	        return ret;
	    }
	    
	    private  List<List<Integer>> twoSum(int[] nums, int start, int end, int target){
	        List<List<Integer>> ret = new ArrayList<List<Integer>> ();
	        while(start < end){
	            int sum = nums[start] + nums[end];
	            if (sum == target){
	                List<Integer> list = new ArrayList<Integer>();
	                list.add(nums[start]);
	                list.add(nums[end]);
	                ret.add(list);
	                
	                while((start < end) && (nums[start] == nums[start+1]) ){
	                  start++;
	                }
	                start++;
	            
	                while((start < end) && (nums[end] == nums[end-1])) {
	                   end--;
	                }
	                end--;
	            }else if (sum < target){
	               while((start < end) && (nums[start] == nums[start+1]) ){
	                  start++;
	                }
	                start++;
	            }else{
	                while((start < end) && (nums[end] == nums[end-1])) {
	                   end--;
	                }
	                end--;
	            }
	        }
	        return ret;
	    }
}
