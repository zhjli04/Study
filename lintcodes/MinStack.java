/*
Implement a stack with min() function, which will return the smallest number in the stack.

It should support push, pop and min operation all in O(1) cost.

Example
push(1)
pop()   // return 1
push(2)
push(3)
min()   // return 2
push(1)
min()   // return 1

*/
public class MinStack {
    Stack<Integer> one = new Stack<Integer>();
    Stack<Integer> two = new Stack<Integer>();
    
    public MinStack() {
        // do intialization if necessary
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        one.push(number);
        
        if (two.isEmpty()){
            two.push(number);
            return;
        }
        
        int min = two.peek();
        
        if (number < min){
            two.push(number);
        }else{
            two.push(min);
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        two.pop();
        return one.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return two.peek();
    }
}
