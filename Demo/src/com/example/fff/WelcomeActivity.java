package com.example.fff;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

public class WelcomeActivity extends Activity {
	Handler mhandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		initView();
	}

	private void initView() {
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		mhandler = new Handler() {
			public void handleMessage(Message msg) {
				startActivity(new Intent(WelcomeActivity.this,
						IntroductionActivity.class));
				overridePendingTransition(R.menu.push_left_in,
						R.menu.push_left_out);
				finish();
			}
		};
		mhandler.sendEmptyMessageDelayed(0, 2000);

	}

}
