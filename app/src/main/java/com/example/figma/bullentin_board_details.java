package com.example.figma;


import android.app.Activity;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


import androidx.annotation.Nullable;
public class bullentin_board_details extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bullentin_board_details);

        // 뒤로가기 버튼
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), bullentin_board.class);
                startActivity(intent);
            }
        });



    }
}

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
