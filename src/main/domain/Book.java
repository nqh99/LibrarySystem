package main.domain;

import main.utils.DateTimeUtils;

public class Book extends RealObject
{

    private String author;

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    @Override
    public String toString()
    {
        return "Book: " + " id=" + this.getId() + " name=" + this.getName() + " author=" + this.getAuthor() + " createTime=" + DateTimeUtils.getDateTime(this.getCreateTime()) + " update=" + DateTimeUtils.getDateTime(this.getUpdateTime());
    }

}
