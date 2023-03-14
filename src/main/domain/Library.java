package main.domain;

import java.util.List;

import main.utils.DateTimeUtils;

/**
 * 
 * @author ttl
 *
 */
public class Library
{
    private Audit        audit;

    private String       location;

    private List<Book>   books;

    private List<Renter> renters;

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public List<Book> getBooks()
    {
        return books;
    }

    public void setBooks(List<Book> books)
    {
        this.books = books;
    }

    public List<Renter> getRenters()
    {
        return renters;
    }

    public void setRenters(List<Renter> renters)
    {
        this.renters = renters;
    }

    @Override
    public String toString()
    {
        return "Library: " + " id=" + audit.getId() + " name=" + audit.getName() + " location=" + getLocation() + " createTime=" + DateTimeUtils.getDateTime(audit.getCreateTime()) + " update=" + DateTimeUtils.getDateTime(audit.getUpdateTime());
    }

    public Audit getAudit()
    {
        return audit;
    }

    public void setAudit(Audit audit)
    {
        this.audit = audit;
    }

}
