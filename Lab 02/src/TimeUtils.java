import java.util.Calendar;
import java.util.Date;

public class TimeUtils {
    public static long now() {
        Calendar cal = Calendar.getInstance();
        Date currentTimeMillis = cal.getTime();

        return currentTimeMillis.getTime();
        // return System.currentTimeMillis();
    }
}
