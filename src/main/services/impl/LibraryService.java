package main.services.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import main.configures.ApplicationCfg;
import main.domain.Library;
import main.domain.ObjectType;
import main.domain.RealObject;
import main.infra.ILibraryQueryRepository;
import main.infra.impl.LibraryQueryRepository;
import main.model.LibraryModel;
import main.services.ILibraryService;

public class LibraryService implements ILibraryService
{

    private final ILibraryQueryRepository             libraryQueryRepository = LibraryQueryRepository.getInstance();

    private final Map<ObjectType, AbstractTableModel> objectMap              = ApplicationCfg.getInstance().getObjectMap();

    private static volatile LibraryService            obj                    = null;

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
        LibraryModel libraryModel = (LibraryModel) objectMap.get(ObjectType.LIBRARY);
        try
        {
            Library library = libraryQueryRepository.findLibraryById(con, id);
            libraryModel.setLibraryList(Arrays.asList(library));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return libraryModel;
    }

    @Override
    public LibraryModel findLibraryByName(Connection con, String name)
    {
        LibraryModel libraryModel = (LibraryModel) objectMap.get(ObjectType.LIBRARY);
        List<RealObject> list = new ArrayList<>();
        try
        {
            list.addAll(libraryQueryRepository.findLibraryByName(con, name));
            libraryModel.setLibraryList(list);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return libraryModel;
    }

    @Override
    public LibraryModel findLibraryByLocation(Connection con, String location)
    {
        LibraryModel libraryModel = (LibraryModel) objectMap.get(ObjectType.LIBRARY);
        try
        {
            Library library = libraryQueryRepository.findLibraryByLocation(con, location);
            libraryModel.setLibraryList(Arrays.asList(library));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return libraryModel;
    }

    @Override
    public LibraryModel findLibraryByNameAndLocation(Connection con, String name, String location)
    {
        LibraryModel libraryModel = (LibraryModel) objectMap.get(ObjectType.LIBRARY);
        try
        {
            Library library = libraryQueryRepository.findLibraryByNameAndLocation(con, name, location);
            libraryModel.setLibraryList(Arrays.asList(library));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return libraryModel;
    }

    @Override
    public LibraryModel findLibraryByIdAndNameAndLocation(Connection con, Integer id, String name, String location)
    {
        LibraryModel libraryModel = (LibraryModel) objectMap.get(ObjectType.LIBRARY);
        try
        {
            Library library = libraryQueryRepository.findLibraryByIdAndNameAndLocation(con, id, name, location);
            libraryModel.setLibraryList(Arrays.asList(library));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return libraryModel;
    }

    @Override
    public int removeLibraryById(Connection con, Integer id)
    {
        // TODO Auto-generated method stub
        return 0;
    }

}
