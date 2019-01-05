package info.ankon.template.log;

import com.androidnetworking.error.ANError;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import info.ankon.template.config.Config;

public class Tracer {

    public static void v(String message, Object... args) {
        Logger.v(message, args);
    }

    public static void d(String message, Object... args) {
        Logger.d(message, args);
        writeLog(null, message, args);
    }

    public static void i(String message, Object... args) {
        Logger.i(message, args);
        writeLog(null, message, args);
    }

    public static void w(String message, Object... args) {
        Logger.w(message, args);
        writeLog(null, message, args);
    }

    public static void e(String message, Object... args) {
        Logger.e(message, args);
        writeLog(null, message, args);
    }

    public static void e(ANError error) {
        String message;
        if (error.getErrorCode() != 0) {
            message = "ErrorCode: " + error.getErrorCode() +
                    "||ErrorBody: " + error.getErrorBody() +
                    "||ErrorDetail: " + error.getErrorDetail();
        } else {
            message = "ErrorDetail: " + error.getErrorDetail();
        }
        Logger.e(message);
        writeLog(null, message);
    }

    public static void e(Throwable throwable, String message, Object... args) {
        Logger.e(throwable, message, args);
        writeLog(throwable, message, args);
    }


    public static void wtf(String message, Object... args) {
        Logger.wtf(message, args);
    }

    public static void json(String message) {
        Logger.json(message);
    }

    private static void writeLog(Throwable thr, String message, Object... args) {
        message = args.length == 0 ? message : String.format(message, args);
        FileLogger.log(message, thr);
    }

    public static void init() {
        Logger
                .init(Config.LOG_TAG)
                .setMethodCount(1)
                .setMethodOffset(1)
                .hideThreadInfo()
                // RELEASE: Use LogLevel.NONE for the release version
                .setLogLevel(LogLevel.FULL);
    }

}