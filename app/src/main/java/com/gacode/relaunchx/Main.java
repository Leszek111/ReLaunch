package com.gacode.relaunchx;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import java.lang.System;
import android.os.Build;

public class Main extends Activity {
	final String TAG = "Main";
	ReLaunchApp app;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		app = ((ReLaunchApp) getApplicationContext());
		if (Build.MODEL == "BNRV520") {
			System.setProperty("bn.bootanim.exit", "1");
		};
		app.RestartIntent = PendingIntent.getActivity(this, 0, getIntent(),
				getIntent().getFlags() | Intent.FLAG_ACTIVITY_NEW_TASK);

		Intent intent = new Intent(Main.this, ReLaunch.class);
		intent.putExtra("home", false);
		intent.putExtra("home1", false);
		intent.putExtra("shop", false);
		intent.putExtra("library", false);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivityForResult(intent, 0);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		finish();
	}
}
