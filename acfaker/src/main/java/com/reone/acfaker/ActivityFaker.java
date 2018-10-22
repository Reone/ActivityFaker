package com.reone.acfaker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by wangxingsheng on 2018/10/22.
 * desc:一个透明的activity，用于执行delegate中的方法，不显示页面
 */
public class ActivityFaker extends Activity {
    private static FakerDelegate fakerDelegate;

    public static void runFakerDelegate(Context context, FakerDelegate delegate) {
        fakerDelegate = delegate;
        Intent intent = new Intent(context, ActivityFaker.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fakerDelegate.onCreate(this, savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fakerDelegate.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        fakerDelegate.onPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        fakerDelegate.onDestroy(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        fakerDelegate.onActivityResult(this, requestCode, resultCode, data);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        fakerDelegate.onRestart(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        fakerDelegate.onStart(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        fakerDelegate.onStop(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        fakerDelegate.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        fakerDelegate.onSaveInstanceState(this, outState);
    }

}
