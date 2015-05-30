package com.xiaoxin.womenclass.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2015/5/27 0027.
 */
public class DataShow extends BmobObject {
    private String title;
    private String logo;
    private String content;

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
