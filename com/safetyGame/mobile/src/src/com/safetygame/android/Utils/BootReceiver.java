/*
 * Name: BootReceiver.java
 * Package: com.safetygame.android.Utils
 * Author: Lorenzo Braghetto
 * Date: {Data di approvazione del file}
 * Version: 0.2
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+------------------+---------------------
 * |   Date   | Programmer       | Changes
 * +----------+------------------+---------------------
 * | 20120306 |Lorenzo Braghetto | + onReceive
 * +----------+------------------+---------------------
 *
*/
package com.safetygame.android.Utils;

import com.safetygame.android.View.TimerNotifica;

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