import 'package:flutter/cupertino.dart';

import '../mvvm/model.dart';

/// @author wu chao
/// @project flutter_demo
/// @date 2021/10/12

//使用单例+ChangeNotifier通知实现MVVM
class TestViewModel extends ChangeNotifier {
  static final TestViewModel _instance = TestViewModel.internal();

  TestViewModel.internal();

  factory TestViewModel() => _instance;

  late Function _listenFunc;

  TestModel testModel = TestModel("123");

  init({required Function function}) {
    _listenFunc = function;
    _instance.addListener(() {
      _listenFunc();
    });
  }

  destruction() {
    _instance.removeListener(() {
      _listenFunc();
    });
  }

  void changeData() {
    testModel.data = "456";
    notifyListeners();
    Future.delayed(Duration(seconds: 5), () {
      notifyListeners();
    });
  }
}
