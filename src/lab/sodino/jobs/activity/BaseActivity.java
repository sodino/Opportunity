package lab.sodino.jobs.activity;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

import lab.sodino.jobs.app.BaseApplication;
import lab.sodino.jobs.app.JobsApp;
import android.os.Bundle;
import android.app.Activity;


/**仅做最基本的父类，做内存泄露分析用。
 * @author Sodino E-mail:sodino@qq.com
 * @version Time：2013年10月1日 下午5:07:22
 * */
public class BaseActivity extends Activity {
	/**标识当前Activity的简名，用于回收时判断。*/
	private String className = getClass().getSimpleName();
	/**存储生成过的仍未被回收的Activity。*/
	private static final ConcurrentLinkedQueue<String> queActivities = new ConcurrentLinkedQueue<String>();
	
	private JobsApp jobsApp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		BaseApplication application = (BaseApplication) getApplication();
		jobsApp = application.getJobsApp();
		queActivities.add(getClass().getSimpleName());
	}
	
	protected void finalize() throws Throwable{
		super.finalize();
		
		Iterator<String> iterator = queActivities.iterator();
		while(iterator.hasNext()){
			String name = iterator.next();
			if(className.equals(name)){
				iterator.remove();
				break;
			}
		}
	}

	
}