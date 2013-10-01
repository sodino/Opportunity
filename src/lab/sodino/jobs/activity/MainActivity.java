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
		
	}

	private void showLoadingDialog(){
		Animatable anim = (Animatable)imgLoading.getDrawable();
		if(anim.isRunning() == false){
			anim.start();
		}
	}
}