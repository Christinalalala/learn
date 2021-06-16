package function;

import java.util.function.Function;

public class demo01 {
    public static void main(String[] args) {
        //输出输入的值
//        Function function = new Function<String,String>() {
//            @Override
//            public String apply(String o) {
//                return o;
//            }
//        };
        Function function = str -> {
            return str;
        };
        System.out.println(function.apply("asd"));
    }
}
