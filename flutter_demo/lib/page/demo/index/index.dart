import 'package:animations/animations.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_demo/config/routers.dart';
import 'package:flutter_demo/config/static_resource.dart';
import 'package:flutter_demo/util/util.dart';

class Index extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
        padding: EdgeInsets.all(20.s),
        child: GridView(
          gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
              crossAxisCount: 3,
              childAspectRatio: 1,
              crossAxisSpacing: 10.s,
              mainAxisSpacing: 10.s),
          children: [
            for (String demoName in StaticResource.demoMap.keys)
              //转场动画组件
              OpenContainer(
                openBuilder: (context, closedContainer) {
                  return Routers.routerMap[StaticResource.demoMap[demoName]]!;
                },
                // openColor: theme.cardColor,
                closedShape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.all(Radius.circular(150.s)),
                ),
                transitionDuration: Duration(milliseconds: 500),
                closedElevation: 0,
                // closedColor: Color(0xFFFFFFFF & Random().nextInt(0xFFFFFFFF)),
                closedColor: Colors.lightGreen,
                closedBuilder: (context, openContainer) {
                  return GestureDetector(
                      child: Center(
                        child: Padding(
                          padding: EdgeInsets.fromLTRB(20.s, 0, 10.s, 0),
                          child: Text(
                            demoName,
                            style: TextStyle(
                                color: Colors.white,
                                fontSize: 30.s,
                                fontWeight: FontWeight.bold),
                          ),
                        ),
                      ),
                      onTap: () {
                        openContainer();
                      });
                },
              ),
          ],
        ),
      ),
    );
  }
}
