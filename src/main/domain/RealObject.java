package main.domain;

public abstract class RealObject
{

    private Integer id;

    private String  name;

    private String  createTime;

    private String  updateTime;

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

    public String getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(String createTime)
    {
        this.createTime = createTime;
    }

    public String getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(String updateTime)
    {
        this.updateTime = updateTime;
    }

    @Override
    public String toString()
    {
        String data = this.getClass() + " : " + " id=" + id + " name=" + name + " createTime=" + createTime + " update=" + updateTime;
        return data;
    }
}
