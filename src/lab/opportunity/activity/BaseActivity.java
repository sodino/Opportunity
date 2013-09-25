package lab.opportunity.activity;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

import android.os.Bundle;
import android.app.Activity;


/**����������ĸ��࣬���ڴ�й¶�����á�*/
public class BaseActivity extends Activity {
	/**��ʶ��ǰActivity�ļ��������ڻ���ʱ�жϡ�*/
	private String className = getClass().getSimpleName();
	/**�洢���ɹ�����δ�����յ�Activity��*/
	private static final ConcurrentLinkedQueue<String> queActivities = new ConcurrentLinkedQueue<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
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