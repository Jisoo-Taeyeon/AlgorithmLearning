package 排序;

import jdk.jfr.StackTrace;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2021/12/23 14:38
 *
 * 基数排序 和技术 排序
 * 时间复杂度  暂定为n     其实为   nlog10 max
 */
public class Code05_RadixSort {
    /**
     *  只适用于非负值
     */
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr,0,arr.length-1,maxbits(arr));
    }

    public static int maxbits(int[] arr) {
        int max =Integer.MIN_VALUE;
        for (int i =0;i<arr.length;i++){
            max = Math.max(max, arr[i]);

        }
        int res =0;
        while (max != 0) {
            res++;
            max/=10;

        }
        return res;

    }

    /**
     * arr[l..r]排序，dight
     * 1..r     3 56 17 100   最大值有3位
     * @param arr
     * @param L
     * @param R
     * @param digit
     */
    public static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        int[] help = new int[R - L + 1];
        //有多少位就进出多少次
        for (int d = 1; d <= digit; d++) {
            /**
             * 10  个空间
             * count[0] 当前位（d位）是0的数字有多少个
             * count[1] 当前位（d位）是0，1的数字有多少个
             * count[2] 当前位（d位）是0，1，2的数字有多少个
             * count[i] 当前位（d位）是0~i的数字有多少个
             */
            int[] count = new int[radix];
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                count[j]++;

            }
            //加工count
            //count[1]   digit位<= 1 的数有 count[1]  个
            //count[2]   digit位<= 2 的数有 count[2]  个
            //count[i]   digit位<= 1 的数有 count[i]  个
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];

            }
            //从右向左循环，这样才能做到原先数组从左向右加入桶中，最先加入的先出桶
            //判断当前数因该在help数组中哪个位置
            //原数组中第digit位小于当前数第digit位的树有count[getDigit] 个
            //所以存放的位置应该是count[getDigit]-1，因为数组0位置也储存数，所以要减一
            for (i = R; i >= L; i--) {
                //个位数字小于等于i的各位数有count[j]个
                //109  1  9
                //109  2  0
                j = getDigit(arr[i], d);
                help[count[j] - 1] = arr[i];
                count[j]--;

            }
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = help[j];
//                System.out.println("help:  "+Arrays.toString(help));
//                System.out.println("arr:  "+Arrays.toString(arr));
            }

        }
    }

    public static int getDigit(int x, int d) {
        for (int i = 1; i < d; i++) {
            x/=10;
        }
        return x%10;
//        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    public static void main(String[] args) {
        int[] str = new int[]{56, 28, 9, 8, 45, 65, 5, 6};
        radixSort(str);
        System.out.println(Arrays.toString(str));

    }


}

