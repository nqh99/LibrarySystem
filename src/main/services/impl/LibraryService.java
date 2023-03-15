package main.services.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import main.configures.ApplicationCfg;
import main.domain.AuditType;
import main.domain.Library;
import main.infra.IAuditRepository;
import main.infra.impl.LibraryQueryRepository;
import main.model.LibraryModel;
import main.services.ILibraryService;

public class LibraryService implements ILibraryService
{

    private final Map<AuditType, AbstractTableModel> objectMap = ApplicationCfg.getInstance().getObjectMap();

    @Override
    public LibraryModel findLibraryById(Connection con, Integer id)
    {
        LibraryModel libraryModel = (LibraryModel) objectMap.get(AuditType.LIBRARY);
        IAuditRepository libraryQueryRepository = new LibraryQueryRepository();

        try
        {
            Library library = libraryQueryRepository.findById(con, id);
            libraryModel.setLibraryList(Arrays.asList(library));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return libraryModel;
    }

    @SuppressWarnings("unchecked")
    @Override
    public LibraryModel findAllLibrary(Connection con)
    {
        LibraryModel libraryModel = (LibraryModel) objectMap.get(AuditType.LIBRARY);
        IAuditRepository libraryQueryRepository = new LibraryQueryRepository();
        List<Library> list = new ArrayList<>();
        try
        {
            list.addAll((List<Library>) libraryQueryRepository.findAll(con));
            libraryModel.setLibraryList(list);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return libraryModel;
    }

    @Override
    public boolean removeLibraryById(Connection con, Integer id)
    {
        IAuditRepository libraryQueryRepository = new LibraryQueryRepository();
        boolean result = false;
        try
        {
            result = libraryQueryRepository.removeById(con, id);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean createLibrary(Connection con, String name, String location)
    {
        IAuditRepository libraryQueryRepository = new LibraryQueryRepository();
        boolean result = false;

        try
        {
            result = libraryQueryRepository.create(con, name, location);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean updateLibraryById(Connection con, Integer id, String name, String location)
    {
        IAuditRepository libraryQueryRepository = new LibraryQueryRepository();
        boolean result = false;

        try
        {
            result = libraryQueryRepository.updateById(con, id, name, location);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
