import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

/// @author wu chao
/// @project flutter_demo
/// @date 2022/1/24
class Test extends StatefulWidget {
  const Test({Key? key}) : super(key: key);

  @override
  _TestState createState() => _TestState();
}

class _TestState extends State<Test> {
  List<double> list = [];
  int count = 0;

  @override
  void didUpdateWidget(Test oldWidget) {
    super.didUpdateWidget(oldWidget);
    print("didUpdateWidget me");
  }

  @override
  Widget build(BuildContext context) {
    print("走了还build");

    return Scaffold(
      appBar: AppBar(
        title: Text("LifeCycle"),
      ),
      body: TestView(list, count),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          setState(() {
            list.add(0);
            count++;
          });
        },
        child: Icon(Icons.add),
      ),
    );
  }
}

class TestView extends StatefulWidget {
  final List<double> list;
  final int count;

  TestView(this.list, this.count);

  @override
  State<StatefulWidget> createState() {
    return _TestViewState();
  }
}

class _TestViewState extends State<TestView> {
  @override
  void initState() {
    super.initState();
    print("initState");
  }

  @override
  void didUpdateWidget(TestView oldWidget) {
    super.didUpdateWidget(oldWidget);
    print("didUpdateWidget");
    print("list:${oldWidget.list.length}:${widget.list.length}");
    print("count:${oldWidget.count}:${widget.count}");
  }

  @override
  Widget build(BuildContext context) {
    print("build");
    return Container();
  }
}
