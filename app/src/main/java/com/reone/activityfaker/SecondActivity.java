package com.reone.activityfaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    public static final String SECOND_RESULT_DATA = "second_result_data";

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.putExtra(SECOND_RESULT_DATA, "this is result");
                SecondActivity.this.setResult(Activity.RESULT_OK, intent);
                finish();
            }
        }, 2000);
    }
}
