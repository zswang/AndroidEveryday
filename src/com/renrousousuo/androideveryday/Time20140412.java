package com.renrousousuo.androideveryday;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;

import android.content.Context;
import android.widget.Toast;

public class Time20140412 extends EverydayBase {

	private LocationClient mLocationClient = null;
	private Context mContext;

	@Override
	public void run(Context context) {
		if (mLocationClient == null) {
			mContext = context;
			mLocationClient = new LocationClient(
					context.getApplicationContext()); // 声明LocationClient类
			mLocationClient.registerLocationListener(new BDLocationListener() { // 注册监听函数

						@Override
						public void onReceiveLocation(BDLocation location) { // 定位请求回调函数
							if (location == null) {
								return;
							}
							StringBuilder builder = new StringBuilder();

							builder.append(String.format(
									"time: %s, addStr: %s, city: %s, poi: %s",
									location.getTime(), location.getAddrStr(),
									location.getCity(), location.getPoi()));

							Toast toast = Toast.makeText(mContext, builder,
									Toast.LENGTH_SHORT);
							toast.show();
						}

						@Override
						public void onReceivePoi(BDLocation location) { // poi请求回调函数

						}
					});
			
			try {
				LocationClientOption option = new LocationClientOption();
				option.setLocationMode(LocationMode.Hight_Accuracy);
				option.setScanSpan(5000);
				option.setCoorType("bd09ll");
				option.setNeedDeviceDirect(true);
				option.setIsNeedAddress(true);
				mLocationClient.setLocOption(option);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (mLocationClient.isStarted()) {
			mLocationClient.stop();
		} else {
			mLocationClient.start();
		}
	}

	@Override
	public String getCaption() {
		return "地理定位";
	}

}
