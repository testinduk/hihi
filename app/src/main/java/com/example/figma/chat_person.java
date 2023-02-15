package com.example.figma;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class chat_person extends Activity {
    // 다른페이지에서 채팅 버튼 눌렀을 때
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_person);
    }
}
