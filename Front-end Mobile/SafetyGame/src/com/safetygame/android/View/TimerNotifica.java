/*
 * Name: PunteggiActivity.java
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
 * | 20120306 |Lorenzo Braghetto | * mUpdateTimeTask
 * | 20120302 |Lorenzo Braghetto | + onStartCommand
 * |          |                  | + mUpdateTimeTask
 * +----------+------------------+---------------------
 *
*/
package com.safetygame.android.View;

import java.util.List;

import com.safetygame.android.R;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;

public class TimerNotifica extends Service
{
	private long mStartTime;
	private	Handler mHandler = new Handler();
	private NotificationManager mNotificationManager;
	private Notification notification;
	private SharedPreferences prefs;

	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		
		prefs = getSharedPreferences("login", Context.MODE_PRIVATE);

		mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
	       
		int icon = R.drawable.ic_launcher;
		CharSequence tickerText = "Una nuova domanda ti attende";
		long when = System.currentTimeMillis();
		notification = new Notification(icon, tickerText, when);
	   
		Context context = getApplicationContext();
		CharSequence contentTitle = "SafetyGame nuova domanda";
		CharSequence contentText = "Una nuova domanda ti attende";
		Intent notificationIntent = new Intent(context, DomandaActivity.class);
		notificationIntent.putExtra("Domanda", true);
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		
		notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
			
		mStartTime = System.currentTimeMillis();
		//mHandler.removeCallbacks(mUpdateTimeTask);
		mHandler.postDelayed(mUpdateTimeTask, 10000);

		return START_STICKY;
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Runnable mUpdateTimeTask = new Runnable() {
		   public void run() {
		       final long start = mStartTime;
		       
		       ActivityManager activityManager = (ActivityManager) getSystemService( ACTIVITY_SERVICE );
		       List<RunningAppProcessInfo> procInfos = activityManager.getRunningAppProcesses();
		       for(int i = 0; i < procInfos.size(); i++){
		           if(procInfos.get(i).processName.equals("com.lorenzobraghetto.safetygame") && procInfos.get(i).importance==100) {
						mHandler.postDelayed(this, 100000);
						return;
		           }
		       }
		       if(prefs.getString("Username", "").length()>0)
		    	   mNotificationManager.notify(1, notification);
				
				mHandler.postDelayed(this, 100000);
		   }
		};
	
}