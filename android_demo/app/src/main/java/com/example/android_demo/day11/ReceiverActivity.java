package com.example.android_demo.day11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_demo.R;
//发送自定义广播
public class ReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        Button button = (Button) findViewById(R.id.button_receiver);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new
                        Intent("com.example.android_demo.MY_BROADCAST");
                //android 8.0 隐式广播必须指定包名 变成显式广播
                intent.setPackage(getPackageName());
                sendOrderedBroadcast(intent,null);
            }
        });
    }
}