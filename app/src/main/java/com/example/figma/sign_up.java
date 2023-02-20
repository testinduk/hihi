package com.example.figma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.auth.AuthResult;

public class sign_up extends AppCompatActivity {
    private FirebaseAuth mAuth; //안드로이드와 파이어베이스 사이의 인증을 확인하기 위한 인스턴스 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        mAuth = FirebaseAuth.getInstance(); //선언한 인스턴스를 초기화
        findViewById(R.id.finishBT).setOnClickListener(onClickListener);

        // 뒤로가기 버튼
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
            }
        });
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.finishBT:
                    signUp();
                    break;
            }
        }
    };

    private void signUp() {
        String id = ((EditText) findViewById(R.id.editTextTextPersonName2)).getText().toString();
        String password = ((EditText) findViewById(R.id.editTextTextPassword)).getText().toString();
        String passwordCheck = ((EditText) findViewById(R.id.editTextNumberPassword)).getText().toString();

        if (id.length() > 0 && password.length() > 0 && passwordCheck.length() > 0) {
            if (password.equals(passwordCheck)) {
                mAuth.createUserWithEmailAndPassword(id, password)
                        .addOnCompleteListener(this, new
                                OnCompleteListener<AuthResult>() //사용자가 입력한 아이디와 비밀번호를 파이어베이스에 저장시켜주는 코드
                                {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) //정상적으로 회원정보가 저장된 경우
                                        {
                                            Toast.makeText(com.example.figma.sign_up.this, "회원가입에 성공했습니다", Toast.LENGTH_SHORT).show();
                                            ;
                                        } else {
                                            if (task.getException().toString() != null) //정상적으로 회원정보가 저장되지 않는 경우
                                            {
                                                Toast.makeText(com.example.figma.sign_up.this, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show();
                                            } //Toast.makeText()토스트 알림을 띄워주는 함수
                                        }
                                    }
                                });
            } else {
                Toast.makeText(com.example.figma.sign_up.this, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(com.example.figma.sign_up.this, "아이디와 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show();
        }
    }
}
