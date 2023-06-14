package 链表操作;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2021/11/16 18:11
 * 用双链表来实现栈和队列
 */
public class DoubleEndsQueueToStackAndQueue {
    public static class Node<T>{
        public T value;
        public Node<T> next;
        //往前指针
        public Node<T> last;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 实现双向链表
     * @param <T>
     */
    public static class DoubleEndsQueue<T>{
        public Node<T> head;
        public Node<T> tail;

        /**
         * 从头部添加一个节点
         * @param value
         */
        public void addFromHead(T value){
            Node<T> cur =new Node<T>(value);
            if (head==null){
                head=cur;
                tail = cur;

            }else{
                cur.next=head;
                head.last=cur;
                head=cur;
            }

        }

        /**
         * 从尾部添加一个节点
         * @param value
         */
        public void addFromBottom(T value){
            Node<T> cur = new Node<T>(value);
            if (tail == null) {
                tail = cur;
                head = cur;
            } else {
                cur.last=tail;
                tail.next= cur;
                tail=cur;
            }

        }

        /**
         * 从头部删除节点
         * @return
         */
        public T popFromHead() {
            if (head == null) {
                return null;
            }
            Node<T> cur= head;
            if (head == tail) {
                tail=null;
                head=null;

            }else {
                head=head.next;
                cur.next =null;
                head.last =null;

            }
            return cur.value;
        }

        /**
         * 从结尾删除节点
         * @return
         */
        public T popFromTail() {
            if(tail ==null){
                return  null;

            }
            Node<T> cur=tail;
            if (head == tail) {
                tail = null;
                head = null;
            } else {
                tail=tail.last;
                cur.last=null;
                tail.next=null;
            }
            return cur.value;
        }


    }

    /**
     * 用双链表来实现栈
     * @param <T>
     */
    public static class MyStack<T>{
        private DoubleEndsQueue<T> queue;
        public MyStack(){
            queue = new DoubleEndsQueue<T>();
        }
        public void push(T value){
            queue.addFromHead(value);
        }
        //从结尾出栈 先进后出
        public T poll(){
            return queue.popFromTail();

        }

    }
}
