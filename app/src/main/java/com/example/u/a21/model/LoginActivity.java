package com.example.u.a21.model;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.u.a21.R;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText txtlogin = (EditText)findViewById(R.id.txtLogin);
        Button btnlogin = (Button)findViewById(R.id.btnLogin);
        Button btnclose = (Button)findViewById(R.id.btnClose);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                Toast.makeText(LoginActivity.this, "登录", Toast.LENGTH_LONG).show();
            }
        });


    }
}
