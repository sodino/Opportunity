package lab.sodino.util.filesys;
/**
 * 用于本地数据读取时，存储操作信息。
 * @author Sodino E-mail:sodino@qq.com
 * @version Time：2013年10月15日 下午2:53:25
 */
public class LocalDataInfo {
	/**数据读取操作。<br/>*/
	public static final int ACTION_READ = 1;
	/**数据写出操作。<br/>*/
	public static final int ACTION_WRITE = 2;
	/**标识是读或写*/
	public int reqAction;
	/**标识要操作的本地文件路径。*/
	public String reqPath;
	public byte[] data;
	/**最后的操作结果。
	 * 值为0时表示成功。*/
	public int result;
	
	
	
	
}
