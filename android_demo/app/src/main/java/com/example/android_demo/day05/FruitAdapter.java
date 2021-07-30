package com.example.android_demo.day05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.android_demo.R;

import java.util.List;

/**
 * Copyright (C), 2015-2021
 * FileName: FruitAdapter
 * Author: Jack
 * Date: 2021/6/3
 * Description:
 */
public class FruitAdapter extends ArrayAdapter {
    private int resourceId;

    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = (Fruit) getItem(position);
        View view;
        ViewHolder viewHolder;
        //缓存加载好的布局，以便重用
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.fruitName  = (TextView) view.findViewById(R.id.fruit_name);
            viewHolder.fruitContent = (TextView) view.findViewById(R.id.fruit_content);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }
        //未优化代码
//        ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
//        TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
//        TextView fruitContent = (TextView) view.findViewById(R.id.fruit_content);
        //优化
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        viewHolder.fruitContent.setText("不管啥都一样");
        return view;
    }
    class  ViewHolder{
        ImageView fruitImage;
        TextView fruitName;
        TextView fruitContent;
    }
}
