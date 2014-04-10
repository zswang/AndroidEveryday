package com.renrousousuo.androideveryday;

import android.app.Service;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;

public class Time20130810 extends EverydayBase {

	@Override
	public void run(Context context) {
		TelephonyManager tm = (TelephonyManager) context.getSystemService(Service.TELEPHONY_SERVICE);
		Log.v(LOG_TAG, String.format("getLine1Number() : %s", tm.getLine1Number()));
		Log.v(LOG_TAG, String.format("getNetworkCountryIso() : %s", tm.getNetworkCountryIso()));
		Log.v(LOG_TAG, String.format("getNetworkOperator() : %s", tm.getNetworkOperator()));
		Log.v(LOG_TAG, String.format("getNetworkOperatorName() : %s", tm.getNetworkOperatorName()));
		Log.v(LOG_TAG, String.format("getPhoneType() : %s", tm.getPhoneType()));
		Log.v(LOG_TAG, String.format("getNetworkType() : %s", tm.getNetworkType()));
		Log.v(LOG_TAG, String.format("isNetworkRoaming() : %s", tm.isNetworkRoaming()));
		Log.v(LOG_TAG, String.format("getDeviceSoftwareVersion() : %s", tm.getDeviceSoftwareVersion()));
		Log.v(LOG_TAG, String.format("getSubscriberId() : %s", tm.getSubscriberId()));
	}

	@Override
	public String getCaption() {
		return "TelephonyManager";
	}

}
