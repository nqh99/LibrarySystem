package main.configures;

import java.util.HashMap;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import main.domain.ObjectType;
import main.model.BookModel;
import main.model.LibraryModel;
import main.model.RenterModel;

public final class ApplicationCfg
{

    private static volatile ApplicationCfg            obj = null;

    private final Map<ObjectType, AbstractTableModel> objectMap;

    private ApplicationCfg()
    {
        objectMap = createObjectMap();
    }

    public static ApplicationCfg getInstance()
    {
        if (obj == null)
        {
            synchronized (ApplicationCfg.class)
            {
                if (obj == null)
                {
                    obj = new ApplicationCfg();
                }
            }
        }
        return obj;
    }

    public Map<ObjectType, AbstractTableModel> createObjectMap()
    {

        Map<ObjectType, AbstractTableModel> objecMap = new HashMap<>();
        objecMap.put(ObjectType.BOOK, new BookModel());
        objecMap.put(ObjectType.LIBRARY, new LibraryModel());
        objecMap.put(ObjectType.RENTER, new RenterModel());

        return objecMap;
    }

    public Map<ObjectType, AbstractTableModel> getObjectMap()
    {
        return objectMap;
    }
}
