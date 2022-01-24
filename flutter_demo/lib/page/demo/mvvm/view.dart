import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_demo/page/demo/mvvm/view_model.dart';

import '../../../util/router_util.dart';

/// @author wu chao
/// @project flutter_demo
/// @date 2021/10/12
class TestMVVMView extends StatefulWidget {
  const TestMVVMView({Key? key}) : super(key: key);

  @override
  _TestMVVMViewState createState() => _TestMVVMViewState();
}

class _TestMVVMViewState extends State<TestMVVMView> {

  TestViewModel testViewModel = TestViewModel();

  late var function;

  @override
  void initState() {
    super.initState();
    function = () {
      print("run1");
      if (mounted) {
        setState(() {});
      }
    };
    testViewModel.addListener( function());
  }

  @override
  void dispose() {
    print("消掉了");
    testViewModel.removeListener(function());
    super.dispose();
  }
  @override
  Widget build(BuildContext context) {
    print("走了还build");
    return Scaffold(
      appBar: AppBar(
        title: Text("TextView"),
      ),
      body: Center(
        child: Column(
          children: [
            SizedBox(height: 300),
            GestureDetector(
              child: Text(testViewModel.testModel.data),
              onTap: () {
                testViewModel.changeData();
              },
            ),
            GestureDetector(
              child: Text(testViewModel.testModel.data),
              onTap: () {
                RouterUtil.push(routerName: "Test");

              },
            ),
          ],
        ),
      ),
    );
  }

}
