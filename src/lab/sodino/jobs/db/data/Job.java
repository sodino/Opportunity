package lab.sodino.jobs.db.data;

/**
 * @author Sodino E-mail:sodino@qq.com
 * @version Time：2013年10月15日 下午4:41:04
 */
public class Job extends Esse {
	@unique
	public String name;
	public String place;
	public String category;
	public String duty;
	public String require;
}
