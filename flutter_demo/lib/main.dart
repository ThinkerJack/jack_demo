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
      home: Test(),
    );
  }
}
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
    return Scaffold(
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