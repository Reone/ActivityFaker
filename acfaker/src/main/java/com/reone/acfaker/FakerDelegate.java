package com.reone.acfaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by wangxingsheng on 2018/10/22.
 * desc:使用时重写需要使用的方法，会在对应的生命周期执行这些方法`
 * <p>
 * 注意：每个方法中的context是faker页面的context
 */
public class FakerDelegate {

    protected void onCreate(@NonNull Activity context, @Nullable Bundle savedInstanceState) {
    }

    protected void onResume(@NonNull Activity context) {
    }

    protected void onPause(@NonNull Activity context) {
    }

    protected void onDestroy(@NonNull Activity context) {
    }

    protected void onActivityResult(@NonNull Activity context, int requestCode, int resultCode, Intent data) {
    }

    protected void onRestart(@NonNull Activity context) {
    }

    protected void onStart(@NonNull Activity context) {
    }

    protected void onStop(@NonNull Activity context) {
    }

    public void onRequestPermissionsResult(@NonNull Activity context, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    }

    protected void onSaveInstanceState(@NonNull Activity context, Bundle outState) {
    }
}
