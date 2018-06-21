package rutils.com.utils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class HttpCallback<T> implements Observer<T> {

    private Operation operation;

    public HttpCallback(Operation op) {
        this.operation = op;
    }

    public HttpCallback() {

    }

    @Override
    public void onSubscribe(Disposable d) {
        if (!NetworkUtils.isConnected()) {
            ToastUtils.showToast("网络连接不可用");
            d.dispose();
        }

        if (operation != null) {
            operation.preOp();
        }
    }

    @Override
    public void onNext(T value) {
        onSuccess(value);
    }

    @Override
    public void onError(Throwable e) {
        if (operation != null) {
            operation.endOp();
        }
        onFail(e);
    }

    @Override
    public void onComplete() {
        if (operation != null) {
            operation.endOp();
        }
        onEnd();
    }

    public void onFail(Throwable throwable) {
        if (throwable instanceof RetryThrowable) {
            ToastUtils.showToast("请求超时");
        }
    }

    public abstract void onSuccess(T value);

    public void onEnd() {

    }
}
