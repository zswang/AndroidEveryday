package com.renrousousuo.androideveryday;

import android.app.Application;
import android.util.Log;

public class EverydayApplication extends Application {
	private static String LOG_TAG = "Everyday";
	
	@Override
	public void onCreate() {
		super.onCreate();
		Log.v(LOG_TAG, String.format("%s.onCreate()", this));
	}
}
