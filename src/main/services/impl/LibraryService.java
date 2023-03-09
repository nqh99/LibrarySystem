package main.services.impl;

import java.sql.Connection;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import main.configures.ApplicationCfg;
import main.domain.ObjectType;
import main.infra.BookQueryRepository;
import main.infra.IBookQueryRepository;
import main.model.LibraryModel;
import main.services.ILibraryService;

public class LibraryService implements ILibraryService
{
    private final IBookQueryRepository                bookQueryRepository = BookQueryRepository.getInstance();

    private final Map<ObjectType, AbstractTableModel> objectMap           = ApplicationCfg.getInstance().getObjectMap();

    private static volatile LibraryService            obj                 = null;

    private LibraryService()
    {

    }

    public static LibraryService getInstance()
    {
        if (obj == null)
        {
            synchronized (LibraryService.class)
            {
                if (obj == null)
                {
                    obj = new LibraryService();
                }
            }
        }
        return obj;
    }

    @Override
    public LibraryModel findLibraryById(Connection con, Integer id)
    {
        return null;
    }

    @Override
    public LibraryModel findLibraryByName(Connection con, String name)
    {
        return null;
    }

    @Override
    public LibraryModel findLibraryByLocation(Connection con, String location)
    {
        return null;
    }

    @Override
    public LibraryModel findLibraryByNameAndLocation(Connection con, String name, String location)
    {
        return null;
    }

    @Override
    public LibraryModel findLibraryByIdAndNameAndLocation(Connection con, Integer id, String name, String location)
    {
        return null;
    }

}
