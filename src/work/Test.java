package work;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/5/26 17:57
 */
public class Test {
    public static void main(String[] args) {
        String id = "341224199109153019";

        String substring = id.substring(6, 14);
        System.out.println(substring);
        System.out.println(substring.substring(0, 4));
        System.out.println(substring.substring(4, 6));
        System.out.println(substring.substring(6, 8));
        System.out.println(Integer.parseInt(substring.substring(6,8)));

        int i = Integer.parseInt(substring.substring(4, 8));
        System.out.println("****"+ i);


        // 先截取到字符串中的年、月、日
        String date = "1991-09-15";
        System.out.println(date.replaceAll("-",""));
        System.out.println(Integer.parseInt(date.replaceAll("-","")));
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.get(Calendar.MONTH)+1);
        System.out.println("************");
        System.out.println(instance.get(Calendar.DAY_OF_MONTH));
        System.out.println(instance.get(Calendar.DATE));
        String test = "";
        System.out.println(test.length());
        System.out.println("--------------------");
        System.out.println(getAgefromBirthTime(date));

        System.out.println("--------------------");
//        BigDecimal bigDecimal = new BigDecimal("0");
//        int i1 = bigDecimal.compareTo(BigDecimal.ZERO);
//        System.out.println(i1);
//        String strs[] = date.split("-");
//        String year = strs[0];
//        String month = strs[1];
//        String day= strs[2];
//        String birthday =year+month+day;
//        System.out.println(birthday);
//        System.out.println(birthday.equals(substring));
//        System.out.println(getAgefromBirthTime("1999-12-11"));
    }

    //计算年龄
    public static int getAgefromBirthTime(String birthTimeString){

        // 先截取到字符串中的年、月、日
        String strs[] = birthTimeString.trim().split("-");
        int selectYear = Integer.parseInt(strs[0]);
        int selectMonth = Integer.parseInt(strs[1]);
        int selectDay = Integer.parseInt(strs[2]);
        // 得到当前时间的年、月、日
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.toString());
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayNow = cal.get(Calendar.DATE);

        // 用当前年月日减去生日年月日
        int yearMinus = yearNow - selectYear -1;
        int monthMinus = monthNow - selectMonth;
        int dayMinus = dayNow - selectDay;

        int age = yearMinus;
        if (yearMinus < 0) {// 选了未来的年份
            age = 0;
        } else if (yearMinus == 0) {// 同年的，要么为1，要么为0
            if (monthMinus < 0) {// 选了未来的月份
                age = 0;
            } else if (monthMinus == 0) {// 同月份的
                if (dayMinus < 0) {// 选了未来的日期
                    age = 0;
                } else if (dayMinus >= 0) {
                    age = 1;
                }
            } else if (monthMinus > 0) {
                age = 1;
            }
        } else if (yearMinus > 0) {
            if (monthMinus < 0) {// 当前月>生日月
            } else if (monthMinus == 0) {// 同月份的，再根据日期计算年龄
                if (dayMinus < 0) {
                } else if (dayMinus >= 0) {
                    age = age + 1;
                }
            } else if (monthMinus > 0) {
                age = age + 1;
            }
        }
        return age;

    }

}
