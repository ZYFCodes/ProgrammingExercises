package org.zyf.programming.treeexercises;

/**
 * 描述：【给出一棵树的中序遍历和后序遍历，请构造这颗二叉树】 或 【给出一棵树的前序遍历和中序遍历，请构造这颗二叉树】
 *
 * @author yanfengzhang
 * @date 2020-05-06 17:51
 */
public class UseTwoTraverseToBuildTree {

    /**
     * 功能描述：给出一棵树的中序遍历和后序遍历，请构造这颗二叉树
     * 思路：后序遍历（左节点→右节点→根节点）最后一个节点为根节点，
     * 因此可以直接确定数组postorder[]最后一个元素是根节点，
     * 然后通过寻找中序遍历（左节点→根节点→右节点）中的根节点即可确定左右子树（根节点前面序列是左子树，根节点后面序列是右子树）
     * ，然后利用递归即可得解
     *
     * @author yanfengzhang
     * @date 2020-05-06 17:53
     */
    public TreeNode buildTreeWitnInorderAndPostorder(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0 || postorder.length != inorder.length) {
            return null;
        }
        int in = inorder.length - 1;
        int post = postorder.length - 1;
        return solve(inorder, 0, in, postorder, 0, post);
    }

    /*x，y分别代表中序遍历起始、结束位置，i,j分别代表后序遍历起始、结束位置*/
    public TreeNode solve(int[] inorder, int x, int y, int[] postorder, int i, int j) {
        if (x > y || i > j) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[j]);
        for (int k = x; k <= y; k++) {
            if (inorder[k] == postorder[j]) {
                /*k-x代表中序遍历中根节点的左子树长度*/
                root.left = solve(inorder, x, k - 1, postorder, i, i + k - x - 1);
                root.right = solve(inorder, k + 1, y, postorder, i + k - x, j - 1);
                break;
            }
        }
        return root;
    }

    /**
     * 功能描述：给出一棵树的前序遍历和中序遍历，请构造这颗二叉树
     * *假设树的先序遍历是12453687，中序遍历是42516837。
     * * 这里最重要的一点就是先序遍历可以提供根的所在，
     * * 而根据中序遍历的性质知道根的所在就可以将序列分为左右子树。
     * * 比如上述例子，我们知道1是根，所以根据中序遍历的结果425是左子树，而6837就是右子树。
     * * 接下来根据切出来的左右子树的长度又可以在先序便利中确定左右子树对应的子序列
     * * （先序遍历也是先左子树后右子树）。
     * * 根据这个流程，左子树的先序遍历和中序遍历分别是245和425，
     * * 右子树的先序遍历和中序遍历则是3687和6837，我们重复以上方法，可以继续找到根和左右子树，
     * * 直到剩下一个元素。
     *
     * @author yanfengzhang
     * @date 2020-05-06 17:57
     */
    public TreeNode buildTreeWithPreorderAndInorder(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preRight < preLeft) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preLeft]);
        if (preRight == preLeft) {
            return node;
        }
        int num = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == preorder[preLeft]) {
                num = i;
                break;
            }
        }
        int length = num - inLeft;

        node.left = buildTree(preorder, preLeft + 1, preLeft + length, inorder, inLeft, inLeft + length - 1);
        node.right = buildTree(preorder, preLeft + length + 1, preRight, inorder, num + 1, inRight);
        return node;
    }
}
