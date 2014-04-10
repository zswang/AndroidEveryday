package com.renrousousuo.androideveryday;

import java.util.Timer;
import java.util.TimerTask;

import android.app.ActivityManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;

public class Time20130802 extends EverydayBase {

	
	private Timer timer;
	private Context context;
	
	@Override
	public void run(Context ctx) {
		context = ctx;
		timer = new Timer();
		timer.schedule(new TimerTask() {
			private String packageName;

			@Override
			public void run() {
				String pn = "";
				try {
					ActivityManager am = (ActivityManager) context.getSystemService(Service.ACTIVITY_SERVICE);
					ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
					pn = cn.getPackageName() + ":" + cn.getClassName();
					
					if (pn.equals(packageName)) {
						return;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				packageName = pn;
				Log.v(LOG_TAG, packageName);
			}
			
		}, 1000, 1000);
	}

	@Override
	public String getCaption() {
		return "分析当前运行包";
	}

}
