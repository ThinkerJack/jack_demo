package com.example.android_demo.day05;

/**
 * Copyright (C), 2015-2021
 * FileName: Fruit
 * Author: Jack
 * Date: 2021/6/3
 * Description:
 */
public class Fruit {
    private String name;
    private int imageId;

    public Fruit(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
