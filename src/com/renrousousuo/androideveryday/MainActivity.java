package com.renrousousuo.androideveryday;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class MainActivity extends Activity {

	public static final String LOG_TAG = "Everyday";

	static {
		EverydayBase.everydayBases.add(new Time20140413());
		EverydayBase.everydayBases.add(new Time20140412());
		EverydayBase.everydayBases.add(new Time20140411());
		EverydayBase.everydayBases.add(new Time20140410());
		EverydayBase.everydayBases.add(new Time20130827());
		EverydayBase.everydayBases.add(new Time20130826());
		EverydayBase.everydayBases.add(new Time20130825());
		EverydayBase.everydayBases.add(new Time20130810());
		EverydayBase.everydayBases.add(new Time20130802());
		EverydayBase.everydayBases.add(new Time20130727());
		EverydayBase.everydayBases.add(new Time20130726());
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.v(LOG_TAG, getString(R.string.stat_download));

		LinearLayout linearLayout = new LinearLayout(this);
		linearLayout.setOrientation(LinearLayout.VERTICAL);

		ScrollView scrollView = new ScrollView(this);
		scrollView.addView(linearLayout);

		RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
		relativeLayout.addView(scrollView);

		@SuppressWarnings("deprecation")
		LayoutParams layoutParams = new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(20, 20, 0, 0);

		for (EverydayBase everydayBase : EverydayBase.everydayBases) {
			Button button = new Button(this);
			button.setTag(everydayBase);
			String[] classNames = everydayBase.getClass().getName().split("\\.");
			button.setText(String.format("%s-%s",
					classNames[classNames.length - 1],
					everydayBase.getCaption()));

			button.setLayoutParams(layoutParams);
			OnClickListener buttonClickListener = new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					Button self = (Button) arg0;
					EverydayBase everydayBase = (EverydayBase) self.getTag();
					everydayBase.run(MainActivity.this);
				}
			};
			button.setOnClickListener(buttonClickListener);
			linearLayout.addView(button);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	static {
		Log.v("Everday", "static run");
	}
}