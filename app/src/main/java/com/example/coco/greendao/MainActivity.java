package com.example.coco.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.anye.greendao.gen.UserBeanDao;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private UserBeanDao userBeanDao;
    private UserBean bean;
    private EditText mEd;
    private Button mBtn,mBtn2,mBtn3,mBtn4;
    private TextView mTv;
    private int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        userBeanDao = MyApplication.getInstance().getDaoSession().getUserBeanDao();
    }

    private void initView() {
        mEd = (EditText) findViewById(R.id.mEd);
        mBtn = (Button) findViewById(R.id.mBtn);
        mBtn2 = (Button) findViewById(R.id.mBtn2);
        mBtn3 = (Button) findViewById(R.id.mBtn3);
        mBtn4 = (Button) findViewById(R.id.mBtn4);
        mTv = (TextView) findViewById(R.id.mTv);

        mBtn.setOnClickListener(this);
        mBtn2.setOnClickListener(this);
        mBtn3.setOnClickListener(this);
        mBtn4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mBtn:
                String str = mEd.getText().toString();
                long id = i++;
                bean=new UserBean(id,str);
                userBeanDao.insert(bean);
                mTv.setText(bean.getId()+", "+bean.getName());
                break;
            case R.id.mBtn2:
                userBeanDao.deleteByKey((long)1);
                break;
            case R.id.mBtn3:
                bean=new UserBean((long)2,mEd.getText().toString());
                userBeanDao.update(bean);
                break;
            case R.id.mBtn4:
                List<UserBean> list = userBeanDao.loadAll();
                String str2 = "";
                for (int i = 0; i < list.size(); i++) {
                    str2+=list.get(i).getName()+",";
                }
                mTv.setText(str2);
                break;

        }
    }
}
