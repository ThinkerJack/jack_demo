package com.example.android_demo.day14;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.android_demo.R;
//获取运行时权限
public class RuntimePermissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runtime_permission);
        Button makeCall = (Button) findViewById(R.id.make_call);
        makeCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //未申请权限 出错
//                    Intent intent = new Intent(Intent.ACTION_CALL);
//                      intent.setData(Uri.parse("tel:10086"));
//                    startActivity(intent);
                    //如果没有打电话权限
                    if (ContextCompat.checkSelfPermission(
                            RuntimePermissionActivity.this, Manifest.permission.CALL_PHONE)
                            != PackageManager.PERMISSION_GRANTED) {
                        //申请打电话权限
                        ActivityCompat.requestPermissions(
                                RuntimePermissionActivity.this,
                                new String[]{Manifest.permission.CALL_PHONE}, 1);
                    } else {
                        call();
                    }
                } catch (SecurityException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void call() {
        try {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:10086"));
            startActivity(intent);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
    //权限处理结束会走到这里
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    call();
                } else {
                    Toast.makeText(this, "You denied the permission", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
}