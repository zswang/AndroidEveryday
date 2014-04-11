package com.renrousousuo.androideveryday;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.util.Log;

public class Time20140411 extends EverydayBase {

	@Override
	public void run(Context context) {
		WifiManager wifiMgr = (WifiManager) context
				.getSystemService(Context.WIFI_SERVICE);
		for (ScanResult result : wifiMgr.getScanResults()) {
			Log.d(LOG_TAG,
					String.format(
							"SSID: %s, BSSID: %s, level: %s, capabilities: %s, frequency: %s",
							result.SSID, result.BSSID, result.level,
							result.capabilities, result.frequency));

		}
	}

	@Override
	public String getCaption() {
		return "WiFi热点";
	}

}
