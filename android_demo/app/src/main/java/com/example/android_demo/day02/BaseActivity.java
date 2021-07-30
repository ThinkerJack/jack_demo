package com.example.android_demo.day02;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android_demo.day01.MainActivity;
import com.example.android_demo.util.ActivityCollector;

//用于查看当前页面是哪个activity
public class BaseActivity extends AppCompatActivity {
    private OfflineReceiver offlineReceiver;
    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, getClass().getSimpleName());
        ActivityCollector.addActivity(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //注册广播监听器
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.android_demo.OFFLINE");
        offlineReceiver = new OfflineReceiver();
        registerReceiver(offlineReceiver, intentFilter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (offlineReceiver != null) {
            unregisterReceiver(offlineReceiver);
            offlineReceiver = null;
        }
    }

    class OfflineReceiver extends BroadcastReceiver {
        private static final String TAG = "OfflineReceiver";

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "customReceiver");
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("warning");
            builder.setMessage("你被踢下线了");
            builder.setCancelable(false);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCollector.finishAll();
                    intent.setClass(context, MainActivity.class);
                    startActivity(intent);
                }
            });
            builder.show();

        }
    }
}
