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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecActivity extends Activity implements OnClickListener {
	// private TextView tv_text;
	private EditText et_xy, et_xyname, et_sex, et_age;
	private Button bt_xy, bt_ret;
	private Context mContext;
	private String xy, xyname, xysex, xyage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_se);
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		mContext = SecActivity.this;
		et_xy = (EditText) findViewById(R.id.et_xy);
		et_xyname = (EditText) findViewById(R.id.et_xyname);
		et_sex = (EditText) findViewById(R.id.et_sex);
		et_age = (EditText) findViewById(R.id.et_age);
		bt_xy = (Button) findViewById(R.id.bt_xy);
		bt_xy.setOnClickListener(this);
		bt_ret = (Button) findViewById(R.id.bt_ret);
		bt_ret.setOnClickListener(this);
		// if (!SharedPreConfig.getInstance()
		// .getValueByKey(mContext, IContent.XYNAME).equals("")) {
		// et_xyname.setText(SharedPreConfig.getInstance().getValueByKey(
		// mContext, IContent.XYNAME));
		// }
		// if (!SharedPreConfig.getInstance()
		// .getValueByKey(mContext, IContent.SEX).equals("")) {
		// et_sex.setText(SharedPreConfig.getInstance().getValueByKey(
		// mContext, IContent.SEX));
		// }
		// if (!SharedPreConfig.getInstance()
		// .getValueByKey(mContext, IContent.AGE).equals("")) {
		// et_age.setText(SharedPreConfig.getInstance().getValueByKey(
		// mContext, IContent.AGE));
		// }
		// if (!SharedPreConfig.getInstance()
		// .getValueByKey(mContext, IContent.XY).equals("")) {
		// et_xy.setText(SharedPreConfig.getInstance().getValueByKey(
		// mContext, IContent.XY));
		// }
	}

	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.bt_xy:
			xy = et_xy.getText().toString();
			xyname = et_xyname.getText().toString();
			xyage = et_age.getText().toString();
			xysex = et_sex.getText().toString();
			if (xy.equals("") || xyname.equals("") || xyage.equals("")
					|| xysex.equals("")) {
				Toast.makeText(mContext, "输入内容为空", Toast.LENGTH_SHORT).show();
			} else {

				SharedPreConfig.getInstance().setValueByKey(mContext,
						IContent.XYNAME, xyname, IContent.FILE_SHAREPRE);

				SharedPreConfig.getInstance().setValueByKey(mContext,
						IContent.XY, xy, IContent.FILE_SHAREPRE);
				SharedPreConfig.getInstance().setValueByKey(mContext,
						IContent.AGE, xyage, IContent.FILE_SHAREPRE);

				SharedPreConfig.getInstance().setValueByKey(mContext,
						IContent.SEX, xysex, IContent.FILE_SHAREPRE);

				startActivity(new Intent(mContext, ConActivity.class));
			}
			break;
		case R.id.bt_ret:
			Toast.makeText(mContext, "你点击了取消", Toast.LENGTH_SHORT).show();
			finish();
			break;
		}
	}
}
