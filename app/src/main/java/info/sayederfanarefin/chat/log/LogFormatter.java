package info.sayederfanarefin.chat.log;

import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Locale;

public abstract class LogFormatter {
    /**
     * format the log.
     *
     * @param level
     * @param tag
     * @param msg
     * @return
     */
    public abstract String format(LEVEL level, String tag, String msg, Throwable tr);

    /**
     * Eclipse Style
     */
    public static class EclipseFormatter extends LogFormatter{
        private final SimpleDateFormat formatter;

        public EclipseFormatter(){
            formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.US);
        }

        public EclipseFormatter(String formatOfTime){
            if (TextUtils.isEmpty(formatOfTime)){
                formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.US);
            }else{
                formatter = new SimpleDateFormat(formatOfTime, Locale.US);
            }
        }

        @Override
        public String format(LEVEL level, String tag, String msg, Throwable tr) {
            if (level == null || TextUtils.isEmpty(tag) || TextUtils.isEmpty(msg)){
                return "";
            }

            StringBuffer buffer = new StringBuffer();
            buffer.append(level.getLevelString());
            buffer.append("\t");
            buffer.append(formatter.format(System.currentTimeMillis()));
            buffer.append("\t");
            buffer.append(android.os.Process.myPid());
            buffer.append("\t");
            buffer.append(android.os.Process.myTid());
            buffer.append("\t");
            buffer.append(tag);
            buffer.append("\t");
            buffer.append(msg);
            if (tr != null) {
                buffer.append(System.getProperty("line.separator"));
                buffer.append(android.util.Log.getStackTraceString(tr));
            }

            return buffer.toString();
        }
    }


    public enum LEVEL {
        VERBOSE(2, "V"),
        DEBUG(3, "D"),
        INFO(4, "I"),
        WARN(5, "W"),
        ERROR(6, "E"),
        ASSERT(7, "A");

        final String levelString;
        final int level;

        //Supress default constructor for noninstantiability
        LEVEL() {
            throw new AssertionError();
        }

        LEVEL(int level, String levelString) {
            this.level = level;
            this.levelString = levelString;
        }

        public String getLevelString() {
            return this.levelString;
        }

        public int getLevel() {
            return this.level;
        }
    }
}