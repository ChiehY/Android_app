package com.example.fff;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.widget.ViewSwitcher;

public class IntroductionActivity extends Activity {
	private ViewSwitcher mSwitcher;
	private ViewPager viewPager;
	private ArrayList<View> views;
	private GestureDetector gestureDetector; // �û�����
	/**
	 * ��ǰҳ
	 */
	int currentItem = 0;
	/**
	 * ������ҳ��������ĳ����ǵ�ǰ��Ļ��ȵ�1/4
	 */
	private int flaggingWidth;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_introdiction);
		gestureDetector = new GestureDetector(new GuideViewTouch());
		// ��ȡ�ֱ���
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		flaggingWidth = dm.widthPixels / 3;
		showWelcome();
	}

	/**
	 * ��ʾ��ӭҳ��
	 */
	public void showWelcome() {
		mSwitcher = (ViewSwitcher) findViewById(R.id.switcher);
		mSwitcher.setDisplayedChild(0);
		initViewPager();
	}

	/**
	 * ��ʼ��ViewPager .
	 */
	public void initViewPager() {
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		LayoutInflater layoutInflater = getLayoutInflater();
		View view1 = layoutInflater.inflate(R.layout.page1_viewpage, null);
		View view2 = layoutInflater.inflate(R.layout.page2_viewpage, null);
		View view3 = layoutInflater.inflate(R.layout.page3_viewpage, null);
		// View view4 = layoutInflater.inflate(R.layout.page4_viewpage, null);
		views = new ArrayList<View>();
		views.add(view1);
		views.add(view2);
		views.add(view3);
		// views.add(view4);

		viewPager.setAdapter(pageAdapter);
		viewPager.setOnPageChangeListener(new MyListener());

		// view3.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View arg0) {
		// finish();
		//
		// }
		// });

	}

	/**
	 * PagerAdapter ������.
	 */
	PagerAdapter pageAdapter = new PagerAdapter() {

		@Override
		public void destroyItem(View container, int position, Object object) {
			((ViewPager) container).removeView(views.get(position));
		}

		@Override
		public Object instantiateItem(View container, int position) {
			((ViewPager) container).addView(views.get(position));
			return views.get(position);
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public int getCount() {
			return views.size();
		}
	};

	@Override
	protected void onStop() {
		super.onStop();

	}

	/**
	 * PagerAdapter ����.
	 */
	class MyListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageSelected(int arg0) {
			viewPager.setCurrentItem(arg0, false);
			currentItem = arg0;
		}
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		if (gestureDetector.onTouchEvent(event)) {
			event.setAction(MotionEvent.ACTION_CANCEL);
		}
		return super.dispatchTouchEvent(event);
	}

	private class GuideViewTouch extends SimpleOnGestureListener {
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			// ���ﵽ���һҳ�������������������������ҳ
			if (currentItem == 2) {
				if (Math.abs(e1.getX() - e2.getX()) > Math.abs(e1.getY()
						- e2.getY())
						&& (e1.getX() - e2.getX() <= (-flaggingWidth) || e1
								.getX() - e2.getX() >= flaggingWidth)) {
					if (e1.getX() - e2.getX() >= flaggingWidth) {
						startActivity(new Intent(IntroductionActivity.this,
								FirActivity.class));
						return true;
					}
				}
			}
			return false;
		}
	}

}
