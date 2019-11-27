import pojo.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {

        Student stuA = new Student(1, "A", "M", 184);
        Student stuB = new Student(0, "B", "G", 163);
        Student stuC = new Student(0, "C", "M", 175);
        Student stuD = new Student(1, "D", "G", 158);
        Student stuE = new Student(0, "E", "M", 170);
        List<Student> list = new ArrayList<>();
        list.add(stuA);
        list.add(stuB);
        list.add(stuC);
        list.add(stuD);
        list.add(stuE);

        ArrayList temp = new ArrayList();
        temp = (ArrayList) list.stream().filter(x->x.getNo() == 0).collect(Collectors.toList());

        System.out.println("乌拉"+temp.toString());

        //Iterator迭代器遍历
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            Student stu = iterator.next();
            if (stu.getSex().equals("G")) {
                System.out.println("Iterator迭代器遍历:");
                System.out.println(stu.toString());
            }
        }
        //双冒号操作符
        System.out.println("=====双冒号操作符==========");
        list.forEach(Student::getSex);

        //stream聚合操作
        list.stream()
                .filter(student -> student.getSex().equals("G"))
                .forEach(student -> System.out.println("stream聚合操作：" + student.toString()));
        list.stream()
                .filter(student -> student.getSex().equals("G"))
                .count();

        List<String> list5 = new ArrayList<>();
        String art = "23434";
        list5.add(art);
        list5.forEach(k -> System.out.println(k));
    }
}
