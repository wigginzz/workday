package cn.mapway.workday.api.module;

import cn.mapway.document.annotation.Doc;

@Doc("返回值基类")
public class Resp {
    public Integer status;
    public String message;

    public Resp ok()
    {
       return ok("");
    }

    public Resp ok(String msg)
    {
        status=0;
        message=msg;
        return  this;
    }

    public Resp fail(Integer status,String msg)
    {
        this.status=status;
        message=msg;
        return  this;
    }


}
