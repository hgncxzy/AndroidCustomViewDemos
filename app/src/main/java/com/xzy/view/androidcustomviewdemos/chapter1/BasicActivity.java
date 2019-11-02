package com.xzy.view.androidcustomviewdemos.chapter1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.xzy.view.androidcustomviewdemos.R;

/**
 * 第一章：绘制基础 demo
 */
public class BasicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
    }
}
