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

public class NewMainActivity extends Activity implements OnClickListener {
	// private TextView tv_text;
	private EditText et_name, et_pwd;
	private Button bt_login, bt_canl;
	private String name, pwd;
	private CheckBox cb_savepwd;
	private Context mContext;
	private String regitname, regitpwd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_newmain);
		initView();
	}

	private void initView() {
		mContext = NewMainActivity.this;
		et_name = (EditText) findViewById(R.id.et_name);
		et_pwd = (EditText) findViewById(R.id.et_pwd);
		cb_savepwd = (CheckBox) findViewById(R.id.cb_savepwd);
		bt_login = (Button) findViewById(R.id.bt_login);
		bt_login.setOnClickListener(this);
		bt_canl = (Button) findViewById(R.id.bt_canl);
		bt_canl.setOnClickListener(this);
		if (!SharedPreConfig.getInstance()
				.getValueByKey(mContext, IContent.USERNAME).equals("")) {
			et_name.setText(SharedPreConfig.getInstance().getValueByKey(
					mContext, IContent.USERNAME));
		}
		if (!SharedPreConfig.getInstance()
				.getValueByKey(mContext, IContent.PWD).equals("")) {
			et_pwd.setText(SharedPreConfig.getInstance().getValueByKey(
					mContext, IContent.PWD));
		}
		regitname = SharedPreConfig.getInstance().getValueByKey(mContext,
				IContent.REGITNAME);
		regitpwd = SharedPreConfig.getInstance().getValueByKey(mContext,
				IContent.REGITPWD);

	}

	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.bt_login:
			name = et_name.getText().toString();
			pwd = et_pwd.getText().toString();
			if (name.equals("")) {
				Toast.makeText(mContext, "用户名不能为空", Toast.LENGTH_SHORT).show();
			} else if (pwd.equals("")) {
				Toast.makeText(mContext, "密码不能为空", Toast.LENGTH_SHORT).show();
			} else {
				if (name.equals(regitname) && pwd.equals(regitpwd)) {
					// Toast.makeText(NewMainActivity.this, "��¼�ɹ�",
					// Toast.LENGTH_SHORT).show();
					if (cb_savepwd.isChecked()) {
						// �����û���
						SharedPreConfig.getInstance()
								.setValueByKey(mContext, IContent.USERNAME,
										name, IContent.FILE_SHAREPRE);
						// ��������
						SharedPreConfig.getInstance().setValueByKey(mContext,
								IContent.PWD, pwd, IContent.FILE_SHAREPRE);
					} else {
						SharedPreConfig.getInstance().clear(mContext,
								IContent.FILE_SHAREPRE);
					}

					startActivity(new Intent(mContext,
							RelativeTestActivity.class));
					// Intent intent=new Intent(mContext,TestActivity.class);
					// intent.putExtra("newName", name);
					// startActivity(intent);
				} else {
					Toast.makeText(mContext, "用户名或密码错误", Toast.LENGTH_SHORT)
							.show();
				}
			}
			break;
		case R.id.bt_canl:
			startActivity(new Intent(mContext, FirActivity.class));
			break;
		}
	}
}
