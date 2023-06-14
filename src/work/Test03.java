package work;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/6/28 15:23
 */
public class Test03 {
    public static boolean isEmpty(String string) {
        if (string == null||string.equals("")) {
            return true;

        }
        return  false;
    }

    public static String flag(String str){
        System.out.println("----------");
        return str;
    }
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());

        System.out.println("------------------------------");
        //可以直接把这个方法强制转换成date类型
        Date nowTime = new Date(System.currentTimeMillis());
        //设定显示格式
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd");
        //按指定格式转换
        String now = sdFormatter.format(nowTime);
        System.out.println(now);

    }
}
