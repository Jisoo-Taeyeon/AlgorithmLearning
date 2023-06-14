package 链表操作.链表面试相关题;

import java.util.Stack;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2021/12/27 21:11
 *
 * 输入链表头结点，奇数长度返回中点， 偶数长度返回上中点
 * 输入链表头结点，奇数长度返回中点， 偶数长度返回下中点
 * 输入链表头结点，奇数长度返回中点前一个， 偶数长度返回上中点前一个
 * 输入链表头结点，奇数长度返回中点前一个， 偶数长度返回下中点前一个
 */
public class Code01_LinkedListMid {
    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     *  * 输入链表头结点，奇数长度返回中点， 偶数长度返回上中点
     * @param head 头结点
     * @return slow 中结点
     */
    public static Node minOrUpMidNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        //链表有三个点或以上
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow= slow.next;
            fast= fast.next.next;

        }
        return slow;
    }

    /**
     * 判断链表是否为回文链表
     * 使用栈的方法适合笔试用
     * @param head 头节点
     * @return
     */
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur= cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head= head.next;
        }
        return true;
    }

    /**
     * 先求出链表的中节点 将右边部分加入栈中 依次出栈与头节点往后的值 比较
     * @param head
     * @return
     */
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right= right.next;
            cur=cur.next.next;
        }
        Stack<Node> stack= new Stack<Node>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head= head.next;
        }
        return true;
    }

    /**
     * 改原链表的方法适合面试用
     * @param head
     * @return
     */
    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        //慢指针
        Node n1 = head;
        //快指针
        Node n2 = head;
        //n1 来到中点的位置
        while (n2.next != null && n2.next.next != null) {
            // n1 ---- mid
            n1 = n1.next;
            // n2 ----- end
            n2 = n2.next.next;

        }
        n2= n1.next;
        n1.next=null;
        Node n3 =null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next =n1;
            n1= n2;
            n2 = n3;

        }
        //n3 保存最后一个节点
        n3=n1;
        n2=head;
        boolean res =true;
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                res=false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1=n3.next;
        n3.next=null;
        while (n1 != null) {
            n2=n1.next;
            n1.next=n3;
            n3=n1;
            n1=n2;
        }
        return res;
    }



    /**
     * 将单项链表按某值划分成左边小、中间相等、右边大的形式
     * 把链表放入数组里，在数组上做partition（笔试用）
     * 分成小、中、大三部分，再把各部分之间串起来（面试用）
     * @param head
     * @param pivot
     * @return
     */
    public static Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        int i=0;
        //求出链表的长度
        while (cur != null) {
            i++;
            cur=cur.next;
        }
        Node[] nodeArr = new Node[i];
        i=0;
        cur =head;
        //链表存入数组中
        for ( i = 0; i < nodeArr.length; i++) {
            nodeArr[i]=cur;
            cur=cur.next;
        }
        //做荷兰国旗问题
        arrPartition(nodeArr, pivot);
        //把数组链表连接起来
        for (i = 1; i != nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i-1].next=null;
        return nodeArr[0];
    }

    public static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big=nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value <= pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].value == pivot) {
                index++;
            }else{
                swap(nodeArr,--big,index);
            }
        }
    }

    public static void swap(Node[] nodeArr, int a, int b) {
        Node temp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = temp;
    }

    public static Node listPartition2(Node head, int pivot){
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next =null;
        while (head != null) {
            next = head.next;
            head.next=null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH=head;
                    sT=head;
                }
                else {
                    sT.next=head;
                    sT=head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next=head;
                    eT=head;
                }
            }else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                }else {
                    bT.next=head;
                    bT=head;
                }
            }
            head=next;
        }
        //如果有小于区域
        if (sT != null) {
            sT.next=eH;
            //下一步谁去连接大于区的头结点，谁就是eT 这一步是应对小于区存在 等于区域不存在
            eT = eT == null ? sT : eT;
        }
        if (eT != null) {
            eT.next=bH;
        }
        return sH != null ? sH : (eH != null ? eH : bH);
    }


}
