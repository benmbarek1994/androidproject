package com.dorsaf.book;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.dorsaf.book.SplashScreen;
import com.mybook.book.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences preferences= getSharedPreferences(Constant.MY_PREF, MODE_PRIVATE);
                if(preferences.getBoolean(Constant.PREF_IS_CONNECT, false)){
                    startActivity(new Intent(SplashScreen.this,MainActivity.class));
                }
                else
                {
                    startActivity(new Intent(SplashScreen.this,LoginActivity.class));
                }
                finish();

            }
        },1500);

    }

}
