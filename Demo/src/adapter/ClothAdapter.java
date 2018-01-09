package adapter;

import java.util.List;

import com.example.fff.R;

import model.ClothBean;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ClothAdapter extends BaseAdapter {

	private Context mContext;
	private List<ClothBean> mlist;

	public ClothAdapter(Context context, List<ClothBean> list) {
		this.mContext = context;
		this.mlist = list;
	}

	@Override
	public int getCount() {
		return mlist.size();
	}

	@Override
	public Object getItem(int postion) { // qushuju
		return mlist.get(postion);
	}

	@Override
	public long getItemId(int postion) {
		return postion;
	}

	@Override
	public View getView(int postion, View arg1, ViewGroup arg2) {
		Holder holder;
		if (arg1 == null) {
			holder = new Holder();
			arg1 = LayoutInflater.from(mContext).inflate(R.layout.item_cloth,
					null);
			holder.item_name = (TextView) arg1.findViewById(R.id.item_name);
			holder.item_color = (TextView) arg1.findViewById(R.id.item_color);
			holder.item_size = (TextView) arg1.findViewById(R.id.item_size);
			holder.item_price = (TextView) arg1.findViewById(R.id.item_price);
			arg1.setTag(holder);
		} else {
			holder = (Holder) arg1.getTag();
		}
		ClothBean bean = mlist.get(postion);
		if (!bean.getName().equals("")) {
			holder.item_name.setText("昵称:" + bean.getName());
		}
		if (!bean.getColor().equals("")) {
			holder.item_color.setText("性别:" + bean.getColor());
		}
		if (!bean.getSize().equals("")) {
			holder.item_size.setText("年龄:" + bean.getSize());
		}
		if (!bean.getPrice().equals("")) {
			holder.item_price.setText("宣言:" + bean.getPrice());
		}
		return arg1;
	}

	public class Holder {
		TextView item_name, item_color, item_size, item_price;
	}

}
