package pojo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimePoint {
    public static void main(String[] args) {
        String beginTime = "2018-05-29 00:00:00";
        String endTime = "2018-05-31 00:00:00";
        System.out.println(getLeavePeriod(beginTime,endTime));
    }
    public static LocalDateTime stringToLocalDateTime(String dateTime) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return  LocalDateTime.parse(dateTime, df);
    }
    public static String toLocalDateWithPoint(String localDateTime){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return df.format(stringToLocalDateTime(localDateTime));
    }
    public static String toString(LocalDateTime localDateTime){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return df.format(localDateTime);
    }
    public static String getLeavePeriod(String beginTime,String endTime){
        String start = toLocalDateWithPoint(beginTime);
        String end = toLocalDateWithPoint(toString(stringToLocalDateTime(endTime).plusDays(-1)));
        return start+"-"+end;
    }
}
