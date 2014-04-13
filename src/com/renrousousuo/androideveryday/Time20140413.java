package com.renrousousuo.androideveryday;

import android.content.Context;
import android.content.Intent;

public class Time20140413 extends EverydayBase {

	@Override
	public void run(Context context) {
		Intent intent = new Intent();
		intent.setClass(context, CameraActivity.class);
		context.startActivity(intent);
	}

	@Override
	public String getCaption() {
		return "相机预览";
	}

}
