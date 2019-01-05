package info.sayederfanarefin.chat.helpers;

import android.content.Context;

import info.sayederfanarefin.chat.log.Tracer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil {

    private static Calendar calendar = Calendar.getInstance();

    public static DateFormat getReadableDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    }

    public static DateFormat getReadableMonthAndYear() {
        return new SimpleDateFormat("yyyy-MM", Locale.getDefault());
    }

    public static DateFormat getReportDateTimeFormat() {
        return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.getDefault());
    }

    public static DateFormat getDeviceDateTimeFormat() {
        return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.getDefault());
    }

    public static DateFormat getDayMonthDateFormat() {
        return new SimpleDateFormat("MMM dd");
    }

    public static String getMonth(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM", Locale.getDefault());
        try {
            Date date1 = sdf.parse(date);
            return String.valueOf(date1.getMonth());
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getYear(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM", Locale.getDefault());
        try {
            Date date1 = sdf.parse(date);
            return String.valueOf(date1.getYear() + 1900);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String buildDatePickerStringDate(int year, int month, int dayOfMonth) {
        String m;
        String d;
        if (++month < 10) m = "0" + month;
        else m = String.valueOf(month);

        if (dayOfMonth < 10) d = "0" + dayOfMonth;
        else d = String.valueOf(dayOfMonth);
        return year + "-" + m + "-" + d;
    }

    public static String buildDatePickerStringDate(int year, int month) {
        String m;
        if (++month < 10) m = "0" + month;
        else m = String.valueOf(month);

        return year + "-" + m;
    }

    public static String getServerDateTime() {
        Calendar c = Calendar.getInstance();
        return SimpleDateFormat.getDateInstance().format(c.getTime());
    }

    public static String getTime() {
        Calendar c = Calendar.getInstance();
        return SimpleDateFormat.getTimeInstance().format(c.getTime());
    }

    public static String getServerDateTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(date);
    }

    public static String getUserDateTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM, yyyy hh:mm:ss a", Locale.getDefault());
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(date);
    }

    public static String getUserTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a", Locale.getDefault());
        // sdf.setTimeZone(TimeZone.getDefault());
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Dhaka"));
        return sdf.format(date);
    }

    public static String getUserDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM, yyyy", Locale.getDefault());
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(date);
    }

    public static String getLocalDateTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM, yyyy hh:mm:ss a", Locale.getDefault());
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Dhaka"));
        return sdf.format(date);
    }

    public static boolean isSameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }

    public static String getShortDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM", Locale.getDefault());
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(date);
    }

    public static int getAge(Date date) {
        if (date == null) return 0;
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date);
        return cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
    }

//    public static int getAgeInMonths(Date birthDay) {
//        LocalDate birthdate = new LocalDate(birthDay);
//        LocalDate now = new LocalDate();
//        return Months.monthsBetween(birthdate, now).getMonths();
//    }

    public static Date toDate(Context context, String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            Tracer.e("CANNOT PARSE DATE FROM STRING" + e.toString());
        }
        return date;
    }

    public static Date addHour(Date date, int hour) {
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hour);
        return calendar.getTime();
    }

}