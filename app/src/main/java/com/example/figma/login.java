package com.example.figma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        firebaseAuth = FirebaseAuth.getInstance();

        editTextEmail = (EditText) findViewById(R.id.editTextTextPersonName);
        editTextPassword = (EditText) findViewById(R.id.editTextTextPassword);

        Button signup = findViewById(R.id.sign); //회원가입 버튼 클릭시 회원가입 페이지로 이동
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), sign_up.class);
                startActivity(intent);
            }
        });

//        buttonSignUp = (Button) findViewById(R.id.sign);// 회원가입 버튼 클릭시
//        buttonSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // SignUpActivity 연결
//                Intent intent = new Intent(getApplicationContext(), sign_up.class); //회원가입 화면으로 전환
//                startActivity(intent);
//            }
//        });
        buttonLogIn = (Button) findViewById(R.id.button); //로그인 버튼 클릭시
        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextEmail.getText().toString().equals("") && !editTextPassword.getText().toString().equals("")) {
                    loginUser(editTextEmail.getText().toString(), editTextPassword.getText().toString());
                    Intent intent = new Intent(getApplicationContext(), main_home.class);
                    startActivityForResult(intent, 1); //메인 홈으로 이동.
                } else {
                    Toast.makeText(login.this, "계정과 비밀번호를 입력하세요.", Toast.LENGTH_LONG).show();
                }
            }
        });

        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(getApplicationContext(), main_home.class);
                    startActivity(intent);
                    finish();
                } else {
                }
            }
        };
    }
    public void loginUser(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // 로그인 성공
                            Toast.makeText(login.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                            firebaseAuth.addAuthStateListener(firebaseAuthListener);
                            Intent intent = new Intent(getApplicationContext(), main_home.class);
                            startActivityForResult(intent, 1);
                        } else {
                            // 로그인 실패
                            Toast.makeText(login.this, "아이디 또는 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), login.class);
                            startActivityForResult(intent,1);
                        }
                    }
                });
    }
    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onStop() {
        super.onStop();
        if (firebaseAuthListener != null) {
            firebaseAuth.removeAuthStateListener(firebaseAuthListener);
        }

    }

    private class override {
    }
}