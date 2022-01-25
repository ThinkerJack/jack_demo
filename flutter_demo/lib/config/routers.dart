import 'package:flutter/cupertino.dart';

import '../main.dart';
import '../page/demo/key/keys.dart';
import '../page/demo/life_cycle/life_cycle.dart';
import '../page/demo/mvvm/view.dart';
import '../page/demo/ticker/ticker.dart';

class Routers {
  //路由表
  static final Map<String, Widget> routerMap = {
    "TestMVVMView":TestMVVMView(),
    "StopWatch":StopWatch(),
    "Test":Test(),
    "PositionedTiles":PositionedTiles(),
  };
}
