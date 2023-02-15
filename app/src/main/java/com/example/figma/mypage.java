package com.example.figma;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class mypage extends Activity {
    // 다른 페이지에서 마이페이지 버튼 눌렀을 때
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);
    }
}
