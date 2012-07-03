/*
 * Name: DatiActivity.java
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
 * |          |                  | + DatiTask
 * | 20120302 |Lorenzo Braghetto | + onCreate
 * |          |                  | + onOptionsItemSelected
 * +----------+------------------+---------------------
 *
 */
package com.safetygame.mobile.View;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.safetygame.mobile.R;
import com.safetygame.mobile.Utils.ConnectionUtils;
import com.safetygame.mobile.condivisi.Dati;

public class DatiActivity extends SherlockActivity {

	private Context context;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		context = this;

		new DatiTask().execute();
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
			// nameValuePairs.add(new BasicNameValuePair("username",
			// user.getText().toString()));
			// nameValuePairs.add(new BasicNameValuePair("password",
			// passw.getText().toString()));
			Dati dati = (Dati) ConnectionUtils
					.HttpCreateClient(
							"http://monossido.ath.cx/teamcommitted/back/connection/API/dati.jsp",
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

}