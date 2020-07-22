package old.Offer;

/*
 * 	������27��������������˫������	151ҳ
 * 	��Ŀ������һ�Ŷ��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬
 * 	ֻ�ܵ������н��ָ���ָ��
 * 	��������������㣬����㡢�ҽ�㣬���ô�С����
 * �ݹ�ⷨ��
 *	��1�����������������Ϊ�գ�����Ҫת������Ӧ˫������ĵ�һ���ڵ���NULL�����һ���ڵ���NULL
 *	��2����������������Ϊ�գ�
 *		���������Ϊ�գ���Ӧ˫����������ĵ�һ���ڵ��Ǹ��ڵ㣬��߲���Ҫ����������
 *		�����������Ϊ�գ�ת���������������������Ӧ˫����������ĵ�һ���ڵ����������ת����˫����������ĵ�һ���ڵ�,ͬʱ�����ڵ��������ת�����˫�������� ������һ���ڵ����ӣ�
 *		���������Ϊ�գ���Ӧ˫��������������һ���ڵ��Ǹ��ڵ㣬�ұ߲���Ҫ����������
 *		�����������Ϊ�գ���Ӧ˫��������������һ���ڵ����������ת����˫��������������һ���ڵ㣬ͬʱ�����ڵ��������ת�����˫����������ĵ�һ���ڵ�����
 *
 *	��ת��������˫������ʱ��ԭ��ָ�����ӽ���ָ�����Ϊ������ָ��ǰһ������ָ�룬
 *		ԭ��ָ�����ӽ���ָ�����Ϊ������ָ����һ������ָ��
 */
public class ConvertDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BinaryTree bt = new BinaryTree();
        bt.insertBST(10);
        bt.insertBST(6);
        bt.insertBST(14);
        bt.insertBST(4);
        bt.insertBST(8);
        bt.insertBST(12);
        bt.insertBST(16);

        MidOrder(bt.root);
        System.out.println("**********");
        BinaryTreeNode node = Convert(bt.root);
        BinaryTreeNode current = node;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.pLeft;
        }

    }

    /*
     * �������
     */
    public static void MidOrder(BinaryTreeNode node) {
        if (node != null) {
            MidOrder(node.pLeft);
            System.out.println(node.val);
            MidOrder(node.pRight);
        }
    }

    public static BinaryTreeNode Convert(BinaryTreeNode pRootOfTree) {
        BinaryTreeNode pLastNodeInList = null;
        ConvertNode(pRootOfTree, pLastNodeInList);

        //pLastNodeInListָ��˫�������β���
        //������Ҫ����ͷ���
        BinaryTreeNode pHeadOfList = pLastNodeInList;
        while (pHeadOfList != null && pHeadOfList.pLeft != null) {
            pHeadOfList = pHeadOfList.pLeft;
        }
        return pHeadOfList;
    }

    public static void ConvertNode(BinaryTreeNode pNode, BinaryTreeNode pLastNodeInList) {
        if (pNode == null)
            return;

        BinaryTreeNode pCurrent = pNode;

        if (pCurrent.pLeft != null) {
            ConvertNode(pCurrent.pLeft, pLastNodeInList);
        }

        pCurrent.pLeft = pLastNodeInList;
        if (pLastNodeInList != null) {
            pLastNodeInList.pRight = pCurrent;
        }

        pLastNodeInList = pCurrent;

        if (pCurrent.pRight != null) {
            ConvertNode(pCurrent.pRight, pLastNodeInList);
        }
    }
}
