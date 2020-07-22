package old.Offer;

/**
 * @author WangZ
 * ������26����������ĸ��� 147ҳ
 * ��Ŀ������һ�����������ڸ��������У�ÿ����������һ��pNextָ��ָ����һ������⣬����һ��pSiblingָ�������е����������NULL
 */
public class CloneNodesDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    /*
     * һ������
     */
    public static ComplexListNode Clone(ComplexListNode pHead) {
        CloneNodes(pHead);
        ConnectSiblingNodes(pHead);
        return ReconnectNodes(pHead);
    }

    /*
     * ��һ��������ԭʼ�����ÿ�����N������Ӧ��N`����N`������N�ĺ���
     */
    public static void CloneNodes(ComplexListNode pHead) {
        ComplexListNode pNode = pHead;
        while (pNode != null) {
            ComplexListNode pCloned = new ComplexListNode();
            pCloned.val = pNode.val;
            pCloned.pNext = pNode.pNext;
            pCloned.pSibling = null;

            pNode.pNext = pCloned;

            pNode = pCloned.pNext;
        }
    }

    /*
     * �ڶ��������ø��Ƴ����Ľ���pSibling������ԭʼ�����ϵ�N��pSiblingָ����S,
     * ��ô���Ӧ���Ƴ�����N`��N��pNextָ��Ľ�㣬ͬ��S`Ҳ��S��pNextָ��Ľ��
     */
    public static void ConnectSiblingNodes(ComplexListNode pHead) {
        ComplexListNode pNode = pHead;
        while (pNode != null) {
            ComplexListNode pCloned = pNode.pNext;
            if (pCloned.pSibling != null) {
                pCloned.pSibling = pNode.pSibling.pNext;
            }

            pNode = pCloned.pNext;
        }
    }

    /*
     * ����������������ѳ������ֳ���������������λ�õĽ����pNext������������ԭʼ����
     * ��ż��λ�õĽ�㣬��pNext�����������Ǹ��Ƴ����Ľ��
     */
    public static ComplexListNode ReconnectNodes(ComplexListNode pHead) {
        ComplexListNode pNode = pHead;
        ComplexListNode pClonedHead = null;
        ComplexListNode pClonedNode = null;
        if (pNode != null) {
            pClonedNode = pClonedHead = pHead.pNext;
            //�����м��Clone�Ľ��
            pNode.pNext = pClonedNode.pNext;
            pNode = pNode.pNext;
        }
        /*
         * pNodeһֱ��pCloned�ĺ���
         */
        while (pNode != null) {
            pClonedNode.pNext = pNode.pNext;
            pClonedNode = pClonedNode.pNext;
            pNode.pNext = pClonedNode.pNext;
            pNode = pNode.pNext;
        }

        return pClonedHead;
    }
}

class ComplexListNode {
    int val;
    ComplexListNode pNext;
    ComplexListNode pSibling;

    public ComplexListNode() {

    }
}
