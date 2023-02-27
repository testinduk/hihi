package com.example.figma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class bullentin_board extends Activity implements View.OnClickListener {
        RecyclerView.LayoutManager layoutManager;
        private RecyclerView recyclerView;
        private MainAdpter adpter;
        private List<Board> Boardlist;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.bullentin_board);

            Button developer_info_btn = (Button) findViewById(R.id.button12);
            developer_info_btn.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view){
                    Intent intent = new Intent(getApplicationContext(), bullentin_board_writing.class);
                    startActivity(intent);
                }
            });

            recyclerView = findViewById(R.id.recyclerView);

            findViewById(R.id.searchView).setOnClickListener(this);

            Boardlist = new ArrayList<>();
            Boardlist.add(new Board(null, "제목을 입력해주세요", null, "내용 입력"));

            adpter = new MainAdpter(Boardlist);
            recyclerView.setAdapter(adpter);
        }

    @Override
    public void onClick(View v) {

    }

    private class MainAdpter extends RecyclerView.Adapter<MainAdpter.MainViewHolder> {
        private List<Board> Boardlist;

        public MainAdpter(List<Board> boardlist) {
            Boardlist = boardlist;
        }

        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
            Board data = Boardlist.get(position);
            holder.bTitleTextView.setText(data.getTitle());
            holder.bNameTextView.setText(data.getContents());

        }

        @Override
        public int getItemCount() {
            return Boardlist.size();
        }

        class MainViewHolder extends RecyclerView.ViewHolder {
            private TextView bTitleTextView;
            private TextView bNameTextView;

            public MainViewHolder(@NonNull View itemView) {
                    super(itemView);

                    bTitleTextView = findViewById(R.id.item_title_text);
                    bNameTextView = findViewById(R.id.item_name_text);
                }
            }

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

public class bullentin_board extends Activity {
    // 다른 페이지에서 게시판 버튼 눌렀을 때
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bullentin_board);

        // 글쓰기 버튼
        Button writingButton = findViewById(R.id.writingButton);
        writingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), bullentin_board_writing.class);
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


    }
}