public class Stack {
    /*
    Implement a stack. You can use any data structure inside a stack except stack itself to implement it.
    
    Example
push(1)
pop()
push(2)
top()  // return 2
pop()
isEmpty() // return true
push(3)
isEmpty() // return false

     * @param x: An integer
     * @return: nothing
     */
    int [] values = new int[1000];
    int size = 0;
    public void push(int x) {
        // write your code here
        size += 1;
        values[size-1] = x;
    }

    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        if (size > 0){
            size -= 1;
        }
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if (size > 0){
            return values[size-1];
        }
        return -1;
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return size == 0;
    }
}
