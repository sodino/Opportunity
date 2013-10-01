package lab.sodino.jobs.app;

import android.app.Application;
import android.content.Context;
/**
 * @author Sodino E-mail:sodino@qq.com
 * @version Time：2013年10月1日 下午5:07:22
 */
public class BaseApplication extends Application {
	private static Context context;
	
	private JobsApp jobsApp;
	
	public void onCreate(){
		super.onCreate();
		jobsApp = new JobsApp();
		context = this;
	}
	
	/**提供给下载、本地存储使用，避免内存泄露。*/
	public static Context getContext(){
		return context;
	}
	
	public JobsApp getJobsApp(){
		return jobsApp;
	}
}
