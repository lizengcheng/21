package com.example.u.a21.activity;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.u.a21.R;
import com.example.u.a21.dao.FlagDAO;
import com.example.u.a21.dao.InaccountDAO;
import com.example.u.a21.dao.OutaccountDAO;
import com.example.u.a21.model.Tb_flag;
import com.example.u.a21.model.Tb_inaccount;
import com.example.u.a21.model.Tb_outaccount;

public class Showinfo extends Activity {
    public static final String FLAG = "id";// ����һ��������������Ϊ������
    private Button btnoutinfo, btnininfo, btnflaginfo;// ����3��Button����
    private ListView lvinfo;// ����ListView����
    private String strType = "";// �����ַ�������¼��������

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showinfo);// ���ò����ļ�

        lvinfo = (ListView) findViewById(R.id.lvinfo);// ��ȡ�����ļ��е�ListView���
        btnoutinfo = (Button) findViewById(R.id.btnoutinfo);// ��ȡ�����ļ��е�֧����Ϣ��ť
        btnininfo = (Button) findViewById(R.id.btnininfo);// ��ȡ�����ļ��е�������Ϣ��ť
        btnflaginfo = (Button) findViewById(R.id.btnflaginfo);// ��ȡ�����ļ��еı�ǩ��Ϣ��ť

        showInfo(R.id.btnoutinfo);// Ĭ����ʾ֧����Ϣ

        btnoutinfo.setOnClickListener(new OnClickListener() {// Ϊ֧����Ϣ��ť���ü����¼�
                    @Override
                    public void onClick(View arg0) {
                        showInfo(R.id.btnoutinfo);// ��ʾ֧����Ϣ
                    }
                });

        btnininfo.setOnClickListener(new OnClickListener() {// Ϊ������Ϣ��ť���ü����¼�
                    @Override
                    public void onClick(View arg0) {
                        showInfo(R.id.btnininfo);// ��ʾ������Ϣ
                    }
                });
        btnflaginfo.setOnClickListener(new OnClickListener() {// Ϊ��ǩ��Ϣ��ť���ü����¼�
                    @Override
                    public void onClick(View arg0) {
                        showInfo(R.id.btnflaginfo);// ��ʾ��ǩ��Ϣ
                    }
                });

lvinfo.setOnItemClickListener(new OnItemClickListener() {// ΪListView�������¼�

    // ��дonItemClick����
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String strInfo = String.valueOf(((TextView) view).getText());// ��¼����������Ϣ
        String strid = strInfo.substring(0, strInfo.indexOf('|'));// ������Ϣ�н�ȡ���
        Intent intent = null;// ����Intent����
        if (strType == "btnoutinfo" | strType == "btnininfo") {// �ж������֧������������Ϣ
            intent = new Intent(Showinfo.this, InfoManage.class);// ʹ��InfoManage���ڳ�ʼ��Intent����
            intent.putExtra(FLAG, new String[] { strid, strType });// ����Ҫ���ݵ�����
        } else if (strType == "btnflaginfo") {// �ж�����Ǳ�ǩ��Ϣ
            intent = new Intent(Showinfo.this, FlagManage.class);// ʹ��FlagManage���ڳ�ʼ��Intent����
            intent.putExtra(FLAG, strid);// ����Ҫ���ݵ�����
        }
        startActivity(intent);// ִ��Intent������Ӧ��Activity
    }
});
    }

    private void showInfo(int intType) {// �������ݴ���Ĺ������ͣ���ʾ��Ӧ����Ϣ
        String[] strInfos = null;// �����ַ������飬�����洢������Ϣ
        ArrayAdapter<String> arrayAdapter = null;// ����ArrayAdapter����
        switch (intType) {// ��intTypeΪ���������ж�
        case R.id.btnoutinfo:// �����btnoutinfo��ť
            strType = "btnoutinfo";// ΪstrType������ֵ
            OutaccountDAO outaccountinfo = new OutaccountDAO(Showinfo.this);// ����OutaccountDAO����
            // ��ȡ����֧����Ϣ�����洢��List���ͼ�����
            List<Tb_outaccount> listoutinfos = outaccountinfo.getScrollData(0, (int) outaccountinfo.getCount());
            strInfos = new String[listoutinfos.size()];// �����ַ�������ĳ���
            int i = 0;// ����һ����ʼ��ʶ
            for (Tb_outaccount tb_outaccount : listoutinfos) {// ����List���ͼ���
                // ��֧�������Ϣ��ϳ�һ���ַ������洢���ַ����������Ӧλ��
                strInfos[i] = tb_outaccount.getid() + "|" + tb_outaccount.getType() + " " + String.valueOf(tb_outaccount.getMoney()) + "Ԫ     "
                        + tb_outaccount.getTime();
                i++;// ��ʶ��1
            }
            break;
        case R.id.btnininfo:// �����btnininfo��ť
            strType = "btnininfo";// ΪstrType������ֵ
            InaccountDAO inaccountinfo = new InaccountDAO(Showinfo.this);// ����InaccountDAO����
            // ��ȡ����������Ϣ�����洢��List���ͼ�����
            List<Tb_inaccount> listinfos = inaccountinfo.getScrollData(0, (int) inaccountinfo.getCount());
            strInfos = new String[listinfos.size()];// �����ַ�������ĳ���
            int m = 0;// ����һ����ʼ��ʶ
            for (Tb_inaccount tb_inaccount : listinfos) {// ����List���ͼ���
                // �����������Ϣ��ϳ�һ���ַ������洢���ַ����������Ӧλ��
                strInfos[m] = tb_inaccount.getid() + "|" + tb_inaccount.getType() + " " + String.valueOf(tb_inaccount.getMoney()) + "Ԫ     "
                        + tb_inaccount.getTime();
                m++;// ��ʶ��1
            }
            break;
        case R.id.btnflaginfo:// �����btnflaginfo��ť
            strType = "btnflaginfo";// ΪstrType������ֵ
            FlagDAO flaginfo = new FlagDAO(Showinfo.this);// ����FlagDAO����
            // ��ȡ���б�ǩ��Ϣ�����洢��List���ͼ�����
            List<Tb_flag> listFlags = flaginfo.getScrollData(0, (int) flaginfo.getCount());
            strInfos = new String[listFlags.size()];// �����ַ�������ĳ���
            int n = 0;// ����һ����ʼ��ʶ
            for (Tb_flag tb_flag : listFlags) {// ����List���ͼ���
                // ����ǩ�����Ϣ��ϳ�һ���ַ������洢���ַ����������Ӧλ��
                strInfos[n] = tb_flag.getid() + "|" + tb_flag.getFlag();
                if (strInfos[n].length() > 15)// �жϱ�ǩ��Ϣ�ĳ����Ƿ����15
                    strInfos[n] = strInfos[n].substring(0, 15) + "����";// ��λ�ô���15֮����ַ����á�������
                n++;// ��ʶ��1
            }
            break;
        }
        // ʹ���ַ��������ʼ��ArrayAdapter����
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strInfos);
        lvinfo.setAdapter(arrayAdapter);// ΪListView�б���������Դ
    }

    @Override
    protected void onRestart() {
        super.onRestart();// ʵ�ֻ����еķ���
        showInfo(R.id.btnoutinfo);// ��ʾ֧����Ϣ
    }
}
