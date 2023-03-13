package main.infra;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import main.domain.Library;

public interface ILibraryQueryRepository
{
    public Library findLibraryById(Connection con, Integer id) throws SQLException;

    public List<Library> findLibraryByName(Connection con, String name) throws SQLException;

    public Library findLibraryByLocation(Connection con, String location) throws SQLException;

    public Library findLibraryByNameAndLocation(Connection con, String name, String location) throws SQLException;

    public Library findLibraryByIdAndNameAndLocation(Connection con, Integer id, String name, String location) throws SQLException;

    public List<Library> findAllLibraries(Connection con) throws SQLException;
    
    public boolean createLibrary(Connection con, String name, String location, Long createTime, Long updateTime) throws SQLException;

    public boolean removeLibraryById(Connection con, Integer id) throws SQLException;

    public boolean updateLibraryById(Connection con, Integer id, String name, String location, Long updateTime) throws SQLException;
}
