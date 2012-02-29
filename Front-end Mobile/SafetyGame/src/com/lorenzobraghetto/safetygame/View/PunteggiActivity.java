package com.lorenzobraghetto.safetygame.View;

import android.content.Context;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;
import com.lorenzobraghetto.safetygame.R;



public class PunteggiActivity extends SherlockActivity {
	
	private Context context;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    	setContentView(R.layout.punteggi);
    	
    }
    
    
}