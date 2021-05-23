
import 'package:demo_module_flutter/app/helloworld/contract/helloworld_contract.dart';
import 'package:demo_module_flutter/app/helloworld/manager/manager_channel.dart';
import 'package:demo_module_flutter/app/helloworld/presenter/helloworld_presenter.dart';
import 'package:demo_module_flutter/core/base_state.dart';
import 'package:demo_module_flutter/core/channel/router/router.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class HelloWorldPage extends BaseWidgetView {
  HelloWorldPage({Key key}) : super(key: key);

  @override
  _HelloWorldPageState createState() => _HelloWorldPageState();
}

class _HelloWorldPageState extends BaseState<HelloWorldPage>
    implements HelloView {
  HelloPresenter _presenter;
  NativeChannel _channel;
  String _message = "";

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      routes: RouterCore.ROUTERS,
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: Scaffold(
        appBar: AppBar(
          title: Text("asasasas"),
          centerTitle: true,
        ),
        body: Column(children: [
          Text(_message),
          ElevatedButton(onPressed: (){
            _presenter.onClickButton();
          }, child: Text("Click here"))
        ],),
      ),
    );
  }

  @override
  onCreatedView() {
    _channel = ManagerChannelImpl();
    _presenter = HelloWorldPresenterImpl(this,_channel);
    _presenter.onClickHelloWorld();
    super.onCreatedView();
  }

  @override
  void showMessage(String message) {
    setState(() {
      _message = message;
    });
  }
}
