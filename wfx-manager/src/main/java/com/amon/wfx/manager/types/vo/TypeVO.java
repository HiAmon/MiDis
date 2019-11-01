package com.amon.wfx.manager.types.vo;

import com.amon.wfx.manager.types.pojos.GType;

public class TypeVO {
    private String text;
    private String href;

    //构造器作为vo的适配器，将GType对象转换为vo对象
    public TypeVO(GType gType) {
        this.text = gType.getTypeName();
        this.href = gType.getTypeId();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
