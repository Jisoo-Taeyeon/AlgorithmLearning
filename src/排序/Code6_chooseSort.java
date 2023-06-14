package 排序;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/4/20 21:25
 */
public class Code6_chooseSort {
    public int[] insertSort(int[] arr) {
        int length = arr.length;
        int preIndex,current;
        for (int i = 1; i < length; i++) {

            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] >= current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;

        }
        return arr;
    }
}
