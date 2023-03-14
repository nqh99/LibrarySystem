package main.services;

import java.sql.Connection;

import main.model.LibraryModel;

public interface ILibraryService
{

    public LibraryModel findLibraryById(Connection con, Integer id);

    public LibraryModel findAllLibrary(Connection con);

    public boolean removeLibraryById(Connection con, Integer id);

    public boolean updateLibraryById(Connection con, Integer id, String name, String location);

    public boolean createLibrary(Connection con, String name, String location);
}
