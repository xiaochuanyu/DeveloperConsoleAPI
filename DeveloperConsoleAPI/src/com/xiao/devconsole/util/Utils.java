package com.xiao.devconsole.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * Utility class for simple helper methods.
 */
public final class Utils {

	private static final int MAX_STACKTRACE_CAUSE_DEPTH = 5;

	/** Private constructor. */
	private Utils() {
	}

	public static String stackTraceToString(Throwable e) {
		return stackTraceToString(e, 0);
	}

	public static String stackTraceToString(Throwable e, int depth) {
		StringBuilder sb = new StringBuilder();
		for (StackTraceElement element : e.getStackTrace()) {
			sb.append(element.toString());
			sb.append("\n");
		}
		if (depth < MAX_STACKTRACE_CAUSE_DEPTH && e.getCause() != null) {
			// While there is an underlying cause below the max depth, append it
			return sb.toString() + stackTraceToString(e.getCause(), ++depth);
		}
		return sb.toString();
	}


	public static void getAndSaveToFile(URL url, File file) throws IOException {
		InputStream is = null;
		FileOutputStream fos = null;

		try {
			HttpURLConnection c = (HttpURLConnection) url.openConnection();
			c.setRequestMethod("GET");
			c.connect();

			is = c.getInputStream();
			fos = new FileOutputStream(file);

			byte[] buffer = new byte[1024];
			int read = 0;
			while ((read = is.read(buffer)) != -1) {
				fos.write(buffer, 0, read);
			}
		} finally {
			if (is != null) {
				is.close();
			}
			if (fos != null) {
				fos.close();
			}
		}
	}
	public static long timestampWithoutMillis(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTimeInMillis();
	}

	// the console uses the 'en-US' format
	public static String getDisplayLocale() {
		return String.format("%s-%s", Locale.getDefault().getLanguage(), Locale.getDefault()
				.getCountry());
	}

	private static final SimpleDateFormat DB_DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public static synchronized Date parseDbDate(String string) {
		try {
			return DB_DATE_FORMAT.parse(string);
		} catch (ParseException e) {
			return null;
		}
	}

	public static synchronized String formatDbDate(Date date) {
		return DB_DATE_FORMAT.format(date);
	}

}
