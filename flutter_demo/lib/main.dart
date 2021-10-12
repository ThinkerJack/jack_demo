// import 'package:device_preview/device_preview.dart';
import 'package:flutter/material.dart';
import 'package:flutter_demo/page/demo/index/index.dart';
import 'package:flutter_demo/util/adaptive_size_util.dart';
import 'package:flutter_demo/util/router_util.dart';

Future<void> main() async {
  SizeAdaptiveUtil.init();
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      //路由配置
      navigatorKey: RouterUtil.routerGlobalKey,
      onGenerateRoute: RouterUtil.jumpTo,
      //多屏幕展示
      // locale: DevicePreview.locale(context), // Add the locale here
      // builder: DevicePreview.appBuilder,
      title: 'Flutter Demo',
      home: Index(),
    );
  }
}
