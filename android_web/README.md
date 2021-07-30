# android_note

## 1.项目简介

自己写的一个登录demo，调用了真实的接口，主要就是想模拟一下真实的android开发流程。

## 2.环境简介

语言：java 1.8

依赖库：详见android_demo/app/build.gradle下的dependencies

## 3.项目截图

<img src="https://img-blog.csdnimg.cn/9b1016b7e4eb4fe58ae7cf5eb96c096f.png" style="zoom: 25%;" />

## 4.开发流程与代码逻辑简述

- 打开Android Studio配置安卓开发环境
- 编写xml布局文件
- 在Activity中获取页面控件，给按钮添加监听事件
- 将输入框中的元素通过网络请求发送给服务器，拿到返回结果后将json序列化为Java对象。

## 5.技术准备

- java基础语法

- [Android布局技术](https://developer.android.com/guide/topics/ui)

- [okhttp](https://github.com/square/okhttp)

- [GSON](https://github.com/google/gson)

  ```java
  Gson gson = new Gson();
  JsonBean data = gson.fromJson(responseData, JsonBean.class);
  ```

## 6.总结

一个简单的小APP，包含了移动开发中必备的环节，网络请求，获取页面元素，json序列化。官网文档+搜索引擎+一点经验解决工作中百分之九十五的问题。。
