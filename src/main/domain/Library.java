package main.domain;

import java.util.List;

import main.utils.DateTimeUtils;

/**
 * 
 * @author ttl
 *
 */
public class Library extends RealObject
{
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
        return "Library: " + " id=" + this.getId() + " name=" + this.getName() + " location=" + this.getLocation() + " createTime=" + DateTimeUtils.getDateTime(this.getCreateTime()) + " update=" + DateTimeUtils.getDateTime(this.getUpdateTime());
    }

}
