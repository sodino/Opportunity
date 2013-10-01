package lab.sodino.jobs.task;

/**所有耗时工作的父类.*/
public abstract class AbstractTask implements Runnable{
	public static final int SUCCESS = 1;
	protected int result;
	
	public int getResult(){
		return SUCCESS;
	}
	
	
}
