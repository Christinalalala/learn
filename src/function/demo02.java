package function;

import java.util.function.Predicate;

public class demo02 {
    public static void main(String[] args) {
        //判断字符串是否为空
//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String str) {
//                return str == null || str.isEmpty() ;
//            }
//        };
        Predicate<String> predicate = str -> {
            return str == null || str.isEmpty();
        };
        System.out.println(predicate.test("df"));
    }
}
