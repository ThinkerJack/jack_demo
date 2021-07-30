package com.example.android_demo.day01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;

import com.example.android_demo.R;
import com.example.android_demo.day02.BaseActivity;
import com.example.android_demo.day19.DrawerLayoutActivity;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    //当活动第一次创建的时候调用
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setActionBar(toolbar);
        Log.d(TAG, this.toString());
        Button button = findViewById(R.id.button_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //弹出提示
//                Toast.makeText(Demo1Activity.this,
//                        "you click", Toast.LENGTH_SHORT).show();
//                finish();
                //隐式intent
//                Intent intent = new Intent(
//                        "com.example.android_demo.ACTION_START");
//                intent.addCategory("com.example.android_demo.MY_CATEGORY");
                //显式intent传递数据
//                Intent intent = new Intent(
//                        MainActivity.this, SecondActivity.class);
//                String data = "tran data";
//                intent.putExtra("extra data",data);
//                startActivity(intent);
                //打开手机浏览器
//                Intent intent = new Intent(
//                        Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("https://www.baidu.com"));
//                startActivity(intent);
                //打开电话s
//                Intent intent = new Intent(
//                        Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));
//                startActivity(intent);
                //activity启动模式测试 standard
//                Intent intent = new Intent(
//                        MainActivity.this, MainActivity.class);
//                startActivity(intent);
                //activity启动模式测试 singleTop
//                Intent intent = new Intent(
//                        MainActivity.this, SecondActivity.class);
//                startActivity(intent);
                //简便启动Activity
//                SecondActivity.actionStart(MainActivity.this, "1", "2");
                //day 03
//                Intent intent = new Intent(
//                        MainActivity.this, FirstUIActivity.class);
//                startActivity(intent);

                //day 04
//                Intent intent = new Intent(
//                        MainActivity.this, FrameLayoutActivity.class);
//                startActivity(intent);
//                Intent intent = new Intent(
//                        MainActivity.this, RelativeLayoutActivity.class);
//                startActivity(intent);
//                Intent intent = new Intent(
//                        MainActivity.this, CustomTitleActivity.class);
//                startActivity(intent);

                //day05
//                Intent intent = new Intent(
//                        MainActivity.this, ListViewActivity.class);
//                startActivity(intent);

                //day06
//                Intent intent = new Intent(
//                        MainActivity.this, RecyclerViewActivity.class);
//                startActivity(intent);

                //day07
//                Intent intent = new Intent(
//                        MainActivity.this, UIBestActivity.class);
//                startActivity(intent);

//                day08
//                Intent intent = new Intent(
//                        MainActivity.this, FragmentActivity.class);
//                startActivity(intent);

//                day09
//                Intent intent = new Intent(
//                        MainActivity.this, DynamicActivity.class);
//                startActivity(intent);
//                day10
//                Intent intent = new Intent(
//                        MainActivity.this, BroadcastActivity.class);
//                startActivity(intent);
//                day11
//                Intent intent = new Intent(
//                        MainActivity.this, ReceiverActivity.class);
//                startActivity(intent);
//                Intent intent = new Intent(
//                        MainActivity.this, LoginActivity.class);
//                startActivity(intent);
                //day12
//                Intent intent = new Intent(
//                        MainActivity.this, FileActivity.class);
//                startActivity(intent);
//                Intent intent = new Intent(
//                        MainActivity.this, SPActivity.class);
//                startActivity(intent);
//                Intent intent = new Intent(
//                        MainActivity.this, RememberPasswordActivity.class);
//                startActivity(intent);
//                day13
//                Intent intent = new Intent(
//                        MainActivity.this, DBActivity.class);
//                startActivity(intent);
//                day14
//                Intent intent = new Intent(
//                        MainActivity.this, RuntimePermissionActivity.class);
//                startActivity(intent);
//                day15
//                Intent intent = new Intent(
//                        MainActivity.this, ContactsActivity.class);
//                startActivity(intent);
//                Intent intent = new Intent(
//                        MainActivity.this, NotificationActivity.class);
//                startActivity(intent);
//                day16
//                Intent intent = new Intent(
//                        MainActivity.this, CameraActivity.class);
//                startActivity(intent);
//                day17
//                Intent intent = new Intent(
//                        MainActivity.this, WebViewActivity.class);
//                startActivity(intent);
//                Intent intent = new Intent(
//                        MainActivity.this, NetActivity.class);
//                startActivity(intent);
                //day18
//                Intent intent = new Intent(
//                        MainActivity.this, ServiceActivity.class);
//                startActivity(intent);
                //day19
                Intent intent = new Intent(
                        MainActivity.this, DrawerLayoutActivity.class);
                startActivity(intent);

            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this,
                        "you clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,
                        "you clicked remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }
}