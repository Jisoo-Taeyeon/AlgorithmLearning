package 堆结构与比较器;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2021/12/17 13:44
 */
public class Code05_Heap02 {

    public static class MyHeap<T> {
        private ArrayList<T> heap;
        private HashMap<T, Integer> indexMap;
        private int heapSize;
        private Comparator<? super T> comparator;
        public MyHeap(Comparator<? super T> com){
            heap = new ArrayList<>();
            indexMap = new HashMap<>();
            heapSize=0;
            comparator=com;
        }
    }


}
