package com.example.android_demo.day10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

//静态广播 无需启动程序就能响应
public class BootCompleteReceiver extends BroadcastReceiver {

    private static final String ACTION_BOOT = "android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
        //不加这行代码是接收不到广播的
        if (ACTION_BOOT.equals(intent.getAction())) {
            Toast.makeText(context, "开机了", Toast.LENGTH_LONG).show();
            Log.d("BootCompleteReceiver", "cao");
        }

    }
}