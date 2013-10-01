package lab.sodino.jobs.task;

import java.io.UnsupportedEncodingException;

import lab.sodino.util.DownloadInfo;
import lab.sodino.util.LogOut;
import lab.sodino.util.NetworkUtil;

/**
 * @author Sodino E-mail:sodino@qq.com
 * @version Time：2013年10月1日 下午5:07:22
 * */
public class JobsDownloadTask extends AbstractTask {
	/**jobs的json文件*/
//	public static final String JOBS_JSON_URL = "http://sodino.com/jobs.json";
	private static final String JOBS_JSON_URL = "http://m.baidu.com/";
	
	public JobsDownloadTask() {
		
	}
	
	@Override
	public void run(){
		DownloadInfo info = new DownloadInfo();
		info.urlOriginal = JOBS_JSON_URL;
		info.dataAction = DownloadInfo.ACTION_READ;
		NetworkUtil.downloadByJava(info);
		if(info.resultCode == NetworkUtil.DOWNLOAD_SUCCESS){
			String detail = null;
			if(info.respContentEncoding != null && info.respContentEncoding.length() > 0){
				try {
					detail = new String(info.data, info.respContentEncoding);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}	
			}
			if(detail == null){
				detail = new String(info.data);
			}
			LogOut.out(this, "detail("+info.respContentEncoding+")[" + new String(info.data) +"]");
		}else{
			LogOut.out(this, "resultCode=" + info.resultCode +" err=" + info.errorDetail);
		}
	}
}