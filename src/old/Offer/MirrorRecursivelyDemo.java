package old.Offer;

import javax.xml.soap.Node;

/*
 *	������19������������ ��125ҳ
 *	��Ŀ�������һ������������һ�����������ú���������ľ���
 *	���������෴
 *	˼·���ڱ�������ͬʱ��������Ҷ�ڵ�������ӽڵ�
 *	Ҷ�ڵ㣺û���ӽڵ�Ľ��
 *	��ǰ������������ÿ����㣬����������Ľ�����ӽ�㣬�ͽ������������ӽڵ㣬
 *		�����������з�Ҷ�ӽ��֮�󣬾͵õ������ľ���
 */
public class MirrorRecursivelyDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BinaryTree bt = new BinaryTree();
        bt.insertBST(5);
        bt.insertBST(8);
        bt.insertBST(3);
        bt.insertBST(10);
        bt.insertBST(6);
        bt.insertBST(1);
        preOrder(bt.root);
        System.out.println("***********");
        MirrorRecursively(bt.root);
        preOrder(bt.root);
    }

    public static void preOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        preOrder(node.pLeft);
        preOrder(node.pRight);
    }

    public static void MirrorRecursively(BinaryTreeNode node) {
        if (node == null)
            return;
        if (node.pLeft == null && node.pRight == null) {
            //���һ�����������ӽ���Ϊnull,��ΪҶ�ڵ㣬����Ҫ����
            return;
        }

        //��ʱ��㱣������
        BinaryTreeNode tmpNode = node.pLeft;
        node.pLeft = node.pRight;
        node.pRight = tmpNode;

        if (node.pLeft != null) {//�������ӽ��
            MirrorRecursively(node.pLeft);
        }

        if (node.pRight != null) {//�������ӽ��
            MirrorRecursively(node.pRight);
        }

    }
}
