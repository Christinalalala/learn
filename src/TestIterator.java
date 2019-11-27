import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestIterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("234");
        list.add("345");
        list.add("456");
        list.add("789");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String temp = iterator.next();
            if ("345".equals(temp)){
                iterator.remove();
            }
        }
        list.forEach(x-> System.out.println(x));

        Integer label = 1;
        for (int i = label;i<list.size();i++){
            System.out.println("--");
        }
        System.out.println(label);
    }
}
