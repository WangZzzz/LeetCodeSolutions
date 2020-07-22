package old.Offer;

import java.util.Arrays;

/**
 * @author WangZ
 * ������42����ת����˳�� VS �����ַ��� 218ҳ
 * ��Ŀһ������һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵��������ַ���˳�򲻱䣬Ϊ�˼�����������ź���ͨ��ĸһ���������������ַ�����
 * ��I am a student�����������student. a am I��
 * <p>
 * ��Ŀ�����ַ���������ת�����ǰ��ַ���ǰ������ɵ��ַ�ת�Ƶ��ַ�����β�����붨��һ������ʵ���ַ������������Ĺ��ܣ����������ַ���
 * ��abcdefg��������2���ú�������������ת2λ�õ��Ľ����cdefgab��
 */
public class ReverseSentenceDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[] str = "I am a student.".toCharArray();
/*		Reverse(str, 0, str.length - 1);
		System.out.println(Arrays.toString(str));*/
        ReverseSentence(str);
        System.out.println(str);

        char[] str2 = "abcdefg".toCharArray();
        LeftRoateString(str2, 2);
        System.out.println(str2);
    }

    //˼·���ȷ�ת�������ӣ��ٷ�ת�����е�ÿ�����ʣ�ʹ�ÿո��ʶһ������
    public static void ReverseSentence(char[] str) {
        if (str == null) {
            return;
        }

        int begin = 0;
        int end = str.length - 1;
        //��ת��������
        Reverse(str, begin, end);

        //��ת�����е�ÿ������
        for (int i = 0, j = 0; i < str.length; i++) {
            if (str[i] == ' ') {
//				System.out.println("@@");
                Reverse(str, j, i - 1);
                j = i + 1;
            }
        }
    }

    //��ת�ַ���
    public static void Reverse(char[] str, int begin, int end) {
        if (str == null || str.length <= 0 || begin > end || begin < 0 || end >= str.length) {
            return;
        }

        while (begin < end) {
            char tmp = str[begin];
            str[begin] = str[end];
            str[end] = tmp;

            begin++;
            end--;
        }
    }

    //��Ŀ�������Խ�������ķ�ת�ַ������ȷֱ�ת�����֣�Ȼ��ת�����ַ���
    public static void LeftRoateString(char[] str, int n) {
        if (str == null || str.length <= 0 || n < 1 || n > str.length) {
            return;
        }

        //ǰ���������ַ���
        char[] tmp1 = new char[n];
        char[] tmp2 = new char[str.length - n];
        //��ԭ����ֱ�ֵ������������
        int i = 0;
        for (i = 0; i < n; i++) {
            tmp1[i] = str[i];
        }

        for (int j = 0; i < str.length; i++, j++) {
            tmp2[j] = str[i];
        }

        //�ֱ�ת��������
        Reverse(tmp1, 0, tmp1.length - 1);
        Reverse(tmp2, 0, tmp2.length - 1);

        //�ٰ���������ϲ���ԭ����
        for (i = 0; i < n; i++) {
            str[i] = tmp1[i];
        }

        for (int j = 0; j < tmp2.length; j++, i++) {
            str[i] = tmp2[j];
        }

        //��ת��������
        Reverse(str, 0, str.length - 1);

    }

}
