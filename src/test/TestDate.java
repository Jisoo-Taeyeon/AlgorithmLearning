package test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2023/1/31 9:37
 */
public class TestDate {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        String loan = sdf.format(new Date());
        System.out.println(loan);


        Long l = 12L;
        int a = Math.toIntExact(l);
        System.out.println(a);
        BigDecimal bigDecimal = BigDecimal.TEN;
        System.out.println(BigDecimal.ZERO.compareTo(bigDecimal));



    }
}
