package com.example.coco.greendao;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.anye.greendao.gen.DaoMaster;
import com.anye.greendao.gen.DaoSession;

/**
 * Created by coco on 2017/8/31.
 */

public class MyApplication extends Application{
    public static MyApplication application;
    private DaoMaster.DevOpenHelper devOpenHelper;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
        setDataBase();

    }
public static MyApplication getInstance(){
    return application;
}
    private void setDataBase() {
        devOpenHelper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        db = devOpenHelper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }
    public DaoSession getDaoSession(){
        return  daoSession;
    }
    public SQLiteDatabase getDb(){
        return db;
    }
}
