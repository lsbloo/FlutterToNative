

import 'package:demo_module_flutter/app/helloworld/contract/helloworld_contract.dart';
import 'package:demo_module_flutter/core/channel/native_channels.dart';

class ManagerChannelImpl implements NativeChannel {
  CoreChannel nativeChannel = CoreChannel();

  @override
  void senderMethod(String method) {
    nativeChannel.sendMethod(method);
  }
}
