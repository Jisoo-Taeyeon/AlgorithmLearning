package mianshi;

import java.util.*;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/4/25 13:45
 */
public class Demo1 {

    /***
     *1.	编写字符串统计程序，该程序可统计字符串里有多少种字符，及每种字符的个数。
     *     用字符串"yekmaakkccekymbvb"验证该程序。（18分）
     *
     * 2.	将数值型式的 RGB 颜色字符串转换为 16 进制格式。输入输出均为字符串。（18分）
     *     如：输入: rgb(255, 255, 255), 输出: #ffffff；
     *     输入: rgb(244, 67, 54), 输出: #f44336。
     *
     *  3.	给定一个字符串，请去除字符串中重复的字母，使得每个字母只出现一次，需保证返回的结果的字典序最小（要求不能打乱其他字符的相对位置）。（20分）
     *     如：输入: bbac, 输出: bac；
     *     输入: bacb, 输出: acb。
     *     用字符串"yekmaakkccekymbvb"验证该程序。
     */
    /**
     * 1.	编写字符串统计程序，该程序可统计字符串里有多少种字符，及每种字符的个数。
     *  用字符串"yekmaakkccekymbvb"验证该程序。（18分）
     * @param mess
     */
    public void test(String mess) {
        Set<Character> set = new HashSet();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < mess.length(); i++) {
            char c = mess.charAt(i);
            set.add(c);
            // 判断该字符有没有出现

        }
//        System.out.println(Arrays.toString(set.toArray()));
        System.out.println("总共有字符种类："+set.size());
        for (Character character : set) {
            int count =0;
            for (int j = 0; j < mess.length(); j++) {
                if (character.equals(mess.charAt(j))) {
                    count++;
                }
            }
            System.out.println(character+"出现了："+count);
        }
    }

    /**
     * 3.	给定一个字符串，请去除字符串中重复的字母，使得每个字母只出现一次，需保证返回的结果的字典序最小（要求不能打乱其他字符的相对位置）。（20分）
     *    如：输入: bbac, 输出: bac；
     *    输入: bacb, 输出: acb。
     *   用字符串"yekmaakkccekymbvb"验证该程序。
     * @param mess
     */
    public void test2(String mess) {
        //用list来保存
        List<Character> list = new ArrayList<>();
        // 数组倒序，确保让字符最后出现的先加入
        for (int i = mess.length()-1; i>=0 ; i--) {
            char c = mess.charAt(i);
            if (!list.contains(c)) {
                list.add(c);
            }

        }
        System.out.println("处理到后的为");
        // 然后把list集合翻转
        for (int i = list.size()-1; i >=0 ; i--) {
            System.out.print(list.get(i));
        }



    }

    /**
     2.	将数值型式的 RGB 颜色字符串转换为 16 进制格式。输入输出均为字符串。（18分）
     *     如：输入: rgb(255, 255, 255), 输出: #ffffff；
     *     输入: rgb(244, 67, 54), 输出: #f44336。
     * @param mess
     */
    public String test3(String mess) {
        String[] split = mess.split(",");

        int i = Integer.parseInt(split[0].substring(4));
        int j = Integer.parseInt(split[1].trim());
        int m = Integer.parseInt(split[2].substring(1, split[2].length() - 1));
        String s = "#"+getHex(i) + getHex(j) + getHex(m);
        return s;
    }
    public String getHex(int num) {
        String[] c = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        String str = "";
        if (num == 0) {
            return c[0];
        }
        while (num != 0) {
            int x = num&0xF;
            str=c[x]+str;
            num = num >> 4;
        }

        return str;


    }
    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
//        demo1.test("yekmaakkccekymbvb");

//        System.out.println("****************");
//        String str = "yekmaakkccekymbvb";
//        System.out.println("测试的字符串："+str);
//
//        demo1.test2(str);
//
//        System.out.println("************");
//        System.out.println(demo1.getHex(255));
        String string = "rgb(244, 67, 54)";
        System.out.println("输入的字符串："+string);
        System.out.println(demo1.test3(string));

    }

}
