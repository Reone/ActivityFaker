package com.reone.activityfaker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.reone.acfaker.ActivityFaker;
import com.reone.acfaker.FakerDelegate;
import com.reone.talklibrary.TalkApp;

public class SimpleActivity extends AppCompatActivity {
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fakerActivity();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askForResult();
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askForResult2(new Callback() {
                    @Override
                    public void onCallback(String data) {
                        TalkApp.talk("result : " + data);
                    }
                });
            }
        });
    }

    private void askForResult() {
        ActivityFaker.runFakerDelegate(this, new FakerDelegate() {
            @Override
            protected void onCreate(@NonNull Activity context, @Nullable Bundle savedInstanceState) {
                Intent intent = new Intent(context, SecondActivity.class);
                context.startActivityForResult(intent, 0);
            }

            @Override
            protected void onActivityResult(@NonNull Activity context, int requestCode, int resultCode, Intent data) {
                if (resultCode == Activity.RESULT_OK && requestCode == 0) {
                    TalkApp.talk("data : " + data.getStringExtra(SecondActivity.SECOND_RESULT_DATA));
                    context.finish();
                }
            }
        });
    }

    private void fakerActivity() {
        ActivityFaker.runFakerDelegate(this, new FakerDelegate() {

            @Override
            protected void onCreate(@NonNull final Activity context, @Nullable Bundle savedInstanceState) {
                TalkApp.talk("top is faker activity");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        TalkApp.talk("now it will finish");
                        context.finish();
                    }
                }, 3000);
            }
        });
    }


    private void askForResult2(final Callback callBack) {
        ActivityFaker.runFakerDelegate(this, new FakerDelegate() {
            @Override
            protected void onCreate(@NonNull Activity context, @Nullable Bundle savedInstanceState) {
                Intent intent = new Intent(context, SecondActivity.class);
                context.startActivityForResult(intent, 0);
            }

            @Override
            protected void onActivityResult(@NonNull Activity context, int requestCode, int resultCode, Intent data) {
                if (resultCode == Activity.RESULT_OK && requestCode == 0) {
                    if (callBack != null) {
                        callBack.onCallback(data.getStringExtra(SecondActivity.SECOND_RESULT_DATA));
                    }
                    context.finish();
                }
            }
        });
    }

    public interface Callback {
        void onCallback(String data);
    }
}
