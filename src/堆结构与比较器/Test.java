package 堆结构与比较器;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2021/12/15 21:21
 * 系统实现的堆
 */
public class Test {
    //返回负数 o1>02  返回正数： o1<o2  返回零：o1 = o2

    public static class MyComp implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }
    public static void main(String[] args) {
        //Integer 创建的堆默认是小根堆
        //new MyComp 按照我的方式排序
        PriorityQueue<Integer> heap = new PriorityQueue<>(new MyComp());
        heap.add(5);
        heap.add(10);
        heap.add(59);
        heap.add(9);
        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }


        String str = "20220812";
        System.out.println(str.substring(0, 6));

    }
}
