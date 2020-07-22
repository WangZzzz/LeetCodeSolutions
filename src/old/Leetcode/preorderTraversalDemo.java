package old.Leetcode;

import java.awt.List;
import java.util.ArrayList;

/*
 * 	144�⣺��һ����������������������Ľ��
 */
public class preorderTraversalDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
}

class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        //��Ŀ��������������Ľ��
        ArrayList<Integer> al = new ArrayList<Integer>();
        pre(al, root);//ʹ�õݹ�ķ����������������ArrayList�洢����

        return al;
    }

    public void pre(ArrayList<Integer> al, TreeNode node) {
        if (node == null) {
            return;
        }
        al.add(node.val);
        pre(al, node.left);
        pre(al, node.right);
    }
}