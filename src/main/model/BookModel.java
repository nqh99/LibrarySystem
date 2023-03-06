package main.model;

import java.lang.reflect.Field;
import java.util.List;

public class BookModel extends Model
{

    public String author;

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    @Override
    public Field[] getAllField()
    {
        return BookModel.class.getFields();
    }

    @Override
    public List<String> getData()
    {
        return null;
    }

}
