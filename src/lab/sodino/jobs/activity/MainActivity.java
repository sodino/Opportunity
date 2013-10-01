package lab.sodino.jobs.activity;

import java.io.UnsupportedEncodingException;

import lab.sodino.jobs.R;
import lab.sodino.jobs.activity.BaseActivity;
import lab.sodino.jobs.app.JobsConstant;
import lab.sodino.util.DownloadInfo;
import lab.sodino.util.LogOut;
import lab.sodino.util.NetworkUtil;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends BaseActivity {
	private ImageView imgLoading;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imgLoading = (ImageView)findViewById(R.id.imgLoading);
		showLoadingDialog();
		
		new Thread(){
			public void run(){
				DownloadInfo info = new DownloadInfo();
				info.urlOriginal = JobsConstant.JOBS_JSON_URL;
				info.dataAction = DownloadInfo.ACTION_READ;
				NetworkUtil.downloadByJava(MainActivity.this, info);
				if(info.resultCode == NetworkUtil.DOWNLOAD_SUCCESS){
					String detail = null;
					if(info.respContentEncoding != null && info.respContentEncoding.length() > 0){
						try {
							detail = new String(info.data, info.respContentEncoding);
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
					}
					if(detail == null){
						detail = new String(info.data);
					}
					LogOut.out(MainActivity.this, "detail("+info.respContentEncoding+")[" + new String(info.data) +"]");
				}else{
					LogOut.out(MainActivity.this, "resultCode=" + info.resultCode +" err=" + info.errorDetail);
				}
			}
		}.start();
	}

	private void showLoadingDialog(){
		Animatable anim = (Animatable)imgLoading.getDrawable();
		if(anim.isRunning() == false){
			anim.start();
		}
	}
}