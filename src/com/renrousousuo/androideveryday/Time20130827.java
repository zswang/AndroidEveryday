package com.renrousousuo.androideveryday;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class Time20130827 extends EverydayBase {

	@Override
	public void run(Context context) {
	    //final String SMS_URI_ALL   = "content://sms/"; // 全部     
	    final String SMS_URI_INBOX = "content://sms/inbox"; // 收件箱
	    //final String SMS_URI_SEND  = "content://sms/sent"; // 发件箱
	    //final String SMS_URI_DRAFT = "content://sms/draft"; // 草稿箱   
	       
	    try {   
	        ContentResolver cr = context.getContentResolver();   
	        String[] projection = new String[]{ "address", "body", "date" };   
	        Uri uri = Uri.parse(SMS_URI_INBOX);
	        Cursor cur = cr.query(uri, projection, null, null, "date desc");   
	        if (cur.moveToFirst()) {   
	            int phoneNumberColumn = cur.getColumnIndex("address");
	            int smsbodyColumn = cur.getColumnIndex("body");
	            //int dateColumn = cur.getColumnIndex("date");
	            do {
	            	Log.v(LOG_TAG, String.format("phoneNumber: %s, smsbody: %s", cur.getString(phoneNumberColumn), cur.getString(smsbodyColumn)));
	            } while(cur.moveToNext());   
	        } else {   
	        }   
	    } catch(Exception ex) {   
	        ex.printStackTrace();   
	    }   
	}

	@Override
	public String getCaption() {
		return "读取短信";
	}

}
