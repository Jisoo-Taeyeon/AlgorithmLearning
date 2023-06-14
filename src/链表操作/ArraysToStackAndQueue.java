package 链表操作;

import java.util.Arrays;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2021/11/16 19:40
 * 用数组来实现队列
 */
public class ArraysToStackAndQueue {
    public static class MyQueue {
        private int[] arr;
        private int pushi;
        private int polli;
        private int size;
        private final int limit;

        /**
         * 用来实现数组模拟队列
         * @param l
         */
        public MyQueue(int l){
            arr = new int[l];
            pushi=0;
            polli=0;
            size=0;
            limit=l;
        }
        public  void push(int value){
            if (size == limit) {
                throw new RuntimeException("栈满了，不能再添加了");
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int pop(){
            if(size ==0){
                throw new RuntimeException("栈空了，不能再拿了");
            }
            size--;
            int ans =arr[polli];
            polli = nextIndex(polli);
            return ans;
        }

        public boolean isEmpty() {
            return size==0;

        }

        private int nextIndex(int i) {
            int b=i<limit-1 ? i+1 : 0;
            return b;
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue= new MyQueue(7);
        for (int i = 0; i < 7 ; i++) {
            myQueue.push(i);

        }
        for (int i = 0; i < 3 ; i++) {
            int num =myQueue.pop();
            System.out.println(num);
        }
        System.out.println(Arrays.toString(myQueue.arr));
    }
}
