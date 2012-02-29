package com.lorenzobraghetto.safetygame.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.lorenzobraghetto.safetygame.R;
import com.lorenzobraghetto.safetygame.Logic.IntentIntegrator;
import com.lorenzobraghetto.safetygame.Logic.IntentResult;


public class DomandaActivity extends SherlockActivity {
	
	private Context context;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    	context = this;
    	
        if(getIntent().getExtras().getBoolean("Domanda", true))
        {
        	int x = (int)(2*Math.random());
        	if(x==1)
        		setContentView(R.layout.domanda_sino);
        	else
        		setContentView(R.layout.domanda_rispostamultipla);

        }else
        {
        	setContentView(R.layout.quest);
        	
        	Button scan = (Button) findViewById(R.id.scanna);
        	
        	scan.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
		        	
		        	IntentIntegrator integrator = new IntentIntegrator(DomandaActivity.this);
		        	integrator.initiateScan();					
				}
        		
        	});

        	
        }

    	
    	 
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	  IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
    	  if (scanResult != null) {
    	    // handle scan result
    	  }
    	  // else continue with any other code you need in the method
    	}

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, DashboardActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
}