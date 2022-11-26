package com.example.quanlybanaoquan;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInActivity extends AppCompatActivity {
    EditText nameET, passET;
    Button loginBT, signUpBT;
    FirebaseAuth mAuth;
    String name, pass;
    CheckBox rememberCB;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AnhXa();
        InitialRememberPass();
        loginBT.setOnClickListener(new View.OnClickListener() {

            @Override
                public void onClick(View view) {
                mAuth = FirebaseAuth.getInstance();
                GetDataFromEditText();
                System.out.println(name + pass);
                if(name.isEmpty() || pass.isEmpty()){
                    nameET.requestFocus();
                    nameET.setError("Trống");
                }
                else{
                    mAuth.signInWithEmailAndPassword(name, pass)
                            .addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        RememberPass();
                                        ConvertToTrangChu();
                                    }
                                    else{
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    }

                                }
                            });
                    }
                }
        });
        signUpBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
    public void AnhXa(){
        nameET = findViewById(R.id.nameETLG);
        passET = findViewById(R.id.passETLG);
        loginBT = findViewById(R.id.logInBTLG);
        signUpBT = findViewById(R.id.signUpBTLG);
        rememberCB = findViewById(R.id.rememberCB);

    }
    public void GetDataFromEditText(){
        name = nameET.getText().toString();
        pass = passET.getText().toString();
    }
    public void ConvertToTrangChu(){
        Intent intent = new Intent(LogInActivity.this, TrangChuActivity.class);
        startActivity(intent);
    }
    public void InitialRememberPass(){
        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);
        nameET.setText(sharedPreferences.getString("name", ""));
        passET.setText(sharedPreferences.getString("pass", ""));
        rememberCB.setChecked(sharedPreferences.getBoolean("remembered",false));
    }
    public void RememberPass(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(rememberCB.isChecked()){
            editor.putString("name",name);
            editor.putString("pass",pass);
            editor.putBoolean("remembered",true);
            editor.commit();
        }
        else {
            editor.remove("name");
            editor.remove("pass");
            editor.remove("remembered");
            editor.commit();
        }
    }
}