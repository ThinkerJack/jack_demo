import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_demo/page/demo/mvvm_demo/view_model.dart';

/// @author wu chao
/// @project flutter_demo
/// @date 2021/10/12
class TestView extends StatefulWidget {
  const TestView({Key? key}) : super(key: key);

  @override
  _TestViewState createState() => _TestViewState();
}

class _TestViewState extends State<TestView> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("TextView"),
      ),
      body: Column(
        children: [
          GestureDetector(
            child: Text(testViewModel.testModel.data),
            onTap: () {
              testViewModel.changeData();
            },
          )
        ],
      ),
    );
  }

  TestViewModel testViewModel = TestViewModel();

  late final void Function() notifierChange;

  @override
  void initState() {
    super.initState();
    notifierChange = () {
      setState(() {});
    };
    testViewModel.addListener(notifierChange);
  }

  @override
  void dispose() {
    testViewModel.removeListener(notifierChange);
    super.dispose();
  }
}
