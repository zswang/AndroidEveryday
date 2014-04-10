package com.renrousousuo.androideveryday;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.util.Log;

public class Time20130726 extends EverydayBase {

	@Override
	public void run(Context context) {
		
		AccountManager accountManager = (AccountManager) context.getSystemService(Context.ACCOUNT_SERVICE);
		for (Account account : accountManager.getAccounts()) {
			
			Log.v(LOG_TAG, String.format("name: %s, type: %s", account.name, account.type));
		}
		
	}

	@Override
	public String getCaption() {
		return "AccountManager";
	}

}
