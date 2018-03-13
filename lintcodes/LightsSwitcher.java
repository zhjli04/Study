public class Solution {
    /**
     * here is a room with n lights which are turned on initially and 4 buttons on the wall. After performing exactly m unknown operations towards buttons, you need to return how many different kinds of status of the n lights could be.

Suppose n lights are labeled as number [1, 2, 3 ..., n], function of these 4 buttons are given below:

You can flip all the lights.
You can flip lights with even numbers.
You can flip lights with odd numbers.
You can flip lights with (3k + 1) numbers, k = 0, 1, 2, ...

Example
Given n = 1, m = 1.
return 2 // Status can be: [on], [off]

Given n = 2, m = 1.
return 3 // Status can be: [on, off], [off, on], [off, off]

- 当m和n其中有任意一个数是0时，返回1

- 当n = 1时

只有两种情况，0和1

- 当n = 2时，

这时候要看m的次数，如果m = 1，那么有三种状态 00，01，10

当m > 1时，那么有四种状态，00，01，10，11

- 当m = 1时，

此时n至少为3，那么我们有四种状态，000，010，101，011

- 当m = 2时，

此时n至少为3，我们有七种状态：111，101，010，100，000，001，110

- 当m > 2时，

此时n至少为3，我们有八种状态：111，101，010，100，000，001，110，011


     * @param n: number of lights
     * @param m: number of operations
     * @return: the number of status
     */
    public int flipLights(int n, int m) {
        // write your code here
      if (n == 0 || m == 0) return 1;
        if (n == 1) return 2;
        if (n == 2) return m == 1 ? 3 : 4;
        if (m == 1) return 4;
        return m == 2 ? 7 : 8;
    }
}
