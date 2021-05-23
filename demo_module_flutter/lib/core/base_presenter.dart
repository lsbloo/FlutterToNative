abstract class BasePresenter<BaseView> {
  void init();
  void dispose();
  BaseView getView();
}