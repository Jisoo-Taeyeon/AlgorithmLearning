package test;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/5/9 16:42
 */
public class TEst {
    /**
     * 矩阵转置
     * @param arr
     */
    public  void change(int  arr[][]){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <3 ; j++) {
                arr[i][j] = arr[j][i];
            }
        }
    }

    /**
     * 输出所有的水花仙数
     */
    public void sout(){
        for (int i = 100; i <= 999; i++) {
            int a = i / 100;
            int b = i % 100 / 10;
            int c = i % 10;
            if (a * a * a + b * b * b + c * c * c == i) {
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args) {
        Integer age = null;
        System.out.println(Optional.of(String.valueOf(age)).orElse(""));

    }
}
