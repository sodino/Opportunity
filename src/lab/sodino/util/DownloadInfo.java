package lab.sodino.util;

import java.io.File;

public class DownloadInfo {
	/**数据直接读到内存。<br/>*/
	public static final int ACTION_READ = 1;
	/**数据直接存到本地。<br/>*/
	public static final int ACTION_SAVE = 2;

	
	/**记录原始的url。*/
	public String urlOriginal;
	/**标识当前的任务。*/
	public int task;
	public String respContentEncoding; 
	public String respContentType; 
	public int respContentLength; 
	public int respCode; 
	/**当前链接的结果。*/
	public int resultCode;

	/**存储直接下载时获取到的数据。<br/>
	 * 用于短数据。<br/>*/
	public byte[] data;
	/**
	 * @see ACTION_READ
	 * @see ACTION_SAVE
	 * */
	public int dataAction = ACTION_SAVE;
	/**用于记录当前下载操作所要保存的本地路径。*/
	public File file;
	/**记录下载过程中发生的异常详情。*/
	public String errorDetail;
}