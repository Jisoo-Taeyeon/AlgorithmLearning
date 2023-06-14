package work;

import java.util.Scanner;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/5/19 15:44
 */
public class MySql {
    public static void main(String[] args) {
        String[] str = new String[300];
        Scanner in = new Scanner(System.in);
        str[0] = "";
        int i=0;
        System.out.println("输入英文");
        while (!str[i].equals("exit")) {
            i++;
            str[i] = in.nextLine();

        }
        System.out.println("输入中文");
        String[] strings = new String[300];
        i=0;
        strings[0] = "";
        while (!strings[i].equals("exit")) {
            i++;
            strings[i] = in.nextLine();

        }
        System.out.println("输入表示符");
        String[] arr = new String[300];
        i=0;
        arr[i] = "";
        while (!arr[i].equals("exit")) {
            i++;
            arr[i] = in.nextLine();

        }
        for (int j = 0; j < str.length; j++) {
            if (arr[j].equals("金额类")||arr[j].equals("评分类")||arr[j].endsWith("占比类")) {
                System.out.println(str[j]+" DECIMAL(15,2) COMMENT '"+ strings[j]+"',");
            }
            else if (arr[j].equals("时长类") || arr[j].equals("计数类") || arr[j].equals("期数类")||arr[j].equals("变更月数类")) {
                System.out.println(str[j]+" DECIMAL(10,0) COMMENT '"+ strings[j]+"',");
            } else if (arr[j].equals("枚举类")) {
                System.out.println(str[j]+" varchar(20) COMMENT '"+ strings[j]+"',");
            } else {
                System.out.println(str[j]+" ********************** COMMENT '"+ strings[j]+"',");

            }
        }
    }
}
