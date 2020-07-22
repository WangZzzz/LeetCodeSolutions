package old.Other;

import java.util.Stack;

/**
 * @author WangZ
 * ����ƥ�䣺
 * ����һ���ַ���������������
 * �Ϸ���() {} [] ([]) {[()]}
 * ���Ϸ���(] ([)]
 * ˼·��ʹ��ջ�����
 */
public class BracketsDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "{[())]}";
        System.out.println(isValid(str));
    }

    public static boolean isValid(String str) {
        if (str == null) {
            return false;
        }

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < str.length(); i++) {
            if (stack.isEmpty()) {
                //���ջ�ǿյ�
                stack.push(str.charAt(i));
            } else if ((stack.peek() == '(' && str.charAt(i) == ')') || (stack.peek() == '[' && str.charAt(i) == ']')
                    || (stack.peek() == '{' && str.charAt(i) == '}')) {
                //˵����ʱջ���ַ����ǿյ�,���ҺϷ�������ջ��Ԫ�أ�����i++
                stack.pop();
            } else {
                //˵���ַ�����[()]���ֻ�����͵�
                stack.push(str.charAt(i));
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
