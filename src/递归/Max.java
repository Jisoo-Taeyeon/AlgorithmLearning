package 递归;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2021/11/17 19:20
 */


public class Max {
    /**
     * 递归求最大值
     */
    public static int process(int[] arr,int L, int R){
        if(L==R) {
            return arr[L];
        }
        //int mid= (L+R)/2;
        int mid =L+((R-L)>>1);
        int leftMax =process(arr,L,mid);
        int rightMax =process(arr,mid +1,R);
        return Math.max(leftMax, rightMax);
    }
}
