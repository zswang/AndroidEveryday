package com.renrousousuo.androideveryday;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;

public class Time20140410 extends EverydayBase {

	private Camera mCamera;
	
	@Override
	public void run(Context context) {
		if (mCamera == null) {
			mCamera = Camera.open();
		}
		Parameters parameters = mCamera.getParameters();
		if (Parameters.FLASH_MODE_TORCH.equals(parameters.getFlashMode())) {
	        parameters.setFlashMode(Parameters.FLASH_MODE_OFF);
	        mCamera.setParameters(parameters);
	        mCamera.release();
	        mCamera = null;
		} else {
	        parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
	        mCamera.setParameters(parameters);
		}
	}

	@Override
	public String getCaption() {
		return "开关手电";
	}

}
