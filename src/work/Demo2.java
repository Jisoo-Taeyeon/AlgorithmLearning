package work;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/5/19 20:50
 */
public class Demo2 {
    private static String[] words = new String[2000];

    public static void main(String[] args) {
        int m = 0;//words数组下标
        //读取文件至 words 字符串数组中
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("C:\\Users\\流年安好\\Desktop\\Irene.txt"))
            );
            //按行读取 将每次读取一行的结果赋值给linestr
            String linestr;
            while ((linestr = br.readLine()) != null) {
                //输出每行的信息
//                System.out.println(linestr);
                //赋值给数组后，下标后移
                words[m++] = linestr;
            }
            br.close();//关闭IO
        } catch (Exception e) {
            System.out.println("文件操作失败");
            e.printStackTrace();
        }
        String[] strings = new String[m];
        for (int i = 0; i <= m-1; i++) {
            String arr = "";
            if (words[i].equals("") || words[i] == null) {
                break;
            }
            strings[i] = "";
            String str = words[i];

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c!='\t') {
                    arr += c;
                } else if (c=='\t' && str.charAt(j+1)!='\t') {
                    arr += '*';
                }
                strings[i] = arr;

            }
        }
        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];
            String[] split = str.split("\\s+");
            String s = "";
            s += split[0] + "(\"" + split[0] + "\",\"" + split[1] + "\"),";
            System.out.println(s);

//            System.out.println(str);


        }

    }
}
