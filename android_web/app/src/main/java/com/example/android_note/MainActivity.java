package com.example.android_note;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.model.JsonBean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView uid;
    private TextView password;
    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message message) {
            Toast.makeText(getApplicationContext(), "密码错误", Toast.LENGTH_SHORT).show();
            Log.d(TAG, message.toString());

            // This is where you do your work in the UI thread.
            // Your worker tells you in the message what to do.
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = (Button) findViewById(R.id.login);
        uid = (TextView) findViewById(R.id.uid);
        password = (TextView) findViewById(R.id.password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequestWithOkHttp();
            }
        });

    }

    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder()
                            .add("uid", uid.getText().toString())
                            .add("password", password.getText().toString())
                            .build();

                    Request request = new Request.Builder().url("https://api.letskeep.com/login").post(requestBody).build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    Gson gson = new Gson();
                    JsonBean data = gson.fromJson(responseData, JsonBean.class);
                    if (data.getCode() == 1001) {
                        Message message = handler.obtainMessage(1, "1");
                        message.sendToTarget();
                    } else {
                        Log.d(TAG, responseData);
                        Log.d(TAG, data.getMessage());
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}