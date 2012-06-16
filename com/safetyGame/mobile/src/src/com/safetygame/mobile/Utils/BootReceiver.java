/*
 * Name: BootReceiver.java
 * Package: com.safetygame.android.Utils
 * Author: Lorenzo Braghetto
 * Date: 2012/06/16
 * Version: 1.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+------------------+---------------------
 * |   Date   | Programmer       | Changes
 * +----------+------------------+---------------------
 * | 20120506 |Lorenzo Braghetto | + onReceive
 * +----------+------------------+---------------------
 *
*/
package com.safetygame.mobile.Utils;

import com.safetygame.mobile.View.TimerNotifica;

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