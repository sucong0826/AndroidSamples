package com.su.androidsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.su.androidsample.animation.BouncingBalls;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(stringFromJNI());

        findViewById(R.id.bb_btn).setOnClickListener((v) -> startActivity(new Intent(this, BouncingBalls.class)));
    }

    public native String stringFromJNI();

    static {
        System.loadLibrary("hello-jni");
    }

    public void count(int i) {
        Log.i("MainActivity", i + "");
    }
}
