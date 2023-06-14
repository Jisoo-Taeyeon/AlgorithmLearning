package 链表操作;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2021/11/17 10:52
 */
public class LoopTest {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    /**
     * 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。若环不存在，请返回 null。
     *
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next=null;
        }
    }

    /**
     * 利用快慢指针解决
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        if (head == null||head.next==null) {
            return null;
        }
        //快指针每次比满指针夺走两步
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast != slow){
            return null;
        }
        fast=head;
        /**
         * 此时快指针移动m，从head开头节点到换开头节点b处；
         * (m+y)*2=m+xn+y  m+y=xn => m=n-y+(x-1)*n
         * n-y 的距离是满指针从相遇点c走到点b处；
         */
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;


    }

    public static void main(String[] args) {

    }
}
