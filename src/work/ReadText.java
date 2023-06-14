package work;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/7/29 10:13
 */
public class ReadText {

    private static int[] flag = new int[51];

    private static int sameCount = 0;

    public static String[] read(String filePath) {
        String[] words = new String[2086];
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
                words[m++] = linestr;
            }
            br.close();//关闭IO
        } catch (Exception e) {
            System.out.println("文件操作失败");
            e.printStackTrace();
        }
        System.out.println(filePath + "        " + m);


        return words;
    }

    public static List<String> readList(String filePath) {
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

    /**
     * 将字符串数组
     * @throws IOException
     */
    public static void writeTxt(String[] strings,String filePath) throws IOException {
        String str = "";
        try {
            BufferedWriter bw =new BufferedWriter(new FileWriter(filePath,true));
            for (String string : strings) {
                if (string == null) {
                    break;
                }
                bw.write(string);
                bw.newLine();
            }

            bw.flush();
            bw.close();
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
        }
    }

    public static boolean isEqual(String str, String[] strings) {
        List<String>list = new ArrayList<>();
        if (str == null) {
            return false;
        } else {
            for (int i = 0; i < strings.length; i++) {
                if (str.equalsIgnoreCase(strings[i])) {
                    if (list.contains(str)) {
                        System.out.println("--------------------------------");
                        System.out.println(str+"    重复了");
                        System.out.println("--------------------------------");

                    }
                    list.add(str);
                    flag[i] = 1;
                    sameCount++;
//                    System.out.println(str+"           "+strings[i]);
                    return true;
                }
            }

        }
        return false;
    }


    public static void main(String[] args) throws IOException {


//        String str = "export dasJobBdzzzdToLoan='0 15 14 * * ? 2099'";
//        System.out.println(str.substring(7));
//        System.out.println(str.substring(7).split("=")[0]);
//        String corn = "=\"0 0 0/2 * * ?\"";
//        String  pro = "export "+str.substring(7).split("=")[0];
//        //读取env中文件的内容
//        String[] read = read("C:\\Users\\流年安好\\Desktop\\das.txt");
//        // 读取定时批量启动的任务
//        String[] strings = read("C:\\Users\\流年安好\\Desktop\\test.txt");
//
//        int count =0;
//        for (int i = 0; i < read.length; i++) {
//            if (read[i] == null) {
//                break;
//            }
//            if (read[i].length() > 7) {
//                if (isEqual(read[i].substring(7).split("=")[0], strings)) {
//                    System.out.println("修改前:  "+read[i]);
//                    read[i] = "export " + read[i].substring(7).split("=")[0] + corn;
//                    System.out.println("修改后：  "+read[i]);
//                }
//            }
//            count++;
//
//        }
//        for (int i = 0; i < flag.length; i++) {
//            if (flag[i] == 0) {
//                read[count++]="export "+strings[i]+corn;
//            }
//        }


//        String outFilePath = "C:\\Users\\流年安好\\Desktop\\a.txt";
//        System.out.println(read.length);
//        writeTxt(read,outFilePath);
//
//        System.out.println("相同的个数为： " + sameCount);
//
//
//        for (int i = 0; i < flag.length; i++) {
//            System.out.print(flag[i]+"       ");
//            if (i % 5 == 0) {
//                System.out.println();
//            }
//        }


        List<String> list = readList("C:\\Users\\流年安好\\Desktop\\jisoo.txt");
        int count = 0;
        List<String> result = new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i).contains("jobName")) {
                count++;
                result.add(list.get(i));
            }

        }
        List<String> hb = new ArrayList<>();
        List<String> hbly = new ArrayList<>();

        List<String> Myjly = new ArrayList<>();
        List<String> Myjzt = new ArrayList<>();

        List<String> Jb = new ArrayList<>();
        List<String> Jbly = new ArrayList<>();

        List<String> Jd = new ArrayList<>();
        List<String> Jdgs = new ArrayList<>();

        List<String> Xmxxd = new ArrayList<>();
        List<String> Xmxyh = new ArrayList<>();

        List<String> Bdzzzd = new ArrayList<>();
        List<String> Bdzzlh = new ArrayList<>();

        List<String> Wld = new ArrayList<>();
        List<String> Wsd = new ArrayList<>();
        List<String> common = new ArrayList<>();





        for (int i = 0; i < result.size(); i++) {
            String s = result.get(i);
            String[] split = s.split("value=\"");
            String s1 = split[1].split("_#")[0];
//            System.out.println(s1);

            if (s1.toLowerCase().contains("hbly")) {
                hbly.add(s1);
            } else if (s1.toLowerCase().contains("jbly")){
                Jbly.add(s1);
            } else if (s1.contains("Hb")){
                hb.add(s1);
            } else if (s1.contains("Jb")){
                Jb.add(s1);
            } else if (s1.toLowerCase().contains("myjly")){
                Myjly.add(s1);
            } else if (s1.toLowerCase().contains("myjzt")){
                Myjzt.add(s1);
            } else if (s1.toLowerCase().contains("jdgs")){
                Jdgs.add(s1);
            } else if (s1.contains("Jd")){
                Jd.add(s1);
            } else if (s1.toLowerCase().contains("xmxxd")){
                Xmxxd.add(s1);
            } else if (s1.toLowerCase().contains("xmxyh")){
                Xmxyh.add(s1);
            } else if (s1.toLowerCase().contains("bdzzzd")){
                Bdzzzd.add(s1);
            } else if (s1.toLowerCase().contains("bdzzlh")){
                Bdzzlh.add(s1);
            } else if (s1.toLowerCase().contains("wld")){
                Wld.add(s1);
            } else if (s1.toLowerCase().contains("wsd")){
                Wsd.add(s1);
            } else{
                common.add(s1);
            }

        }

//        hb.forEach(System.out::println);
//        System.out.println("------------");
//        hbly.forEach(System.out::println);System.out.println("------------");
//        Jb.forEach(System.out::println);System.out.println("------------");
//        Jbly.forEach(System.out::println);System.out.println("------------");
//        Myjly.forEach(System.out::println);
//        System.out.println("------------");
//        Myjzt.forEach(System.out::println);
//        System.out.println("------------");

//        Jdgs.forEach(System.out::println);
//        Jd.forEach(System.out::println);
//        Xmxxd.forEach(System.out::println);
//        Xmxyh.forEach(System.out::println);
//        Bdzzzd.forEach(System.out::println);
//        Bdzzlh.forEach(System.out::println);
//        Wld.forEach(System.out::println);
//        Wsd.forEach(System.out::println);
        common.forEach(System.out::println);


        System.out.println(hb.size()+hbly.size()+Jb.size()+ Jbly.size()+Myjly.size()+Myjzt.size()
                +Jdgs.size()+Jd.size()+Xmxxd.size()+Xmxyh.size()+Bdzzzd.size()
                +Bdzzlh.size()+Wld.size()+Wsd.size()+common.size()


        );

        System.out.println("-------------"+result.size());




    }
}
