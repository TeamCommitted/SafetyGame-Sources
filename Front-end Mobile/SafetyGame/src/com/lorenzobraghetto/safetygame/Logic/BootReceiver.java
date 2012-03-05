package com.lorenzobraghetto.safetygame.Logic;

import com.lorenzobraghetto.safetygame.View.TimerNotifica;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class BootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent arg1) {
        Intent startServiceIntent = new Intent(context, TimerNotifica.class);
        context.startService(startServiceIntent);		
	}
}