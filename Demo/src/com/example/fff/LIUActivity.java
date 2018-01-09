package com.example.fff;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

//import com.admob.zkapp.covers.Covers;

public class LIUActivity extends Activity implements OnClickListener {

	private ListView listMessage;
	private ImageView ivSend;
	private List<Message> list = new ArrayList<Message>();;
	private Dialog dialog;
	private EditText et_comment;
	MyAdapter adapter = new MyAdapter();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_liu);

		// Covers c = new Covers(this, "ab51d5a3cb4d45bbae9e8de9e43a432e");

		ivSend = (ImageView) findViewById(R.id.ivAdd);
		listMessage = (ListView) findViewById(R.id.listMessage);
		// initData();
		listMessage.setAdapter(new MyAdapter());
		ivSend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showCommentDialog();
			}
		});
	}

	class MyAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ViewHolder holder = null;
			View view = null;
			if (convertView == null) {
				view = view.inflate(LIUActivity.this, R.layout.item_adapter,
						null);
				holder = new ViewHolder();
				holder.tvMessage = (TextView) view.findViewById(R.id.message);
				holder.tvTime = (TextView) view.findViewById(R.id.tvTime);
				holder.ivAnswer = (ImageView) view.findViewById(R.id.iv_answer);
				holder.ivAnswer.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						// showAnswerDialog();
					}
				});
				view.setTag(holder);
			} else {
				view = convertView;
				holder = (ViewHolder) view.getTag();
			}
			holder.tvMessage.setText(list.get(position).getMessage());
			holder.tvTime.setText(list.get(position).getTime());
			return view;
		}
	}

	class ViewHolder {
		TextView tvMessage;
		TextView tvTime;
		ImageView ivAnswer;
	}

	private void showCommentDialog() {
		dialog = new Dialog(this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		View v = View.inflate(this, R.layout.dialog_comment, null);
		dialog.setContentView(v);
		ImageView comment_cancel = (ImageView) v
				.findViewById(R.id.comment_cancel);
		ImageView comment_fb = (ImageView) v.findViewById(R.id.comment_fb);
		et_comment = (EditText) v.findViewById(R.id.et_comment);
		comment_cancel.setOnClickListener(this);
		comment_fb.setOnClickListener(this);
		Window dialogWindow = dialog.getWindow();
		// WindowManager.LayoutParams lp = dialogWindow.getAttributes();
		dialogWindow.setGravity(Gravity.TOP);

		/*
		 * 将对话框的大小按屏幕大小的百分比设置
		 */
		WindowManager m = getWindowManager();
		Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
		WindowManager.LayoutParams p = dialogWindow.getAttributes(); //
		p.y = DpUtils.dip2px(this, 70);
		// p.gravity
		// 获取对话框当前的参数值
		// p.height = DpUtils.dip2px(this, 300); // 高度设置为屏幕的0.6
		// p.width = DpUtils.dip2px(this, 150); // 宽度设置为屏幕的0.65
		dialogWindow.setAttributes(p);
		dialog.show();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.comment_cancel:
			dialog.cancel();
			break;
		case R.id.comment_fb:
			String Msg = et_comment.getText().toString();
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy年MM月dd日 HH:mm:ss ");
			Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
			String time = formatter.format(curDate);
			Message message = new Message();
			message.setMessage(Msg);
			message.setTime(time);
			list.add(0, message);
			adapter.notifyDataSetChanged();
			dialog.cancel();
			break;
		}
	}

	private void showAnswerDialog() {
		dialog = new Dialog(this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		View v = View.inflate(this, R.layout.dialog_answer, null);
		dialog.setContentView(v);
		ImageView comment_cancel = (ImageView) v
				.findViewById(R.id.comment_cancel);
		ImageView comment_fb = (ImageView) v.findViewById(R.id.comment_fb);
		et_comment = (EditText) v.findViewById(R.id.et_comment);
		comment_cancel.setOnClickListener(this);
		comment_fb.setOnClickListener(this);
		Window dialogWindow = dialog.getWindow();
		// WindowManager.LayoutParams lp = dialogWindow.getAttributes();
		dialogWindow.setGravity(Gravity.TOP);

		/*
		 * 将对话框的大小按屏幕大小的百分比设置
		 */
		WindowManager m = getWindowManager();
		Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
		WindowManager.LayoutParams p = dialogWindow.getAttributes(); //
		p.y = DpUtils.dip2px(this, 70);
		// p.gravity
		// 获取对话框当前的参数值
		// p.height = DpUtils.dip2px(this, 300); // 高度设置为屏幕的0.6
		// p.width = DpUtils.dip2px(this, 150); // 宽度设置为屏幕的0.65
		dialogWindow.setAttributes(p);
		dialog.show();
	}

}