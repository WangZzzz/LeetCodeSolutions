package old.Offer;

import java.util.LinkedList;
import java.util.Queue;

/*
 * ����������������������Ԫ�ز�����ʱ�临�Ӷ���O(logn)
 */
public class BinaryTree {
    BinaryTreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void insertBT(int data) {
        //��ȫ�������в�������
        BinaryTreeNode node = new BinaryTreeNode(data);

        if (root == null) {
            root = node;
        } else {
            LinkedList<BinaryTreeNode> ll = new LinkedList<BinaryTreeNode>();
            ll.offerFirst(root);
            while (!ll.isEmpty()) {
                BinaryTreeNode temp = ll.pollLast();
                if (temp.pLeft == null) {
                    temp.pLeft = node;
                    return;
                } else if (temp.pRight == null) {
                    temp.pRight = node;
                    return;
                } else {
                    ll.offerFirst(temp.pLeft);
                    ll.offerFirst(temp.pRight);
                }
            }
        }
    }

    public void insertBST(int data) {//�ڶ����������в�������
        BinaryTreeNode node = new BinaryTreeNode(data);
        if (root == null) {
            //��ʱû��Ԫ��
            root = node;
            root.pLeft = null;
            root.pRight = null;
        } else {
            BinaryTreeNode current = root;
            BinaryTreeNode parent = null;
            while (true) {
                if (data < current.val) {//��������С�����ĸ�����ֵ
                    parent = current;
                    current = current.pLeft;
                    if (current == null) {//˵���ҵ����һ����
                        parent.pLeft = node;
                        break;
                    }
                } else {//��������ֵ���Ǵ��ڵ������ĸ�����ֵ
                    parent = current;
                    current = current.pRight;
                    if (current == null) {
                        parent.pRight = node;
                        break;
                    }
                }
            }
        }
    }
}
