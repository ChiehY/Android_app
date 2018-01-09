package com.example.fff;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class ClothActivitydetail extends Activity implements OnClickListener {
	private TextView tv_clothname_detail, tv_clothcolor_detail,
			tv_clothsize_detail, tv_clothprice_detail;
	private String name, color, size, price;
	private ImageView iv_back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clothdetail);
		initView();

	}

	private void initView() {
		// TODO Auto-generated method stub
		iv_back = (ImageView) findViewById(R.id.iv_back);
		iv_back.setOnClickListener(this);
		name = getIntent().getStringExtra("clothname");
		color = getIntent().getStringExtra("clothcolor");
		size = getIntent().getStringExtra("clothsize");
		price = getIntent().getStringExtra("clothprice");
		tv_clothname_detail = (TextView) findViewById(R.id.tv_cloth_clothname_detail);
		tv_clothname_detail.setText("昵称:" + name);
		tv_clothcolor_detail = (TextView) findViewById(R.id.tv_cloth_clothcolor_detail);
		tv_clothcolor_detail.setText("性别:" + color);
		tv_clothsize_detail = (TextView) findViewById(R.id.tv_cloth_clothsize_detail);
		tv_clothsize_detail.setText("年龄:" + size);
		tv_clothprice_detail = (TextView) findViewById(R.id.tv_cloth_clothprice_detail);
		tv_clothprice_detail.setText("宣言:" + price);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.iv_back:
			finish();
		}
	}
}
