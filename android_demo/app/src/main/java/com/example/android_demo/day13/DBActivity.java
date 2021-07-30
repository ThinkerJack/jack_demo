package com.example.android_demo.day13;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_demo.R;
//操作数据库
public class DBActivity extends AppCompatActivity {
    private MyDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_activity);
        Button button = (Button) findViewById(R.id.create_db);
        //获取帮助类
        databaseHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.getWritableDatabase();
            }
        });
        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name", "wu chao");
                values.put("author", "you");
                values.put("pages", 999);
                values.put("price", 16.96);
                db.insert("Book", null, values);
                values.clear();
                values.put("name", "wu chao2");
                values.put("author", "you2");
                values.put("pages", 9992);
                values.put("price", 16.962);
                db.insert("Book", null, values);
                values.clear();
            }
        });
        Button updateData = (Button) findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
//                values.put("name", "wu chao");
                values.put("author", "me");
                values.put("pages", 999);
                values.put("price", 0001);
                db.update("Book", values, "name = ?", new String[]{"wu chao"});
            }
        });
        Button deleteData = (Button) findViewById(R.id.delete_data);
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                db.delete("Book", "name = ?", new String[]{"wu chao2"});

            }
        });
        Button selectData = (Button) findViewById(R.id.select_data);
        selectData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                // 查询Book表中所有的数据
                Cursor cursor = db.query("Book", null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        // 遍历Cursor对象，取出数据并打印
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("DBActivity", "book name is " + name);
                        Log.d("DBActivity", "book author is " + author);
                        Log.d("DBActivity", "book pages is " + pages);
                        Log.d("DBActivity", "book price is " + price);
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
        });
    }
}