package others;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2023/6/21 10:18
 */
public class TestChar {


    /**
     *
     * 判断一个字符串source中，有几个字符串src
     * @param source 源
     * @param src    src
     * @return int
     */
    public static int getStringCount(String source, String src) {
        int index = 0;
        int count = 0;
        int start = 0;
        // indexof(src,start) 指定子字符串第一次出现的索引，从指定索引开始，如果没有这样的出现，则为-1
        // 首先从 0 开始， 得到最开始出现的位置，在从下一个位置去查找
        while ((index = source.indexOf(src, start)) != -1) {
            count++;
            start = index + 1;
        }
        return count;
    }

    /**
     * 判断一个字符串source中，从指定的位置开始开始计算，字符串src的游标值
     * @param source     源
     * @param src        src
     * @param beginIndex 开始指数
     * @return int
     */
    public static int getStringIndex(String source, String src, int beginIndex) {
        int index = 0;
        int start = 0;
        // 先找到src 再 source 中首次出现的位置，如果index 小于 beginx  就从当前位置的后一位开始找
        // 否则此时index 就是 需要的值
        while ((index = source.indexOf(src, start)) != -1 && index < beginIndex) {
            start = index + 1;
        }
        return  index;
    }

    /**
     * 判断一个byte数值在另外一个byte数组中对应的游标值
     *
     * @param sources    来源
     * @param src        src
     * @param startIndex 开始指数
     * @return int
     */
    public static int getByteIndexOf(byte[] sources, byte[] src, int startIndex) {

        return getByteIndexOf(sources, src, startIndex, sources.length);
    }


    /**
     * 判断一个byte数值在另外一个byte数组中对应的游标值，指定开始的游标和结束的游标位置
     *
     * @param sources    来源
     * @param src        src
     * @param startIndex 开始指数
     * @param endIndex   结束索引
     * @return int
     */
    public static int getByteIndexOf(byte[] sources, byte[] src, int startIndex, int endIndex) {

        if (sources == null || src == null | sources.length == 0 || src.length == 0 || startIndex > sources.length) {
            return -1;
        }
        endIndex = Math.min(endIndex, sources.length);
        int i,j;
        for (i = startIndex; i < endIndex; i++) {
            for (j = 1; j < src.length; j++) {
                if (sources[i + j] != src[j]) {
                    break;
                }
            }
            if (j == src.length) {
                return i;
            }
        }


        return  -1;

    }


    /**
     * 判断一个byte数组src，在另一个byte数组source中存在的个数
     * @param sources 来源
     * @param src     src
     * @return int
     */
    public static int getByteCountOf(byte[] sources, byte[] src) {
        if (sources == null || src == null | sources.length == 0 || src.length == 0) {
            return -1;
        }
        int count = 0;
        int start = 0;
        int index = 0;
        while ((index = getByteIndexOf(sources, src, start)) != -1) {
            start = index + 1;
            count++;
        }
        return count;
    }



    public static void main(String[] args) {
        int stringCount = getStringCount("abcdefg", "g");
        System.out.println(stringCount);

        stringCount = getStringIndex("abcdefg", "c",2);
        System.out.println(stringCount);
    }
}
