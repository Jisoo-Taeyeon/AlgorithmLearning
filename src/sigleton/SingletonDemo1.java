package sigleton;

import java.util.concurrent.*;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/4/18 10:18
 */
public class SingletonDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 多线程获取  改成04 是false
        Callable<Singleton04> callable = new Callable<Singleton04>() {
            @Override
            public Singleton04 call() throws Exception {
                return Singleton04.getInstance();
            }
        };

        // 创建线程池
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Singleton04> f1 = es.submit(callable);
        Future<Singleton04> f2 = es.submit(callable);

        // 通过future 对象获取实例
        Singleton04 s1 = f1.get();
        Singleton04 s2 = f2.get();

        System.out.println(s1 == s2);

        es.shutdown();

        System.out.println("****************");
        int i =2<<3;
        System.out.println(i);
    }
}

/**
 饿汉式1:
 * 优点: 在类加载的时候,就完成初始化
 * 缺点: 在类装载的时候就完成实例化,没有达到 lazy loading的效果.如果没有用到该实例则造成内存浪费.
 */
class Singleton01{
    /**
     * 1. 创建静态的实例变量
     */
    private static final Singleton01 INSTANCE = new Singleton01();
    /**
     * 2. 构造方法私有化
     */
    private Singleton01(){}

    /**
     * 3. 获取实例对象
     * @return
     */
    public static Singleton01 getInstance(){
        return INSTANCE;
    }
}
/**
*  饿汉式2 枚举形式
 * * 表示该类型对象是有限的几个,我们可以限定为一个,就成了单例
*/
enum  Singleton02{
    //枚举的构造方法都是私有的.
    single;
}

/**
 * 懒汉式1 (适用于单线程)
 * 优点: 使用的时候再加载,延时创建对象
 * 缺点: 只能在单线程下使用
 */
class Singleton03{
    /**
     * 1. 先new 一个空的对象，用到的时候，再去私有化
     */
    private static Singleton03 singleton03 = null;
    /**
     * 2. 构造方法用private 实例化
     */
    private Singleton03(){}

    public static Singleton03 getInstance() throws InterruptedException {
        // 判断 单例类的实例是否创建
        if (singleton03 == null) {
            // 添加休眠 ，查看解决多线程中的安全信息，正常写不用加
            Thread.sleep(10);

            return singleton03 = new Singleton03();
        }
        return  singleton03;
    }

}
/**
 *  懒汉式2 (适用于多线程)
 *  1.属性和构造方法私有化
 *  2.属性用static和volatile修饰
 *  3.获取方法双重检查锁
 */
class Singleton04 {
    /**
     * 1. 先new 一个空的对象，用到的时候，再去私有化
     */
    private static Singleton04 singleton04 = null;
    /**
     * 2. 构造方法用private 实例化
     */
    private Singleton04(){}

    /**
     * 双重锁检查
     * @return
     * @throws InterruptedException
     */
    public static Singleton04 getInstance() throws InterruptedException {
        // 判断 单例类的实例是否创建
        if (singleton04 == null) {
            // 此处添加同步锁,锁对象选择当前类的class对象, 线程获取到锁之后
            synchronized (Singleton04.class) {
                if (singleton04 == null) {
                    singleton04 = new Singleton04();
                }
            }
        }
        return  singleton04;
    }
}