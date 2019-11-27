package Util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class TimeUtil {
    private TimeUtil(){}
    public static LocalDate stringToDateTime(String date){
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    public static LocalDateTime stringToLocalDateTime(String dateTime){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dateTime,df);
    }
    public static String localDateTimeToString(LocalDateTime time) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
        return df.format(time);
    }
    public static String supply(String string){
        if (string.length()==4){
            return "0"+string;
        }
        return string;
    }
    public static LocalDateTime getDateBeginTime(String dateTime){
        return stringToLocalDateTime(dateTime.split(" ")[0]+" "+"00:00:00");
    }
    public static String localDateTimeToHourAndMinute(LocalDateTime time) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
        return df.format(time);
    }
}
