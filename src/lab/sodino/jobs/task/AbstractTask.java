package lab.sodino.jobs.task;
/**所有耗时工作的父类.
 * @author Sodino E-mail:sodino@qq.com
 * @version Time：2013年10月1日 下午5:07:22
 */
public abstract class AbstractTask implements Runnable{
	public static final int SUCCESS = 1;
	protected int result;
	
	public int getResult(){
		return SUCCESS;
	}
	
}
