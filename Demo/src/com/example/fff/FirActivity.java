package com.example.fff;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class FirActivity extends Activity implements OnClickListener {
	private Button bt_login1, bt_regi1;
	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_firmain);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		mContext = FirActivity.this;
		bt_login1 = (Button) findViewById(R.id.bt_login1);
		bt_login1.setOnClickListener(this);
		bt_regi1 = (Button) findViewById(R.id.bt_regi1);
		bt_regi1.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.bt_login1:
			startActivity(new Intent(mContext, NewMainActivity.class));
			break;
		case R.id.bt_regi1:
			startActivity(new Intent(mContext, RegiActivity.class));
		}
	}
}
