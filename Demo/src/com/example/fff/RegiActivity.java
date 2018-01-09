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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegiActivity extends Activity implements OnClickListener {
	private EditText et_name, et_pwd;
	private Button bt_con, bt_canl;
	private String name, pwd;
	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reg);
		initView();
	}

	private void initView() {
		mContext = RegiActivity.this;
		et_name = (EditText) findViewById(R.id.et_name);
		et_pwd = (EditText) findViewById(R.id.et_pwd);
		bt_con = (Button) findViewById(R.id.bt_con);
		bt_con.setOnClickListener(this);
		bt_canl = (Button) findViewById(R.id.bt_canl);
		bt_canl.setOnClickListener(this);
	}

	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.bt_con:
			name = et_name.getText().toString();
			pwd = et_pwd.getText().toString();
			if (name.equals("") || pwd.equals("")) {
				Toast.makeText(mContext, "帐户或密码不能为空", Toast.LENGTH_SHORT)
						.show();
			} else {

				SharedPreConfig.getInstance().setValueByKey(mContext,
						IContent.REGITNAME, name, IContent.FILE_SHAREPRE);

				SharedPreConfig.getInstance().setValueByKey(mContext,
						IContent.REGITPWD, pwd, IContent.FILE_SHAREPRE);

				startActivity(new Intent(mContext, NewMainActivity.class));
			}
			break;
		case R.id.bt_canl:
			Toast.makeText(mContext, "你点击了取消", Toast.LENGTH_SHORT).show();
			finish();
			break;
		}
	}
}
