package com.example.android_demo.day06;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_demo.R;
import com.example.android_demo.day05.Fruit;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Copyright (C), 2015-2021
 * FileName: FruitRecyclerAdapter
 * Author: Jack
 * Date: 2021/6/4
 * Description:
 */
public class FruitRecyclerAdapter extends RecyclerView.Adapter<FruitRecyclerAdapter.ViewHolder> {
    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
        TextView fruitContent;
        View fruitView;

        public ViewHolder(View view) {
            super(view);
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
            fruitContent = (TextView) view.findViewById(R.id.fruit_content);
            fruitView = view;
        }
    }

    public FruitRecyclerAdapter(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }

    //创建ViewHolder实例
    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.fruit_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(view.getContext(),
                        "you click view" + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(view.getContext(),
                        "you click image" + fruit.getImageId(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    //对RecyclerView子项的数据进行赋值
    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
        holder.fruitContent.setText("都是一样的");

    }

    //返回RecyclerView的子项个数
    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}
