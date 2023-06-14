package work;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/5/20 14:51
 *
 * 读取的文件列为： CREATE TABLE  原始中文字段  类型
 */
public class Demo3 {
    private static String[] words = new String[2000];

    public static void main(String[] args) {
        int m = 0;//words数组下标
        //读取文件至 words 字符串数组中
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("C:\\Users\\流年安好\\Desktop\\公司数据库表\\a.txt"))
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
        System.out.println("CREATE TABLE debt_level_category(\n" +
                "  ID BIGINT NOT NULL AUTO_INCREMENT,");
        for (int i = 0; i < strings.length; i++) {
            String[] split = strings[i].split("\\*");
//            System.out.println(split[0]+" DECIMAL(15,2) COMMENT '"+ split[1]+"',");
            System.out.println(" "+split[0]+" "+split[2]+" COMMENT '"+split[1]+"',");
        }

        System.out.println("  CREATE_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',\n" +
                "  CREATE_BY VARCHAR(40) COMMENT '创建用户',\n" +
                "  UPDATE_DATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',\n" +
                "  UPDATE_BY VARCHAR(40) COMMENT '修改用户',\n" +
                "  JPA_VERSION BIGINT NOT NULL COMMENT '版本',\n" +
                "\n" +
                "  PRIMARY KEY(ID)\n" +
                ")ENGINE =InnoDB DEFAULT CHARACTER SET utf8mb4 COMMENT '负债程度类';");

    }
}
