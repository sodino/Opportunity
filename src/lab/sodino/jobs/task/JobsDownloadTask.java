package lab.sodino.jobs.task;

import java.io.UnsupportedEncodingException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import lab.sodino.util.LogOut;
import lab.sodino.util.filesys.FileUtil;
import lab.sodino.util.filesys.LocalDataInfo;
import lab.sodino.util.network.DownloadInfo;
import lab.sodino.util.network.NetworkUtil;

/**
 * 完成文件下载
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
		String detail = download();
		if(detail == null){
			LogOut.out(this,"download fail, detail is null.");
			return;
		}
		parseJson(detail);
	}
	
	private String download(){
		DownloadInfo info = new DownloadInfo();
		info.urlOriginal = JOBS_JSON_URL;
		info.dataAction = DownloadInfo.ACTION_READ;
		NetworkUtil.downloadByJava(info);
		String detail = null;
		if(info.resultCode == NetworkUtil.DOWNLOAD_SUCCESS){
			if(info.respContentEncoding != null && info.respContentEncoding.length() > 0){
				try {
					detail = new String(info.data, info.respContentEncoding);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}	
			}
			if(detail == null){
				/////////////////////////////////////////////////////////////////////
//				detail = new String(info.data);
				LocalDataInfo localInfo = new LocalDataInfo();
				localInfo.reqAction = LocalDataInfo.ACTION_READ;
				localInfo.reqPath = "/sdcard/bao/demo.json";
				FileUtil.read(localInfo);
				if(localInfo.result == FileUtil.RESULT_SUCCESS){
					detail = new String(localInfo.data);
				}else{
					LogOut.out(this, "FileUtil.result=" + localInfo.result);
				}
				/////////////////////////////////////////////////////////////////////
			}
			
			LogOut.out(this, "detail("+info.respContentEncoding+")[" + detail +"]");
		}else{
			LogOut.out(this, "resultCode=" + info.resultCode +" err=" + info.errorDetail);
		}
		return detail;
	}
	
	private void parseJson(String detail){
		if(detail == null){
			return;
		}
		
		try {
			JSONObject jObj = new JSONObject(detail);
			boolean hasCode = jObj.has("code");
			if(!hasCode){
				LogOut.out(this,"hasCode is false.");
				return;
			}
			JSONArray jArr = jObj.getJSONArray("jobs");
			LogOut.out(this,"jArr.len=" + jArr.length());
			for(int i = 0;i < jArr.length();i ++){
				JSONObject jTmp = jArr.getJSONObject(i);
				String name = jTmp.getString("name");
				String place = jTmp.getString("place");
				String category = jTmp.getString("category");
				String duty = jTmp.getString("duty");
				String require = jTmp.getString("require");
				LogOut.out(this,"name[" + name+"]place[" + place +"]category[" + category+"]duty[" + duty+"]require[" + require+"]");
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}