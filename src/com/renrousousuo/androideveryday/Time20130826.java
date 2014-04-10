package com.renrousousuo.androideveryday;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.SmsManager;

@SuppressLint("UnlocalizedSms")
public class Time20130826 extends EverydayBase {

	/**
	 * 电话号码
	 */
	private String mPhoneNumber = "13500000000";
	
	@Override
	public void run(Context context) {
		//直接调用短信接口发短信  
		SmsManager smsManager = SmsManager.getDefault();  
		List<String> divideContents = smsManager.divideMessage("你好，我是程序发送的！");  
		for (String text : divideContents) {    
		    smsManager.sendTextMessage(mPhoneNumber, null, text, null, null);    
		}
	}

	@Override
	public String getCaption() {
		return "发送短信";
	}

}
