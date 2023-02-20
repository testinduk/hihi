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
    }
}