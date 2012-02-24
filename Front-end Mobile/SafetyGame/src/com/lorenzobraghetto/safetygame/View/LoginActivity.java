package com.lorenzobraghetto.safetygame.View;

import com.lorenzobraghetto.safetygame.R;
import com.lorenzobraghetto.safetygame.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class LoginActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView hello = (TextView) findViewById(R.id.hello);
        hello.setText("Ciao");
        
    }
}