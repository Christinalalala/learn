package single;

public class StaticInnerClass {

    private StaticInnerClass() {

    }

    public static StaticInnerClass getInstance() {
        return InnerClass.STATIC_INNER_CLASS;
    }

    public static class InnerClass {
        private static final StaticInnerClass STATIC_INNER_CLASS = new StaticInnerClass();
    }
}
