package old.Offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

/**
 * @author WangZ
 * ������35����һ��ֻ����һ�ε��ַ� 186ҳ
 * ��Ŀ�����ַ������ҳ���һ��ֻ����һ�ε��ַ���������"abaccdeff"�������"b"
 * ʹ�ù�ϣ��
 * ���ȣ������ַ������������ַ������ڹ�ϣ���У������valΪval+1����������ڣ�������ϣ��valΪ1
 * Ȼ���ٴα����ַ���������ÿ���ַ��ڹ�ϣ���д洢��val�����valΪ1���򷵻�����ַ���
 * �ڹ�ϣ���и���һ���ַ����ֵĴ�����ʱ��O(1)������ַ�������Ϊn,��ô����һ�ε�ʱ�临�Ӷ�ΪO(n)
 */
public class FirstNotRepeatingCharDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "abaccdeff";
        System.out.println(FirstNotRepeatingChar(str));
        System.out.println(FirstNotRepeatingChar2(str));
    }

    /*
     * ���ֽⷨ�ý���HashMap
     */
    public static char FirstNotRepeatingChar(String str) {
        if (str == null) {
            return '\0';
        }
        char res = '\0';
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            if (hm.containsKey(str.charAt(i))) {
                int val = hm.get(str.charAt(i));
                hm.put(str.charAt(i), (val + 1));
            } else {
                hm.put(str.charAt(i), 1);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (hm.get(str.charAt(i)) == 1) {
                res = str.charAt(i);
                break;
            }
        }

        return res;
    }

    /*
     * 	�ַ�char��һ������Ϊ8���������ͣ���˹���256�ֿ��ܣ����Դ���һ������Ϊ256�����飬ÿ����ĸ������ASCII��ֵ��Ϊ�������±�(0~255)��
     * 	�����д洢����ÿ���ַ����ֵĴ�����ͬ��Ҳ�����α���
     *
     *
     */
    public static char FirstNotRepeatingChar2(String str) {
        if (str == null) {
            return '\0';
        }
        int[] hashtable = new int[256];
        //��ʼ��
        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = 0;
        }
        //��һ�α�������ֵ
        for (int i = 0; i < str.length(); i++) {
            hashtable[(int) str.charAt(i)]++;
        }
        //�ڶ��α���
        for (int i = 0; i < str.length(); i++) {
            if (hashtable[(int) str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }

        return '\0';
    }

}
