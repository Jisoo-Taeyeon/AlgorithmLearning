package 树;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Lihu
 * @PROJECT_NAME: 算法学习
 * @DESCRIPTION:
 * @USER: Irene-Jisoo
 * @DATE: 2022/4/21 21:48
 */
public class Code03_binaryTree {
    public  class TreeNode {
        //值
        int data;
        //左子树
        TreeNode leftChild;
        //右子树
        TreeNode rightChild;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public class BinarySearchTree {
        //根节点
        TreeNode root;

        // 插入数据
        public void insertNode(int data) {
            root = insert(root,data);
        }
        // 递归插入节点
        private  TreeNode insert(TreeNode node, int data) {
            //结束条件
            if (node == null) {
                return new TreeNode(data);
            }
            // 左孩子
            if (data < node.data) {
                node.leftChild = insert(node.leftChild, data);
            }
            //右孩子
            else if (data>node.data){
                node.rightChild = insert(node.rightChild, data);
            }else{
                node.data=data;
            }

            return  node;
        }

        /**
         * 先序遍历
         * @param node
         */
        public void preOrderTraveral(TreeNode node) {
            if (node == null) {
                return;
            }
            System.out.println(node.data);
            preOrderTraveral(node.leftChild);
            preOrderTraveral(node.rightChild);

        }

        /***
         * 广度优先遍历 nlogn
         * 极端情况下二叉查找树退化成链表，时间复杂度为O(n)，所以需要平衡二叉查找树。
         * @param root
         */
        public void levelTravel(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            //从队尾开始入队
            queue.offer(root);
            //队列不为空
            while (!queue.isEmpty()) {
                // 出队
                TreeNode node = queue.poll();
                System.out.println(node.data);
                //左孩子入队
                if (node.leftChild != null) {
                    queue.offer(node.leftChild);
                }
                // 右孩子入队
                if (node.rightChild != null) {
                    queue.offer(node.rightChild);
                }
            }
        }


    }

    public  void sout() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insertNode(10);
        binarySearchTree.insertNode(8);
        binarySearchTree.insertNode(11);
        binarySearchTree.insertNode(7);
        binarySearchTree.insertNode(9);
        binarySearchTree.insertNode(12);

        TreeNode root = binarySearchTree.root;

        binarySearchTree.preOrderTraveral(root);

        System.out.println("*******************");
        binarySearchTree.levelTravel(binarySearchTree.root);
    }

    public static void main(String[] args) {
        Code03_binaryTree code03_binaryTree = new Code03_binaryTree();
        code03_binaryTree.sout();
    }

}
