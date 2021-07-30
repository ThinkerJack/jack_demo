package com.example.android_demo.day11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_demo.R;
import com.example.android_demo.day02.BaseActivity;

public class TestMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main);
        Button button = (Button) findViewById(R.id.button_test_main);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.android_demo.OFFLINE");
                sendBroadcast(intent);
            }
        });
    }
}