package 排序;

import java.util.Arrays;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2021/11/19 20:43
 * 归并排序和随机快排
 *时间的复杂度 NlogN
 */
public class Code01_MergeSort {

    public static void merge(int[] arr,int L,int M, int R){
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        //当p1 或者 p2 越界时会跳出循环
        //当p2开始越界时，
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        // 当p1 开始越界，把 p2剩下的内容加入
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L+j]=help[j];
        }
    }

    /**
     * 递归方法实现归并排序
     * @param arr
     * @param L
     * @param R
     */
    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr, L, mid, R);
        System.out.println("过程中排序："+Arrays.toString(arr));
    }

    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N=arr.length;
        //一组是2倍的mergeSize,当前有序的merge长度
        int mergeSize=1;
        while (mergeSize < N) {
            int L=0;
            while (L < N ) {
                // 左组（mergeSize）  L  ... M
                int M = L + mergeSize - 1;
                if (M >= N) {
                    break;

                }
                //L....M  M+1.....R
                int R = Math.min(M + mergeSize, N - 1);

                merge(arr,L,M,R);
                //下一组的左节点
                L=R+1;


            }
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize<<=1;
        }
    }

    public static void main(String[] args) {
        int[] arr= new int[]{1,56,98,4,6,85,4,2,1};
        System.out.println(Arrays.toString(arr));
//        mergeSort2(arr);
        process(arr, 0,arr.length-1);
        System.out.println(Arrays.toString(arr));


    }
}
