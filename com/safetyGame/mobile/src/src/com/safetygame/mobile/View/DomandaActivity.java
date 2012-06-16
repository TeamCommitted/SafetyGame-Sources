/*
 * Name: DomandaActivity.java
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
 * |          |                  | + DomandaTask
 * | 20120502 |Lorenzo Braghetto | + onCreate
 * |          |                  | + onOptionsItemSelected
 * +----------+------------------+---------------------
 *
 */
package com.safetygame.mobile.View;

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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.safetygame.mobile.R;
import com.safetygame.mobile.Utils.ConnectionUtils;
import com.safetygame.mobile.Utils.IntentIntegrator;
import com.safetygame.mobile.Utils.IntentResult;
import com.safetygame.mobile.condivisi.Domanda;
import com.safetygame.mobile.condivisi.Quest;

public class DomandaActivity extends SherlockActivity {

	private Context context;
	private Domanda domanda;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		context = this;

		if (getIntent().getExtras().getBoolean("Domanda", true)) {
			/*
			 * int x = (int)(2*Math.random()); if(x==1)
			 * setContentView(R.layout.domanda_sino); else
			 * setContentView(R.layout.domanda_rispostamultipla);
			 */
			new DomandaTask().execute();

		} else {
			new QuestTask().execute();

		}

	}

	private class DomandaTask extends AsyncTask<Object, String, Domanda> {
		ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			dialog = ProgressDialog.show(DomandaActivity.this, "",
					"Loading. Please wait...", true);
		}

		@Override
		protected Domanda doInBackground(Object... params) {

			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			// nameValuePairs.add(new BasicNameValuePair("username",
			// user.getText().toString()));
			// nameValuePairs.add(new BasicNameValuePair("password",
			// passw.getText().toString()));
			domanda = (Domanda) ConnectionUtils
					.HttpCreateClient(
							"http://monossido.ath.cx/teamcommitted/back/connection/API/domanda.jsp",
							nameValuePairs);

			return domanda;
		}

		@Override
		protected void onPostExecute(final Domanda domanda) {
			dialog.dismiss();
			if (domanda != null) {
				if (domanda.getType().equals("sino")) {
					setContentView(R.layout.domanda_sino);
					((TextView) findViewById(R.id.Titolo)).setText(domanda
							.getTitle());
					((TextView) findViewById(R.id.Testo)).setText(domanda
							.getTesto());

					Button invia = (Button) findViewById(R.id.buttonsi);
					invia.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View arg0) {

							String[] params = { domanda.getId() + "", 0 + "" };
							new RispostaTask().execute(params);
						}

					});
					Button inviaNo = (Button) findViewById(R.id.buttonno);
					inviaNo.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View arg0) {

							new RispostaTask().execute();
						}

					});
				} else {
					setContentView(R.layout.domanda_rispostamultipla);
					((TextView) findViewById(R.id.Titolo)).setText(domanda
							.getTitle());
					((TextView) findViewById(R.id.Testo)).setText(domanda
							.getTesto());
					final RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
					String[] risposte = domanda.getRisposte();
					((RadioButton) findViewById(R.id.radio0))
							.setText(risposte[0]);
					((RadioButton) findViewById(R.id.radio1))
							.setText(risposte[1]);
					((RadioButton) findViewById(R.id.radio2))
							.setText(risposte[2]);

					Button invia = (Button) findViewById(R.id.button2);
					invia.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View arg0) {
							int checked = -1;
							switch (rg.getCheckedRadioButtonId()) {
							case R.id.radio0:
								checked = 0;
							case R.id.radio1:
								checked = 1;
							case R.id.radio2:
								checked = 2;
							}
							new RispostaTask().execute();
						}

					});
				}

			} else {

				AlertDialog.Builder builder = new AlertDialog.Builder(context);
				builder.setTitle("Errore");
				builder.setMessage("C'è stato qualche problema nel download della domanda");
				builder.show();
			}
		}
	}

	private class QuestTask extends AsyncTask<Object, String, Quest> {
		ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			dialog = ProgressDialog.show(DomandaActivity.this, "",
					"Loading. Please wait...", true);
		}

		@Override
		protected Quest doInBackground(Object... params) {

			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			// nameValuePairs.add(new BasicNameValuePair("username",
			// user.getText().toString()));
			// nameValuePairs.add(new BasicNameValuePair("password",
			// passw.getText().toString()));
			Quest quest = (Quest) ConnectionUtils
					.HttpCreateClient(
							"http://monossido.ath.cx/teamcommitted/backend/API/quest.jsp",
							nameValuePairs);

			return quest;
		}

		@Override
		protected void onPostExecute(Quest quest) {
			dialog.dismiss();
			if (quest != null) {
				setContentView(R.layout.quest);
				Button scan = (Button) findViewById(R.id.scanna);
				scan.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						IntentIntegrator integrator = new IntentIntegrator(
								DomandaActivity.this);
						integrator.initiateScan();
					}
				});
				((TextView) findViewById(R.id.Titolo))
						.setText(quest.getTitle());
				((TextView) findViewById(R.id.Testo)).setText(quest.getTesto());
			} else {

				AlertDialog.Builder builder = new AlertDialog.Builder(context);
				builder.setTitle("Errore");
				builder.setMessage("C'è stato qualche problema nel download della domanda");
				builder.show();
			}
		}

	}

	private class RispostaTask extends AsyncTask<String, String, Void> {
		ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			dialog = ProgressDialog.show(DomandaActivity.this, "",
					"Loading. Please wait...", true);
		}

		@Override
		protected Void doInBackground(String... arg0) {
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			SharedPreferences prefs = getSharedPreferences("SafetyGame", Context.MODE_PRIVATE);

			nameValuePairs.add(new BasicNameValuePair("username",
					prefs.getString("user", "")));
			nameValuePairs.add(new BasicNameValuePair("password",
					prefs.getString("password", "")));
			nameValuePairs.add(new BasicNameValuePair("id", domanda.getId() + ""));
			nameValuePairs.add(new BasicNameValuePair("punti", domanda.getPunteggio() + ""));
			nameValuePairs.add(new BasicNameValuePair("risposta1", domanda.getRisposte()[0]));
			nameValuePairs.add(new BasicNameValuePair("risposta2", domanda.getRisposte()[1]));
			nameValuePairs.add(new BasicNameValuePair("risposta3", domanda.getRisposte()[2]));
			nameValuePairs.add(new BasicNameValuePair("corretta", domanda.getCorretta() + ""));
			nameValuePairs.add(new BasicNameValuePair("rispostaData", arg0[1]));

			ConnectionUtils
					.HttpCreateClient(
							"http://monossido.ath.cx/teamcommitted/backend/API/rispondi.jsp",
							nameValuePairs);
			return null;
		}

		@Override
		protected void onPostExecute(Void arg0) {
			dialog.dismiss();
		}
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		IntentResult scanResult = IntentIntegrator.parseActivityResult(
				requestCode, resultCode, intent);
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