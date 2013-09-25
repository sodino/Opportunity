package lab.opportunity.util;

public class LogOut {
	public static final String LOG_TAG = "ANDROID_LAB";
	/**
	 * �������������<br/>
	 * ���������<br/>
	 * 08-10 09:40:24.940: DEBUG/ANDROID_LAB(28558):
	 * lab.sodino.androidlab.MainActivity->call onCreate() <br/>
	 * added by sodino
	 * 
	 * @param Object
	 *            obj ���õ���������ࡣ���ھ�̬����ʱ��ֱ���ø�������������String���и�ֵ��
	 * @param String
	 *            info ���������Ϣ��
	 * */
	public static void out(String info) {
		android.util.Log.d(LOG_TAG, getClassNameByStackIndex(4) + "->" + info);
	}

	public static void out(Object obj, String info) {
		if (obj instanceof String) {
			android.util.Log.d(LOG_TAG, ((String) obj) + "->" + info);
		} else {
			android.util.Log.d(LOG_TAG, obj.getClass().toString().substring(6) + "->" + info);
		}
	}
	
	/**
	 * ����������������������ڶ�ʱ�����д�����ͬ��ʽ����ͬ���ݵ�������ڷ����еĵڶ������������ø���Tag�ɽ���Щ���ƵĴ������ݹ��ൽһ��ȫ�µ�Tag��
	 * ������Tag��Ϣ�Ĳ��ҡ�<br/>
	 * ���������<br/>
	 * 08-10 09:40:24.940: DEBUG/ANDROID_LAB_TAG(28558):
	 * lab.sodino.androidlab.MainActivity
	 * ->img1[http://www.sodino.com/dsfwetrtssd/lskdfjs.jpg respondCode=200] <br/>
	 * added by sodino
	 * 
	 * @param Object
	 *            obj ���õ���������ࡣ���ھ�̬����ʱ��ֱ���ø�������������String���и�ֵ��
	 * @param String
	 *            tag ������Tag��
	 * @param String
	 *            info ���������Ϣ��
	 * */
	public static void out(String tag, String info) {
		android.util.Log.d(LOG_TAG + "_" + tag, getClassNameByStackIndex(4) + "->" + info);
	}

	public static void out(Object obj, String tag, String info) {
		if (obj instanceof String) {
			android.util.Log.d(LOG_TAG + "_" + tag, ((String) obj) + "->" + info);
		} else {
			android.util.Log.d(LOG_TAG + "_" + tag, obj.getClass().toString().substring(6) + "->" + info);
		}
	}

	public static String getClassNameByStackIndex(int index) {
		StackTraceElement[] traces = Thread.currentThread().getStackTrace();
		if (index < 0 || index >= traces.length) {
			return "";
		}
		String name = traces[index].getClassName();
		String method = traces[index].getMethodName();
		return name;
	}

	// ��log�ĺ�����������������ĺ����������ں���ջ�ĵ�5��
	public static int e(String msg) {
		return android.util.Log.d(LOG_TAG,getClassNameByStackIndex(4)+"->"+msg);
	}
}