package main.model;

import java.lang.reflect.Field;
import java.util.List;

public class RenterModel extends Model
{

    @Override
    public Field[] getAllField()
    {
        return RenterModel.class.getFields();
    }

    @Override
    public List<String> getData()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
