package com.example.android_demo.day01;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.android_demo.R;
import com.example.android_demo.day02.BaseActivity;

public class SecondActivity extends BaseActivity {


    private static final String TAG = "SecondActivity";

    public static void actionStart(Context context, String data1, String data2) {
        Intent intent = new Intent(
                context, SecondActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //获取上个Activity传来的数据
//        Intent intent = getIntent();
//        String data = intent.getStringExtra("extra data");
//        Log.d(TAG, data);
        Button button = findViewById(R.id.button_2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //销毁当前Activity
//                finish();
                //跳转页面 接改页面返回的值的方式
                Intent intent = new Intent(
                        SecondActivity.this, ThirdActivity.class);
                startActivityForResult(intent, 1);
                //测试singleTop
//                Intent intent = new Intent(
//                        SecondActivity.this, MainActivity.class);
//                startActivity(intent);

            }
        });
    }

    //当页面返回数据时 调用此回调函数
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("return");
                    Log.d(TAG, returnedData);
                }
                break;
            default:

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}