package org.zyf.programming.treeexercises;

import java.util.*;

/**
 * 描述：二叉树的相关遍历情况代码
 *
 * @author yanfengzhang
 * @date 2020-05-06 11:49
 */
public class TraverseTreeNode {

    /**
     * 功能描述：前序遍历二叉树, 访问顺序：先根节点，再左子树，最后右子树
     *
     * @param root 当前二叉树信息
     * @return 前序遍历二叉树结果
     * @author yanfengzhang
     * @date 2020-05-06 11:56
     */
    public List<Integer> proOderTraverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                result.add(node.val);
                stack.push(node);
                node = node.left;
            } else {
                TreeNode temp = stack.pop();
                node = temp.right;
            }
        }
        return result;
    }

    /**
     * 功能描述：中序遍历二叉树, 访问顺序：先左子树，再根节点，最后右子树
     *
     * @param root 当前二叉树信息
     * @return 中序遍历二叉树结果
     * @author yanfengzhang
     * @date 2020-05-06 13:35
     */
    public List<Integer> inOderTraverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode temp = stack.pop();
                result.add(temp.val);
                node = temp.right;
            }
        }
        return result;
    }

    /**
     * 功能描述：后序遍历二叉树, 访问顺序：先左子树，再右子树，最后根节点
     *
     * @param root 当前二叉树信息
     * @return 后序遍历二叉树结果
     * @author yanfengzhang
     * @date 2020-05-06 13:46
     */
    public List<Integer> postOderTraverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode cur, pre = null;
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if ((cur.left == null && cur.right == null) ||
                    (pre != null && (pre == cur.left || pre == cur.right))) {
                result.add(cur.val);
                stack.pop();
                pre = cur;
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }

                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
        return result;
    }

    /**
     * 功能描述：层序遍历二叉树, 访问顺序：从根节点依次按层输出
     *
     * @param root 当前二叉树信息
     * @return 层序遍历二叉树结果
     * @author yanfengzhang
     * @date 2020-05-06 14:03
     */
    public ArrayList<ArrayList<Integer>> levelOderTraverse(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        /*将根节点加入到队列中*/
        queue.add(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> arrayList = new ArrayList<>();

            /*得到当前队列中有几个对象*/
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                /*取出队列中的元素,因为队列的数量是随时变化的，所以数量要放在循环外面*/
                /*弹出但不删除*/
                TreeNode node = queue.poll();
                arrayList.add(node.val);

                /*左子树不为空，添加到队列中*/
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(arrayList);
        }
        return result;
    }

    /**
     * 功能描述：给定一个二叉树，返回该二叉树的之字形层序遍历，（从左向右，下一层从右向左，一直这样交替）
     *
     * @param root 当前二叉树信息
     * @return 之字形层序遍历结果
     * @author yanfengzhang
     * @date 2020-05-06 14:31
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOderTraverse(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean flag = true;
        while (!queue.isEmpty()) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                arrayList.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (flag) {
                result.add(arrayList);
                flag = false;
            } else {
                Collections.reverse(arrayList);
                result.add(arrayList);
                flag = true;
            }

        }
        return result;
    }

    /**
     * 功能描述：给定一个二叉树，返回该二叉树由底层到顶层的层序遍历，（从左向右，从叶子节点到根节点，一层一层的遍历）
     *
     * @param root 当前二叉树信息
     * @return 由底层到顶层的层序遍历结果
     * @author yanfengzhang
     * @date 2020-05-06 15:42
     */
    public ArrayList<ArrayList<Integer>> bottomToTopLevelOderTraverse(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                arrayList.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(0, arrayList);
        }
        return result;
    }


    /**
     * 功能描述：根据链表构建一颗二叉树
     *
     * @param inputList 输入具体的二叉树信息
     * @return TreeNode 具体的二叉树
     * @author yanfengzhang
     * @date 2020-04-30 12:11
     */
    public TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        TreeNode node = null;
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.left = createBinaryTree(inputList);
            node.right = createBinaryTree(inputList);
        }
        return node;
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(
                Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4)
        );

        TraverseTreeNode traverseTreeNode = new TraverseTreeNode();
        TreeNode root = traverseTreeNode.createBinaryTree(inputList);
        System.out.println("当前二叉树信息为：3, 2, 9, null, null, 10, null, null, 8, null, 4");
        System.out.println("当前二叉树的前序遍历结果为：" + traverseTreeNode.proOderTraverse(root));
        System.out.println("当前二叉树的中序遍历结果为：" + traverseTreeNode.inOderTraverse(root));
        System.out.println("当前二叉树的后序遍历结果为：" + traverseTreeNode.postOderTraverse(root));
        System.out.println("当前二叉树的层序遍历结果为：" + traverseTreeNode.levelOderTraverse(root));
        System.out.println("当前二叉树的之字形层序遍历结果为：" + traverseTreeNode.zigzagLevelOderTraverse(root));
        System.out.println("当前二叉树的从底层到顶层的层序遍历结果为：" + traverseTreeNode.bottomToTopLevelOderTraverse(root));
    }
}
