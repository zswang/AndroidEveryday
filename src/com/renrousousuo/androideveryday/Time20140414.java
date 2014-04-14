package com.renrousousuo.androideveryday;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;

public class Time20140414 extends EverydayBase {

	@Override
	public void run(Context context) {
		Activity activity = ((Activity) context);
		if (activity.getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
			activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		} else {
			activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		}
	}

	@Override
	public String getCaption() {
		return "横竖屏切换";
	}

}
