

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';


abstract class SimpleLifeCycle{
  void onCreatedView();
  void onStop();
  void onPause();
  void onResume();
  void onRecreate();
}

class BaseState<T extends BaseWidgetView> extends State<T> with WidgetsBindingObserver implements SimpleLifeCycle {


  @override
  void initState() {
    onCreatedView();
    super.initState();
    WidgetsBinding.instance.addObserver(this);

  }


  @override
  void didChangeAppLifecycleState(AppLifecycleState state) {
    switch(state) {
      case AppLifecycleState.resumed: {
        onResume();
      }
      break;
      case AppLifecycleState.paused: {
        onPause();
      }
      break;
      case AppLifecycleState.inactive: {
        onStop();
      }
      break;
      case AppLifecycleState.detached: {
        // OnDEstroyer?
      }
    }
    super.didChangeAppLifecycleState(state);
  }

  @override
  void dispose() {
    super.dispose();
    WidgetsBinding.instance.removeObserver(this);
  }

  @override
  void onCreatedView() {}

  @override
  void onPause() {
    print("onPause");
  }

  @override
  void onResume() {
    print("onResume");
  }

  @override
  void onStop() {}

  @override
  Widget build(BuildContext context) {
    return Container();
  }

  @override
  void onRecreate() {
    print("onView Recreated");
    onCreatedView();
  }

}
class BaseWidgetView extends StatefulWidget {
  BaseWidgetView({Key key}) : super(key: key);

  @override
  BaseState createState() => BaseState();
}