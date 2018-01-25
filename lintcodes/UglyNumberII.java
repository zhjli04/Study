public class Solution {
    /*
    Ugly number is a number that only have factors 2, 3 and 5.

Design an algorithm to find the nth ugly number. The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...

Example
If n=9, return 10.

     * @param n: An integer
     * @return: the nth prime number as description.
     */
     
     List<Integer> list = new ArrayList<Integer>();
     
    public int nthUglyNumber(int n) {
        // write your code here
 /*       int count = 1;
        int i = 1;
        
        while(n > count){
            i++;
            if (isUgly(i)){
                count++;
                list.add(i);
            }
        }
        return i;*/
        
      /*  int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];*/
        
        if(n<=0) return 0;
		int a=0,b=0,c=0;
		List<Integer> table = new ArrayList<Integer>();
		table.add(1);
		while(table.size()<n)
		{
			int next_val = Math.min(table.get(a)*2,Math.min(table.get(b)*3,table.get(c)*5));
			table.add(next_val);
			if(table.get(a)*2==next_val) a++;
			if(table.get(b)*3==next_val) b++;
			if(table.get(c)*5==next_val) c++;
		}
		return table.get(table.size()-1);
    }
    
    public boolean isUgly(int num){
        for (int i=list.size()-1; i>=0; i--){
            Integer n = list.get(i);
            if (num == n*2 || num == n*3 || num == n*5){
                return true;
            }
        }
        
        num = divide(num, 2);
        if (num == 1){
            return true;
        }
        num = divide(num, 3);
        if (num == 1){
            return true;
        }
        num = divide(num, 5);
        
        return num == 1;
    }
    
    public int divide(int a, int b){
        while(a % b == 0){
            a /= b;
        }
        return a;
    }
}
