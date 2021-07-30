package com.example.android_demo.day12;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_demo.R;

public class RememberPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remeber_password);
        CheckBox checkBox = (CheckBox) findViewById(R.id.remember_checkbox);
        EditText account = (EditText) findViewById(R.id.account);
        EditText password = (EditText) findViewById(R.id.remember_password);
        Button login = (Button) findViewById(R.id.remember_login);
        SharedPreferences preferences = getSharedPreferences("remember", MODE_PRIVATE);
        if (preferences.getString("account", "") != "") {
            //SharedPreferences 取
            account.setText(preferences.getString("account", ""));
            password.setText(preferences.getString("password", ""));
            checkBox.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accountStr = account.getText().toString();
                String passwordStr = password.getText().toString();
                if (accountStr.equals("") || passwordStr.equals("")) return;
                if (checkBox.isChecked()) {
                    //SharedPreferences 存
                    SharedPreferences.Editor editor = getSharedPreferences("remember", MODE_PRIVATE).edit();
                    editor.putString("account", accountStr);
                    editor.putString("password", passwordStr);
                    editor.apply();
                }
                finish();
            }
        });
    }
}