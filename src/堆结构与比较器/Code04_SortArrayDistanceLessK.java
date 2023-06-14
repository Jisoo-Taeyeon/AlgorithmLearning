package 堆结构与比较器;

import java.util.PriorityQueue;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2021/12/15 21:33
 */
public class Code04_SortArrayDistanceLessK {
    public void sortArrayDistanceLessK(int[] arr, int k) {
        //默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index=0;
        //0....k
        for (; index <= Math.min(arr.length - 1, k); index++) {
            heap.add(arr[index]);

        }
        int i=0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()) {
            arr[i++]=heap.poll();
        }
    }

    public static void main(String[] args) {

    }
}
