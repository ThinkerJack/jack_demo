package com.example.android_demo.day03;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.android_demo.R;
import com.example.android_demo.day01.MainActivity;

public class FirstUIActivity extends AppCompatActivity {
    private static final String TAG = "FirstUIActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_first);
        Button button1 = findViewById(R.id.button_1);
        EditText editText = findViewById(R.id.editText_1);
        ImageView imageView = findViewById(R.id.image_view);
        ProgressBar progressBar = findViewById(R.id.progress_bar);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "button1 tap");
                //获取输入框内文字
//                String inputText = editText.getText().toString();
//                Log.d(TAG, inputText);
//                Toast.makeText(FirstUIActivity.this, "inputText", Toast.LENGTH_LONG).show();

                //更改img控件图片
//                imageView.setImageResource(R.drawable.img_2);

                //更改控件可见状态
//                if(progressBar.getVisibility() == View.GONE){
//                    progressBar.setVisibility(View.VISIBLE);
//                }else {
//                    progressBar.setVisibility(View.GONE);
//
//                }

                //修改进度条进度
//                int progress = progressBar.getProgress();
//                progress = progress + 10;
//                progressBar.setProgress(progress);

                //弹出提示框
//                AlertDialog.Builder dialog = new AlertDialog.Builder(FirstUIActivity.this);
//                dialog.setTitle("this is dialog");
//                dialog.setMessage("something important");
//                dialog.setCancelable(false);
//                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });
//                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                    }
//                });
//                dialog.show();

                //弹出进度提示框
                ProgressDialog progressDialog = new ProgressDialog(FirstUIActivity.this);
                progressDialog.setTitle("this is progressDialog");
                progressDialog.setMessage("Loading......");
                progressDialog.setCancelable(true);
                progressDialog.show();
            }
        });
    }
}