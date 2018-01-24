/*
As the title described, you should only use two stacks to implement a queue's actions.

The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.

Both pop and top methods should return the value of first element.
Example
push(1)
pop()     // return 1
push(2)
push(3)
top()     // return 2
pop()     // return 2

*/
public class MyQueue {
    Stack<Integer> one = new Stack<Integer>();
    Stack<Integer> two = new Stack<Integer>();
    
    public MyQueue() {
        // do intialization if necessary
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        // write your code here
        one.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if (two.isEmpty()){
            while(!one.isEmpty()){
                two.push(one.pop());
            }
        }
        return two.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if (two.isEmpty()){
            while(!one.isEmpty()){
                two.push(one.pop());
            }
        }
        return two.peek();
    }
}
