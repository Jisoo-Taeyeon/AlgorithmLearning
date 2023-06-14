package work;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/7/27 18:35
 */
public class WrittenExamination {

    /**
     * 字符串翻转
     * @param str 翻转之前的
     * @return 翻转之后的字符串
     */
    public String flipString(String str) {
        if (str == null || str.length()==0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        return stringBuffer.reverse().toString();

    }

    /**
     * 冒泡排序升序
     * @param arr 原始数组
     * @return 要排序的数组
     */
    public int[] arrSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
