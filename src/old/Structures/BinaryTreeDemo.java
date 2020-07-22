package old.Structures;

import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = {20, 15, 6, 18, 3, 1, 9, 33, 30, 36};
        BinaryTree bst = new BinaryTree();
        for (int i : arr) {
            bst.insertBST(i);
        }
        bst.PreOrderTraverse(bst.root);
        System.out.println("************");
        bst.PreOrderTraverse2(bst.root);
	/*	bst.inOrderTraverse(bst.root);
		System.out.println("************");
		bst.AftOrderTraverse(bst.root);*/
        System.out.println("NodeNum : " + bst.getNodeNum(bst.root));
        System.out.println("Depth : " + bst.GetDepth(bst.root));
    }

}


class BinaryTree {
    class Node {
        int data;
        Node pLeft;
        Node pRight;

        public Node(int data) {
            this.data = data;
            pLeft = null;
            pRight = null;
        }
    }

    public Node root;//���ڵ�

    public void insertBST(int data) {//�ڶ����������в�������
        Node node = new Node(data);
        if (root == null) {
            //��ʱû��Ԫ��
            root = node;
            root.pLeft = null;
            root.pRight = null;
        } else {
            Node current = root;
            Node parent = null;
            while (true) {
                if (data < current.data) {//��������С�����ĸ�����ֵ
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

    public void PreOrderTraverse(Node node) {//ǰ�����--���ȸ�����,ͨ���ݹ鷽ʽ
        if (node == null) {//����
            return;
        }
        System.out.println(node.data);
        PreOrderTraverse(node.pLeft);
        PreOrderTraverse(node.pRight);
    }

    public void PreOrderTraverse2(Node node) {//ǰ�����--���ȸ�����,ͨ���ǵݹ鷽ʽ��������ջ
        LinkedList<Node> ll = new LinkedList<Node>();
        ll.offerFirst(node);
        while (!ll.isEmpty()) {
            Node tmpNode = ll.pollFirst();
            System.out.println(tmpNode.data);

            if (tmpNode.pRight != null) {
                ll.offerFirst(tmpNode.pRight);
            }

            if (tmpNode.pLeft != null) {
                ll.offerFirst(tmpNode.pLeft);
            }
        }
    }

    public void inOrderTraverse(Node node) {//�������,ͨ���ݹ鷽ʽ
        if (node == null) {//����
            return;
        }
        inOrderTraverse(node.pLeft);
        System.out.println(node.data);
        inOrderTraverse(node.pRight);
    }

    public void AftOrderTraverse(Node node) {//�������,ͨ���ݹ鷽ʽ
        if (node == null) {//����
            return;
        }
        AftOrderTraverse(node.pLeft);
        AftOrderTraverse(node.pRight);
        System.out.println(node.data);
    }

    public void LevelTraverse(Node node) {//������ȱ�����˳��Ϊ�������£���������

    }

    /*
     * 	 ��������еĽڵ����:
     * 	˼·����1�����������Ϊ�գ��ڵ����Ϊ0
                ��2�������������Ϊ�գ��������ڵ���� = �������ڵ���� + �������ڵ���� + 1
     */
    public int getNodeNum(Node node) {
        if (node == null) {//�ݹ����
            return 0;
        }
        return getNodeNum(node.pLeft) + getNodeNum(node.pRight) + 1;
    }

    /*
     * �����������ȣ�
     * 	1.���������Ϊ�գ����Ϊ0
     *	2.�����������Ϊ�գ����Ϊmax(��������ȣ����������)+1
     */
    public int GetDepth(Node node) {
        if (node == null) {//�ݹ����
            return 0;
        }
        int depthLeft = GetDepth(node.pLeft);
        int depthRight = GetDepth(node.pRight);

        return Math.max(depthLeft, depthRight) + 1;
    }

    /*
     * �ǵݹ�ʵ��ǰ�����
     */
}