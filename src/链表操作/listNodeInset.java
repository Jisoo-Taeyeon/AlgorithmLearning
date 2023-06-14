package 链表操作;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2021/11/14 14:49
 */
public class listNodeInset {
    public class ListNode{
        public int value;
        public ListNode next;

        public ListNode(int data) {
            this.value = data;
        }
        public void ListNode(int val, ListNode next){
            this.value=val;
            this.next=next;
        }
    }


    /***
     * 实现单链表翻转
     * @param l
     * @return
     */
    public static  ListNode reverseLinkedList(ListNode l){
        ListNode pre=null;
        ListNode next=null;
        while(l!=null){
            next=l.next;
            l.next=pre;
            pre=l;
            l=next;
        }
        return pre;
    }

    /**
     *给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode arr = reverseLinkedList(head);
        if (head == null) {
            return null;
        }
        if (n == 1) {
            arr=arr.next;
            return reverseLinkedList(arr);
        }
        ListNode pre = arr;
        ListNode cur = arr;
        int count = 1;


        while (pre.next!=null){
            if (n == count) {
                if(pre.next==null){
                    cur.next=null;

                }
                cur.next=pre.next;

            } else {
                cur=pre;
            }

            pre=pre.next;
            count++;
        }
        return reverseLinkedList(arr);

    }

    /**
     * 根据num值链表删除
     * @param head
     * @param num
     * @return
     */
    public static ListNode removeValue(ListNode head, int num){
        while(head!=null){
            if(head.value!=num){
                break;

            }
            head =head.next;
        }
        //head 来到第一个不需要删除的位置，这个位置的value值不等于num；

        ListNode pre=head;
        ListNode cur=head;
        while(cur!=null){
            if(cur.value==num){
                //pre 指向下个节点的值
                pre.next=cur.next;

            }else {
                pre=cur;
            }
            cur=cur.next;
        }
        return head;

    }
    public int res(ListNode l){
        int a=0;
        ListNode next=null;

        while (l!=null){
            next=l.next;
            a=a*10+l.value;
            l=next;
        }
        return a;

    }

    public static void main(String[] args) {
        System.out.println();

    }
}
