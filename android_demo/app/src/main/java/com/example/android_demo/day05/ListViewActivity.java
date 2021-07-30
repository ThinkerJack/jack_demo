package com.example.android_demo.day05;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_demo.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {
    private String[] data = {"a", "b", "c", "d", "e", "f",
            "a", "b", "c", "d", "e", "f", "a", "b", "c", "d",
            "e", "f", "a", "b", "c", "d", "e", "f"};
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        //当前上下文，ListView子布局id，要适配的数据
        //android.R.layout.simple_list_item_1是默认的
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListViewActivity.this,
//                android.R.layout.simple_list_item_1, data);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(ListViewActivity.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                
                Fruit fruit = fruitList.get(position);
                Toast.makeText(ListViewActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits() {
        for (int i = 0; i < 4; i++) {
            Fruit apple = new Fruit("a", R.mipmap.ic_launcher);
            fruitList.add(apple);
            Fruit apple1 = new Fruit("b", R.mipmap.ic_launcher);
            fruitList.add(apple1);
            Fruit apple2 = new Fruit("c", R.mipmap.ic_launcher);
            fruitList.add(apple2);
            Fruit apple3 = new Fruit("d", R.mipmap.ic_launcher);
            fruitList.add(apple3);
            Fruit apple4 = new Fruit("e", R.mipmap.ic_launcher);
            fruitList.add(apple4);
        }
    }

}