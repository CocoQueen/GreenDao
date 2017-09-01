package com.example.coco.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by coco on 2017/8/31.
 */
@Entity
public class UserBean {
    @Id
    private Long id;


    private String name;

    @Transient
    private int tempUsageCount;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 2024802960)
    public UserBean(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 1203313951)
    public UserBean() {
    }
   
}
