import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/scheduler.dart';
import 'package:flutter_demo/util/router_util.dart';

/// @author wu chao
/// @project flutter_demo
/// @date 2022/1/24
class StopWatch extends StatefulWidget {
  const StopWatch({Key? key}) : super(key: key);

  @override
  _StopWatchState createState() => _StopWatchState();
}

// 1. add SingleTickerProviderStateMixin
class _StopWatchState extends State<StopWatch>
    with SingleTickerProviderStateMixin {
  Duration _elapsed = Duration.zero;

  // 2. declare Ticker
  late final Ticker _ticker;

  @override
  void initState() {
    super.initState();
    // 3. initialize Ticker
    _ticker = this.createTicker((elapsed) {
      // 4. update state
      setState(() {
        _elapsed = elapsed;
      });
    });
    // 5. start ticker
    _ticker.start();
  }

  @override
  void dispose() {
    // 6. don't forget to dispose it
    _ticker.dispose();
    super.dispose();
  }


  @override
  Widget build(BuildContext context) {
    // 7. pass the elapsed time to a widget
    // that shows the formatted text as mm:ss:hh
    return Scaffold(
      appBar: AppBar(
        title: Text("Ticker"),
      ),
      body: Center(
        child: GestureDetector(
            onTap: () {
              RouterUtil.push(routerName: "TestMVVMView");
            },
            child: Text(
              "${_elapsed}",
              style: TextStyle(color: Colors.black),
            )),
      ),
    );
  }
}
