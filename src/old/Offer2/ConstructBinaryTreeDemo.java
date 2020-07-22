package old.Offer2;


import old.Offer.BinaryTreeNode;

/**
 * @author WangZ
 * ����ǰ���������������ؽ�������
 * ����������кͺ���������У����Ƶķ������ؽ�����������ǰ��������кͺ���������в�ͬ�ָ�һ�ö�������
 */
public class ConstructBinaryTreeDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] midOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode root = ConstructBinaryTree(preOrder, midOrder);
    }

    public static BinaryTreeNode ConstructBinaryTree(int[] preOrder, int[] midOrder) {
        if (preOrder == null || midOrder == null) {
            return null;
        }

        //ǰ������ĵ�һ��ֵ���Ǹ��ڵ��ֵ
        BinaryTreeNode root = new BinaryTreeNode(preOrder[0]);
        root.pLeft = null;
        root.pRight = null;
//		System.out.println(root.val);
        // ���Ҹ��ڵ�����������е�λ�ã���������У����ڵ����Ϊ���������ұ�Ϊ������
        int rootPositionInMidOrder = -1;
        for (int i = 0; i < midOrder.length; i++) {
            System.out.println(midOrder[i]);
            if (midOrder[i] == root.val) {
                rootPositionInMidOrder = i;
                break;
            }
        }

        //������������û��ǰ������еĸ��ڵ��ֵ����ô�������
        if (rootPositionInMidOrder == -1) {
            throw new RuntimeException("�������");
        }


        //�ؽ�������
        //�������������
        int nodeNumLeft = rootPositionInMidOrder;
        //������ǰ�����������
        int[] preOrderLeft = new int[nodeNumLeft];
        for (int i = 1, j = 0; i < nodeNumLeft + 1; i++, j++) {
            preOrderLeft[j] = preOrder[i];
        }
        //�������������������
        int[] midOrderLeft = new int[nodeNumLeft];
        for (int i = 0; i < nodeNumLeft; i++) {
            preOrderLeft[i] = preOrder[i];
        }
        root.pLeft = ConstructBinaryTree(preOrderLeft, midOrderLeft);

        //�ؽ�������
        //�������������
        int nodeNumRight = preOrder.length - nodeNumLeft - 1;
        //������ǰ�����������
        int[] preOrderRight = new int[nodeNumRight];
        for (int j = 0, i = nodeNumRight; i < preOrder.length; i++, j++) {
            preOrderRight[j] = preOrder[i];
        }
        //�������������������
        int[] midOrderRight = new int[nodeNumRight];
        for (int i = rootPositionInMidOrder + 1, j = 0; i < preOrder.length; j++, i++) {
            midOrderRight[j] = midOrder[i];
        }

        root.pRight = ConstructBinaryTree(preOrder, midOrder);

        return root;
    }
}
