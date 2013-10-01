package lab.sodino.util;

import java.io.File;

/**
 * @author Sodino E-mail:sodino@qq.com
 * @version Time：2013年10月1日 下午5:07:22
 * */
public class DownloadInfo {
	/**���ֱ�Ӷ����ڴ档<br/>*/
	public static final int ACTION_READ = 1;
	/**���ֱ�Ӵ浽���ء�<br/>*/
	public static final int ACTION_SAVE = 2;

	
	/**��¼ԭʼ��url��*/
	public String urlOriginal;
	/**��ʶ��ǰ������*/
	public int task;
	public String respContentEncoding; 
	public String respContentType; 
	public int respContentLength; 
	public int respCode; 
	/**��ǰ���ӵĽ��*/
	public int resultCode;

	/**�洢ֱ������ʱ��ȡ������ݡ�<br/>
	 * ���ڶ���ݡ�<br/>*/
	public byte[] data;
	/**
	 * @see ACTION_READ
	 * @see ACTION_SAVE
	 * */
	public int dataAction = ACTION_SAVE;
	/**���ڼ�¼��ǰ���ز�����Ҫ����ı���·����*/
	public File file;
	/**��¼���ع���з�����쳣���顣*/
	public String errorDetail;
}