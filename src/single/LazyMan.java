package single;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class LazyMan {

    private static Boolean flag = false;

    private volatile static LazyMan lazyMan;

    private LazyMan() {
        synchronized (LazyMan.class) {
            if (flag == false) {
                flag = true;
            } else {
                throw new RuntimeException("不要试图用反射破坏单例");
            }
        }
    }

    public static LazyMan getInstance() {
        if (lazyMan == null) {
            synchronized (LazyMan.class) {
                if (lazyMan == null) {
                    lazyMan = new LazyMan();
                    //不是一个原子性操作
                    //1.分配内存空间
                    //2.执行构造方法 初始化对象
                    //3.把这个对象指向这个空间

                    //123
                    //132 A
                    //    B  //此时lazyMan还没有完成构造
                }
            }
        }
        return lazyMan;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Field flag = LazyMan.class.getDeclaredField("flag");
        flag.setAccessible(true);

        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        LazyMan instance1 = declaredConstructor.newInstance();
        flag.set(instance1, false);
        LazyMan instance2 = declaredConstructor.newInstance();

        System.out.println(instance1);
        System.out.println(instance2);
    }
}
