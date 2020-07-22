package old.Offer;

public class SingletonDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

/*
 * ����ʽ��һ��������ͳ�ʼ��
 */
class Singleton1 {
    private static final Singleton1 instance = new Singleton1();

    private Singleton1() {
    }//�����캯��˽�л�

    //�ṩ�ⲿ���ʵĽӿ�
    public static Singleton1 getInstance() {
        return instance;
    }
}

/*
 * ����ʽ�������ڷ���������ʱ�Ŵ�����Ҳ����������ӳټ���
 */
class Singleton2 {
    private Singleton2() {
    }

    private static Singleton2 instance = null;

    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

/*
 *	������������ʽ�Ļ���ְ�ȫ���⣬���̷߳��ʵ�ʱ�򣬻ᴴ�����ʵ����
 *	���£�Ϊ�Ľ�,����
 */

class Singleton3 {
    private Singleton3() {
    }

    private static Singleton3 instance = null;

    public static Singleton3 getInstance() {
        if (instance == null) {//���ж�һ�Σ����Ч��
            synchronized (Singleton3.class) {//�ٴ��жϵ�ʱ�򣬼���
                if (instance == null) {
                    instance = new Singleton3();
                }

            }
        }
        return instance;
    }
}
