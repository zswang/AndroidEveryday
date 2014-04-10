package com.renrousousuo.androideveryday;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.util.Log;

public class Time20130727 extends EverydayBase {

	@Override
	public void run(Context context) {

		ActivityManager ActivityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		MemoryInfo outInfo = new MemoryInfo();
		ActivityManager.getMemoryInfo(outInfo);
		
		Log.v(LOG_TAG, String.format("availMem: %s, totalMem: %s, threshold: %s", outInfo.availMem, outInfo.totalMem, outInfo.threshold));

	}

	@Override
	public String getCaption() {
		
		return "ActivityManager";
	}

}
