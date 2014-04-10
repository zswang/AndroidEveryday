package com.renrousousuo.androideveryday;

import java.util.ArrayList;

import android.content.Context;

public abstract class EverydayBase {
	public static ArrayList<EverydayBase> everydayBases = new ArrayList<EverydayBase>();
	public static final String LOG_TAG = "Everyday";
	/**
	 * 开始测试
	 * context 上下文
	 */
	public abstract void run(Context context);
	/**
	 * 获取描述
	 * @return 返回描述信息
	 */
	public abstract String getCaption();
}
