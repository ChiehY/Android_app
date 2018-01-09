package com.example.fff;

import java.util.ArrayList;
import java.util.List;

import model.ClothBean;
import adapter.ClothAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;

public class ClothActivity extends Activity implements OnClickListener {
	private ListView lv_cloth;
	private ClothAdapter madapter;
	private List<ClothBean> mlist = new ArrayList<ClothBean>();
	private Context mContext;
	private ImageView iv_cloth_back;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clomain);
		initView();

	}

	private void initView() {
		mContext = ClothActivity.this;
		iv_cloth_back = (ImageView) findViewById(R.id.iv_cloth_back);
		iv_cloth_back.setOnClickListener(this);
		lv_cloth = (ListView) findViewById(R.id.lv_cloth);
		madapter = new ClothAdapter(mContext, mlist);
		lv_cloth.setAdapter(madapter);
		lv_cloth.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ClothActivity.this,
						ClothActivitydetail.class);
				intent.putExtra("clothname", mlist.get(arg2).getName());
				intent.putExtra("clothcolor", mlist.get(arg2).getColor());
				intent.putExtra("clothsize", mlist.get(arg2).getSize());
				intent.putExtra("clothprice", mlist.get(arg2).getPrice());
				startActivity(intent);
			}
		});
		getData();
	}

	private void getData() {
		ClothBean info = new ClothBean();
		info.setName("云飞扬");
		info.setColor("男");
		info.setSize("24");
		info.setPrice("错过只为相遇");
		mlist.add(info);
		ClothBean info1 = new ClothBean();
		info1.setName("葬爱家族");
		info1.setColor("女");
		info1.setSize("18");
		info1.setPrice("花季恰逢雨季");
		mlist.add(info1);
		ClothBean info2 = new ClothBean();
		info2.setName("眼泪太咸");
		info2.setColor("女");
		info2.setSize("22");
		info2.setPrice("为一人恋一城");
		mlist.add(info2);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.iv_cloth_back:
			finish();
		}
	}
}
