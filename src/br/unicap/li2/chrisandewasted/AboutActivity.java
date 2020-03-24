package br.unicap.li2.chrisandewasted;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AboutActivity extends Activity implements OnClickListener{

	Button ButtonMenu;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ButtonMenu = (Button) findViewById(R.id.ButtonMenu);
	
        ButtonMenu.setOnClickListener(new View.OnClickListener() {

			public void onClick(View y) {

				Intent menuview = new Intent(AboutActivity.this,
						MainActivity.class);
				AboutActivity.this.startActivity(menuview);
				AboutActivity.this.finish();

			}
		});
	 }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}	
