package com.bw.zg3day05;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends RxAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new RxPermissions(this)
                .request(
                        "android.permission.VIBRATE",
                        "android.permission.RECORD_AUDIO" ,
                        "android.permission.CAMERA",
                        "android.permission.ACCESS_NETWORK_STATE",
                        "android.permission.WRITE_EXTERNAL_STORAGE" ,
                        "android.permission.ACCESS_FINE_LOCATION",
                        "android.permission.GET_TASKS" ,
                        "android.permission.ACCESS_WIFI_STATE" ,
                        "android.permission.CHANGE_WIFI_STATE" ,
                        "android.permission.WAKE_LOCK",
                        "android.permission.MODIFY_AUDIO_SETTINGS",
                        "android.permission.READ_PHONE_STATE",
                        "android.permission.RECEIVE_BOOT_COMPLETED",
                        "android.permission.FOREGROUND_SERVICE",
                        "android.permission.ACCESS_COARSE_LOCATION"
                )
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean){
                            Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


        Observable.interval(1, TimeUnit.SECONDS)
                .compose(this.<Long>bindToLifecycle())
                .compose(this.<Long>bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.i("qqq", "onNext: "+aLong);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });



    }
}
