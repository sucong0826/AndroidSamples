package com.su.androidsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.widget.TextView;

import com.su.androidsample.animation.BouncingBalls;
import com.su.androidsample.basicjni.BasicJni;
import com.su.androidsample.basicjni.entity.Book;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int SEAT_POS = 12;

    private BasicJni basicJni = new BasicJni();
    private List<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(stringFromJNI());

        findViewById(R.id.bb_btn).setOnClickListener((v) -> startActivity(new Intent(this, BouncingBalls.class)));

        TextView myBookListTV = (TextView) findViewById(R.id.myBookListTV);
        bookList = basicJni.generateBooks();
        myBookListTV.setText(bookList.toString());
    }

    public native String stringFromJNI();

    static {
        System.loadLibrary("hello-jni");
    }

    public String count(String prefix, int i, String suffix) {
        Log.i("MainActivity", prefix + i + suffix);
        return prefix + i + suffix;
    }
}
