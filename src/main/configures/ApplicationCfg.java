package main.configures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import main.domain.ObjectType;
import main.domain.RealObject;
import main.model.BookModel;
import main.model.LibraryModel;
import main.model.RenterModel;
import main.model.UserModel;

/**
 * Hold application configures for running process of application
 * userRole
 * tableModel
 * tableName
 * 
 * @author ttl
 *
 */
public final class ApplicationCfg
{

    private static volatile ApplicationCfg            obj        = null;

    private final Map<ObjectType, AbstractTableModel> objectMap;

    private UserModel                                 user;

    private final String[]                            tableNames = new String[] { ObjectType.BOOK.getValue(), ObjectType.LIBRARY.getValue(), ObjectType.RENTER.getValue() };

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
        List<RealObject> datas = new ArrayList<>();
        objecMap.put(ObjectType.BOOK, new BookModel(datas));
        objecMap.put(ObjectType.LIBRARY, new LibraryModel(datas));
        objecMap.put(ObjectType.RENTER, new RenterModel(datas));

        return objecMap;
    }

    public Map<ObjectType, AbstractTableModel> getObjectMap()
    {
        return objectMap;
    }

    public String[] getTableNames()
    {
        return tableNames;
    }

    public UserModel getUser()
    {
        return user;
    }

    public void setUser(UserModel user)
    {
        this.user = user;
    }
}
