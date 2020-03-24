package br.unicap.li2.chrisandewasted;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class ChrisActivity extends Activity{

	private ChrisView view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	       view = new ChrisView(this);
	        setContentView(view);
	    	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	}
}
