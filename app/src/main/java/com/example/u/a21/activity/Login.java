package com.example.u.a21.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.u.a21.R;
import com.example.u.a21.dao.PwdDAO;

public class Login extends Activity {
    private EditText txtlogin;
    private Button btnlogin, btnclose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtlogin = (EditText) findViewById(R.id.txtLogin);
        btnlogin = (Button) findViewById(R.id.btnLogin);
        btnclose = (Button) findViewById(R.id.btnClose);

        btnlogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Login.this, MainActivity.class);
                PwdDAO pwdDAO = new PwdDAO(Login.this);
                if ((pwdDAO.getCount() == 0 || pwdDAO.find().getPassword().isEmpty()) && txtlogin.getText().toString().isEmpty()) {
                    startActivity(intent);
                } else {
                    if (pwdDAO.find().getPassword().equals(txtlogin.getText().toString())) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(Login.this, "请输入正确的密码！", Toast.LENGTH_SHORT).show();
                    }
                }
                txtlogin.setText("");
            }
        });

        btnclose.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }
}
