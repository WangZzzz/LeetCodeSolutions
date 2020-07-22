package old.Structures;

/*
 *	�ѣ�һ����ȫ��������������ÿ��������Ů��˫�׽�����Ŷ����Ը��ݵ�ǰ�������ֱ�����
 *	Parent(i) = i/2;
 *	Left(i) = 2 * i;
 *	Right(i) = 2 * i + 1;
 *	�ѣ�heap������ȫ����������Ԫ�صļ�ֵ�������������ʣ��Ӹ������Ҷ�����κ�·���ϵļ�ʱ�ǵ�����---����������
 *	ÿ����ȫ��������Ҫ���������Ȼӳ�䣬ӳ��ʵ������ͨ���Զ�������һ�ηֲ�����õ���,�ڽ�������У�λ��i����
 *	�����λ���±�i/2�����ӽ��ֱ�λ��2i��2i+1��
 *
 *	��ȫ��������������ӳ���ϵ��˫��ģ����Ҫ������Ԫ�ع����Ӧ����ȫ�����������Ƚ������һ��Ԫ��ӳ��Ϊ�������ĸ���
 *		Ȼ���շֲ�����������ι����������������Ȼ�������±�i�е����ݸ��Ƶ���i����㡣
 *
 *	Ϊ��ȷ���������Ƿ���ж����ʣ������Ƚ���ת���ɶ�������Ȼ������֤ÿһ���ɸ��ڵ㵽Ҷ��·���Ƿ���������
 *	�߱������ʵ������ǡ���������ġ����������д󲿷ּ�ֵ���Ԫ�ض�λ�ڼ�ֵС��Ԫ�ص�ǰ�棬��׼ȷ��˵���������У�ÿ����·�������鶼��
 *	�ǵ�������ġ�
 *
 *	�ѵĲ��룺
 *	������в�����Ԫ��ʱ����Ԫ�����ǲ��뵽���²㣬��Ϊ���ұߵ�Ҷ��㣬Ȼ�������Ԫ�ؽ����ʵ���������ʹ�����ٱ����ĸ����������ѵ�
 *		���ʾ͵���ά����
 *
 *	�ѵ�ɾ����
 *		�ѵ�ɾ�����Ǵ�����ɾ����Ԫ�أ������ǣ��öѵ����һ��Ҷ��������ڵ㣬�����µĸ���㲻���½���ֱ�������ٱ������ӽ��СΪֹ���ѵ�
 *		�����ֵ��Ա��֡�
 *	����в���Ԫ�ػ��ߴӶ���ɾ��Ԫ�ص�ʱ�临�Ӷ���O(logn)
 */
public class MaxHeap {
    int[] heap;
    int heapsize;

    //���캯��
    public MaxHeap(int[] array) {
        this.heap = array;
        this.heapsize = array.length;
    }

    public void BuildMaxHeap() {
        for (int i = heapsize / 2 - 1; i >= 0; i--) {
            Maxify(i);//�������Ͻ���ǰ�������ѻ�
        }
    }

    //������
    public void HeapSort() {
        for (int i = 0; i < heap.length; i++) {
            //ִ��n�Σ���ÿ����ǰ����ֵ�ŵ�ĩβ
            int tmp = heap[0];
            heap[0] = heap[heapsize - 1];
            heap[heapsize - 1] = tmp;
            heapsize--;
            Maxify(0);
        }
    }

    public void Maxify(int i) {
        int l = Left(i);
        int r = Right(i);
        int largeset;

        if (l < heapsize && heap[l] > heap[i])
            largeset = l;
        else
            largeset = i;

        if (r < heapsize && heap[r] > heap[largeset])
            largeset = r;
        if (largeset == i || largeset >= heapsize) {
            //���largest����i˵��i�����Ԫ�أ�larges����i�ķ�Χ˵�������ڱ�i�������Ů
            return;
        }
        int tmp = heap[i];
        heap[i] = heap[largeset];
        heap[largeset] = tmp;
        Maxify(largeset);
    }

    public void IncreaseValue(int i, int val) {
        heap[i] = val;
        if (i >= heapsize || i <= 0 || heap[i] >= val) {
            return;
        }
        int p = Parent(i);
        if (heap[p] >= val)
            return;
        heap[i] = heap[p];
        IncreaseValue(p, val);
    }

    private int Parent(int i) {
        return (i - 1) / 2;
    }

    private int Left(int i) {
        return 2 * (i + 1) - 1;
    }

    private int Right(int i) {
        return 2 * (i + 1);
    }
}
