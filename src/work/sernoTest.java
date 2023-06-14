package work;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/8/1 19:02
 */
public class sernoTest {

    public static void main(String[] args) {
        String[] read = ReadText.read("C:\\Users\\流年安好\\Desktop\\jisoo.txt");
        Set<String> set = new HashSet<>();
//        String s = "O_WDPT_WSD_COMPANY_INFO";
//        System.out.println(s.replaceAll("O_WDPT","tm_klb"));

        for (String s : read) {
            if (s != null) {
                set.add("|"+s+"|"+s.replaceAll("O_WDPT","tm_klb")+" |"+" |");
            }

        }
        set.forEach(System.out::println);
    }
}
