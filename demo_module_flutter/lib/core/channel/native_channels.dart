

import 'package:flutter/services.dart';

class CoreChannel {
  final MethodChannel _plataformMethodChannel = MethodChannel('TestChannel');

  Future sendMethod(String method) {
    return _plataformMethodChannel.invokeListMethod(method);
  }
}