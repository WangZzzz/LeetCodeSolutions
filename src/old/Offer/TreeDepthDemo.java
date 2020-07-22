package old.Offer;

import java.util.DuplicateFormatFlagsException;

/**
 * @author WangZ
 * ������39������������� 207ҳ
 * ��Ŀһ������һ�Ŷ������ĸ��ڵ㣬���������ȣ��Ӹ���㵽Ҷ���һ�ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ�������
 * <p>
 * ��Ŀ��������һ�Ŷ������ĸ���㣬�жϸ����ǲ���ƽ������������ĳ����������������������������������������ô������һ��ƽ���������
 * <p>
 * ƽ����������������������������1
 */
public class TreeDepthDemo {

    public static int pDepth = 0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(13);
        BinaryTreeNode node3 = new BinaryTreeNode(2);
        BinaryTreeNode node4 = new BinaryTreeNode(1);
        BinaryTreeNode node5 = new BinaryTreeNode(5);

        root.pLeft = node1;
        node1.pLeft = node2;
        node1.pRight = node3;
        node2.pLeft = node4;
        node4.pLeft = node5;
        preOrder(root);
        System.out.println("***********");
        System.out.println(TreeDepth(root));
        System.out.println("***********");
        System.out.println(IsBalanced(root));
    }


    public static void preOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        preOrder(node.pLeft);
        preOrder(node.pRight);
    }

    //��Ŀһ��������������
    public static int TreeDepth(BinaryTreeNode pRoot) {
        if (pRoot == null) {
            return 0;
        }

        int nLeft = TreeDepth(pRoot.pLeft);//���
        int nRight = TreeDepth(pRoot.pRight);//�ұ�

        return (nLeft > nRight) ? (nLeft + 1) : (nRight + 1);
    }

    //��Ŀ�����ж��ǲ���ƽ���������������������������
    public static boolean IsBalanced(BinaryTreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }

        int left = TreeDepth(pRoot.pLeft);
        int right = TreeDepth(pRoot.pRight);

        int diff = left - right;
        if (diff > 1 || diff < -1) {
            return false;
        }
        return IsBalanced(pRoot.pLeft) && IsBalanced(pRoot.pRight);
    }

    /*
     * 	�������ֱ�����ʽ��һ�����ᱻ�ظ��������,�������ú����������������������㡢�ҽ�㡢����㣬
     * 	�ڱ���һ�����֮ǰ���Ǿ��Ѿ���������������������ֻҪ�ڱ���ÿ������ʱ���¼������ȣ�ĳһ������ȵ�������Ҷ����·���ĳ��ȣ�
     * 	�������ǾͿ���һ�߱���һ���ж�ÿ������ǲ���ƽ���
     */

}
