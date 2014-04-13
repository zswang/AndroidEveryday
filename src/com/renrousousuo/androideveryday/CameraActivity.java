package com.renrousousuo.androideveryday;

import java.io.IOException;

import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CameraActivity extends Activity {
	
	private SurfaceView mSurfaceView;
	private SurfaceHolder mSurfaceHolder;
	private Camera mCamera;
	
	private SurfaceHolder.Callback mSurfaceCallback = new SurfaceHolder.Callback() {  
  
        public void surfaceCreated(SurfaceHolder holder) {  
        	mCamera = Camera.open(); // Turn on the camera  
            try {  
            	mCamera.setPreviewDisplay(holder); // Set Preview  
            } catch (IOException e) {  
            	mCamera.release();// release camera  
            	mCamera = null;  
            }  
        }  
  
        @SuppressWarnings("deprecation")
		public void surfaceChanged(SurfaceHolder holder, int format, int width,  
                int height) {  
            Camera.Parameters parameters = mCamera.getParameters();  
            parameters.setPictureFormat(PixelFormat.JPEG);  
            mCamera.setDisplayOrientation(0);  
            mCamera.setParameters(parameters);  
            mCamera.startPreview();  
        }  
  
        public void surfaceDestroyed(SurfaceHolder holder) {  
        	mCamera.stopPreview();  
        	mCamera.release();  
        	mCamera = null;  
        }  
    };  

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);
		mSurfaceView = (SurfaceView) findViewById(R.id.camera_preview); // Camera interface to instantiate components
		mSurfaceHolder = mSurfaceView.getHolder(); // Camera interface to instantiate components
		mSurfaceHolder.addCallback(mSurfaceCallback); // Add a callback for the SurfaceHolder
		mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.camera, menu);
		return true;
	}

}
