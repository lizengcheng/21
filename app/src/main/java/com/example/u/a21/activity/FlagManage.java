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
import com.example.u.a21.dao.FlagDAO;
import com.example.u.a21.model.Tb_flag;

public class FlagManage extends Activity {
private EditText txtFlag;
private Button btnEdit, btnDel;
private String strid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flagmanage);
        txtFlag = (EditText) findViewById(R.id.txtFlagManage);
        btnEdit = (Button) findViewById(R.id.btnFlagManageEdit);
        btnDel = (Button) findViewById(R.id.btnFlagManageDelete);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        strid = bundle.getString(Showinfo.FLAG);
        final FlagDAO flagDAO = new FlagDAO(FlagManage.this);
        txtFlag.setText(flagDAO.find(Integer.parseInt(strid)).getFlag());

        btnEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Tb_flag tb_flag = new Tb_flag();
                tb_flag.setid(Integer.parseInt(strid));
                tb_flag.setFlag(txtFlag.getText().toString());
                flagDAO.update(tb_flag);
                Toast.makeText(FlagManage.this, "", Toast.LENGTH_SHORT).show();
            }
        });

        btnDel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                flagDAO.detele(Integer.parseInt(strid));
                Toast.makeText(FlagManage.this, "", Toast.LENGTH_SHORT).show();
            }
        });
    }

}