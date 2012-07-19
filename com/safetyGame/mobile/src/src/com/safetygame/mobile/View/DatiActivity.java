/*
 * Name: DatiActivity.java
 * Package: com.safetygame.android.View
 * Author: Lorenzo Braghetto
 * Date: 2012/06/16
 * Version: 1.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+------------------+---------------------
 * |   Date   | Programmer       | Changes
 * +----------+------------------+---------------------
 * | 20120506 |Lorenzo Braghetto | * onCreate
 * |          |                  | + DatiTask
 * | 20120302 |Lorenzo Braghetto | + onCreate
 * |          |                  | + onOptionsItemSelected
 * +----------+------------------+---------------------
 *
 */
package com.safetyGame.mobile.View;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.safetyGame.mobile.R;
import com.safetyGame.mobile.Utils.ConnectionUtils;
import com.safetyGame.mobile.condivisi.Dati;

public class DatiActivity extends SherlockActivity {

	private Context context;
	private EditText vecchiaPassw;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		context = this;

		new DatiTask().execute();

		vecchiaPassw = (EditText) findViewById(R.id.vecchiaPass);
		Button invia = (Button) findViewById(R.id.buttonInvia);
		invia.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				new InviaDatiTask().execute();

			}

		});
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

	private class DatiTask extends AsyncTask<Object, String, Dati> {
		ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			dialog = ProgressDialog.show(DatiActivity.this, "",
					"Loading. Please wait...", true);
		}

		@Override
		protected Dati doInBackground(Object... params) {

			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			SharedPreferences prefs = getSharedPreferences("SafetyGame", Context.MODE_PRIVATE);

			nameValuePairs.add(new BasicNameValuePair("username",
					prefs.getString("user", "")));
			nameValuePairs.add(new BasicNameValuePair("password",
					prefs.getString("password", "")));
			Dati dati = (Dati) ConnectionUtils
					.HttpCreateClient(
							"http://monossido.ath.cx/teamcommitted/API/dati.jsp",
							nameValuePairs);

			return dati;
		}

		@Override
		protected void onPostExecute(Dati dati) {
			dialog.dismiss();
			if (dati != null) {
				setContentView(R.layout.dati);

				((TextView) findViewById(R.id.Nome)).setText(dati.getNome()
						+ "\n" + dati.getCognome());

			} else {

				AlertDialog.Builder builder = new AlertDialog.Builder(context);
				builder.setTitle("Errore");
				builder.setMessage("C'è stato qualche problema nel download della domanda");
				builder.show();
			}
		}

	}

	private class InviaDatiTask extends AsyncTask<Object, String, Boolean> {
		ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			dialog = ProgressDialog.show(DatiActivity.this, "",
					"Loading. Please wait...", true);
		}

		@Override
		protected Boolean doInBackground(Object... params) {

			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			SharedPreferences prefs = getSharedPreferences("SafetyGame", Context.MODE_PRIVATE);

			nameValuePairs.add(new BasicNameValuePair("username",
					prefs.getString("user", "")));
			nameValuePairs.add(new BasicNameValuePair("vecchiaPassword",
					vecchiaPassw.getText().toString()));
			Boolean dati = (Boolean) ConnectionUtils
					.HttpCreateClient(
							"http://monossido.ath.cx/teamcommitted/API/cambioPassw.jsp",
							nameValuePairs);

			return dati;
		}

		@Override
		protected void onPostExecute(Boolean dati) {
			dialog.dismiss();
			if (dati) {

			} else {

				AlertDialog.Builder builder = new AlertDialog.Builder(context);
				builder.setTitle("Errore");
				builder.setMessage("C'è stato qualche problema nel download della domanda");
				builder.show();
			}
		}

	}

}