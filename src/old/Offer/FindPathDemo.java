package old.Offer;

import java.util.Stack;

/**
 * @author WangZ ������25���������к�Ϊĳһֵ��·�� 143ҳ
 * ��Ŀ������һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·���������ĸ��ڵ㿪ʼ����һֱ��Ҷ����������� ����γ�һ��·����
 */

public class FindPathDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BinaryTree bt = new BinaryTree();
        bt.insertBST(10);
        bt.insertBST(5);
        bt.insertBST(4);
        bt.insertBST(7);
        bt.insertBST(12);
        // preOrder(bt.root);

        FindPath(bt.root, 22);
    }

    private static void FindPath(BinaryTreeNode root, int expectedSum) {
        if (root == null) {
            return;
        }

        Stack<Integer> path = new Stack<Integer>();
        int currentSum = 0;// ��ǰ�ĺ�
        FindPath(root, expectedSum, path, currentSum);
    }

    private static void FindPath(BinaryTreeNode root, int expectedSum,
                                 Stack<Integer> path, int currentSum) {
        currentSum = currentSum + root.val;
        path.push(root.val);

        // �����Ҷ�ڵ���·���Ͻ��ĺ͵��������ֵ
        // ��ӡ������·��
        boolean isLeaf = ((root.pLeft == null) && (root.pRight == null));
        if (isLeaf && currentSum == expectedSum) {
            System.out.print("A path is found : ");
            for (int i : path) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }

        // �������Ҷ��㣬����������ӽڵ�
        if (root.pLeft != null) {
            FindPath(root.pLeft, expectedSum, path, currentSum);
        }
        if (root.pRight != null) {
            FindPath(root.pRight, expectedSum, path, currentSum);
        }

        // �ڷ��ظ��ڵ�֮ǰ����·����ɾ����ǰ���
        path.pop();
    }

    private static void preOrder(BinaryTreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrder(root.pLeft);
            preOrder(root.pRight);
        }
    }
}
