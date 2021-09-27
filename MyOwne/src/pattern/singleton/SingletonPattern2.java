package pattern.singleton;

public class SingletonPattern2 {
    private static volatile SingletonPattern2 instance;//声明成 volatile

    private SingletonPattern2() {

    }

    public static SingletonPattern2 getInstance() {
        if (instance == null) {
            synchronized (SingletonPattern2.class) {
                if (instance == null) {
                    instance = new SingletonPattern2();
                }
            }
        }
        return instance;
    }
}
