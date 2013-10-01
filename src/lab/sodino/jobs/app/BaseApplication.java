package lab.sodino.jobs.app;

import android.app.Application;
import android.content.Context;

public class BaseApplication extends Application {
	private static Context context;
	
	public void onCreate(){
		super.onCreate();
		context = this;
	}
	
	/**提供给下载、本地存储使用，避免内存泄露。*/
	public static Context getContext(){
		return context;
	}
}
