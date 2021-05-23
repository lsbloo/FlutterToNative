

import 'package:demo_module_flutter/app/helloworld/contract/helloworld_contract.dart';
import 'package:demo_module_flutter/core/base_presenter.dart';

class HelloWorldPresenterImpl extends BasePresenter implements HelloPresenter {
  HelloView _view;
  NativeChannel _managerChannel;

  HelloWorldPresenterImpl(this._view, this._managerChannel);

  @override
  void dispose() {}

  @override
  void init() {}

  @override
  void onClickHelloWorld() {
    _managerChannel.senderMethod("METHOD CHANNEL SENDER");
    this.getView().showMessage("osvaldo airon filho");
  }

  @override
  getView() => this._view;

  @override
  void onClickButton() {
    _managerChannel.senderMethod("METHOD CHANNEL CLICK BUTTON");
  }
}
