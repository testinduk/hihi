package com.example.figma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;

import androidx.annotation.Nullable;


public class notice_list extends AppCompatActivity {
    @Override

    private SearchView nSearchView;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notice_list);

        // 글쓰기 버튼
        Button writingButton = findViewById(R.id.writingButton);
        writingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), notice_writing.class);
                startActivity(intent);
            }
        });

        //채팅 버튼
        ImageButton chatButton = findViewById(R.id.chatButton);
        chatButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), chat_person.class);
                startActivity(intent);
            }
        });

        // 나눔 버튼
                ImageButton sharingButton = findViewById(R.id.sharingButton);
                sharingButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), sharing_board.class);
                        startActivity(intent);
            }
        });

        // 홈 버튼
        ImageButton homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), main_home.class);
                startActivity(intent);
            }
        });

        // 게시판 버튼
        ImageButton boardButton = findViewById(R.id.boardButton);
        boardButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), bullentin_board.class);
                startActivity(intent);
            }
        });

        // 마이페이지 버튼
        ImageButton mypageButton = findViewById(R.id.mypageButton);
        mypageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), mypage.class);
                startActivity(intent);
            }
        });

        // 뒤로가기 버튼
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), main_home.class);
                startActivity(intent);
            }
        });

        //글쓰기 버튼 연동
        Button developer_info_btn = (Button) findViewById(R.id.SerchView4);
        developer_info_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), bullentin_board_writing.class);
                startActivity(intent);
            }
        });

        nSearchView = findViewById(R.id.searchView); //SearchView

        nSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                // 입력받은 문자열 처리
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                // 입력란의 문자열이 바뀔 때 처리
                return false;
            }
        });

        //글쓰기 버튼 연동
        Button developer_info_btn = (Button) findViewById(R.id.SerchView4);
        developer_info_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), bullentin_board_writing.class);
                startActivity(intent);
            }
        });

        nSearchView = findViewById(R.id.searchView); //SearchView

        nSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                // 입력받은 문자열 처리
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                // 입력란의 문자열이 바뀔 때 처리
                return false;
            }
        });

    }
}