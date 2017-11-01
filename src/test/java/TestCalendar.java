import java.util.Calendar;

/**
 * Created by Niu Qianghong on 2017-11-01 0001.
 */
public class TestCalendar {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int endMon = calendar.get(Calendar.MONTH) + 1;
        int endDay = calendar.get(Calendar.DAY_OF_MONTH);
        String endTime = calendar.get(Calendar.YEAR) + "-" + (endMon < 10 ? "0" + endMon : endMon) + "-" + (endDay < 10 ? "0" + endDay : endDay);
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        int startMon = calendar.get(Calendar.MONTH) + 1;
        int startDay = calendar.get(Calendar.DAY_OF_MONTH);
        String startTime = calendar.get(Calendar.YEAR) + "-" + (startMon < 10 ? "0" + startMon : startMon) + "-" + (startDay < 10 ? "0" + startDay : startDay); // 前一天
        System.out.println("endTime = " + endTime);
        System.out.println("startTime = " + startTime);
    }
}
