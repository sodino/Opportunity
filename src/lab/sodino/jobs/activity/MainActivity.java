package lab.sodino.jobs.activity;

import lab.sodino.jobs.R;
import lab.sodino.jobs.app.TAG;
import lab.sodino.jobs.db.data.Job;
import lab.sodino.jobs.task.JobsDownloadTask;
import lab.sodino.util.LogOut;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends BaseActivity {
	private ImageView imgLoading;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imgLoading = (ImageView)findViewById(R.id.imgLoading);
		showLoadingDialog();
//		new Thread(new JobsDownloadTask()).start();
		
		LogOut.out(TAG.ACT_MAIN, "test");
	}

	private void showLoadingDialog(){
		Animatable anim = (Animatable)imgLoading.getDrawable();
		if(anim.isRunning() == false){
			anim.start();
		}
	}
}