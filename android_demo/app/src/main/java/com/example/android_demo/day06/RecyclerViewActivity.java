package com.example.android_demo.day06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.android_demo.R;
import com.example.android_demo.day05.Fruit;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initFruits();
        FruitRecyclerAdapter fruitRecyclerAdapter=
                new FruitRecyclerAdapter(fruitList);
        //指定布局方式 纵向
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //指定布局方式 瀑布流
        StaggeredGridLayoutManager layoutManager =
                new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);


        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(fruitRecyclerAdapter);
    }
    private void initFruits() {
        for (int i = 0; i < 4; i++) {
            Fruit apple = new Fruit("1", R.mipmap.ic_launcher);
            fruitList.add(apple);
            Fruit apple1 = new Fruit("21231233123213123121321311223311", R.mipmap.ic_launcher);
            fruitList.add(apple1);
            Fruit apple2 = new Fruit("3", R.mipmap.ic_launcher);
            fruitList.add(apple2);
            Fruit apple3 = new Fruit("432131313131232131", R.mipmap.ic_launcher);
            fruitList.add(apple3);
            Fruit apple4 = new Fruit("53123131321321312321133131321321321", R.mipmap.ic_launcher);
            fruitList.add(apple4);
        }
    }
}