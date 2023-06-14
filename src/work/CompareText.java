package work;

import javax.swing.text.html.Option;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/8/4 9:52
 */
public class CompareText {
    public static List<String> read(String filePath) {
        List<String> list = new ArrayList<>();
        //words数组下标
        int m = 0;
        //读取文件至 words 字符串数组中
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(filePath))
            );
            //按行读取 将每次读取一行的结果赋值给linestr
            String linestr;
            while ((linestr = br.readLine()) != null) {
                //赋值给数组后，下标后移
                list.add(linestr);
            }
            br.close();//关闭IO
        } catch (Exception e) {
            System.out.println("文件操作失败");
            e.printStackTrace();
        }
        System.out.println(filePath + "        " + m);

        return list;
    }


    public static void main(String[] args) {
        List<String> read = read("C:\\Users\\流年安好\\Desktop\\custInfoUpload (4).xlsx");
        String[] strings = new String[read.size()];



        read.forEach(System.out::println);
//        for (int i = 1; i <read.size()-1; i++) {
//            String arr = "";
//            if (read.get(i).equals("") || read.get(i) == null) {
//                break;
//            }
//            strings[i] = "";
//
//            for (int j = 0; j < str.length(); j++) {
//                char c = str.charAt(j);
//                if (c!='\t') {
//                    arr += c;
//                } else if (c=='\t' && str.charAt(j+1)!='\t') {
//                    arr += '*';
//                }
//                strings[i] = arr;
//
//            }
//        }
    }
}
