package com.example.android_demo.day09;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_demo.R;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        //实际的业务逻辑在NewsTitleFragment文件下
    }
}