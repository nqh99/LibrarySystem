package main.model;

import java.lang.reflect.Field;
import java.sql.Date;
import java.util.List;

public abstract class Model
{

    public Integer   id;

    public String    name;

    public Date createTime;

    public Date updateTime;

    public abstract Field[] getAllField();
    
    public abstract List<String> getData();

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date date)
    {
        this.createTime = date;
    }

    public Date getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }

}
