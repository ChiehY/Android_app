package com.example.fff;

import content.IContent;
import content.SharedPreConfig;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ConActivity extends Activity implements OnClickListener {
	private TextView tv_xyname_detail, tv_xyage_detail, tv_xysex_detail,
			tv_xy_detail;
	private String xyname, xy, xyage, xysex;
	private Context mContext;
	private ImageView iv_xyback;
	private Button bt_photo, bt_code;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_conf);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		iv_xyback = (ImageView) findViewById(R.id.iv_xyback);
		iv_xyback.setOnClickListener(this);
		bt_photo = (Button) findViewById(R.id.bt_photo);
		bt_photo.setOnClickListener(this);
		bt_code = (Button) findViewById(R.id.bt_code);
		bt_code.setOnClickListener(this);
		mContext = ConActivity.this;
		xyname = SharedPreConfig.getInstance().getValueByKey(mContext,
				IContent.XYNAME);
		xy = SharedPreConfig.getInstance().getValueByKey(mContext, IContent.XY);
		xyage = SharedPreConfig.getInstance().getValueByKey(mContext,
				IContent.AGE);
		xysex = SharedPreConfig.getInstance().getValueByKey(mContext,
				IContent.SEX);
		tv_xyname_detail = (TextView) findViewById(R.id.tv_xyname_detail);
		tv_xyname_detail.setText("姓名:" + xyname);
		tv_xyage_detail = (TextView) findViewById(R.id.tv_xyage_detail);
		tv_xyage_detail.setText("年龄:" + xyage);
		tv_xysex_detail = (TextView) findViewById(R.id.tv_xysex_detail);
		tv_xysex_detail.setText("性别:" + xysex);
		tv_xy_detail = (TextView) findViewById(R.id.tv_xy_detail);
		tv_xy_detail.setText("交友宣言:" + xy);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.iv_xyback:
			finish();
		case R.id.bt_photo:
			startActivity(new Intent(mContext, PhotoActivity.class));
			break;
		case R.id.bt_code:
			startActivity(new Intent(mContext, BarCodeTestActivity.class));
			break;
		}
	}

}
