package utils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/11/30 14:37
 */
public class StreamLearn {
    static class User{
        private String name;
        private String age;
        private int height;
        public User(String name, String age, int height) {
            this.name = name;
            this.age = age;
            this.height = height;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    ", height=" + height +
                    '}';
        }
    }

    /**
     * 添加测试
     * new一个list，一个一个添加
     */
    public static void addTest(){
        User user1 = new User("111", "18", 180);
        User user2 = new User("222", "18", 175);
        User user3 = new User("333", "19", 170);
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        //使用stream流，创建动态数组，可以添加元素
        List<User> list = Stream.of(user1,user2,user3).collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * 遍历测试
     * stream: map
     */
    public static void traversalTest(){
        // 遍历
        List<String> userNameList = new ArrayList<>();
        User user1 = new User("111", "18", 180);
        User user2 = new User("222", "18", 175);
        User user3 = new User("333", "19", 170);
        //使用stream流，创建动态数组，可以添加元素
        List<User> list = Stream.of(user1,user2,user3).collect(Collectors.toList());
        for (User user : list) {
            userNameList.add(user.getName());
        }
        List<String> collect = list.stream().map(User::getName).collect(Collectors.toList());
        System.out.println(collect);

    }

    /**
     * 统一测试
     * 测试一些 stream 的经典用法
     */
    public static void uniformTest(){
        User user1 = new User("111", "30", 160);
        User user4 = new User("111", "18", 180);
        User user2 = new User("222", "18", 175);
        User user3 = new User("333", "19", 170);



        //使用stream流，创建动态数组，可以添加元素
        List<User> userList = Stream.of(user1,user4,user2,user3).collect(Collectors.toList());
        System.out.println("排序 年龄升序 身高降序");
        // 排序 年龄升序 身高降序
        List<User> collect4 = userList.stream().sorted(Comparator.comparing(User::getAge).reversed().thenComparingInt(User::getHeight)).collect(Collectors.toList());
        System.out.println(collect4);
        System.out.println(userList.stream().sorted(Comparator.comparing(s -> Integer.parseInt(s.getAge()))).collect(Collectors.toList()));
        // 获取 用户年龄大于18
        // Stream流：filter
        List<User> collect = userList.stream().filter(user -> Integer.parseInt(user.getAge()) > 18).collect(Collectors.toList());
        System.out.println("年龄大于18");
        System.out.println(collect.toString());

        //根据年龄分组
        Map<String, List<User>> collect1 = userList.stream().collect(Collectors.groupingBy(User::getAge, Collectors.toList()));
        System.out.println("根据年龄分组");
        System.out.println(collect1.toString());

        //求和
        double summation = userList.stream().mapToInt(User::getHeight).sum();
        System.out.println("体重之和");
        System.out.println(summation);

        //list 转map
        //(1）转换map，key重复问题；
        //代码中使用(key1,key2)->key2表达式可以解决此类问题，如果出现重复的key就使用key2覆盖前面的key1,也可以定义成(key1,key2)->key1，保留key1,根据自己的业务场景来调整。
        //（2）空指针异常，即转为map的value是null。这个可以用filter过滤；
        System.out.println("list 转 map");
        Map<String, User> userMap = userList.stream().collect(Collectors.toMap(User::getAge, Function.identity(), (key1, key2) -> key2));
        System.out.println(userMap);

        //map 转list
        List<User> collect2 = userMap.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
        userMap.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        List<User> collect3 = userMap.values().stream().collect(Collectors.toList());
        new ArrayList<>(userMap.values());
        System.out.println("map 转 list");
        System.out.println(collect2);

        // 做判断  anyMatch（）
        //判断的条件里，任意一个元素成功，返回true;
        System.out.println("是否有体重大于175  只有任意一个元素成功 返回true");
        boolean anyMatch = userList.stream().anyMatch(user -> user.getHeight() > 175);
        System.out.println(anyMatch);

        System.out.println("是否有体重大于175  所有元素都成功 返回true");
        boolean allMatch = userList.stream().allMatch(user -> user.getHeight() > 175);
        System.out.println(allMatch);

        // 所有都不是
        userList.stream().noneMatch(user -> user.getHeight() > 175);

        // 求取目标元素之和
        long count = userList.stream().filter(user -> user.getHeight() > 175).count();
        System.out.println("体重大于175 人的体重的人数");
        System.out.println(count);

        //合并多个一维list
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> list3 = Arrays.asList(7, 8, 9);
        List<Integer> mergedList = Stream.of(list1, list2, list3).flatMap(Collection::stream).collect(Collectors.toList());
        // [1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(mergedList);

        // 合并嵌套List
        List<String> asList = Arrays.asList("张三", "李四", "王二麻子");
        List<String> asList1 = Arrays.asList("111", "222", "333");
        // 合并前
        List<List<String>> lists = Arrays.asList(asList, asList1);
        System.out.println(lists);

        // 合并后
        List<String> flatMap = lists.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(mergedList);

        Map<String,Object> map = new HashMap<>();
        //list -> 当前页所有数据
        int pageNo = 1;
        int pageSize = 1;
        map.put("list",userList.stream().skip((long) (pageNo - 1) * pageSize).limit(pageSize).collect(Collectors.toList()));
        //count -> 记录总条数
        map.put("count",userList.size());
        System.out.println(map.toString());


    }

    public static void testStreamTest(){
        User user1 = new User("111", "30", 160);
        User user4 = new User("111", "18", 180);
        User user2 = new User("222", "18", 175);
        User user3 = new User("333", "19", 170);



        //使用stream流，创建动态数组，可以添加元素
        List<User> userList = Stream.of(user1,user4,user2,user3).collect(Collectors.toList());
        System.out.println("排序 年龄升序 身高降序");
        // 排序 年龄升序 身高降序  String 排序比较最后一个字符
        List<User> collect4 = userList.stream().sorted(Comparator.comparing(User::getAge).reversed().thenComparingInt(User::getHeight)).collect(Collectors.toList());
        System.out.println(collect4);
        System.out.println("根据年龄升序排序");
        System.out.println(userList.stream().sorted(Comparator.comparing(s -> Integer.parseInt(s.getAge()))).collect(Collectors.toList()));
        System.out.println(userList.stream().sorted(Comparator.comparing(s -> Integer.parseInt(s.getAge()))).sorted(Comparator.comparingInt(User::getHeight)).collect(Collectors.toList()));

//        System.out.println(userList.stream().sorted(Comparator.comparing(s -> Integer.parseInt(s.getAge())).thenComparingInt(User::getHeight)).collect(Collectors.toList()));
    }

    public static void main(String[] args) {
//        addTest();
//        System.out.println("**********************************");
//        traversalTest();
//        System.out.println("**********************************");
//        uniformTest();
//        System.out.println("**********************************");

//        User user1 = new User("111", "18", 180);
//        User user2 = new User("222", "18", 175);
//        User user3 = new User("333", "19", 170);
//        //使用stream流，创建动态数组，可以添加元素
////        List<User> userList = Stream.of(user1,user2,user3).collect(Collectors.toList());
//        List<User> userList = new ArrayList<>();
//        // 获取 用户年龄大于18
//        // Stream流：filter
//        long count = userList.stream().filter(user -> Integer.parseInt(user.getAge()) > 18).count();
//        System.out.println(count);


        String str = "lhg/2236235png,";
        String[] split = str.split("\\.");
        for (String s : split) {
            System.out.println(s);
        }
        System.out.println(split[split.length-1]);

        StringBuffer buffer = new StringBuffer();
        buffer.append(str);
        System.out.println(buffer.lastIndexOf(","));
        buffer.substring(0, buffer.length() - 1);
        System.out.println(buffer);
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        String mergedString = strings.stream()
                .filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));

        System.out.println(mergedString);
        List<Integer> list = new ArrayList<>();
        list.add(1);
//        list.add(2);
//        list.add(3);
        String joined = list.stream().map(Object::toString).collect(Collectors.joining(","));
        System.out.println(joined);

        testStreamTest();

    }


}
