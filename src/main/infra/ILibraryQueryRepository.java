package main.infra;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import main.domain.Library;

public interface ILibraryQueryRepository
{
    public Library findLibraryById(Connection con, Integer id) throws SQLException;

    public List<Library> findAllLibraries(Connection con) throws SQLException;

    public boolean createLibrary(Connection con, String name, String location) throws SQLException;

    public boolean removeLibraryById(Connection con, Integer id) throws SQLException;

    public boolean updateLibraryById(Connection con, Integer id, String name, String location) throws SQLException;
}
