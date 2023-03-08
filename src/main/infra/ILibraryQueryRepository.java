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
    
    public Library findLibraryByIdAndNameAndLocation(Connection con,Integer id, String name, String location) throws SQLException;
}
