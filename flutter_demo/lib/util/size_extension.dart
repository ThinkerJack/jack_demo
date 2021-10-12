import 'adaptive_size_util.dart';

extension getSize on num {
  double get s => SizeAdaptiveUtil().size(this);
  double get sp => SizeAdaptiveUtil().fontSize(this);
}
