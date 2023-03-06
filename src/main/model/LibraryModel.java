package main.model;

import java.lang.reflect.Field;
import java.util.List;

public class LibraryModel extends Model
{

    public String location;

    @Override
    public Field[] getAllField()
    {
        return LibraryModel.class.getFields();
    }

    @Override
    public List<String> getData()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
