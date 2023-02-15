package com.example.figma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class main_home extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_home);

        Button show_notice_more = findViewById(R.id.show_notice_more);
        Button show_notice_writing = findViewById(R.id.show_notice_writing);
        Button btn_timetable = findViewById(R.id.btn_timetable);
        show_notice_more.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), notice_list.class);
                startActivity(intent);
            }
        });

        show_notice_writing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), notice_writing.class);
                startActivity(intent);
            }
        });

        btn_timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Timetable.class);
                startActivity(intent);
            }
        });
    }
}