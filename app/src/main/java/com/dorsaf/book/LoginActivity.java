package com.dorsaf.book;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mybook.book.R;

public class LoginActivity extends AppCompatActivity {
    EditText EditEmail,EdiPassword;
    Button btnEnvoyer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

    }

    private void  initView(){
        EditEmail= findViewById(R.id.edit_email);
        EdiPassword= findViewById(R.id.edit_password);
        btnEnvoyer= findViewById(R.id.btn_connect);

        btnEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=EditEmail.getText().toString();
                String pwd=EdiPassword.getText().toString();
                if(Patterns.EMAIL_ADDRESS.matcher(email).matches()==false|| TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(), "INCORRECT EMAIL", Toast.LENGTH_LONG).show();
                    return;
                }
                else if(pwd.length()<5 || TextUtils.isEmpty(pwd)){
                    Toast.makeText(getApplicationContext(), "INCORRECT PASSWORD", Toast.LENGTH_LONG).show();
                    return;
                }
                else
                    LoginUser();

            }
        });

    }

    private void LoginUser(){
        SharedPreferences sharedPref = getSharedPreferences(Constant.MY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(Constant.PREF_IS_CONNECT,true);
        editor.apply();
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

}

