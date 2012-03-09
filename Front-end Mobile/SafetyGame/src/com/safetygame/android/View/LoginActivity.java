/*
 * Name: LoginActivity.java
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
 * |          |                  | + LoginTask
 * | 20120302 |Lorenzo Braghetto | + onCreate
 * +----------+------------------+---------------------
 *
*/
package com.safetygame.android.View;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.actionbarsherlock.app.SherlockActivity;
import com.safetygame.android.R;
import com.safetygame.android.Utils.ConnectionUtils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends SherlockActivity {
	
	private Context context;
	 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
         context = this;
        
        //getSupportActionBar();
        
        Button login = (Button)findViewById(R.id.button1);
        login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				new LoginTask().execute();
			}
        	
        });
        
    }
    
    private class LoginTask extends AsyncTask<Object, String, String>
    {
    	ProgressDialog dialog;
    	EditText user;
        EditText passw;
    	
    	@Override
    	protected void onPreExecute()
    	{
			dialog = ProgressDialog.show(LoginActivity.this, "", 
                    "Loading. Please wait...", true);
    	}

		@Override
		protected String doInBackground(Object... params) {
			
			user = (EditText)findViewById(R.id.userE);
	        passw = (EditText)findViewById(R.id.passwordE);
	        
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	        nameValuePairs.add(new BasicNameValuePair("username", user.getText().toString()));
	        nameValuePairs.add(new BasicNameValuePair("password", passw.getText().toString()));
	        String status = (String) ConnectionUtils.HttpCreateClient("http://monossido.ath.cx/teamcommitted/backend/API/login.jsp", nameValuePairs);
			
			return status;
		}
		
		@Override
		protected void onPostExecute(String status)
		{
			dialog.dismiss();
			if(status != null && status.equals("OK"))
	        {
				SharedPreferences prefs = getSharedPreferences("login", Context.MODE_PRIVATE);
				Editor editor = prefs.edit();
				editor.putString("Username", user.getText().toString());
				editor.putString("Password", passw.getText().toString());
				editor.commit();
				Intent dashboard = new Intent(getApplicationContext(), DashboardActivity.class);
				startActivity(dashboard);
				finish();
	        }else{
	        	
	        	AlertDialog.Builder builder = new AlertDialog.Builder(context);
	        	builder.setTitle("Errore");
	        	builder.setMessage("C'è stato qualche problema nel login");
	        	builder.show();
	        }
		}
    	
    }
}