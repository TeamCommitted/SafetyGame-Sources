/*
 * Name: DomandaActivity.java
 * Package: com.safetygame.android.View
 * Author: Lorenzo Braghetto
 * Date: {Data di approvazione del file}
 * Version: 0.2
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+------------------+---------------------
 * |   Date   | Programmer       | Changes
 * +----------+------------------+---------------------
 * | 20120306 |Lorenzo Braghetto | * onCreate
 * |          |                  | + DomandaTask
 * | 20120302 |Lorenzo Braghetto | + onCreate
 * |          |                  | + onOptionsItemSelected
 * +----------+------------------+---------------------
 *
*/
package com.safetygame.android.View;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.safetygame.android.R;
import com.safetygame.android.Utils.ConnectionUtils;
import com.safetygame.android.Utils.IntentIntegrator;
import com.safetygame.android.Utils.IntentResult;
import com.safetygame.android.condivisi.Domanda;
import com.safetygame.android.condivisi.Quest;


public class DomandaActivity extends SherlockActivity {
	
	private Context context;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	
    	context = this;
    	    	
        if(getIntent().getExtras().getBoolean("Domanda", true))
        {
        	/*int x = (int)(2*Math.random());
        	if(x==1)
        		setContentView(R.layout.domanda_sino);
        	else
        		setContentView(R.layout.domanda_rispostamultipla);*/
        	new DomandaTask().execute();

        }else
        {
        	new QuestTask().execute();
        	        	
        }

    }

    private class DomandaTask extends AsyncTask<Object, String, Domanda>
    {
    	ProgressDialog dialog;
    	@Override
    	protected void onPreExecute()
    	{
			dialog = ProgressDialog.show(DomandaActivity.this, "", 
                    "Loading. Please wait...", true);
    	}

		@Override
		protected Domanda doInBackground(Object... params) {
	        
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	        //nameValuePairs.add(new BasicNameValuePair("username", user.getText().toString()));
	        //nameValuePairs.add(new BasicNameValuePair("password", passw.getText().toString()));
	        Domanda domanda = (Domanda) ConnectionUtils.HttpCreateClient("http://monossido.ath.cx/teamcommitted/backend/API/domanda.jsp", nameValuePairs);
						
			return domanda;
		}
		
		@Override
		protected void onPostExecute(Domanda domanda)
		{
			dialog.dismiss();
			if(domanda!=null)
	        {
				if(domanda.getType().equals("sino"))
				{
	        		setContentView(R.layout.domanda_sino);
	        		((TextView)findViewById(R.id.Titolo)).setText(domanda.getTitle());
	        		((TextView)findViewById(R.id.Testo)).setText(domanda.getTesto());
				}
				else
				{
	        		setContentView(R.layout.domanda_rispostamultipla);
	        		((TextView)findViewById(R.id.Titolo)).setText(domanda.getTitle());
	        		((TextView)findViewById(R.id.Testo)).setText(domanda.getTesto());
	        		String[] risposte = domanda.getRisposte();
	        		((RadioButton)findViewById(R.id.radio0)).setText(risposte[0]);
	        		((RadioButton)findViewById(R.id.radio1)).setText(risposte[1]);
	        		((RadioButton)findViewById(R.id.radio2)).setText(risposte[2]);		
				}

	        }else{
	        	
	        	AlertDialog.Builder builder = new AlertDialog.Builder(context);
	        	builder.setTitle("Errore");
	        	builder.setMessage("C'è stato qualche problema nel download della domanda");
	        	builder.show();
	        }
		}
    	
    }
    
    private class QuestTask extends AsyncTask<Object, String, Quest>
    {
    	ProgressDialog dialog;
    	@Override
    	protected void onPreExecute()
    	{
			dialog = ProgressDialog.show(DomandaActivity.this, "", 
                    "Loading. Please wait...", true);
    	}

		@Override
		protected Quest doInBackground(Object... params) {
	        
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	        //nameValuePairs.add(new BasicNameValuePair("username", user.getText().toString()));
	        //nameValuePairs.add(new BasicNameValuePair("password", passw.getText().toString()));
	        Quest quest = (Quest) ConnectionUtils.HttpCreateClient("http://monossido.ath.cx/teamcommitted/backend/API/quest.jsp", nameValuePairs);
			
	        return quest;
		}
		
		@Override
		protected void onPostExecute(Quest quest)
		{
			dialog.dismiss();
			if(quest!=null)
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
        		((TextView)findViewById(R.id.Titolo)).setText(quest.getTitle());
        		((TextView)findViewById(R.id.Testo)).setText(quest.getTesto());
	        }else{
	        	
	        	AlertDialog.Builder builder = new AlertDialog.Builder(context);
	        	builder.setTitle("Errore");
	        	builder.setMessage("C'è stato qualche problema nel download della domanda");
	        	builder.show();
	        }
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