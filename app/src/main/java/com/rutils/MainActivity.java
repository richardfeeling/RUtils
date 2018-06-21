package com.rutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.reactivex.Observable;
import rutils.com.utils.HttpCallback;
import rutils.com.utils.Operation;
import rutils.com.utils.RetrofitUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Observable<JsonObject> login = RetrofitUtil.api(ApiService.class).login();
//        RetrofitUtil.retryRequest(login, new HttpCallback<JsonObject>() {
//            @Override
//            public void onSuccess(JsonObject value) {
//
//            }
//        });

        Observable<Integer> observable = Observable.just(1);

        RetrofitUtil.retryRequest(observable,
                new HttpCallback<Integer>(new CustomerOperation()) {
                    @Override
                    public void onSuccess(Integer value) {

                    }
                });
    }

    class CustomerOperation implements Operation {
        @Override
        public void preOp() {

        }

        @Override
        public void endOp() {

        }
    }
}
