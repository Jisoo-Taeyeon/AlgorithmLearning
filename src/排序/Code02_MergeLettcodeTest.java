package 排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2021/11/23 18:59
 * 在一个数组中，一个数左边比他小的数的总和，叫数的小和，所有书的小和累加起来，叫数组小和
 * [1,3,4,2,5]
 * 1左边比1 小的数没有
 * 3 左边比3 小的数： 1
 * 4 左边比4小的数： 1 3
 * 2                1
 * 5                1 3 4 2
 * .....
 * <p>
 * <p>
 * 给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code02_MergeLettcodeTest{
//    public List<Integer> countSmall(int[] nums) {
//        List<Integer> list = new ArrayList<Integer>();
//        return  list;
//    }

    public static int smallNum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return processNum(arr,0,arr.length-1);
    }

    /**
     * 所有merge时，产生的小数和，累加
     * 左排序时 merge 右排序时merge
     * @param arr
     * @param L
     * @param R
     * @return
     */

    public static int processNum(int[] arr, int L, int R) {
        if (L == R) {
            return 0;

        }
        int mid= L+((R-L)>>1);
        return processNum(arr,L,mid)+processNum(arr,mid+1,R)+mergeNum(arr,L,mid,R);
    }

    public static int  mergeNum(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i=0;
        int p1=l;
        int p2=mid+1;
        int res = 0;
        while (p1 <= mid && p2 <= r) {
            //左组的数
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];

        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j <help.length ; j++) {
            arr[l + j] = help[j];
        }
        return res;
    }
/*

    public static void process(int[] nums, int L, int R) {
        if (L == R) {
            return;
        }
        int mid =L+(L+R)>>1;
        process(nums,L,mid);
        process(nums,mid+1,R);
        merge(nums, L, mid, R);
    }
    public static void merge(int[] nums,int L,int M,int R){
        int[] help = new int[R - L + 1];
        int i=0;
        int p1=L;
        int p2=M+1;
        while (p1 <= p2) {
            help[i++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];

        }
        while (p1 <= M) {
            help[i++] = nums[p1++];
        }
        // 当p1 开始越界，把 p2剩下的内容加入
        while (p2 <= R) {
            help[i++] = nums[p2++];
        }
        for (int i1 = 0; i1 < help.length; i1++) {
            nums[L + i1] = help[i1];
        }
        System.out.println();

    }
*/

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 2, 5};
        System.out.println(Arrays.toString(arr));

        System.out.println(smallNum(arr));
    }



}
