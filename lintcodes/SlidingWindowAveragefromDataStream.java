public class MovingAverage {
    int size = 0;
    int capacity = 0;
    long sum = 0;
    int[] values = null;
    
    /*
    * @param size: An integer
    */public MovingAverage(int size) {
        // do intialization if necessary
        this.capacity = size;
        this.values = new int[size];
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        // write your code here
        if (size < capacity){
            size += 1;
            values[size-1] = val;
            sum += val;
        }else{
            int ze = values[0];
            move(values);
            values[size-1] = val;
            sum = sum - ze + val;
        }
        return (double)sum / size;
    }
    
    public void move(int[] nums){
        for (int i=0; i<nums.length-1; i++){
            nums[i] = nums[i+1];
        }
    }
}
