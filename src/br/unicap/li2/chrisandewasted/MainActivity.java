package br.unicap.li2.chrisandewasted;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	Button ButtonJogar, ButtonAjuda, ButtonSobre;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        ButtonJogar = (Button) findViewById(R.id.ButtonJogar);
        ButtonAjuda = (Button) findViewById(R.id.ButtonAjuda);
        ButtonSobre = (Button) findViewById(R.id.ButtonSobre);
        
        
        ButtonJogar.setOnClickListener(new View.OnClickListener() {

			public void onClick(View y) {

				Intent jogarview = new Intent(MainActivity.this,
						ChrisActivity.class);
				MainActivity.this.startActivity(jogarview);
				MainActivity.this.finish();

			}
		});
        
        ButtonAjuda.setOnClickListener(new View.OnClickListener() {

			public void onClick(View y) {

				Intent ajudaview = new Intent(MainActivity.this,
						HelpActivity.class);
				MainActivity.this.startActivity(ajudaview);
				MainActivity.this.finish();

			}
		});
        
        ButtonSobre.setOnClickListener(new View.OnClickListener() {

			public void onClick(View y) {

				Intent sobreview = new Intent(MainActivity.this,
						AboutActivity.class);
				MainActivity.this.startActivity(sobreview);
				MainActivity.this.finish();

			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
