package com.lorenzobraghetto.safetygame.View;

import com.lorenzobraghetto.safetygame.R;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

public class TimerNotifica extends Service
{
	private long mStartTime;
	private	Handler mHandler = new Handler();
	private NotificationManager mNotificationManager;
	private Notification notification;

	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
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

				mNotificationManager.notify(1, notification);
		     	
				mHandler.postDelayed(this, 100000);

		   }
		};
	
}