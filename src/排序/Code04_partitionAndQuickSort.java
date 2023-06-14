package 排序;

import java.util.Arrays;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2021/12/13 19:02
 * 随机快排
 */
public class Code04_partitionAndQuickSort {
    //[i]==num i++
    //[i]<num [i]与小于区右一个交换，小于区右扩一个，i++
    //[i]>num [i]与大于区左一个交换，大于区右扩， i不变
    //荷兰国旗问题
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }
        //小于区de右边界
        int less = L - 1;
        //大于区de左边界

        int more = R;
        int index =L;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;

            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else {
                swap(arr,index,--more);
            }

        }
        //将等于num的值与第一个大于区的值交换
        swap(arr, more,R);
        return new int[]{less + 1, more};
    }
    //快速排序1.0
    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process1(arr,0,arr.length-1);
    }

    public static void process1(int[] arr,int L, int R) {
        if (L >= R) {
            return;
        }
        int M = partition(arr, L, R);
        process1(arr, L, M - 1);
        process1(arr, M + 1, R);
    }

    /**
     * 快速排序2.0
     * @param arr
     */
    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);

    }

    public static void process2(int[] arr, int L, int R) {
        if (L>=R) {
            return;
        }
        int[] equalArea = netherlandsFlag(arr, L, R);
        process2(arr,L,equalArea[0]-1);
        process2(arr,equalArea[1]+1,R);
    }



    /**
     * 快速排序3.0
     * 时间复杂度 nlogn
     * @param arr
     */

    public static void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process3(arr, 0, arr.length - 1);

    }
    public static void process3(int[] arr, int L, int R) {
        if (L>=R) {
            return;
        }
        //随机选择一个位置
        swap(arr,L+(int)(Math.random()*(R-L+1)),R);
        int[] equalArea = netherlandsFlag(arr, L, R);
        process3(arr,L,equalArea[0]-1);
        process3(arr,equalArea[1]+1,R);
    }
    public static void swap(int[] arr, int r, int l) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lessEqual = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);

            }
            index++;

        }
        swap(arr, ++lessEqual, R);
        return lessEqual;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 2, 0, 58, 645,2};
        quickSort3(arr);

        System.out.println(Arrays.toString(arr));
        for (int i : netherlandsFlag(arr, 0, arr.length - 1)) {
            System.out.println(i);
        }
    }

}
