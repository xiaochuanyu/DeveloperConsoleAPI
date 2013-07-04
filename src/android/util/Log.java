package android.util;

public class Log {

	public static final int DEBUG = 0;
	public static final int WARN = 1;
	private static final int MAX_LEVEL = WARN;
	private static int level = WARN;

	public static void setLevel(int l) {
		if(l <= MAX_LEVEL && l >= 0)
			level = l;
	}

	public static int getLevel()
	{
		return level;
	}
	
	public static void w(String tag, String string, Exception e) {
		if (level <= WARN) {
			System.err.printf("WARN %s : %s\n", tag, string);
			e.printStackTrace();
		}
	}

	public static void d(String tag, String string) {
		if (level <= DEBUG) {
			System.out.printf("DEBUG %s : %s\n", tag, string);
		}
	}

}
