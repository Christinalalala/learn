import java.math.RoundingMode;
import java.text.NumberFormat;

public class TestNumberFormat {
    public static void main(String[] args) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        nf.setRoundingMode(RoundingMode.HALF_UP);
        double number = (double) 10/ (double) 3;
        System.out.println(number);
        System.out.println(nf.format(number));
        System.out.println(String.format("%.2f",number));
    }
}
