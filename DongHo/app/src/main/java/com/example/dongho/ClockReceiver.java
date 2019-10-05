package com.example.dongho;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ClockReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("sang tran","hello ban");
        String keyclock= intent.getExtras().getString("hello");
        Intent myinten=new Intent(context,Nhac.class);
        myinten.putExtra("hellow",keyclock);
        context.startService(myinten);

    }
}
