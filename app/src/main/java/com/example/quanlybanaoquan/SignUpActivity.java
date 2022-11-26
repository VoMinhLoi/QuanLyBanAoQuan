package com.example.quanlybanaoquan;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    Button logInBTAX, signUpBTAX;
    EditText nameET, passET, confirmET;
    String name, pass, confirm;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        AnhXa();
        mAuth = FirebaseAuth.getInstance();
        signUpBTAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetDataEditText();
                if(name.isEmpty()){
                    nameET.setError("Trống");
                    nameET.requestFocus();
                }
                else
                    if(pass.isEmpty()){
                        passET.setError("Trống");
                        passET.requestFocus();
                    }
                    else
                        if(confirm.isEmpty()){
                            confirmET.setError("Trống");
                            confirmET.requestFocus();
                        }
                        else
                            if(pass.equals(confirm)){
                                UpdateDataToFirebase();
                            }
                            else{
                                passET.setError("Không khớp mật khẩu");
                                passET.requestFocus();
                            }
            }
        });
        logInBTAX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
                startActivity(intent);
            }
        });
    }
    public void AnhXa(){
        nameET = findViewById(R.id.nameET);
        passET = findViewById(R.id.passET);
        confirmET = findViewById(R.id.passConfirmET);
        logInBTAX = findViewById(R.id.logInBT);
        signUpBTAX = findViewById(R.id.signUpBT);
    }
    public void GetDataEditText(){
        name = nameET.getText().toString();
        pass = passET.getText().toString();
        confirm = confirmET.getText().toString();
    }
    public void UpdateDataToFirebase(){
        mAuth.createUserWithEmailAndPassword(name, pass).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    ConvertToLogin();
                }
                else {
                    Toast.makeText(SignUpActivity.this, "Tạo tài khoản thất bại", Toast.LENGTH_SHORT).show();
                    Log.w(TAG,"", task.getException()) ;
                }
            }
        });
    }
    public void ConvertToLogin(){
        Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
        startActivity(intent);
    }
}