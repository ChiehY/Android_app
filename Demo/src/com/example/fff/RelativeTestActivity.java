package com.example.fff;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class RelativeTestActivity extends Activity implements OnClickListener {
	private ImageView iv_back, iv_cloth, iv_dining, iv_store, iv_del;
	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_relativemain);
		initView();

	}

	private void initView() {
		// TODO Auto-generated method stub
		mContext = RelativeTestActivity.this;
		iv_back = (ImageView) findViewById(R.id.iv_back);
		iv_back.setOnClickListener(this);
		iv_cloth = (ImageView) findViewById(R.id.iv_cloth);
		iv_cloth.setOnClickListener(this);
		iv_dining = (ImageView) findViewById(R.id.iv_dining);
		iv_dining.setOnClickListener(this);
		iv_store = (ImageView) findViewById(R.id.iv_store);
		iv_store.setOnClickListener(this);
		iv_del = (ImageView) findViewById(R.id.iv_del);
		iv_del.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.iv_cloth:
			startActivity(new Intent(mContext, ClothActivity.class));
			break;
		case R.id.iv_dining:
			startActivity(new Intent(mContext, SecActivity.class));
			break;
		case R.id.iv_store:
			startActivity(new Intent(mContext, ChatActivity.class));
			break;
		case R.id.iv_del:
			startActivity(new Intent(mContext, LIUActivity.class));
			break;
		case R.id.iv_back:
			finish();
		}
	}
}