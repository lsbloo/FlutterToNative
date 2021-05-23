

import 'package:demo_module_flutter/core/base_presenter.dart';
import 'package:demo_module_flutter/core/base_view.dart';

abstract class HelloPresenter extends BasePresenter {
  void onClickHelloWorld();
  void onClickButton();
}

abstract class HelloView extends BaseView {
  void showMessage(String message);
}

abstract class NativeChannel {
  void senderMethod(String method);
}
