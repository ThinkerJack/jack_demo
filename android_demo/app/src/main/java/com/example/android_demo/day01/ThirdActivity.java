package com.example.android_demo.day01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_demo.R;
import com.example.android_demo.day02.BaseActivity;

public class ThirdActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Button button = findViewById(R.id.button_3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //销毁当前Activity并存值
                Intent intent = new Intent();
                intent.putExtra("return","return data");
                setResult(RESULT_OK,intent);
                finish();
                //测试销毁所有Activity
//                ActivityCollector.finishAll();
            }
        });
    }
    //物理导航键拦截
    @Override
    public void onBackPressed() {
        //销毁当前Activity并存值
        Intent intent = new Intent();
        intent.putExtra("return","return data");
        setResult(RESULT_OK,intent);
        finish();
    }
}