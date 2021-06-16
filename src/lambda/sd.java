package lambda;

import java.util.ArrayList;
import java.util.List;

public class sd {

    public static List<Integer> getTransportDistribution(int num, int time, int[] arr) {
        List<Integer> result = new ArrayList<>();
        List<Integer> list = getRightOrder(num, time);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < arr.length; i++) {
                if (list.get(i).equals(arr[j])) {
                    result.add(arr[j]);
                } else {
                    result.add(0);
                }
            }
        }
        return result;
    }


    public static List<Integer> getRightOrder(int num, int time) {
        List<Integer> list = new ArrayList<>();
        int order = 1;
        for (int i = 0; i < num; i++) {
            list.add(order);
            if (order > time) {
                order = 1;
            } else {
                order++;
            }
        }
        return list;
    }
}


