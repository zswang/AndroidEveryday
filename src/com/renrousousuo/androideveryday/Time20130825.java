package com.renrousousuo.androideveryday;

import android.app.Service;
import android.content.Context;
import android.os.Vibrator;

public class Time20130825 extends EverydayBase {

	@Override
	public void run(Context context) {
		Vibrator vib = (Vibrator)context.getSystemService(Service.VIBRATOR_SERVICE);
		vib.vibrate(200);
	}

	@Override
	public String getCaption() {
		return "手机振动";
	}

}
