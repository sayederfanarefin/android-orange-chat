package info.sayederfanarefin.chat.log;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import info.sayederfanarefin.chat.config.Config;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileLogger {

    private static ExecutorService executor = null;

    /**
     * Get the ExecutorService
     *
     * @return the ExecutorService
     */
    protected static ExecutorService getExecutor() {
        return executor;
    }


    protected static void log2file(final String path, final String str) {
        if (executor == null) {
            executor = Executors.newSingleThreadExecutor();
        }

        executor.execute(new Runnable() {
            @Override
            public void run() {
                PrintWriter out = null;

                File file = GetFileFromPath(path);

                try {
                    out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
                    out.println(str);
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (out != null) {
                        out.close();
                    }
                }
            }
        });
    }

    /**
     * Get File form the file path.<BR>
     * if the file does not exist, create it and return it.
     *
     * @param path the file path
     * @return the file
     */
    private static File GetFileFromPath(String path) {
        boolean ret;
        boolean isExist;
        boolean isWritable;
        File file = null;

        if (TextUtils.isEmpty(path)) {
            Log.e("Error", "The path of Log file is Null.");
            return file;
        }

        file = new File(path);

        isExist = file.exists();
        isWritable = file.canWrite();

        if (isExist) {
            if (isWritable) {
                //Log.i("Success", "The Log file exist,and can be written! -" + file.getAbsolutePath());
            } else {
                Log.e("Error", "The Log file can not be written.");
            }
        } else {
            //create the log file
            try {
                ret = file.createNewFile();
                if (ret) {
                    Log.i("Success", "The Log file was successfully created! -" + file.getAbsolutePath());
                } else {
                    Log.i("Success", "The Log file exist! -" + file.getAbsolutePath());
                }

                isWritable = file.canWrite();
                if (!isWritable) {
                    Log.e("Error", "The Log file can not be written.");
                }
            } catch (IOException e) {
                Log.e("Error", "Failed to create The Log file.");
                e.printStackTrace();
            }
        }

        return file;
    }

    public static void log(String message, Throwable tr) {
        LogFormatter.EclipseFormatter formatter = new LogFormatter.EclipseFormatter();
        String formatMsg = formatter.format(LogFormatter.LEVEL.DEBUG, Config.LOG_TAG, message, tr);
        String dataDirPath = Environment.getDataDirectory().getAbsolutePath();
//        File externalFilesDir = CoreApplication.getInstance().getExternalFilesDir(dataDirPath);
//        if (externalFilesDir != null) {
//            log2file(externalFilesDir.getAbsolutePath() + File.separator + getFileName(), formatMsg);
//        }
    }

    private static String getFileName() {
        return "log-" + new SimpleDateFormat("yyMMdd", Locale.ENGLISH).format(Calendar.getInstance().getTime()) + ".txt";
    }

}