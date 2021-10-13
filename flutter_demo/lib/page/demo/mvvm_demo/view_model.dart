import 'package:flutter/cupertino.dart';
import 'package:flutter_demo/page/demo/mvvm_demo/model.dart';

/// @author wu chao
/// @project flutter_demo
/// @date 2021/10/12

//使用单例+ChangeNotifier通知实现MVVM
class TestViewModel extends ChangeNotifier {
  static final TestViewModel _instance = TestViewModel.internal();

  TestViewModel.internal();

  factory TestViewModel() => _instance;

  TestModel testModel = TestModel("123");

  void changeData(){
    testModel.data = "456";
    notifyListeners();
  }

}
