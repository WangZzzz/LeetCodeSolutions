package old.Offer;

import java.util.Arrays;

/*	������6����55ҳ,ǰ���������{1,2,4,7,3,5,6,8} �������{4,7,2,1,5,3,8,6}
 * 	����ǰ���������������Ľ�����ؽ�������
 * 	1.ǰ������ĵ�һ��ֵ��һ���Ǹ��ڵ��ֵ
 * 	2.��������У�1���ҵ��ĸ��ڵ��ֵ����࣬�����������������ֵ���Ҳ������������������ֵ
 * 	3.�ݹ�
 */
public class RebuildBinaryTreeDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
/*		int[] preOrder = {1,2,4,7,3,5,6,8};
		int[] inOrder = {4,7,2,1,5,3,8,6};*/
        int[] preOrder = {1, 2, 3, 4};
        int[] inOrder = {4, 3, 2, 1};
        MyBinaryTree.Node root = MyBinaryTree.rebuildBinaryTree(preOrder, inOrder, preOrder.length);
        MyBinaryTree.preOrder(root);
        System.out.println("*******");
        MyBinaryTree.inOrder(root);
        System.out.println("*******");
        MyBinaryTree.aftOrder(root);
    }

}

class MyBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node() {
        }

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public Node root;//���ڵ�

    public MyBinaryTree() {
        // TODO Auto-generated constructor stub
        root = null;
    }

    /*
     * ����ǰ���������������Ľ�����ؽ�������
     * 	�ݹ�ⷨ��
     *	1.���ǰ�����Ϊ�ջ��������Ϊ�ջ�ڵ����С�ڵ���0������NULL��
     *	2.�������ڵ㡣ǰ������ĵ�һ�����ݾ��Ǹ��ڵ�����ݣ�������������ҵ����ڵ��λ�ã��ɷֱ��֪����������������ǰ��������
     *	�����У��ؽ���������
     */
    public static Node rebuildBinaryTree(int[] preOrder, int[] inOrder, int nodeNum) {
        if (preOrder == null || inOrder == null || nodeNum <= 0) {
            return null;
        }
	/*	for(int i : preOrder){
			System.out.print(i + "");
		}
		System.out.println();
		for(int i : inOrder){
			System.out.print(i + "");
		}
		System.out.println();*/
        Node root = new Node();
        root.data = preOrder[0];//ǰ������ĵ�һ��ֵΪ���ڵ��ֵ
        root.left = null;
        root.right = null;
        int rootPositionInOrder = -1;//���ڵ�����������е�λ��
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == preOrder[0]) {
                rootPositionInOrder = i;
                break;
            }
        }

        if (rootPositionInOrder == -1) {
            throw new RuntimeException("�������д���");
        }

        int nodeNumLeft = rootPositionInOrder;//�������Ľڵ������������������и��ڵ���ߵ����ָ���
        //��ԭ��������н�ȡ���������������
        int[] preOrderLeft = Arrays.copyOfRange(preOrder, 1, rootPositionInOrder + 1);
        //��ԭ��������н�ȡ���������������
        int[] inOrderLeft = Arrays.copyOfRange(inOrder, 0, rootPositionInOrder);
        root.left = rebuildBinaryTree(preOrderLeft, inOrderLeft, nodeNumLeft);

        int nodeNumRight = nodeNum - rootPositionInOrder - 1;//�������Ľڵ����
        //��ԭ��������н�ȡ���������������
        int[] preOrderRight = Arrays.copyOfRange(preOrder, nodeNum - rootPositionInOrder - 1, nodeNum);
        //��ԭ��������н�ȡ���������������
        int[] inOrderRight = Arrays.copyOfRange(inOrder, rootPositionInOrder + 1, nodeNum);
        root.right = rebuildBinaryTree(preOrderRight, inOrderRight, nodeNumRight);

        return root;
    }

    public static void preOrder(Node node) {
        if (node == null) {//����
            return;
        } else {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void inOrder(Node node) {
        if (node == null) {//����
            return;
        } else {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }

    public static void aftOrder(Node node) {
        if (node == null) {//����
            return;
        } else {
            aftOrder(node.left);
            aftOrder(node.right);
            System.out.println(node.data);
        }
    }
}
