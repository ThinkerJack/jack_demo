package com.example.android_demo.day12;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_demo.R;
//SharedPreferences本地存储
public class SPActivity extends AppCompatActivity {

    private static final String TAG = "SPActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_activity);
        Button saveData = (Button) findViewById(R.id.save_data);
        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name", "tom");
                editor.putInt("age", 22);
                editor.putBoolean("live", false);
                editor.apply();
            }
        });
        Button getData = (Button) findViewById(R.id.get_data);
        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
                String name = preferences.getString("name", "cao");
                int age = preferences.getInt("age", 0);
                boolean live = preferences.getBoolean("live", true);
                Log.d(TAG, name);
                Log.d(TAG, age + "");
                Log.d(TAG, live + "");
            }
        });
    }
}