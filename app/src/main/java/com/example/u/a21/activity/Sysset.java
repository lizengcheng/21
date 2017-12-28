package com.example.u.a21.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.u.a21.R;
import com.example.u.a21.dao.PwdDAO;
import com.example.u.a21.model.Tb_pwd;

public class Sysset extends Activity {
private EditText txtpwd;
private Button btnSet, btnsetCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sysset);
        txtpwd = (EditText) findViewById(R.id.txtPwd);                                                  //获取数据
        btnSet = (Button) findViewById(R.id.btnSet);
        btnsetCancel = (Button) findViewById(R.id.btnsetCancel);

        btnSet.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                PwdDAO pwdDAO = new PwdDAO(Sysset.this);
                Tb_pwd tb_pwd = new Tb_pwd(txtpwd.getText().toString());
                if (pwdDAO.getCount() == 0) {                                                           //判断是否设置密码
                    pwdDAO.add(tb_pwd);                                                                 //添加密码
                } else {
                    pwdDAO.update(tb_pwd);                                                              //修改密码
                }
                Toast.makeText(Sysset.this, "【密码】设置成功！", Toast.LENGTH_SHORT).show();        //提示
            }
        });

        btnsetCancel.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                txtpwd.setText("");                     //清空密码
                txtpwd.setHint("请输入密码!");          //提示
            }
        });
    }
}
