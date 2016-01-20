package com.example.test35;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import de.greenrobot.event.EventBus;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		EventBus.getDefault().register(this);
		
	}
	
	public void startSecondActivity(View view){
		startActivity(new Intent(this,SecondActivity.class));
	}
	
	public void onEvent(Object object){
		String string = (String) object;
		Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}
	

}
