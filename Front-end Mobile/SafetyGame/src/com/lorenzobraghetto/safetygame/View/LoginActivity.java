package com.lorenzobraghetto.safetygame.View;

import com.actionbarsherlock.app.SherlockActivity;
import com.lorenzobraghetto.safetygame.R;
import com.lorenzobraghetto.safetygame.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends SherlockActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //getSupportActionBar();
        
        Button login = (Button)findViewById(R.id.button1);
        login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent dashboard = new Intent(getApplicationContext(), DashboardActivity.class);
				startActivity(dashboard);
				
			}
        	
        });
        
    }
}