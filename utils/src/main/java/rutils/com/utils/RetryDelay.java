package rutils.com.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class RetryDelay implements
        Function<Observable<? extends Throwable>, Observable<?>> {

    // 重试计数
    private int retryCnt;
    // 最大重试次数
    private int retryMaxCnt = 10;
    // 每次重试延时
    private int delayMillis = 1000;

    public RetryDelay() {

    }

    public RetryDelay(int retryCnt, int retryMaxCnt, int delayMillis) {
        this.retryCnt = retryCnt;
        this.retryMaxCnt = retryMaxCnt;
        this.delayMillis = delayMillis;
    }

    @Override
    public Observable<?> apply(Observable<? extends Throwable> throwable) throws Exception {
        return throwable.flatMap(new Function<Throwable, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Throwable throwable) throws Exception {
                if (throwable instanceof IOException) {
                    if (retryCnt++ < retryMaxCnt) {
                        return Observable.timer(delayMillis, TimeUnit.MILLISECONDS);
                    } else {
                        retryCnt = 0;
                        return Observable.error(new RetryThrowable());
                    }
                } else {
                    return Observable.error(throwable);
                }
            }
        });
    }
}
