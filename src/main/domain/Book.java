package main.domain;

import main.utils.DateTimeUtils;

public class Book
{
    private Audit  audit;

    private String author;

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public Audit getAudit()
    {
        return audit;
    }

    public void setAudit(Audit audit)
    {
        this.audit = audit;
    }

    @Override
    public String toString()
    {
        return "Book: " + " id=" + audit.getId() + " name=" + audit.getName() + " author=" + getAuthor() + " createTime=" + DateTimeUtils.getDateTime(audit.getCreateTime()) + " update=" + DateTimeUtils.getDateTime(audit.getUpdateTime());
    }
}
