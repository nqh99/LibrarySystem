package main.configures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import main.domain.AuditType;
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

    private static volatile ApplicationCfg           obj        = null;

    private final Map<AuditType, AbstractTableModel> objectMap;

    private UserModel                                user;

    private final String[]                           tableNames = new String[] { AuditType.BOOK.getValue(), AuditType.LIBRARY.getValue(), AuditType.RENTER.getValue() };

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

    public Map<AuditType, AbstractTableModel> createObjectMap()
    {

        Map<AuditType, AbstractTableModel> objecMap = new HashMap<>();
        objecMap.put(AuditType.BOOK, new BookModel(new ArrayList<>()));
        objecMap.put(AuditType.LIBRARY, new LibraryModel(new ArrayList<>()));
        objecMap.put(AuditType.RENTER, new RenterModel(new ArrayList<>()));

        return objecMap;
    }

    public Map<AuditType, AbstractTableModel> getObjectMap()
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
