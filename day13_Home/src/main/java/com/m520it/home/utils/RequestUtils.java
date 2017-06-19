package com.m520it.home.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.m520it.home.R;


public class RequestUtils {

	/**
	 * ImageRequest
	 * @param context
	 * @param img_pic
	 * @param url
	 */

	public static void loadImageByRequest(Context context, final ImageView img_pic, String url) {
//		1. 创建一个RequestQueue对象。
		RequestQueue mQueue = Volley.newRequestQueue(context);
//		2. 创建一个Request对象。
		@SuppressWarnings("deprecation")
		ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
			@Override
			public void onResponse(Bitmap response) {
				Log.v("520it","onResponse2----"+Thread.currentThread().getName());
				img_pic.setImageBitmap(response);
			}
		}, 0, 0, Config.RGB_565, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
//				img_pic.setImageResource(R.drawable.ic_launcher);
			}
		});
//		3. 将Request对象添加到RequestQueue里面。
		mQueue.add(imageRequest);
	}

	/**
	 * ImageLoader
	 * @param context
	 * @param img_pic
	 * @param url
	 */

	public static void loadImageByImageLoader(Context context, final ImageView img_pic, String url) {

//		1. 创建一个RequestQueue对象。
		RequestQueue mQueue = Volley.newRequestQueue(context);
//		2. 创建一个ImageLoader对象。
		ImageLoader imageLoader = new ImageLoader(mQueue, new ImageCache() {
			@Override
			public void putBitmap(String url, Bitmap bitmap) {
			}

			@Override
			public Bitmap getBitmap(String url) {
				return null;
			}
		});
//		3. 获取一个ImageListener对象。
		ImageListener listener = ImageLoader.getImageListener(img_pic, R.drawable.ic_launcher, R.drawable.ic_launcher);
//		4. 调用ImageLoader的get()方法加载网络上的图片
		imageLoader.get(url, listener, 0, 0);
	}

	public static void loadStringByRequest(Context context, final View view, String url) {

//		1. 创建一个RequestQueue对象。
		RequestQueue mQueue = Volley.newRequestQueue(context);
//		2. 创建一个StringRequest对象。
		StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				Log.d("RequestUtils", response);
//				Log.v("RequestUtils", "onResponse-->" + Thread.currentThread().getName());
				Log.v("RequestUtils", "loadStringByRequest：响应成功");
				if (view instanceof TextView) {//TODO
					((TextView) view).setText(response);
				}

			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
//				Log.e("RequestUtils", error.getMessage(), error);
				Log.e("RequestUtils", "loadStringByRequest：响应失败");
			}
		});
//		3. 将StringRequest对象添加到RequestQueue里面。
		mQueue.add(stringRequest);
//		Log.v("RequestUtils", "loadStringByRequest-->" + Thread.currentThread().getName());

	}
}
