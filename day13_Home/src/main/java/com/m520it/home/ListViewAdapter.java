package com.m520it.home;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.m520it.home.bean.HomeBean;
import com.m520it.home.utils.RequestUtils;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

	private Context mContext;
	private ArrayList<HomeBean> mDatas;
	private int mCount = 0;

	public ListViewAdapter(Context c) {
		mContext = c;
	}

	public ListViewAdapter(Context c,ArrayList<HomeBean> mDatas) {
		mContext = c;
		this.mDatas = mDatas;
	}

	public void setMDatas(ArrayList<HomeBean> mDatas) {
		this.mDatas = mDatas;
	}

	public ArrayList<HomeBean> getMDatas() {
		return mDatas;
	}

	@Override
	public int getCount() {
//		Log.v("520it", "getcount" + mCount++);
//		Log.v("520it", mDatas.toString());
		return mDatas == null ? 0 : mDatas.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	class ViewHolder {
		TextView countsTv;
		TextView timeTv;
		TextView descriptionTv;
		ImageView imageView;
		ImageView iconImageView;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.lv_item_layout, parent, false);
			holder = new ViewHolder();

			holder.descriptionTv = (TextView) convertView.findViewById(R.id.description_tv);
			holder.countsTv = (TextView) convertView.findViewById(R.id.counts_iv);
			holder.timeTv = (TextView) convertView.findViewById(R.id.time_iv);

			holder.imageView = (ImageView) convertView.findViewById(R.id.image_iv);
			holder.iconImageView = (ImageView) convertView.findViewById(R.id.icon_iv);

			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		HomeBean homeBean = mDatas.get(position);

		holder.countsTv.setText(homeBean.getCounts());
		holder.timeTv.setText(homeBean.getTime());
		holder.descriptionTv.setText(homeBean.getDescription());

		RequestUtils.loadImageByRequest(mContext, holder.imageView, homeBean.getImageUrl());
		RequestUtils.loadImageByImageLoader(mContext, holder.iconImageView, homeBean.getIconHeart());
		return convertView;
	}



}
