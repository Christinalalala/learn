package thread;

public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new You("张三"));
        weddingCompany.happyMarry();
    }
}

interface Mary {
    void happyMarry();
}

class You implements Mary {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public You(String name) {
        this.name = name;
    }

    public You() {
    }

    @Override
    public void happyMarry() {
        System.out.println(name + "结婚了！");
    }
}

class WeddingCompany implements Mary {

    private static Mary target;

    public WeddingCompany(Mary target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        this.target.happyMarry();
        after();
    }

    private void after() {
        System.out.println("收费");
    }

    private void before() {
        System.out.println("布置现场");
    }
}