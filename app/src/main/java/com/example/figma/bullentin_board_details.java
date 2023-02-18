package com.example.figma;

import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class bullentin_board_details extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bullentin_board_details);
        ImageButton btn_amend = findViewById(R.id.btn_amend);


        btn_amend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), bullentin_board_writing.class);
                startActivity(intent);
            }
        });


    }
}

